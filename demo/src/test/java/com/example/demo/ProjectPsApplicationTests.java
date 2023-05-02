package com.example.demo;

import com.example.demo.Test.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProjectPsApplicationTests {

	@Mock
	private DBOperation dbOperation;

	@Test
	void contextLoads() {
	}

	@Test
	void testDobandaMare(){
		OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);
		int res = operatiiDobanda.calculDobanda(Dobanda.BIG);
		int exepectedResult = 20;
		assertTrue(res == exepectedResult);

	}

	@Test
	void testUserSMALL(){
		User user = new User("Alin", Risc.SMALL);
		when(dbOperation.getUser()) .thenReturn(user);
		OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);
		int res = operatiiDobanda.calcUserDobanda();
		int expectedResult = 10;
		assertTrue(res == expectedResult);
		verify(dbOperation).getUser();
	}

	@Test
	void testUserMEDIUM(){
		User user = new User("Alin", Risc.MEDIUM);
		when(dbOperation.getUser()) .thenReturn(user);
		OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);
		int res = operatiiDobanda.calcUserDobanda();
		int expectedResult = 15;
		assertTrue(res == expectedResult);
		verify(dbOperation).getUser();
	}

	@Test
	void testUserBIG(){
		User user = new User("Alin", Risc.BIG);
		when(dbOperation.getUser()) .thenReturn(user);
		OperatiiDobanda operatiiDobanda = new OperatiiDobanda(dbOperation);
		int res = operatiiDobanda.calcUserDobanda();
		int expectedResult = 20;
		assertTrue(res == expectedResult);
		verify(dbOperation).getUser();
	}

}
