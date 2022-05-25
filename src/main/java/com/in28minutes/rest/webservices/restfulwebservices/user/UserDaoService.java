package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> listOfusers = new ArrayList<>();

	private static int userCount = 3;

	static {
		listOfusers.add(new User(1, "Yoga", new Date()));
		listOfusers.add(new User(2, "Eve", new Date()));
		listOfusers.add(new User(3, "Jack", new Date()));
	}

	public List<User> findAll() {
		return listOfusers;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		listOfusers.add(user);
		return user;

	}
	
	public User findOne(int id) {
		for(User user : listOfusers) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = listOfusers.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
