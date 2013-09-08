package me.fishbowl.facebookSDK.objects;

public class TagData
{

	@Override
	public String toString()
	{
		return "TagData [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", created_time=" + created_time + "]";
	}

	private String id;
	private String name;
	private double x;
	private double y;
	private String created_time;

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

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public String getCreated_time()
	{
		return created_time;
	}

	public void setCreated_time(String created_time)
	{
		this.created_time = created_time;
	}

}
