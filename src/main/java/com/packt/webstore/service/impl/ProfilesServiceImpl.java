package com.packt.webstore.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.packt.webstore.domain.*;
import com.packt.webstore.domain.repository.*;
import com.packt.webstore.service.*;
@Service
public class ProfilesServiceImpl implements ProfileService{
@Autowired
private ProfileRepository profilesRepository;
public Profiles create(Profiles profile) {
return profilesRepository.create(profile);
}
public Profiles read(int id) {
return profilesRepository.read(id);
}
public void update(int id, Profiles profile) {
	profilesRepository.update(id, profile);
}
public void delete(int id) {
	profilesRepository.delete(id);
}
}

