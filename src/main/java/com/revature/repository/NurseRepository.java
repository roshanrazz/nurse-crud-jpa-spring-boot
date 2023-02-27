package com.revature.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Nurse;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NurseRepository extends JpaRepository<Nurse, Integer> {

	Optional<Nurse> findByNurseName(String name);

}
