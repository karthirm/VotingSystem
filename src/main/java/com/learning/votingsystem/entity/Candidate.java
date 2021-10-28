package com.learning.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
public class Candidate {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Column(name="candidate_name")
	private String name;

	@Column(name="numberOfVotes")
	private Long numberOfVotes;
}
