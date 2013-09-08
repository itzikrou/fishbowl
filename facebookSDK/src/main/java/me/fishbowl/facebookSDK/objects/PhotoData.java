package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class PhotoData
{

	@Override
	public String toString()
	{
		return "PhotoData [id=" + id + ", from=" + from + ", picture=" + picture + ", source=" + source + ", height=" + height + ", width=" + width
				+ ", images=" + images + ", link=" + link + ", icon=" + icon + ", created_time=" + created_time + ", position=" + position
				+ ", updated_time=" + updated_time + "]";
	}

	private String id;
	private From from;
	private String picture;
	private String source;
	private int height;
	private int width;
	List<Image> images;
	private String link;
	private String icon;
	private String created_time;
	private int position;
	private String updated_time;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public From getFrom()
	{
		return from;
	}

	public void setFrom(From from)
	{
		this.from = from;
	}

	public String getPicture()
	{
		return picture;
	}

	public void setPicture(String picture)
	{
		this.picture = picture;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public List<Image> getImages()
	{
		return images;
	}

	public void setImages(List<Image> images)
	{
		this.images = images;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getCreated_time()
	{
		return created_time;
	}

	public void setCreated_time(String created_time)
	{
		this.created_time = created_time;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public String getUpdated_time()
	{
		return updated_time;
	}

	public void setUpdated_time(String updated_time)
	{
		this.updated_time = updated_time;
	}

}
