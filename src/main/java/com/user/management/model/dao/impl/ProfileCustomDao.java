package com.user.management.model.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.user.management.dto.ListProfileDto;
import com.user.management.model.dao.IProfileCustomDao;
import com.user.management.model.entity.User;

@Repository
public class ProfileCustomDao implements IProfileCustomDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ListProfileDto> listProfileExceptByUser(User user) {
		
		Query query = entityManager
				.createQuery("select pro.id, pro.name from Profile as pro where pro.id NOT IN"
						+ " (select pr.id"
						+ " from ProfileUser as pu inner join pu.profile as pr"
						+ " where pu.user = ?1)")
				.setParameter(1, user);
		List<Object[]> results = query.getResultList();

		return results
				.stream().map(result ->  ListProfileDto.builder().nameProfile((String) result[1]).idProfile((Long) result[0]).build())
				.collect(Collectors.toList());
	}

}
