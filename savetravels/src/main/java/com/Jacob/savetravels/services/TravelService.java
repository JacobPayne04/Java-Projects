package com.Jacob.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Jacob.savetravels.models.Travel;
import com.Jacob.savetravels.repositories.TravelRepository;

@Service
public class TravelService {

	private final TravelRepository travelRepo;
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	//get all
	public List<Travel> getAll(){
		return travelRepo.findAll();
	}
	
	//create one
	public Travel create(Travel travel) {
		return travelRepo.save(travel);
	}
	
	//get one by id
	public Travel getOne(Long id) {
		Optional<Travel> optionalTravel = travelRepo.findById(id);
		return optionalTravel.isPresent() ? optionalTravel.get() : null;
	}
	
	//edit by id
	public Travel edit(Travel travel) {
		return travelRepo.save(travel);
	}
	
	//delete one by id
	public void Delete(Long id) {
		travelRepo.deleteById(id);
	}
	
//	//find by name
//	public List<Travel> findByTravelName(String name) {
//		return travelRepo.findByTravelNameContaining(name);
//	}
}
