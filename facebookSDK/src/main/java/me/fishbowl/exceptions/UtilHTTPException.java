package me.fishbowl.exceptions;

public class UtilHTTPException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UtilHTTPException(String msg)
	{
		super(msg);
	}

	public UtilHTTPException(String msg, Exception e)
	{
		super(msg, e);
	}
}
