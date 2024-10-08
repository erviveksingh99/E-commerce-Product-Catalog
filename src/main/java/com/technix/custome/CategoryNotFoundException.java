package com.technix.custome;

@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException{
	public CategoryNotFoundException(String msg) {
		super(msg);
	}
}
