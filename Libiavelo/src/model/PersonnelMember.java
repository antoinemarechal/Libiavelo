package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.enumerations.WorkType;

public class PersonnelMember extends Person {
	private String id;
	
	private WorkType function;

	private String hashedPassword;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/	
	public PersonnelMember(WorkType function) {
		this.setFunction(function);
	}
	
	public PersonnelMember() {
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public String getId() {
		return id;
	}
	
	public WorkType getFunction() {
		return function;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setFunction(WorkType function) {
		this.function = function;
	}
	
	public void setID(String id) {
		this.id = id;
	}

	public void setHashedPassword(String hashedPassword) 
	{
		this.hashedPassword = hashedPassword;		
	}

	public boolean isEnteredPasswordValid(String clearPassword)
	{
		MessageDigest hashTool;
		
		try {
			hashTool = MessageDigest.getInstance("SHA-256");
			
			byte[] hash = hashTool.digest(clearPassword.getBytes(StandardCharsets.UTF_8));
			
			StringBuilder hexString = new StringBuilder();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString().toUpperCase().equals(hashedPassword.toUpperCase());

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
}
