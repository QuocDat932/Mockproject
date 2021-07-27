package com.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "SYSTEM",name="unit_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="isdeleted")
	private boolean isDeleted;
}
/*
 create table unit_types
(
	id				tinyint			primary key auto_increment,
	`description`	nvarchar(20)	null,
	isDeleted		bit				not null default 0
)
;
 */