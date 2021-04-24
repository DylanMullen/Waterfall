package me.dylanmullen.waterfall.mysql.callbacks;

import java.sql.ResultSet;

import me.dylanmullen.waterfall.util.Callback;

public abstract class SQLCallback implements Callback
{

	protected long timeExecuted;
	protected ResultSet result;
	protected boolean completed;
	
	public SQLCallback()
	{
	}
	
	public void setTimeExecuted(long timeExecuted)
	{
		this.timeExecuted = timeExecuted;
	}
	
	public void setResult(ResultSet result)
	{
		this.result = result;
	}
	
	public ResultSet getResult()
	{
		return result;
	}
	
	public boolean isCompleted()
	{
		return completed;
	}
}
