package me.fishbowl.facebookSDK.objects;

public class EventData
{
	@Override
	public String toString()
	{
		return "EventData [name=" + name + ", start_time=" + start_time + ", end_time=" + end_time + ", location=" + location + ", id=" + id
				+ ", rsvp_status=" + rsvp_status + "]";
	}

	private String name;
	private String start_time;
	private String end_time;
	private String location;
	private String id;
	private String rsvp_status;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getStart_time()
	{
		return start_time;
	}

	public void setStart_time(String start_time)
	{
		this.start_time = start_time;
	}

	public String getEnd_time()
	{
		return end_time;
	}

	public void setEnd_time(String end_time)
	{
		this.end_time = end_time;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getRsvp_status()
	{
		return rsvp_status;
	}

	public void setRsvp_status(String rsvp_status)
	{
		this.rsvp_status = rsvp_status;
	}

}
