package com.user.management.model.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.user.management.dto.ListTaskDto;
import com.user.management.model.dao.ITaskCustomDao;
import com.user.management.model.entity.User;

@Repository
public class TaskCustomDao implements ITaskCustomDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ListTaskDto> listTaskExceptByUser(User user) {
		
		Query query = entityManager
				.createQuery("select tas.name, tas.id from Task as tas where tas.id NOT IN"
						+ " (select ta.id"
						+ " from TaskUser as tu inner join tu.task as ta"
						+ " where tu.user = ?1) ")
				.setParameter(1, user);
		List<Object[]> results = query.getResultList();

		return results
				.stream().map(result ->  ListTaskDto.builder().nameTask((String) result[0]).idTask((Long) result[1]).build())
				.collect(Collectors.toList());
	}

}
