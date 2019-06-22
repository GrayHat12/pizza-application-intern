package in.ac.sharda.pizzaapplication.data;

import java.util.ArrayList;
import java.util.List;

public class Songs {
	
	List<Song> songs;
	
	public Songs(String query)
	{
		Search ob=new Search(query);
		List<String> tsong=ob.getSongList();
		Process ob2=new Process(tsong);
		ob2.process();
		songs=ob2.getFinalList();
	}

	public List<Song> getSongs() {
		return songs;
	}
	

}
