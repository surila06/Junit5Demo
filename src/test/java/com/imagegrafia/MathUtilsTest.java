package com.imagegrafia;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
	
	MathUtils mathUtils;
	
	@BeforeAll
	  static void beforeAllInit() {
		
		System.out.println("This needs to run before all");
	}
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo=testInfo;
		
		
		mathUtils= new MathUtils();	
	 
	}
	@Nested
	@Tag("Math")
	class AddTest{
		
		@Test
		@DisplayName("Testing Add method for negative")
		void testAddNegative() {
			
			//boolean isServerUp=false;
			//assumeTrue(isServerUp);
			int expected=-2;
			int actual=mathUtils.add(-1,-1);
			assertEquals(expected, actual,"The add method should add two numbers");	
		
		}
		
		@Test
		@DisplayName("Testing Add method for positive")
		void testAddPositive() {
			
			//boolean isServerUp=false;
			//assumeTrue(isServerUp);
			int expected=2;
			int actual=mathUtils.add(1,1);
			assertEquals(expected, actual,"The add method should add two numbers");	
		
		}
		
		
		
	}
	
	@AfterEach
	void cleanup() {
		
		System.out.println("Cleaning up.....");
	}

	@Test
	@DisplayName("Testing Add metod")
	void testAdd() {
		
		//boolean isServerUp=false;
		//assumeTrue(isServerUp);
		int expected=2;
		int actual=mathUtils.add(1,1);
		assertEquals(expected, actual,"The add method should add two numbers");	
	
	}
	@Tag("Circle")
	@RepeatedTest(2)
	@DisplayName("Testing Circle Area metod")
	void testComputeCircleArea(RepetitionInfo repition) {
		//if(repition.getTotalRepetitions()==1)
		assertEquals(314.1592653589793,mathUtils.computeCircleArea(10),"Should return correct circle area");
		
		
	}
	 
	@Test
	//@EnabledOnOs(OS.LINUX)
	@DisplayName("Testing Divide metod")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),"Divide by zero should throw exceptions");
		
	}
	
	
	@Test
	@DisplayName("Multiply method")
	void testMultiply() {
		//assertEquals(4,mathUtils.multiply(2,2),"Should return the right product");
		assertAll(
				() ->assertEquals(4,mathUtils.multiply(2,2)),
				() ->assertEquals(0,mathUtils.multiply(2,0)),
				() ->assertEquals(-2,mathUtils.multiply(2,-1))
				);
		
	}
	@Test
	@Disabled
	@DisplayName("A disabled method")
	void disabledTest() {
		fail("This test id disabled"); 
	}
	

}
