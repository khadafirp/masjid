package com.example.masjid.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.masjid.entity.LoginEntity;
import com.example.masjid.service.LoginService;
import com.example.masjid.service.ValidationService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	public LoginController() {
		
	}
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ValidationService validationService;
	
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
	public Map<String, Object> login(@RequestParam (name = "email") String email, @RequestParam (name = "password") String password){
		Map<String, Object> validasi = new HashMap<String, Object>();
		validasi.put("email", email);
		validasi.put("password", password);
		
		validationService.validate(validasi);
		
		Map<String, Object> map = loginService.login(
			email,
			password
		);
		
		return map;
	}
}
