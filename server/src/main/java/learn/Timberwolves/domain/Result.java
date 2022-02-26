package learn.Timberwolves.domain;

import java.util.ArrayList;

public class Result<T>
{

	private ActionStatus status = ActionStatus.SUCCESS;
	private ArrayList<String> messages = new ArrayList<>();
	private T t;

	public ActionStatus getStatus()
	{
		return status;
	}

	public ArrayList<String> getMessages()
	{
		return messages;
	}

	public T getPayload()
	{
		return t;
	}

	public void setPayload(T t)
	{
		this.t = t;
	}

	public void addMessage(ActionStatus status, String message)
	{
		this.status = status;
		messages.add(message);
	}

	public boolean isSuccess()
	{
		return messages.size() == 0;
	}
}
