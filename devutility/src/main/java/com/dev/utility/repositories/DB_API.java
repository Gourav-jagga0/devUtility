package com.dev.utility.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.utility.entities.baseEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class DB_API<T extends baseEntity> {
	@Autowired
	EntityManager em;

	public T findById(Long id, Class<T> domainClass) {
		return em.find(domainClass, id);
	}

	public List<T> findAll(Class<T> domainClass) {
		TypedQuery<T> findAllQuery = em.createQuery("Select e from " + domainClass.getSimpleName() + " e", domainClass);
		return findAllQuery.getResultList();
	}

	public T save(T data) {
		return em.merge(data);
	}

	public T softDelete(T data) {
		return data;
	}

	public T Delete(T data) {
		return em.merge(data);
	}

	public String getFullName(Long Id,Class<T> domainClass) {
		Query query = em.createNamedQuery("getfullName",String.class);
		return query.setParameter(1, Id).getSingleResult().toString();
	}

}
