package com.cognizant.PensionerDetail.controllerTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.PensionerDetail.controller.PensionerDetailController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PensionerDetailControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PensionerDetailController pensionerDetailController;
	
	@Test
	public void contextLoads() {
		assertNotNull(pensionerDetailController);
	}
	
	@Test
	public void testWithValidAadhaar() throws Exception{
		ResultActions actions = mockMvc.
									perform(get("/pensionerDetailByAadhar/329612345677")
											.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXNoYWwiLCJleHAiOjE2NjExNDAxMDAsImlhdCI6MTY2MTEzNjUwMH0._eYFnU4qcam6q93yZxSCyjVEo6ogYs7mMwi1-INscsg")
											.contentType(MediaType.APPLICATION_JSON));
		actions.andExpect(status().isOk());
	}
	
	@Test
	public void testWithInvalidAadhaar() throws Exception{
		ResultActions actions = mockMvc.
									perform(get("/pensionerDetailByAadhar/3296123456")
											.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJWaXNoYWwiLCJleHAiOjE2NjExNDAxMDAsImlhdCI6MTY2MTEzNjUwMH0._eYFnU4qcam6q93yZxSCyjVEo6ogYs7mMwi1-INscsg")
											.contentType(MediaType.APPLICATION_JSON));
		actions.andExpect(status().isNotFound());
	}

}
