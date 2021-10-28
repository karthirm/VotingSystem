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
@Table(name="citizens")
public class Citizen {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;

	@Column(name="citizen_name")
	private String name;
	

	@Column(name="hasvoted", columnDefinition = "BOOLEAN",nullable = false)
	//@Column(name="hasvoted")
	private Boolean hasVoted;
}
