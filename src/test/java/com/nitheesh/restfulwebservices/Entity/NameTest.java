package com.nitheesh.restfulwebservices.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	void nametest() {
		Name name=new Name("mandadi","nitheesh");
		String expected="nitheesh";
		
		assertEquals(expected,name.getLastname(),"basic test case passed");
	}

}
