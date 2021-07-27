package com.project.services;
import java.util.*;
import com.project.entity.*;
public interface RolesServices  {
	List<roles> findAll();
	
	roles findByUserID(int roles);
}
