package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
 UserService user;
	
	@PostMapping("adduser")
	public User add(@RequestBody User u) {
		return user.adduser(u);
	}
	
	@PostMapping("addusers")
	public List<User> addmultipleusers(@RequestBody List<User> u){
		return user.addusers(u);
	}
	@GetMapping("showusers")
	public List<User> showuser(){
		return user.showusers();
	}
	
	@PutMapping("alteru")
	public User modify(@RequestBody User u) {
		return user.alteruserdetail(u);
	}
	@DeleteMapping("deleteu")
	public String delete(@RequestBody User u) {
		user.deleteuser(u);
		return "deleted successfully";
	}
	@DeleteMapping("deleteid/{id}")
	public void deletemyid(@PathVariable int id) {
		user.deleteid(id);
	}
	@DeleteMapping("deleteparamid")
	public void deletemyparamid(@RequestParam int id) {
		user.deletepid(id);
	}
	@GetMapping("showid/{id}")
	public Optional<User> showid(@PathVariable int id) {
		return user.showbyid(id);
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody User ss) {
		return user.updateinfobyid(id, ss);
	}
}
