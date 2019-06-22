package in.ac.sharda.pizzaapplication.data;

import java.util.List;

public class SongData {

	String url="https://www.youtube.com/watch?v=";
	Song song;
	
	public SongData(String link)
	{
		this.url+=link;
	}
	
	public Song getData()
	{
		try
        {
        	String output=execCmd("python getData.py "+this.url);
        	List<String> tokens=new GrayTokenizer(output,'\n').tokenize();
        	String title=tokens.get(0);
        	String author=tokens.get(1);
        	String mrl=tokens.get(2);
        	song=new Song(this.url,title,author,mrl);
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
		return song;
	}
	
	public String execCmd(String cmd) throws java.io.IOException {
	    java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
	
}
