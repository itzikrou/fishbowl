package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class ProfilePicureTags
{
	@Override
	public String toString()
	{
		return "ProfilePicureTags [data=" + data + "]";
	}

	private List<TagData> data;

	public List<TagData> getData()
	{
		return data;
	}

	public void setData(List<TagData> data)
	{
		this.data = data;
	}

}
