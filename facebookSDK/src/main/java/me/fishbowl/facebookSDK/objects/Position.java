package me.fishbowl.facebookSDK.objects;

public class Position
{
	@Override
	public String toString()
	{
		return "Position [id=" + id + ", name=" + name + "]";
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
