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

import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;

@RestController
public class RestaurantController {
	@Autowired
 RestaurantService rser;
	@PostMapping("addrestaurant")
	public Restaurant addnew(@RequestBody Restaurant r) {
		return rser.addrestaurant(r);
	}
	@PostMapping("addrestaurants")
	public List<Restaurant> addlist(@RequestBody List<Restaurant> r) {
		return rser.addrestaurants(r);
	}
	@GetMapping("showrestaurants")
	public List<Restaurant> showr(){
		return rser.showrestaurants();
	}
	@PutMapping("alterrestaurant")
	public Restaurant modifyrestaurant(@RequestBody Restaurant r) {
		return rser.alterrestaurantdetails(r);
	}
	@DeleteMapping("rdeleter")
	public String rdelete(@RequestBody Restaurant r) {
		rser.deleteRestaurant(r);
		return "query executed";
	}
	@DeleteMapping("deleteidr/{id}")
	public void deletemyid(@PathVariable int id) {
		rser.deleteid(id);
	}
	@DeleteMapping("deleteparamidr")
	public void deletemyparamid(@RequestParam int id) {
		rser.deletepid(id);
	}
	@GetMapping("showidr/{id}")
	public Optional<Restaurant> showid(@PathVariable int id) {
		return rser.showbyid(id);
	}
	@PutMapping("updatebyidr/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Restaurant ss) {
		return rser.updateinfobyid(id, ss);
	}
}
