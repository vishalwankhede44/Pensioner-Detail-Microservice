package com.cognizant.PensionerDetail.model;

import javax.persistence.Embeddable;

@Embeddable
public class BankDetail {

	private String bankName;
	private Long accountNumber;
	private Boolean isPublicBank;
	
	public BankDetail(){}
	
	public BankDetail(String bankName, Long accountNumber, Boolean isPublicBank) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.isPublicBank = isPublicBank;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Boolean getIsPublicBank() {
		return isPublicBank;
	}
	public void setIsPublicBank(Boolean isPublicBank) {
		this.isPublicBank = isPublicBank;
	}
	
	
	
}
