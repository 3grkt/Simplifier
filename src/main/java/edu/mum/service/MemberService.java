package edu.mum.service;

import java.util.List;
import java.util.Set;

import edu.mum.domain.Group;
import edu.mum.domain.Member;
 
public interface MemberService {

	public void save(Member member);
    public void saveFull( Member member, Group group);  		

	public List<Member> findAll();
 	public Member findOne(Long id);
 	public void delete(Long id);
 	public void update(Member member);
 		
}
