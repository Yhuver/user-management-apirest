package com.user.management.model.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.user.management.dto.ListProfileUserDto;
import com.user.management.model.dao.IProfileUserCustomDao;
import com.user.management.model.entity.User;

@Repository
public class ProfileUserCustomDaoImpl implements IProfileUserCustomDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ListProfileUserDto> listProfileByIdUser(User user) {
		Query query = entityManager
				.createQuery("select pu.id, pr.id, pr.name, pr.description"
						+ " from ProfileUser as pu inner join pu.profile as pr"
						+ " where pu.user = ?1 ")
				.setParameter(1, user);
		List<Object[]> results = query.getResultList();

		return results
				.stream().map(result -> new ListProfileUserDto((Long) result[0], (Long) result[1],
						(String) result[2], (String) result[3]))
				.collect(Collectors.toList());
	}
	

}
