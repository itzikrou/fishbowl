package me.fishbowl.facebookSDK.objects;

public class Employer
{
	@Override
	public String toString()
	{
		return "Employer [id=" + id + ", name=" + name + "]";
	}

	private String id;
	private String name;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
