package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepo;

@Service
public class RestaurantService {
	@Autowired
RestaurantRepo rr;
	//post-single
	public Restaurant addrestaurant(Restaurant r) {
		return rr.save(r);
	}
	//post-multiple
	public List<Restaurant> addrestaurants(List<Restaurant> r)
	{
		return (List<Restaurant>)rr.saveAll(r);
	}
	//get
	public List<Restaurant> showrestaurants(){
		return rr.findAll();
	}
	//update
	public Restaurant alterrestaurantdetails(Restaurant r) {
		return rr.saveAndFlush(r);
	}
	//delete
	public void deleteRestaurant(Restaurant r) {
		rr.delete(r);
	}
	public void deleteid(int id) {
		rr.deleteById(id);
	}
	public void deletepid(int id) {
		rr.deleteById(id);
	}
	public Optional<Restaurant> showbyid(int id){
		return rr.findById(id);
	}
	public String updateinfobyid(int id,Restaurant ss) {
		rr.saveAndFlush(ss);
		if(rr.existsById(id)) {
			return "updated";
			
		}
		else {
			return "enter valid id";
		}
	}
}
