package org.application.my.controller;


import org.application.my.modal.Activity;
import org.application.my.modal.User;
import org.application.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String Hello() {
		return "Type /login";
	}
		
	
	@GetMapping("/saveactivity")
	public String saveActivity(@RequestParam String activityname,@RequestParam String activityby,@RequestParam String activitystatus) {
		Activity activity=new Activity(activityname,activityby,activitystatus);
		userService.saveMyActivity(activity);
		return "User Saved";
	}
	

	
}
