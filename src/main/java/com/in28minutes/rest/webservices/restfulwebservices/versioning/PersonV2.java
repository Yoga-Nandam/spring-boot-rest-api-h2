package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonV2 {
	

	private Name name;

	public PersonV2(Name name) {
		super();
		this.name = name;
	}
	
	

}
