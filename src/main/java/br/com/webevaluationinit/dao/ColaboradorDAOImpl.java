package br.com.webevaluationinit.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Colaborador;
import br.com.webevaluationinit.model.Educacao;
import br.com.webevaluationinit.model.Funcao;
import br.com.webevaluationinit.model.Genero;
import br.com.webevaluationinit.model.Habilidade;
import br.com.webevaluationinit.model.Relatorio;

@Repository
public class ColaboradorDAOImpl extends JPAGenericDAO<Colaborador, Long> implements ColaboradorDAO {

	public List<Colaborador> procurarPorCargo(Long idCargo) {
		TypedQuery<Colaborador> query = em
				.createQuery("SELECT e FROM " + entityClass.getName() + " e WHERE id_cargo = :idCargo", entityClass)
				.setParameter("idCargo", idCargo);
		return (List<Colaborador>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Colaborador> procurarRelatorio(Relatorio relatorio) {
		TypedQuery<Colaborador> query = null;
		String criteria = "";
		String table = "";
		int countCriteria = 0;
		if (relatorio.getEmpresa().getId() != 0) {
			String cargoTable = "Cargo";
			String empresaTable = "Empresa";
			String colaboradorTable = "Colaborador";
			table = table + colaboradorTable + " e JOIN " + cargoTable + " car ON (e.id_cargo = car.id) JOIN "
					+ empresaTable + " emp ON (car.id_empresa = emp.id) ";
			criteria = criteria + " emp.id = " + relatorio.getEmpresa().getId();
			countCriteria++;

		}
		
		if (relatorio.getLstHabilidade() != null) {
			String cargoTable = "Cargo";
			String cargoHabilidadeTable = "Cargo_Habilidade";
			String colaboradorTable = "Colaborador";
			String idsHabilidade = "";
			if (relatorio.getEmpresa().getId() == 0) {
				table = table + colaboradorTable + " e JOIN " + cargoTable + " car ON (e.id_cargo = car.id) JOIN "
						+ cargoHabilidadeTable + " cha ON (car.id = cha.cargo_id) ";
			} else {
				table = table + " JOIN " + cargoHabilidadeTable + " cha ON (car.id = cha.cargo_id) ";
			}
			for (Habilidade habilidade : relatorio.getLstHabilidade()) {
				if (idsHabilidade.equals("")) {
					idsHabilidade = habilidade.getId().toString();
				} else {
					idsHabilidade = idsHabilidade + "," + habilidade.getId().toString();
				}
			}
			if (countCriteria > 0) {
				criteria = criteria + " AND cha.habilidades_id = ALL (SELECT habilidades_id FROM " + cargoHabilidadeTable + " WHERE cha.habilidades_id IN (" + idsHabilidade + "))";
			}else{
				criteria = " AND cha.habilidades_id = ALL (SELECT habilidades_id FROM " + cargoHabilidadeTable + " WHERE cha.habilidades_id IN (" + idsHabilidade + "))";
			}
			countCriteria++;
		}
		
		if (relatorio.getLstEducacao() != null) {
			String cargoTable = "Cargo";
			String colaboradorTable = "Colaborador";
			String idsEducacao = "";
			if (relatorio.getEmpresa().getId() == 0 && relatorio.getLstHabilidade() == null) {
				table = table + colaboradorTable + " e JOIN " + cargoTable + " car ON (e.id_cargo = car.id) ";
			}
			for (Educacao educacao : relatorio.getLstEducacao()) {
				if (idsEducacao.equals("")) {
					idsEducacao = educacao.getValue() + "";
				} else {
					idsEducacao = idsEducacao + ", " + educacao.getValue();
				}
			}
			if (countCriteria > 0) {
				criteria = criteria + " AND car.educacao IN (" + idsEducacao + ")";
			}else{
				criteria = "car.educacao IN (" + idsEducacao + ")";
			}
		}
		
		if (relatorio.getLstFuncao() != null) {
			String cargoTable = "Cargo";
			String colaboradorTable = "Colaborador";
			String idsFuncao = "";
			if (relatorio.getEmpresa().getId() == 0 && relatorio.getLstHabilidade() == null && relatorio.getLstEducacao() == null) {
				table = table + colaboradorTable + " e JOIN " + cargoTable + " car ON (e.id_cargo = car.id) ";
			}
			for (Funcao funcao: relatorio.getLstFuncao()) {
				if (idsFuncao.equals("")) {
					idsFuncao = funcao.getId().toString();
				} else {
					idsFuncao = idsFuncao + ", " + funcao.getId().toString();
				}
			}
			if (countCriteria > 0) {
				criteria = criteria + " AND car.id_funcao IN (" + idsFuncao + ")";
			}else{
				criteria = "car.id_funcao IN (" + idsFuncao + ")";
			}
			countCriteria++;
		}
		
		if (relatorio.getLstGenero() != null) {
			String idsGenero = "";
			for (Genero genero : relatorio.getLstGenero()) {
				if (idsGenero.equals("")) {
					idsGenero = genero.getValue() + "";
				} else {
					idsGenero = idsGenero + ", " + genero.getValue();
				}
			}
			if (countCriteria > 0) {
				criteria = criteria + " AND e.genero IN (" + idsGenero + ")";
			}else{
				criteria = "e.genero IN (" + idsGenero + ")";
			}
		}

		if (criteria.equals("") || table.equals("")) {
			System.out.println("SELECT DISTINCT(e) FROM " + entityClass.getName() + " e");
			query = em.createQuery("SELECT DISTINCT(e) FROM " + entityClass.getName() + " e", entityClass);
		} else {
			System.out.println("SELECT DISTINCT(e.id) AS \"e.id\", e.* FROM " + table + " WHERE " + criteria);
			query = (TypedQuery<Colaborador>) em.createNativeQuery("SELECT DISTINCT(e.id) AS \"e.id\", e.* FROM " + table + " WHERE " + criteria,
					entityClass);
		}
		return (List<Colaborador>) query.getResultList();
	}

}
