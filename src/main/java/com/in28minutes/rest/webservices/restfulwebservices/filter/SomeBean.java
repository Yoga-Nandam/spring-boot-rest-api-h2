package com.in28minutes.rest.webservices.restfulwebservices.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@JsonIgnoreProperties(value={"field1","field2"}) //static-filtering 
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	private String field1;
	private String field2;
//	@JsonIgnore
	private String field3;

}
