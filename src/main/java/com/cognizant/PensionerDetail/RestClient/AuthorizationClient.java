package com.cognizant.PensionerDetail.RestClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.PensionerDetail.exception.PensionerNotFoundException;

//@FeignClient(name="authorizationService", url="http://localhost:9000")
@FeignClient(name="authorizationService", url="${authorization_service_uri}")
public interface AuthorizationClient {
	
	@GetMapping("/validate")
	public ResponseEntity<?> authorization(@RequestHeader("Authorization") String token);

	 
}
