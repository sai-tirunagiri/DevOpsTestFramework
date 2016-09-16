/**
 * 
 */
package com.quinnox.wso2testautomation.exception;

/**
 * @author daravatu
 *
 */
public class BusinessException extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9018974741575671046L;
	private String message;
	
	
	
	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
		this.setMessage(message);
	}
	
	
	/**
	 * @param message
	 */
	public BusinessException(String message, Throwable throwable) {
		super(message, throwable);
		this.setMessage(message);
	}


	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
