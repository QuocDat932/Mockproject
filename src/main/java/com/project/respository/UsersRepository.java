package com.project.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.entity.*;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	Users findByfullname(String fullname);
	
	Users findByUsernameAndHashPassword(String username, String hashpassword);
	
	Users findByEmail(String email);
	
	List<Users> findByRoleIn(List<roles> roles);
	
	/*@Query(value = "SELECT hashPassword FROM users WHERE username = ?1", nativeQuery = true)
	Optional<Users> findby(String hashPassword);*/
	Optional<Users> findByUsername(String username);
	
}
