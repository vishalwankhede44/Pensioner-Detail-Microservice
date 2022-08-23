package com.cognizant.PensionerDetail.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.PensionerDetail.RestClient.AuthorizationClient;
import com.cognizant.PensionerDetail.exception.CustomException;
import com.cognizant.PensionerDetail.exception.PensionerNotFoundException;
import com.cognizant.PensionerDetail.model.BankDetail;
import com.cognizant.PensionerDetail.model.PensionerDetail;
import com.cognizant.PensionerDetail.repository.PensionerDetailRepository;
import com.cognizant.PensionerDetail.service.PensionerDetailService;

@RestController
@CrossOrigin
@SuppressWarnings("PMD.GuardLogStatementJavaUtil")
public class PensionerDetailController {

	@Autowired
	private PensionerDetailService service;
	
	@Autowired
	private PensionerDetailRepository pensionerDetailRepository;
	
	@Autowired
	private AuthorizationClient authorizationClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailController.class);

	@GetMapping("/pensionerDetailByAadhar/{aadhaarNumber}")
	public ResponseEntity<Optional<PensionerDetail>> pensionerDetailsByAadhar(@RequestHeader("Authorization") String token,@PathVariable Long aadhaarNumber) throws Exception{
		
		LOGGER.info("PensionerDetailCotroller - pensionerDetailsByAadhar - {} - Started",aadhaarNumber);
		try{
			if(authorizationClient.authorization(token).getStatusCode() == HttpStatus.OK){
				 Optional<PensionerDetail> pensionerDetail =  pensionerDetailRepository.findById(aadhaarNumber);
				 if(pensionerDetail.isPresent()){
					 LOGGER.info("PensionerDetailCotroller - pensionerDetailsByAadhar - {} - Data Present in DB - Ended Successfully",aadhaarNumber);
					 return ResponseEntity.ok(pensionerDetail);
				 }
				 else{
					 throw new PensionerNotFoundException("Invalid pensioner detail provided, please provide valid detail");
				 }
			}
		}catch(PensionerNotFoundException pne){
			if(LOGGER.isDebugEnabled())
				LOGGER.debug("PensionerDetailCotroller - pensionerDetailsByAadhar - {} - Data Not Present in DB - Ended with Exception {} ",aadhaarNumber,pne.getMessage());
			throw pne;
		}
		catch(Exception e){
			if(LOGGER.isDebugEnabled())
				LOGGER.debug("PensionerDetailCotroller - pensionerDetailsByAadhar - {} - Data Present in DB - Ended with Exception (Invalid Token) {}",aadhaarNumber,e.getMessage());
			throw new CustomException("Invalid Token");
		}
		return null;
		
	}
	
	
	
}
