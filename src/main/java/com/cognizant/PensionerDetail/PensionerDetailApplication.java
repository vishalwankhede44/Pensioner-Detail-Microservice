package com.cognizant.PensionerDetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.annotation.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.cognizant.PensionerDetail.exception.PensionerNotFoundException;
import com.cognizant.PensionerDetail.model.BankDetail;
import com.cognizant.PensionerDetail.model.PensionerDetail;
import com.cognizant.PensionerDetail.repository.PensionerDetailRepository;
import com.cognizant.PensionerDetail.service.PensionerDetailService;


@SpringBootApplication
@EnableFeignClients
public class PensionerDetailApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailApplication.class, args);
	}

	
	
	

}
