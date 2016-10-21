package br.com.webevaluationinit.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public abstract class JPAGenericDAO<E, K> implements GenericDAO<E, K>{

    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager em;

    @SuppressWarnings("unchecked")
    public JPAGenericDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    public E salvar(E entity) {
        em.persist(entity);
        return entity;
    }

    public E atualizar(E entity) {
       return em.merge(entity);
    }

    public void remover(E entity) {
        em.remove(entity);
    }

    public E procurarPorId(K id) {
        E entity = em.find(entityClass, id);
        return entity;
    }

    public List<E> procurarTudo() {
        TypedQuery<E> query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
        return query.getResultList();
    }

    public void refresh(E entity){
        em.refresh(entity);
    }
}