package com.sample.weather.web.exception;

/**
 * Custome Exception.
 * @author Srini
 *
 */

public class CustomException extends Exception {

	private static final long serialVersionUID = 4641133562477277798L;

	private String message = "Some thing went wrong...";
	private int code;

	public CustomException(int code, String message) {
		super();
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
