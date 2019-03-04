package io.cms.exceptions;

/**
 * 
 * @author Vitor Correa
 * @date 4 Mar 2019
 */

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -4779185919341502388L;

	public ServiceException(String message) {
		super(message);
	}

}
