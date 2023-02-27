package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Nurse;
import com.revature.repository.NurseRepository;


@Service
public class NurseService {
	
	@Autowired
	private NurseRepository nurseRepository;
	
	public Nurse saveNurse(Nurse nurse) {
		return nurseRepository.save(nurse);
	}
	
	public List<Nurse> saveNurses(List<Nurse> nurses) {
		return nurseRepository.saveAll(nurses);
	}
	
	public List<Nurse> getNurses(){
		return nurseRepository.findAll();
	}
	
	public Nurse getNurseById(int id) {
		return nurseRepository.findById(id).orElse(null);
	}
	
	public Nurse getNurseByName(String name) {
		return nurseRepository.findByNurseName(name).orElse(null);
	}
	
	public String deleteNurse(int id) {
		nurseRepository.deleteById(id);
		return "Nurse removed : " + id;
	}
	
	public Nurse updateNurse(Nurse nurse) {
		Nurse existingNurse = nurseRepository.findById(nurse.getNurseId()).orElse(null);
		existingNurse.setNurseName(nurse.getNurseName());
		existingNurse.setEmail(nurse.getEmail());
		existingNurse.setGender(nurse.getGender());
		return nurseRepository.save(existingNurse);
	}

}
