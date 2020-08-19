package org.application.my.repository;

import org.application.my.modal.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUsernameAndPasswordAndUsertype(String username, String password, String usertype);
	
	//public User findt(int id,String username,String firsname, String lastname,int age,String password);

}
