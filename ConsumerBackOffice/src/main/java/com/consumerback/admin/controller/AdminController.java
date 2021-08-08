package com.consumerback.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consumerback.api.entities.UserOtp;
import com.consumerback.api.entities.Users;
import com.consumerback.service.UserRepositoryService;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class AdminController {

	@Autowired
	public UserRepositoryService userRepositoryService;
	
	@RequestMapping("/admin")
	public String Admin() {
		return "redirect:/admin/login";
	}
	
	@RequestMapping("/admin/login")
	public String AdminLogin(Model model) {
		
		return "index";
	}
	
	
	
	@RequestMapping("/admin/index")
	public String Login(Model model) {
		
		long countUsers = userRepositoryService.countUsers();
		
//		List<Users> users = userRepositoryService.getUsers();
		
		model.addAttribute("usersCount", countUsers);
		model.addAttribute("users", userRepositoryService.getUsers());
		
		System.out.println(countUsers );
		
		return "/admin/index";
	}

	@RequestMapping("/admin/index/users")
	public String UsersPage(Model model) {
		
		long countUsers = userRepositoryService.countUsers();
		
//		List<Users> users = userRepositoryService.getUsers();
		
		model.addAttribute("usersCount", countUsers);
		model.addAttribute("users", userRepositoryService.getUsers());
		
		System.out.println("Test Link for Users Pages" );
		
		return "/admin/users";
	}
	
	
	@RequestMapping("/admin/otp/{id}")
	public String OtpSearch(@PathVariable Integer id, Model model) {
		
		Users usersById = userRepositoryService.getUsers(id);
		List<UserOtp> userOtp = usersById.getUserOtp();
		
		model.addAttribute("userotp", userOtp);
		model.addAttribute("userbyid", usersById);
		
		System.out.println(usersById.getMsisdn());
		
		return "/admin/otp";
		
	}
	
}
