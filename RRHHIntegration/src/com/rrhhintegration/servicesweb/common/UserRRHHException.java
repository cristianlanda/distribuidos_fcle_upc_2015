package com.rrhhintegration.servicesweb.common;

public class UserRRHHException extends Exception{
	private static final long serialVersionUID = 1L;
	private String codeMessage;
	
	/**
	 * Constructor por defecto
	 */
	public UserRRHHException() {
    }
	
	
	/**
	 * @param codeMessage
	 * @param cause
	 */
	public UserRRHHException(String codeMessage, Throwable cause) {
        super(cause);
        this.codeMessage=codeMessage;
    }

    /**
     * @param codeMessage
     * @param message
     * @param cause
     */
    public UserRRHHException(String codeMessage, String message, Throwable cause) {
        super(message, cause);
        this.codeMessage=codeMessage;
    }

    /**
     * @param codeMessage
     * @param message
     */
    public UserRRHHException(String codeMessage, String message) {
        super(message);
        this.codeMessage=codeMessage;
    }
    

	/**
	 * @return the codeMessage
	 */
	public String getCodeMessage() {
		return codeMessage;
	}

	/**
	 * @param codeMessage the codeMessage to set
	 */
	public void setCodeMessage(String codeMessage) {
		this.codeMessage = codeMessage;
	}

}

