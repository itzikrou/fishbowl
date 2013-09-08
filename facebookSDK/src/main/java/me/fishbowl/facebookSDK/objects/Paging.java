package me.fishbowl.facebookSDK.objects;

public class Paging
{

	@Override
	public String toString()
	{
		return "Paging [previous=" + previous + ", next=" + next + "]";
	}

	private String previous;
	private String next;

	public String getPrevious()
	{
		return previous;
	}

	public void setPrevious(String previous)
	{
		this.previous = previous;
	}

	public String getNext()
	{
		return next;
	}

	public void setNext(String next)
	{
		this.next = next;
	}

}
