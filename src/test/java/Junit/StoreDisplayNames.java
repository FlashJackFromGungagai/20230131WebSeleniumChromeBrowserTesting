package Junit;

import java.util.ArrayList;
import java.util.List;

public class StoreDisplayNames 
{
	// this class stores the displaynames
	
	private int indx = 0;
	private String nme = "";
	private List<String> EventDisplayNames = new ArrayList<>();
	//private List<String> tmp2 = new ArrayList<>();
	
	//=========================================================================	
	/*  This adds an event to the array list of events.
	 * 	It also updated an index value.
	 */
	
	public void addEvent (String EventName)
	{
		EventDisplayNames.add(EventName);
		indx++;
	}
	
	//=========================================================================	
	/*  
	 * 
	 */
	
	public List<String> getPreviousEventNames()
	{
		return EventDisplayNames;
	}
	
	//=========================================================================	
	/*  
	 * 
	 */
	
	
	public int getIndex()
	{
		return indx;
	}
	
	/*
	
	These accessors have been commented out.
	
	public void setIndex (int index)
	{
		indx= index;
	}
	
	public void setName (String name)
	{
		nme =name;
	}
	
	

	
	public String getName()
	{
		return nme;
	}
	
	
	*/
	
	
	
	

}//close class StoreDisplayNames
