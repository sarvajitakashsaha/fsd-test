package com.cts.newsReporter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MockMVCTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MockMVCTest.class);
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		System.out.println("this is executed before");
	}

	@After
	public void after() {
		System.out.println("this is executed after the test");
	}
	@Test
	public void tsetSignupStatus() throws Exception {
		LOGGER.info(" START");
		String EMPLOYEE_REQUEST = "{\"name\":\"aka4\"," + "\"email\":\"saghj\","
                + "\"password\":\"A123456\"," + "\"status\":\"false\"," + "\"language\":{\"id\":\"1\"},"
                + "\"role\":{\"id\":1}}";

		LOGGER.info("USER IS GETTING ADDED");
		mockMvc.perform(post("/user/save").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.signupStatus").value("true"))
				.andExpect(jsonPath("$.emailExist").value("false"));
		LOGGER.info(" End");
	}
	
	@Test
	public void tsetEmailExist() throws Exception {
		LOGGER.info(" START");
		String EMPLOYEE_REQUEST = "{\"name\":\"aka4\"," + "\"email\":\"saha\","
                + "\"password\":\"A123456\"," + "\"status\":\"false\"," + "\"language\":{\"id\":\"1\"},"
                + "\"role\":{\"id\":1}}";

		LOGGER.info("USER IS GETTING ADDED");
		mockMvc.perform(post("/user/save").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.signupStatus").value("false"))
				.andExpect(jsonPath("$.emailExist").value("true"));
		LOGGER.info(" End");
	}
	
	@Test
	public void invalidEmail() throws Exception {
		LOGGER.info(" START");
		String EMPLOYEE_REQUEST = "{\"name\":\"aka4\"," + "\"email\":\"s\","
                + "\"password\":\"A123456\"," + "\"status\":\"false\"," + "\"language\":{\"id\":\"1\"},"
                + "\"role\":{\"id\":1}}";

		LOGGER.info("USER IS GETTING ADDED");
		mockMvc.perform(post("/user/save").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info(" End");
	}
	
	@Test
	public void invalidName() throws Exception {
		LOGGER.info(" START");
		String EMPLOYEE_REQUEST = "{\"name\":\"a\"," + "\"email\":\"sasd\","
                + "\"password\":\"A123456\"," + "\"status\":\"false\"," + "\"language\":{\"id\":\"1\"},"
                + "\"role\":{\"id\":1}}";

		LOGGER.info("USER IS GETTING ADDED");
		mockMvc.perform(post("/user/save").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info(" End");
	}
	@Test
	public void nullUser() throws Exception {
		LOGGER.info(" START");
		String EMPLOYEE_REQUEST = "{\"email\":\"sasdwe\","
                + "\"password\":\"A123456\"," + "\"status\":\"false\"," + "\"language\":{\"id\":\"1\"},"
                + "\"role\":{\"id\":1}}";

		LOGGER.info("USER IS GETTING ADDED");
		mockMvc.perform(post("/user/save").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info(" End");
	}
	@Test
	public void nullEmail() throws Exception {
		LOGGER.info(" START");
		String EMPLOYEE_REQUEST = "{\"name\":\"a\"," + "\"password\":\"A123456\"," + "\"status\":\"false\"," + "\"language\":{\"id\":\"1\"},"
                + "\"role\":{\"id\":1}}";

		LOGGER.info("USER IS GETTING ADDED");
		mockMvc.perform(post("/user/save").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info(" End");
	}
	
	@Test
	public void testUser() throws Exception {
		LOGGER.info(" START");
		mockMvc.perform(
				get("/user/analyst/akjs").contentType("application/json;charset=UTF-8")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
		.andExpect(jsonPath("$.email").value("akjs"));
		LOGGER.info(" End");

	}
	@Test
	public void changeUserStatusTest() throws Exception {
		LOGGER.info(" START");
		mockMvc.perform(
				get("/user/saveuser/akjs").contentType("application/json;charset=UTF-8")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
		.andExpect(jsonPath("$.status").value(false));
		LOGGER.info(" End");

	}
	
	
	
	@Test
	public void addFavouriteArticleTest() throws Exception {
		LOGGER.info(" START");
		String EMPLOYEE_REQUEST = "{\r\n" + 
				"	\"email\":\"saha\",\r\n" + 
				"	\"article\" : [\r\n" + 
				"		{\r\n" + 
				"			\"title\" : \"java\"\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}";

		LOGGER.info("USER IS GETTING ADDED");
		mockMvc.perform(post("/user/savearticle").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is2xxSuccessful());
		LOGGER.info(" End");
	}
	
	@Test
	public void deleteFavouriteArticleTest() throws Exception {
		LOGGER.info(" START");
		String EMPLOYEE_REQUEST = "{\r\n" + 
				"	\"email\":\"saha\",\r\n" + 
				"	\"article\" : [\r\n" + 
				"		{\r\n" + 
				"			\"title\" : \"java\"\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}";

		LOGGER.info("USER IS GETTING ADDED");
		mockMvc.perform(post("/user/removerticle").content(EMPLOYEE_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is2xxSuccessful());
		LOGGER.info(" End");
	}
	
	


}
