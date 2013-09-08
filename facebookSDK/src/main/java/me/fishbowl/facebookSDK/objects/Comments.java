package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class Comments
{
	List<CommentsData> data;
	private Paging paging;

	public List<CommentsData> getData()
	{
		return data;
	}

	public void setData(List<CommentsData> data)
	{
		this.data = data;
	}

	public Paging getPaging()
	{
		return paging;
	}

	@Override
	public String toString()
	{
		return "Comments [data=" + data + ", paging=" + paging + "]";
	}

	public void setPaging(Paging paging)
	{
		this.paging = paging;
	}

}
