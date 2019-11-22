package com.BharatPays.jwtAuth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserMasterRepo userMasterRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("inside userDetails service + "+ username);
		UserMaster loggedInUser= userMasterRepo.findByUserName(username);
		System.out.println("User fetched from backend");
		System.out.println(loggedInUser);
		List <String> roles=new ArrayList<String>();
		roles.add("ADMIN");
		GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("ADMIN");
		Set<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();
		authorities.add(grantedAuthority);
		User registeredUser=new User(loggedInUser.getUserName(),"{noop}"+loggedInUser.getPassword() , authorities);
		return registeredUser; 
		/*if ("javainuse".equals(username)) {
			System.out.println("found user with userName :- "+username);
			return new User("javainuse", "$2a$10$y144BOEcej3t5Ra5F98B/Od6dDuTvnqQESCO2zgUw0ozZ3qeDuymy",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}*/
	}
}
