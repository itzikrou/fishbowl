package me.fishbowl.facebookSDK.objects;

public class GroupsData
{

	@Override
	public String toString()
	{
		return "GroupsData [version=" + version + ", name=" + name + ", id=" + id + ", unread=" + unread + ", bookmark_order=" + bookmark_order + "]";
	}

	private String version;
	private String name;
	private String id;
	private int unread;
	private String bookmark_order;

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

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

	public int getUnread()
	{
		return unread;
	}

	public void setUnread(int unread)
	{
		this.unread = unread;
	}

	public String getBookmark_order()
	{
		return bookmark_order;
	}

	public void setBookmark_order(String bookmark_order)
	{
		this.bookmark_order = bookmark_order;
	}

}
