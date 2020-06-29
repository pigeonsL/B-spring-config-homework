package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "levelNumber=2")
class DemoSpringConfigApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void returnBasicWhenLevelNumberLesserThan1() throws Exception {

		String result = mockMvc.perform(MockMvcRequestBuilders.get("/level"))
				.andReturn()
				.getResponse()
				.getContentAsString();

		assertEquals("basic", result);
	}

	@Test
	public void returnBasicWhenLevelNumberEquals1() throws Exception {

		String result = mockMvc.perform(MockMvcRequestBuilders.get("/level"))
				.andReturn()
				.getResponse()
				.getContentAsString();

		assertEquals("advanced", result);
	}
	@Test
	public void returnBasicWhenLevelNumberGreaterThan1() throws Exception {

		String result = mockMvc.perform(MockMvcRequestBuilders.get("/level"))
				.andReturn()
				.getResponse()
				.getContentAsString();

		assertEquals("advanced", result);
	}



}
