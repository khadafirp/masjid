package com.example.masjid.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.masjid.entity.LoginEntity;
import com.example.masjid.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	public LoginController() {
		
	}
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/allUserLogin")
	@ResponseBody
	public Map<String, Object> login(){
		Map<String, Object> map = loginService.showAll();
		return map;
	}
	
	@PostMapping("/addUserLogin")
	@ResponseBody
	public Map<String, Object> addUserLogin(@RequestBody LoginEntity loginEntity){
		Map<String, Object> map = loginService.addUserLogin(
			loginEntity.getLogin_id(),
			loginEntity.getEmail(),
			loginEntity.getPassword(),
			loginEntity.getLevel(),
			loginEntity.getIs_active()
		);
		
		return map;
	}

	@GetMapping("/login")
	@ResponseBody
	public Map<String, Object> login(@RequestBody LoginEntity loginEntity){
		
		Map<String, Object> map = loginService.login(
			loginEntity.getEmail(),
			loginEntity.getPassword()
		);
		
		return map;
	}
}
