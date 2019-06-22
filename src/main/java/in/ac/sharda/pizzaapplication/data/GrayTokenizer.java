package in.ac.sharda.pizzaapplication.data;

import java.util.LinkedList;
import java.util.List;

public class GrayTokenizer {
	
	String text;
	
	public GrayTokenizer(String txt)
	{
		this.text=txt;
	}
	
	public List<String> tokenize()
	{
		List<String> list=new LinkedList<>();
		String tmp="";
		for(int i=0;i<this.text.length();i++)
		{
			if(this.text.charAt(i)=='\n')
			{
				list.add(tmp);
				tmp="";
			}
			else
			{
				tmp+=this.text.charAt(i);
			}
		}
		list.add(tmp);
		return list;
	}
	
}
