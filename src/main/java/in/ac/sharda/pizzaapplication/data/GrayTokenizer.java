package in.ac.sharda.pizzaapplication.data;

import java.util.LinkedList;
import java.util.List;

public class GrayTokenizer {
	
	String text;
	char deli;
	
	public GrayTokenizer(String txt, char del)
	{
		this.text=txt;
		this.deli=del;
	}
	
	public List<String> tokenize()
	{
		List<String> list=new LinkedList<>();
		String tmp="";
		for(int i=0;i<this.text.length();i++)
		{
			if(this.text.charAt(i)==this.deli)
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
