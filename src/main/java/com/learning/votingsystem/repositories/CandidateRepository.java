package com.learning.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.votingsystem.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {

	public Candidate findById(long id);
	
}
