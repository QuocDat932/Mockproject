package com.project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.entity.*;
import com.project.jwt.CustomUser;
import com.project.services.*;

@Service
public class CustomUserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsersService userService;

	@Override
    public UserDetails loadUserByUsername(String username) {
		Users user = userService.findByUserName(username);
    	if (user == null) {
            throw new UsernameNotFoundException(username);
        }
    	try {
    		List<GrantedAuthority> grantList = new ArrayList<>();
    		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getDescription());
    		grantList.add(authority);
            return new CustomUser(user, grantList);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
	
}
