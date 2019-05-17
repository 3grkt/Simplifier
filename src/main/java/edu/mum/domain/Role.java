package edu.mum.domain;

public enum Role {
	ROLE_ADMIN,
	ROLE_SUPERVISOR,
	ROLE_USER,
	ROLE_GUEST;
	
	public int getIdRole(){
		switch (this) {
		case ROLE_SUPERVISOR:
			return 1;
		case ROLE_ADMIN:
			return 2;
		case ROLE_USER:
			return 3;
		default:
			return 4;
		}

	}
}
