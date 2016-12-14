package br.com.webevaluationinit.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.webevaluationinit.model.Colaborador;
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
			if (relatorio.getEmpresa().getId() != 0) {
				table = table + " JOIN " + cargoHabilidadeTable + " cha ON (car.id = cha.cargo_id) ";
			} else {
				table = table + colaboradorTable + " e JOIN " + cargoTable + " car ON (e.id_cargo = car.id) JOIN "
						+ cargoHabilidadeTable + " cha ON (car.id = cha.cargo_id) ";
			}
			for (Habilidade habilidade : relatorio.getLstHabilidade()) {
				if (idsHabilidade.equals("")) {
					idsHabilidade = habilidade.getId().toString();
				} else {
					idsHabilidade = idsHabilidade + ", " + habilidade.getId().toString();
				}
			}
			if (countCriteria > 0) {
				criteria = criteria + " AND cha.habilidades_id IN (" + idsHabilidade + ")";
			}else{
				criteria = "cha.habilidades_id IN (" + idsHabilidade + ")";
			}
		}

		if (criteria.equals("") || table.equals("")) {
			System.out.println("SELECT e FROM " + entityClass.getName() + " e");
			query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
		} else {
			System.out.println("SELECT e FROM " + table + " WHERE " + criteria);
			query = (TypedQuery<Colaborador>) em.createNativeQuery("SELECT e.* FROM " + table + " WHERE " + criteria,
					entityClass);
		}
		return (List<Colaborador>) query.getResultList();
	}

}
