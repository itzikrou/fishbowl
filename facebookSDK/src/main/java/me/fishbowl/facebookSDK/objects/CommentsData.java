package me.fishbowl.facebookSDK.objects;

public class CommentsData
{
	@Override
	public String toString()
	{
		return "CommentsData [id=" + id + ", from=" + from + ", message=" + message + ", can_remove=" + can_remove + ", created_time=" + created_time
				+ ", like_count=" + like_count + ", user_likes=" + user_likes + ", paging=" + paging + "]";
	}

	private String id;
	private From from;
	private String message;
	private boolean can_remove;
	private String created_time;
	private int like_count;
	private boolean user_likes;
	private Paging paging;

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

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public boolean isCan_remove()
	{
		return can_remove;
	}

	public void setCan_remove(boolean can_remove)
	{
		this.can_remove = can_remove;
	}

	public String getCreated_time()
	{
		return created_time;
	}

	public void setCreated_time(String created_time)
	{
		this.created_time = created_time;
	}

	public int getLike_count()
	{
		return like_count;
	}

	public void setLike_count(int like_count)
	{
		this.like_count = like_count;
	}

	public boolean isUser_likes()
	{
		return user_likes;
	}

	public void setUser_likes(boolean user_likes)
	{
		this.user_likes = user_likes;
	}

	public Paging getPaging()
	{
		return paging;
	}

	public void setPaging(Paging paging)
	{
		this.paging = paging;
	}

}
