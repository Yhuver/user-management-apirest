package com.user.management.model.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.user.management.dto.ListTaskUserDto;
import com.user.management.model.dao.ITaskUserCustomDao;
import com.user.management.model.entity.User;

@Repository
public class TaskUserCustomDao implements ITaskUserCustomDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ListTaskUserDto> listTaskByIdUser(User user) {
		
		Query query = entityManager
				.createQuery("select tu.id, ta.name, ta.duration, ta.status, ta.description"
						+ " from TaskUser as tu inner join tu.task as ta"
						+ " where tu.user = ?1 ")
				.setParameter(1, user);
		List<Object[]> results = query.getResultList();

		return results
				.stream().map(result -> new ListTaskUserDto((Long) result[0], (String) result[1],
						(Integer) result[2], (boolean) result[3], (String) result[4]))
				.collect(Collectors.toList());
	}

}
