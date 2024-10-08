package com.technix.custome;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException{
	
	public IdNotFoundException(String msg) {
		super(msg);
	}
}
