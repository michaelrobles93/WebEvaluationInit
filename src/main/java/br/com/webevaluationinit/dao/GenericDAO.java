package br.com.webevaluationinit.dao;

import java.util.List;

public interface GenericDAO<E, K> {

    E salvar(E entity);
    E atualizar(E entity);
    void remover(E entity);
    E procurarPorId(K id);
    List<E> procurarTudo();
    void refresh(E entity);
}