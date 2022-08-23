package com.cognizant.PensionerDetail.modelTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cognizant.PensionerDetail.model.BankDetail;
import com.cognizant.PensionerDetail.model.PensionerDetail;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PensionerDetailModelTest {
	
	@Test
	public void testNoArgsBankDetailTest() {
		assertThat(new BankDetail()).isNotNull();
	}

	@Test
	public void testAllArgsBankDetailTest() {
		
		BankDetail bankDetails = new BankDetail("SBI", 12345678L, true) ;
		assertNotNull(bankDetails) ;
	}
	

	@Test
	public void testSetterBankTest() {
		BankDetail bankDetails = new BankDetail();
		bankDetails.setAccountNumber(102233445566L);
		bankDetails.setBankName("SBI");
		bankDetails.setIsPublicBank(true);;
		assertThat(assertThat(bankDetails).isNotNull());

	}
	
	@Test
	public void getterBankDetailTest() {
		BankDetail bankDetails = new BankDetail("SBI", 12345678L, true) ;
		assertEquals("SBI", bankDetails.getBankName()) ;
		assertEquals(12345678L, bankDetails.getAccountNumber()) ;
		assertEquals(true, bankDetails.getIsPublicBank()) ;
	}
	
	@Test
	public void testPenionerDetailsGettersSetters(){
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection();
		beanTester.testBean(PensionerDetail.class);
	}

	
}
