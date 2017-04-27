package com.wipro.medclaim.util;

public class ExceededClaimLimitException extends Exception {
	
	public String toString()
	{
		return "You have exceeded the claim limit";
	}

}
