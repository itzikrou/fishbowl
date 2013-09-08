package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class ProfilePicturePicData
{

	private String pid;
	private String src;
	private int src_height;
	private int src_width;
	private List<ProfilePictureImages> images;
	private String link;
	private String created;
	private String modified;

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getSrc()
	{
		return src;
	}

	public void setSrc(String src)
	{
		this.src = src;
	}

	public int getSrc_height()
	{
		return src_height;
	}

	public void setSrc_height(int src_height)
	{
		this.src_height = src_height;
	}

	public int getSrc_width()
	{
		return src_width;
	}

	public void setSrc_width(int src_width)
	{
		this.src_width = src_width;
	}

	public List<ProfilePictureImages> getImages()
	{
		return images;
	}

	public void setImages(List<ProfilePictureImages> images)
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

	public String getCreated()
	{
		return created;
	}

	public void setCreated(String created)
	{
		this.created = created;
	}

	public String getModified()
	{
		return modified;
	}

	public void setModified(String modified)
	{
		this.modified = modified;
	}

}
