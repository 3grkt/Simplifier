package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="Groups")
public class Group implements Serializable{
	private static final long serialVersionUID = 5784L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	String group_name;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	List<Authority> authority = new ArrayList<Authority>();

    @ManyToMany(fetch = FetchType.EAGER)
	List<UserCredentials> userCredentials = new ArrayList<UserCredentials>();


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public List<UserCredentials> getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(List<UserCredentials> userCredentials) {
		this.userCredentials = userCredentials;
	}

	public String getIdAsString() {
		return new Long(id).toString();
	}
}
