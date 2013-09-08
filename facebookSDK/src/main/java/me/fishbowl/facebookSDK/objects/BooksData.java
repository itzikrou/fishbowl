package me.fishbowl.facebookSDK.objects;

public class BooksData
{

	private String name;
	private String category;
	private String id;
	private String created_time;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCreated_time()
	{
		return created_time;
	}

	public void setCreated_time(String created_time)
	{
		this.created_time = created_time;
	}

	@Override
	public String toString()
	{
		return "BooksData [name=" + name + ", category=" + category + ", id=" + id + ", created_time=" + created_time + "]";
	}

}
