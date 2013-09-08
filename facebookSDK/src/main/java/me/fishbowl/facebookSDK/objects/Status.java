package me.fishbowl.facebookSDK.objects;

public class Status {

	private String message;
	private long time;
	private String status_id;
	private long comment_count;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}

	public long getComment_count() {
		return comment_count;
	}

	public void setComment_count(long comment_count) {
		this.comment_count = comment_count;
	}

	@Override
	public String toString() {
		return "Status [message=" + message + ", time=" + time + ", status_id="
				+ status_id + ", comment_count=" + comment_count + "]";
	}

}
