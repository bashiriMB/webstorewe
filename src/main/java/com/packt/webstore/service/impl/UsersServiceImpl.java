package com.packt.webstore.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import com.packt.webstore.domain.*;
import com.packt.webstore.domain.repository.*;
import com.packt.webstore.service.*;
@Service
public class UsersServiceImpl implements UserService{
@Autowired
private UserRepositoriy usersRepository;
public Users create(Users user) {
return usersRepository.create(user);
}
public Users read(int id) {
return usersRepository.read(id);
}
public void update(int id, Users user) {
usersRepository.update(id, user);
}
public void delete(int id) {
usersRepository.delete(id);
}
}
