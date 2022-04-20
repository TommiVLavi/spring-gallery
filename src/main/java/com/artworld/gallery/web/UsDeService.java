package com.artworld.gallery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.artworld.gallery.domain.UserRepository;

import com.artworld.gallery.domain.User;

//This class is dedicated for user authorization utilizing Spring Security
@Service
public class UsDeService implements UserDetailsService{
	private final UserRepository rep;
	
	@Autowired
	public UsDeService(UserRepository usRep) {
		this.rep = usRep;
	}
	
	public UserDetails loadUserByUsername(String username) throws
	UsernameNotFoundException {
		User current = rep.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(
				username, current.getPassword(), 
				AuthorityUtils.createAuthorityList(current.getRole()));
		return user;
	}
}
