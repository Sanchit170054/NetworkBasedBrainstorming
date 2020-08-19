package org.application.my.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.servlet.http.HttpServletRequest;

import org.application.my.modal.Activity;
import org.application.my.modal.User;
import org.application.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"activityName","activityBy","activityStatus"})
public class ApplicationController {

@Autowired
UserService userService;

int acId=1;
String acName="Effort Logger";
String acBy="Client 1";
String acStatus="Pending";

@RequestMapping("/login")
public String login(HttpServletRequest request) {
return "welcomepage";
}

@RequestMapping("/register")
public String registration(HttpServletRequest request) {
request.setAttribute("mode", "MODE_REGISTER");
return "homepage";
}

@RequestMapping("/brainstorming")
public String brainstorming(HttpServletRequest request) {
request.setAttribute("mode", "MODE_BRAINSTORMING");
return "homepage";
}

 @PostMapping("/save-activity")
 public String registerUser(@ModelAttribute Activity activity, BindingResult bindingResult, HttpServletRequest request) {
 userService.saveMyActivity(activity);
 //request.setAttribute("mode", "MODE_HOME");
 return "redirect:/homepage"; }
 
 
 @PostMapping("/start-brainstorming")
 public String startBrainstorming(@ModelAttribute Activity activity, BindingResult bindingResult, HttpServletRequest request) throws IOException {
		/*
		 * String[] argumnts = new String[] {"6000"}; Server.main(argumnts);
		 */

  Socket sk=new Socket("192.168.43.52",6000); BufferedReader sin=new
  BufferedReader(new InputStreamReader(sk.getInputStream())); PrintStream
  sout=new PrintStream(sk.getOutputStream()); BufferedReader stdin=new
  BufferedReader(new InputStreamReader(System.in)); String s; while ( true ) {
 System.out.print("Client : "); s=stdin.readLine(); sout.println(s); if (
  s.equalsIgnoreCase("BYE") ) {
  System.out.println("Connection ended by client"); break; } s=sin.readLine();
  System.out.print("Server : "+s+"\n");
  
  } sk.close(); sin.close(); sout.close(); stdin.close();

 //request.setAttribute("mode", "MODE_HOME");
 return "redirect:/homepage"; }
 

 
@RequestMapping(value="/edit-user")
public String editUser(@RequestParam int id,HttpServletRequest request, ModelMap model) {
request.setAttribute("mode", "MODE_EDIT");
request.setAttribute("activitys", userService.editUser(id));
String values=userService.editUser(id);
System.out.println("value "+values);
String value3=values.replaceAll(" ","=");
String value4=value3.replaceAll(",","");
System.out.println(value4);
String[] value5=value4.split("=");
for(String value6:value5) {
System.out.println(value6);
}
acId=Integer.parseInt(value5[2]);
acName=value5[4];
acBy=value5[6]+" "+value5[7];
acStatus=value5[9];

//model.put("acId", acId);
model.put("acName", acName);
model.put("acBy", acBy);
model.put("acStatus", acStatus);
return "homepage";
}


// @RequestMapping("/editpage")
// public String editpage(ModelMap model) {
// model.put("acId", acId);
// model.put("acName", acName);
// model.put("acBy", acBy);
// model.put("acStatus", acStatus);
// return "editpage";
// }


@RequestMapping("/delete-activity")
public String deleteUser(@RequestParam int id, HttpServletRequest request) {
userService.deleteMyActivity(id);
request.setAttribute("activitys", userService.showAllActivitys());
request.setAttribute("mode", "ALL_USERS");
return "homepage"; }

@RequestMapping("/homepage")
public String homepage(HttpServletRequest request) {
request.setAttribute("activitys", userService.showAllActivitys());
request.setAttribute("mode", "ALL_USERS");
return "homepage";
}

@RequestMapping ("/login-user")
public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
if(userService.findByUsernameAndPasswordAndUsertype(user.getUsername(), user.getPassword(), user.getUsertype())!=null) {
return "redirect:/homepage";
}
else {
request.setAttribute("error", "Invalid Username or Password");
request.setAttribute("mode", "MODE_LOGIN");
return "welcomepage";

}
}

}