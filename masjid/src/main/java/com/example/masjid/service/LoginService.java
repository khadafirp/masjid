package com.example.masjid.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.masjid.entity.LoginEntity;
import com.example.masjid.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginRepository loginRepositoryDua;
	
	@Autowired
	private ValidationService validationService;
	
	@Transactional
	public Map<String, Object> showAll(){
		List<LoginEntity> list = loginRepository.findAll();
		Map<String, Object> map = new HashMap<>();
		
		if(list.isEmpty()) {
			map.put("statusCode", 400);
			map.put("message", "data is null");
		}else {
			map.put("statusCode", 200);
			map.put("message", "success");
			map.put("data", list);
		}
		
		return map;
	}
	
	@Transactional
	public Map<String, Object> addUserLogin(String login_id, String email, String password, String level, Integer is_active){
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setEmail(email);
		loginEntity.setPassword(password);
		loginEntity.setLevel(level);
		loginEntity.setLogin_id(login_id);
		loginEntity.setIs_active(is_active);
		
		Map<String, Object> map = new HashMap<>();
		map.put("statusCode", 200);
		map.put("message", "success");
		map.put("data", loginRepository.save(loginEntity));
		
		return map;
	}
	
	@Transactional
	public Map<String, Object> login(String email, String password){
//		Map<String, Object> validasi = new HashMap<String, Object>();
//		validasi.put("email", email);
//		validasi.put("password", password);
//		
//		validationService.validate(validasi);
//		
//		String token = UUID.randomUUID().toString();
		
		LoginEntity loginEntity = loginRepository.login(email, password);
		Map<String, Object> map = new HashMap<>();
		if(loginEntity == null) {
			map.put("statusCode", 404);
			map.put("message", "something wrong with your email or password");
		}else {
//			Map<String, Object> backup = new HashMap<String, Object>();
//			backup.put("email", loginEntity.getEmail());
//			backup.put("password", loginEntity.getPassword());
//			backup.put("level", loginEntity.getLevel().toString());
//			backup.put("login_id", loginEntity.getLogin_id());
			
//			loginRepository.deleteById(loginEntity.getId());
//			
//			LoginEntity loginEntityDua = new LoginEntity();
//			loginEntityDua.setEmail("adminmasjid@gmail.com");
//			loginEntityDua.setPassword("rahasia");
//			loginEntityDua.setLevel("1");
//			loginEntityDua.setLogin_id("adminmasjidkhusus");
//			loginEntityDua.setIs_active(1);
//			loginEntityDua.setToken(token);
//			
//			loginRepositoryDua.save(loginEntity);
		
//			map.put("token", token);
			map.put("statusCode", 200);
			map.put("message", "success");
			map.put("data", loginEntity);
		}
		return map;
	}

}
