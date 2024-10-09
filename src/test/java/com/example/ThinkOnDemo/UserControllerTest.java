package com.example.ThinkOnDemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

public class UserControllerTest extends BaseControllerTest{
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void whenCreateSucess() throws Exception {
		String content = "{\"id\":null,\"username\":\"controllerTester\",\"firstName\":\"nina\",\"lastName\":\"Lin\",\"email\":\"nina@gmail.com\",\"phoneNumber\":\"2455588585\",\"available\":\"true\"}";
		String result = mockMvc
				.perform(
						post("/api/users")
						.content(content)
						.contentType( MediaType.APPLICATION_JSON_VALUE ))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.id").isNumber())
				.andReturn().getResponse()
				.getContentAsString();
		
		System.out.println(result);
	}
}
