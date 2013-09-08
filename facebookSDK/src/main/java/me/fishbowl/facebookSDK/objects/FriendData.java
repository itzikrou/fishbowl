package me.fishbowl.facebookSDK.objects;

public class FriendData
{
	public FriendData(String id, String name)
	{
		this.id = id;
		this.name = name;		
	}
	
	public FriendData(String id)
	{
		this.id = id;		
	}

	@Override
	public String toString()
	{
		return "FriendData [name=" + name + ", id=" + id + "]";
	}

	private String name;
	private String id;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

}
