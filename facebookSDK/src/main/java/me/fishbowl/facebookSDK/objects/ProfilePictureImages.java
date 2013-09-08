package me.fishbowl.facebookSDK.objects;

public class ProfilePictureImages
{
	@Override
	public String toString()
	{
		return "ProfilePictureImages [height=" + height + ", width=" + width + ", source=" + source + "]";
	}

	private int height;
	private int width;
	private String source;

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

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

}
