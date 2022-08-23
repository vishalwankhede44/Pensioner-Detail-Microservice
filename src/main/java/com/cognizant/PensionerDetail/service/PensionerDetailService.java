package com.cognizant.PensionerDetail.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.PensionerDetail.PensionerDetailApplication;
import com.cognizant.PensionerDetail.exception.PensionerNotFoundException;
import com.cognizant.PensionerDetail.model.BankDetail;
import com.cognizant.PensionerDetail.model.PensionerDetail;
import com.cognizant.PensionerDetail.repository.PensionerDetailRepository;

@Service
@SuppressWarnings("PMD.GuardLogStatementJavaUtil")
public class PensionerDetailService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailService.class);
	
	@Autowired
	private PensionerDetailRepository pensionerDetailRepository;
	
	
	@PostConstruct
	@SuppressWarnings("PMD.AvoidFileStream")
	public void addData(){
		// TODO Auto-generated method stub
LOGGER.info("PensionerDetailService - addPensionerDetails - STARTED");
		
		List<PensionerDetail> pensionerList = new ArrayList<>();

		try{
//			final FileReader fileReader = new FileReader("src/main/resources/data.csv");
			final FileReader fileReader = new FileReader("data.csv");
			final BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(",");
				PensionerDetail pensionerDetail = new PensionerDetail();
				pensionerDetail.setAadhaarId(Long.parseLong(data[0]));
				pensionerDetail.setName(data[1]);
				pensionerDetail.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse(data[2]));
				pensionerDetail.setPan(data[3]);
				pensionerDetail.setLastSalaryEarned(Double.parseDouble(data[4]));
				pensionerDetail.setAllowances(Double.parseDouble(data[5]));
				pensionerDetail.setIsSelfPension(Boolean.parseBoolean(data[6]));
				pensionerDetail.setBankDetail(new BankDetail(data[7], Long.parseLong(data[8]), Boolean.parseBoolean(data[9])));
				
				
				pensionerList.add(pensionerDetail);
				

			}
			bufferedReader.close();
			fileReader.close();
			
			
		}catch (Exception e) {
			if(LOGGER.isDebugEnabled())
				LOGGER.debug("PensionerDetailService - addPensionerDetails - ENDED with Exception "+e.getMessage());
			throw new PensionerNotFoundException("Pensioner detail not added");
		} 
		
		pensionerDetailRepository.saveAll(pensionerList);
		LOGGER.info("PensionerDetailService - addPensionerDetails - ENDED");
	}
}
