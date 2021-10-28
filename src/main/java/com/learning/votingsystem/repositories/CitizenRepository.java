package com.learning.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.votingsystem.entity.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Long> {
	
	public Citizen findByName(String name);

}
