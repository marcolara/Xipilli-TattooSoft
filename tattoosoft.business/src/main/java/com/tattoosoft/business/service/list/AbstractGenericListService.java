package com.tattoosoft.business.service.list;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xipilli.persistence.dao.AbstractBaseDAO;
import com.xipilli.persistence.model.AbstractPersistentEntity;

/**
 * @author mlara
 *
 */
@Transactional
public abstract class AbstractGenericListService<T extends AbstractPersistentEntity, TDAO extends AbstractBaseDAO<T>> {
	@Autowired
	protected TDAO dao;

	public List<T> getAll() {
		return dao.findAll();
	}

	public List<T> getAllPaged(int start, int limit) {
		return dao.findAll(start, limit);
	}

	public List<T> getAllPagedSorted(int start, int limit, String sort, String dir) {
		return dao.findAll(start, limit, sort, dir);
	}

	public List<T> getAllSorted(String sort, String dir) {
		return dao.findAll(sort, dir);
	}

	public List<T> getByPropertyName(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	public List<T> getByPropertyNamePaged(String propertyName, Object value, int start, int limit) {
		return dao.findByProperty(propertyName, value, start, limit);
	}

	public List<T> getByPropertyNamePagedSorted(String propertyName, Object value, int start, int limit, String sort, String dir) {
		return dao.findByProperty(propertyName, value, start, limit, sort, dir);
	}

	public List<T> getByPropertyNameSorted(String propertyName, Object value, String sort, String dir) {
		return dao.findByProperty(propertyName, value, sort, dir);
	}

	public List<T> getByCriterion(Criterion... criterion) {
		return dao.findByCriterion(criterion);
	}

	public List<T> getByDetachedCriteria(DetachedCriteria criteria) {
		return dao.findByDetachedCriteria(criteria);
	}

	public Long countAll() {
		return dao.countAll();
	}

	public Long countByProperty(String propertyName, Object value) {
		return dao.countByProperty(propertyName, value);
	}

	public Long countByCriterion(Criterion... criterion) {
		return dao.countByCriterion(criterion);
	}
}
