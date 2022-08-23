package com.cognizant.PensionerDetail;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.PensionerDetail.controllerTest.PensionerDetailControllerTest;
import com.cognizant.PensionerDetail.modelTest.PensionerDetailModelTest;
import com.cognizant.PensionerDetail.serviceTest.PensionerDetailServiceTest;

@RunWith(Suite.class)
@SuiteClasses({PensionerDetailModelTest.class,PensionerDetailControllerTest.class,PensionerDetailServiceTest.class})

public class PensionerDetailApplicationTests {

}
