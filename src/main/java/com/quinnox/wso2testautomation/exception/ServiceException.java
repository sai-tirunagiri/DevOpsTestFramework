/**
 * 
 */
package com.quinnox.wso2testautomation.exception;

/**
 * @author daravatu
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8351565970603384107L;
	private String message;
	
	public ServiceException(String message) {
		super(message);
		this.setMessage(message);
	}
	


	/**
	 * @param message
	 */
	public ServiceException(String message, Throwable throwable) {
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
