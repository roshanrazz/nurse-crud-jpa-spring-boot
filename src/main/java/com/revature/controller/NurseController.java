package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Nurse;
import com.revature.service.NurseService;
 

@RestController	// This means that this class is a Controller
@RequestMapping(path="/api/v1") // This means URL's start with /api/v1 (after Application path)
public class NurseController {

	@Autowired
	private NurseService nurseService;
	
	
	@PostMapping("/addNurse")
	public Nurse addNurse(@RequestBody Nurse nurse) {
		return nurseService.saveNurse(nurse);
	}
	
	@PostMapping("/addNurses")
	public List<Nurse> addNurses(@RequestBody List<Nurse> nurses) {
		return nurseService.saveNurses(nurses);
	}
	
	@GetMapping("/nurses")
	public List<Nurse> findAllNurses(){
		return nurseService.getNurses();
	}
	
	@GetMapping("/nurses/{id}")
	public Nurse findNurseById(@PathVariable int id) {
		return nurseService.getNurseById(id);
	}
	
	@GetMapping("/nurses/name/{name}")
	public Nurse findNurseByName(@PathVariable String name) {
		return nurseService.getNurseByName(name);
	}
	
	@PutMapping("/update")
	public Nurse editNurse(@RequestBody Nurse nurse) {
		return nurseService.updateNurse(nurse);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteNurse(@PathVariable int id) {
		return nurseService.deleteNurse(id);
	}
	
}