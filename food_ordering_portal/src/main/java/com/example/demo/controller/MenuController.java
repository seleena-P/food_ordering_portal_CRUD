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

import com.example.demo.model.Menu;
import com.example.demo.service.MenuService;
@RestController
public class MenuController {
	@Autowired
	MenuService mser;
	@PostMapping("additems")
	public List<Menu> addlist(@RequestBody List<Menu> ss) {
		return mser.savedetails(ss);
	}
	@PostMapping("additem")
	public Menu add(@RequestBody Menu ss) {
		return mser.saveinfo(ss);
	}
	@GetMapping("showdetailsm")
	public List<Menu> show(){
		return mser.showinfo();
	}
	@PutMapping("updatem")
	public Menu modify(@RequestBody Menu ss){
		return mser.changeinfo(ss);
	}
	@DeleteMapping("deletem")
	public String deletem(@RequestBody Menu ss) {
		mser.deleteinfo(ss);
		return "Successfully deleted";
	}
	@DeleteMapping("deletemid/{id}")
	public void deletemyid(@PathVariable int id) {
		mser.deleteid(id);
	}
	@DeleteMapping("deleteparamidm")
	public void deletemyparamid(@RequestParam int id) {
		mser.deletepid(id);
	}
	@GetMapping("showidm/{id}")
	public Optional<Menu> showid(@PathVariable int id) {
		return mser.showbyid(id);
	}
	@PutMapping("updatebyidm/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Menu ss) {
		return mser.updateinfobyid(id, ss);
	}
	
}
