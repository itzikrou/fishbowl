package me.fishbowl.facebookSDK.objects;

public class From
{
	@Override
	public String toString()
	{
		return "From [name=" + name + ", id=" + id + "]";
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
