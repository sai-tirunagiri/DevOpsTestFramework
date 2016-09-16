/**
 * 
 */
package com.quinnox.wso2testautomation.exception;

import java.sql.SQLException;

/**
 * @author daravatu
 *
 */
public class DAOException extends SQLException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5964230441931940890L;
	private String message;
	
	
	/**
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
		this.setMessage(message);
	}
	
	
	
	/**
	 * @param message
	 */
	public DAOException(String message, Throwable throwable) {
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
