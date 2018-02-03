package com.packt.webstore.domain.repository.impl;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.*;
import com.packt.webstore.domain.repository.*;
@Repository("UsersRepository")
public class UsersRepositoryImpl implements UserRepositoriy{

	@Autowired
	public EntityManager entityManager;
	public UsersRepositoryImpl() {
	}

	public Users create(Users user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		Profiles profile = new Profiles(null,null,user);
		entityManager.persist(profile);
		entityManager.getTransaction().commit();
		return user;
	}

	public Users read(int id) {

		Users user = entityManager.find(Users.class, id);
		return user;
	}
	public void update(int id, Users user) {
		entityManager.getTransaction().begin();
		user = entityManager.merge(user);
		entityManager.getTransaction().commit();
	}
	public void delete(int id) {

		entityManager.getTransaction().begin();
		entityManager.remove(id);
		entityManager.getTransaction().commit();
	}
}

