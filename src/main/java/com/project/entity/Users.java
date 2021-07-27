package com.project.entity;

import java.io.Serializable;
import java.sql.Timestamp;
//import java.util.Date;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "SYSTEM",name ="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name="Identity_Users", sequenceName = "Identity_Users")
	@Column(name ="id")
	private int id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name ="username")
	private String username;
	
	@Column(name="hashpassword")
	private String hashPassword;
	
	@Column(name="email")
	private String email;
	/*
	@Column(name="createdate")
	//@CreationTimestamp
	private Date createDate;
	private Timestamp createDate;
	*/
	@Column(name="imgurl")
	private String imgUrl;
	
	@Column(name="isdeleted")
	private Boolean isDeleted;
	
	// Khoa Ngoai
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "roleid", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private roles role;
}

