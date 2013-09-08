package me.fishbowl.facebookSDK.objects;

public class PhotoAlbumData
{
	@Override
	public String toString()
	{
		return "PhotoAlbumData [id=" + id + ", from=" + from + ", name=" + name + ", link=" + link + ", cover_photo=" + cover_photo + ", privacy="
				+ privacy + ", count=" + count + ", type=" + type + ", created_time=" + created_time + ", updated_time=" + updated_time
				+ ", can_upload=" + can_upload + ", likes=" + likes + ", comments=" + comments + "]";
	}

	private String id;
	private From from;
	private String name;
	private String link;
	private String cover_photo;
	private String privacy;
	private int count;
	private String type;
	private String created_time;
	private String updated_time;
	private boolean can_upload;
	private Likes likes;
	private Comments comments;

	public Likes getLikes()
	{
		return likes;
	}

	public void setLikes(Likes likes)
	{
		this.likes = likes;
	}

	public Comments getComments()
	{
		return comments;
	}

	public void setComments(Comments comments)
	{
		this.comments = comments;
	}

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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getCover_photo()
	{
		return cover_photo;
	}

	public void setCover_photo(String cover_photo)
	{
		this.cover_photo = cover_photo;
	}

	public String getPrivacy()
	{
		return privacy;
	}

	public void setPrivacy(String privacy)
	{
		this.privacy = privacy;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getCreated_time()
	{
		return created_time;
	}

	public void setCreated_time(String created_time)
	{
		this.created_time = created_time;
	}

	public String getUpdated_time()
	{
		return updated_time;
	}

	public void setUpdated_time(String updated_time)
	{
		this.updated_time = updated_time;
	}

	public boolean isCan_upload()
	{
		return can_upload;
	}

	public void setCan_upload(boolean can_upload)
	{
		this.can_upload = can_upload;
	}

}
