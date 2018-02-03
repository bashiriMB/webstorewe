package com.packt.webstore.domain.repository.impl;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.*;
import com.packt.webstore.domain.repository.*;
@Repository("ProfilesRepository")
public class ProfilesRepositoryImpl implements ProfileRepository{
	@Autowired
	public EntityManager entityManager;
	public ProfilesRepositoryImpl() {
	}

	public Profiles create(Profiles profile) {
		entityManager.getTransaction().begin();
		entityManager.persist(profile);
		entityManager.getTransaction().commit();
		return profile;
	}

	public Profiles read(int id) {

		Profiles profile = entityManager.find(Profiles.class, id);
		return profile;
	}
	public void update(int id, Profiles profile) {
		entityManager.getTransaction().begin();
		profile = entityManager.merge(profile);
		entityManager.getTransaction().commit();
	}
	public void delete(int id) {

		entityManager.getTransaction().begin();
		entityManager.remove(id);
		entityManager.getTransaction().commit();
	}
}


