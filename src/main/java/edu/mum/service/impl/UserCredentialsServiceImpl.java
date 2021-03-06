package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.dao.UserCredentialsDao;
import edu.mum.domain.UserCredentials;
import edu.mum.service.GroupService;
import edu.mum.domain.UserCredentials;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements edu.mum.service.UserCredentialsService {
	
 	@Autowired
	private UserCredentialsDao userCredentialsDao;

 	
    public void save( UserCredentials userCredentials) {  	
 		
    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
  		String encodedPassword = passwordEncoder.encode(userCredentials.getPassword());
  		userCredentials.setPassword(encodedPassword);
  		
 		userCredentialsDao.save(userCredentials);
	}
 	
    public void update( UserCredentials userCredentials) {  		
 		userCredentialsDao.update(userCredentials);
	}
 	
  	
	public List<UserCredentials> findAll() {
		return (List<UserCredentials>)userCredentialsDao.findAll();
	}
	
	public UserCredentials findOne(Long id){
		return userCredentialsDao.findOne(id);
	}


	public UserCredentials findByUserName(String userName) {
		return userCredentialsDao.findByUserName(userName);
	}

}
