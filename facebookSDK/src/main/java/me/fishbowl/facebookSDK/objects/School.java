package me.fishbowl.facebookSDK.objects;

public class School
{
	@Override
	public String toString()
	{
		return "School [id=" + id + ", name=" + name + ", type=" + type + ", degree=" + degree + "]";
	}

	private String id;
	private String name;
	private String type;
	private String degree;

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDegree()
	{
		return degree;
	}

	public void setDegree(String degree)
	{
		this.degree = degree;
	}

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
