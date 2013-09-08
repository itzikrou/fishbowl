package me.fishbowl.facebookSDK.objects;

public class RequestObj
{
	private String request_id;
	private String app_id;
	private String recipient_uid;
	private String sender_uid;
	private String message;
	private String data;
	private String created_time;

	public String getRequest_id()
	{
		return request_id;
	}

	public void setRequest_id(String request_id)
	{
		this.request_id = request_id;
	}

	public String getApp_id()
	{
		return app_id;
	}

	public void setApp_id(String app_id)
	{
		this.app_id = app_id;
	}

	public String getRecipient_uid()
	{
		return recipient_uid;
	}

	public void setRecipient_uid(String recipient_uid)
	{
		this.recipient_uid = recipient_uid;
	}

	public String getSender_uid()
	{
		return sender_uid;
	}

	public void setSender_uid(String sender_uid)
	{
		this.sender_uid = sender_uid;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
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
		return "Request [request_id=" + request_id + ", app_id=" + app_id + ", recipient_uid=" + recipient_uid + ", sender_uid=" + sender_uid
				+ ", message=" + message + ", data=" + data + ", created_time=" + created_time + "]";
	}

}
