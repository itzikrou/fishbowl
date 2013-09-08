package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class Permissions
{

	@Override
	public String toString()
	{
		return "Permissions [data=" + data + "]";
	}

	List<PermissionsData> data;

	public List<PermissionsData> getData()
	{
		return data;
	}

	public void setData(List<PermissionsData> data)
	{
		this.data = data;
	}

}
