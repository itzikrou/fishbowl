package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class Request
{
	List<RequestObj> data;

	public List<RequestObj> getData()
	{
		return data;
	}

	public void setData(List<RequestObj> data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "Request [data=" + data + "]";
	}

}
