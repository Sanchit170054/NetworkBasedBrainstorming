package org.application.my.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.application.my.modal.Activity;
import org.application.my.modal.User;
import org.application.my.repository.ActivityRepository;
import org.application.my.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserService {

	private UserRepository userRepository;
	private ActivityRepository activityRepository;
	
	public UserService(UserRepository userRepository,ActivityRepository activityRepository) {
		this.userRepository=userRepository;
		this.activityRepository=activityRepository;
	}
	
	public void deleteMyActivity(int id) {
		activityRepository.deleteById(id);;
	}
	
	public void saveMyActivity(Activity activity) {
		activityRepository.save(activity);
	}
	
	public String editUser(int id) {
		System.out.println("Its id is "+activityRepository.findById(id));
		List<Optional<Activity>> dsfa = new ArrayList<>();
		dsfa.add(activityRepository.findById(id));
		System.out.println(dsfa.get(0));
		String va =dsfa.get(0).toString();
		int length=va.length();
		System.out.println(length);
		String va2="";
		String va3="";
		String va4="";
		if(va.substring(0, 8).equals("Optional")) {
			va2=va.replaceAll("Optional", "");
			
		}
		
		if(va2.charAt(0)=='[') {
			va3=va2.substring(1,va2.length()-2);
			
		}
		
		
		


		
		System.out.println(va3);
		
		return va3;
	}
	
	
	public List<Activity> showAllActivitys(){
		List<Activity> activitys=new ArrayList<Activity>();
		for(Activity activity:activityRepository.findAll()) {
			activitys.add(activity);
		}
		return activitys;
	}
	
	public User findByUsernameAndPasswordAndUsertype(String username, String password, String usertype) {
		return userRepository.findByUsernameAndPasswordAndUsertype(username, password, usertype);
	}

}
