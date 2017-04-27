package com.wipro.medclaim.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wipro.medclaim.bean.ClaimBean;
import com.wipro.medclaim.util.DBUtil;

public class ClaimDAO {
	
	Connection conn;
	public int insertClaim(ClaimBean claimBean) throws SQLException, ClassNotFoundException
	{
		try
		{
			int res =0;
		int claimId = 0;
		 String userId = claimBean.getUserId();	
		 String natureOfClaim =claimBean.getNatureOfClaim();
		 String illness= claimBean.getIllness();
		 double amount=claimBean.getAmount();
		 String month=claimBean.getMonth();
		 String year=claimBean.getYear();
		
		 conn = DBUtil.getDBConnection();
		 Statement s = conn.createStatement();
		 ResultSet rst = s.executeQuery("select * from Profile_Tb where USERID='"+userId+"'") ;
		 if(rst.next() || rst!=null)
		
		 {
			 
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery("select CLAIM_ID_SEQ.NEXTVAL from dual");
	    if(rs.next() || rs!=null)
	    {
	   	claimId = rs.getInt(1);	   		
		PreparedStatement ps = conn.prepareStatement("insert into Claim_Tb values(?,?,?,?,?,?,?)");
	    ps.setInt(1, claimId);
	    ps.setString(2, userId);
	    ps.setString(3, natureOfClaim);
	    ps.setString(4, illness);
	    ps.setDouble(5, amount);
	    ps.setString(6, month);
	    ps.setString(7, year);
	    
	    res = ps.executeUpdate();
	    if(res>0 || res == 1)
	    {
	    return res;
	    }
	    else
	    {
	    	return 0;
	    }
	    
	    }
		 }
		 
	    
		}
		
		catch(Exception e)
		{
			return 0;
		}
		return 0;
		
		
	}

	@SuppressWarnings("unused")
	public ClaimBean fetchClaim(int claimId) throws SQLException, ClassNotFoundException
	{
		try
		{
			
		
		ClaimBean cb = new ClaimBean();
		conn = DBUtil.getDBConnection();
		 Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("select * from Claim_Tb where CLAIMID ="+claimId);
		    if(rs.next() || rs!=null)
		    {
		    	cb.setClaimId(rs.getInt(1));
		    	cb.setUserId(rs.getString(2));
		    	cb.setNatureOfClaim(rs.getString(3));
		    	cb.setIllness(rs.getString(4));
		    	cb.setAmount(rs.getInt(5));
		    	cb.setMonth(rs.getString(6));
		    	cb.setYear(rs.getString(7));
		    	 return cb;
		    	
		    }
		
		   
		    	return null;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
	
	@SuppressWarnings("unused")
	public double fetchTotalClaim(String userId) throws SQLException, ClassNotFoundException
	{
		try
		{
			
		
		conn = DBUtil.getDBConnection();
		Statement st = conn.createStatement();
	    ResultSet r = st.executeQuery("select tochar(sysdate,'yyyy') from dual");
		
		 Statement stmt = conn.createStatement();
		    ResultSet rs1 = stmt.executeQuery("select sum(AMOUNT) from Claim_Tb where USERID ='"+userId+"' and YEAR ="+r.getString(1));
		    if(rs1.next() || rs1 !=null)
		    {
		    	double totalclaim =rs1.getInt(1);
		    	
		    	
		    	
		    	return totalclaim;
		    }
		    else
		    {
		    	return 0;
		    }
		}
		catch(Exception e)
		{
			return 0;
		}
		
		
		
	}
}
