package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class FriendsPublicUserDetails
{
	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		for (FacebookUserData details : data)
		{
			buffer.append(details.toString() + "\n");
		}
		return "FriendsPublicUserDetails: " + buffer.toString();
	}

	public List<FacebookUserData> getData()
	{
		return data;
	}

	public void setData(List<FacebookUserData> data)
	{
		this.data = data;
	}

	List<FacebookUserData> data;
}
