package me.fishbowl.facebookSDK.objects;

public class NotesData
{

	@Override
	public String toString()
	{
		return "NotesData [id=" + id + ", from=" + from + ", subject=" + subject + ", message=" + message + ", icon=" + icon + ", created_time="
				+ created_time + ", updated_time=" + updated_time + "]";
	}

	private String id;
	private From from;
	private String subject;
	private String message;
	private String icon;
	private String created_time;
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

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
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

	public String getUpdated_time()
	{
		return updated_time;
	}

	public void setUpdated_time(String updated_time)
	{
		this.updated_time = updated_time;
	}

}
