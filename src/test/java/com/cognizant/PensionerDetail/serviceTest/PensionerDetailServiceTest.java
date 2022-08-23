package com.cognizant.PensionerDetail.serviceTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.PensionerDetail.service.PensionerDetailService;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PensionerDetailServiceTest {
	
	@InjectMocks
	private PensionerDetailService pensionerDetailService;
	
	@Test
	public void testNotNullPensionDetailServiceInstance() {
		assertNotNull(pensionerDetailService);
	}
	
	
}
