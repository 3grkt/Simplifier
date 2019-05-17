package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Group;
import edu.mum.domain.Member;
import edu.mum.service.GroupService;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	private MemberDao memberDao;

 	@Autowired
 	UserCredentialsService credentialsService;
 	
 	@Autowired
 	GroupService groupService;

 	 
    public void save( Member member) {  		
		memberDao.save(member);
	}
	
 	
    @Override
   	public void saveFull( Member member, Group group) {  	
        
  		credentialsService.save(member.getUserCredentials());
  		groupService.update(group);	
  		memberDao.save(member);
	}
  	
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Member> findAll() {
		return (List<Member>)memberDao.findAll();
	}

 	public Member findOne(Long id) {
		return memberDao.findOne(id);
	}
 	public void delete(Long id){
 		memberDao.delete(id);
 	}


	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		memberDao.update(member);
	}
	
 
}
