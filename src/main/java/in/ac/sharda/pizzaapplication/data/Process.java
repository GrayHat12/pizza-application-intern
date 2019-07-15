package in.ac.sharda.pizzaapplication.data;

import java.util.ArrayList;
import java.util.List;

public class Process {
	
	List<String> songList;
	List<Song> finalList;
	
	public List<Song> getFinalList() {
		return this.finalList;
	}

	public Process(List<String> songs)
	{
		this.songList=songs;
		this.finalList=new ArrayList<>();
	}
	
	public void process()
	{
		this.songList.parallelStream().forEach((link) -> {
			if(link.startsWith("https:"))
            {
                String title,author,mrl,thumb;
                try
                {
                	String output=execCmd("python getData.py "+link);
                	List<String> tokens=new GrayTokenizer(output,'\n').tokenize();
                	title=tokens.get(0);
                	author=tokens.get(1);
                	mrl=tokens.get(2);
                	thumb=tokens.get(3);
                	Song song=new Song(link,title,author,mrl,thumb);
                	this.finalList.add(song);
                }
                catch(Exception ex)
                {
                	ex.printStackTrace();
                }
            }
		});
	}
	
	public String execCmd(String cmd) throws java.io.IOException {
	    java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
	
}
