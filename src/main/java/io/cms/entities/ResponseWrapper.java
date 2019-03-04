package io.cms.entities;

/**
 * 
 * @author Vitor Correa
 * @date 4 Mar 2019
 */
public class ResponseWrapper {

	private String operationResult;
	private String operationName;

	public String getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

}
