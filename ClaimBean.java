package com.wipro.medclaim.bean;

public class ClaimBean {
	
	 int claimId;
	 String userId;	
	 String natureOfClaim;
	 String illness;
	 double amount;
	 String month;
	 String year;
	 double totalClaim;
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNatureOfClaim() {
		return natureOfClaim;
	}
	public void setNatureOfClaim(String natureOfClaim) {
		this.natureOfClaim = natureOfClaim;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getTotalClaim() {
		return totalClaim;
	}
	public void setTotalClaim(double totalClaim) {
		this.totalClaim = totalClaim;
	}
	
	

}
