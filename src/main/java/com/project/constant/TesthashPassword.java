package com.project.constant;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesthashPassword {
	public static void main( String[] args) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String Pasword1 = "abcdef";
		String Pasword2 = "123";
		String PassWordToDB1 = bcrypt.encode(Pasword1);
		String PassWordToDB2 = bcrypt.encode(Pasword2);
		System.out.println("Pass1: abcdef "+PassWordToDB1);
		System.out.println("Pass2: 123 "+PassWordToDB2);
		
		boolean login = bcrypt.matches(Pasword1, PassWordToDB1);
		System.out.println(login);
	}
	
}
