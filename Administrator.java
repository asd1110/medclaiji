package com.wipro.medclaim.service;

import java.sql.SQLException;

import com.wipro.medclaim.bean.ClaimBean;
import com.wipro.medclaim.dao.ClaimDAO;
import com.wipro.medclaim.util.ExceededClaimLimitException;

public class Administrator {

	

	String addClaim(ClaimBean claimBean) throws SQLException,
			ClassNotFoundException {

		try {

			if (claimBean == null || claimBean.getUserId() == null) 
			{
				return "FAIL";
			}
			else 
			{

				ClaimDAO cd = new ClaimDAO();
				double totalclaim = cd.fetchTotalClaim(claimBean.getUserId());
				claimBean.setTotalClaim(totalclaim);

				if (totalclaim + claimBean.getAmount() < 10000)
				{
					int res = cd.insertClaim(claimBean);

					if (res > 0 || res ==1) {
						return "SUCCESS";
					}

					else {
						return "FAIL";
					}
				} else {
					try {
						throw new ExceededClaimLimitException();

					} catch (ExceededClaimLimitException e) {
						return "You have exceeded the claim limit";
					}
				}

			}

		} 
		catch (Exception e) {
			return "FAIL";
		}

	}

	ClaimBean viewClaim(int claimId) throws SQLException,
			ClassNotFoundException {
		ClaimDAO cd = new ClaimDAO();
		if (claimId == 0 || claimId < 1000) {
			return null;
		} else {
			ClaimBean cb = new ClaimBean();
			cb = cd.fetchClaim(claimId);
			return cb;
		}

	}
}
