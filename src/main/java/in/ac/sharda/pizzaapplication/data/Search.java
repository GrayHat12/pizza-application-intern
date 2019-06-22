package in.ac.sharda.pizzaapplication.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Search {
	
	private String term;
	private List<String> songList;
	
	public List<String> getSongList() {
		return songList;
	}
	
	public Search(String query)
	{
		songList = new ArrayList<>();
		this.term=query;
		makeSearch();
	}

	private void makeSearch() {
		try {
            URL url = new URL("https://www.youtube.com/results?search_query=" + URLEncoder.encode(this.term, "UTF-8"));
            HttpsURLConnection urlConnection=(HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            String code = toString(urlConnection.getInputStream());
            while(code.contains("watch?v="))
            {
                code=code.substring(code.indexOf("watch?v="));
                String tmp=code.substring(0,11+"watch?v=".length());
                System.out.println("https://www.youtube.com/"+tmp);
                if(!this.songList.contains("https://www.youtube.com/"+tmp))
                {
                    this.songList.add("https://www.youtube.com/"+tmp);
                    System.out.println("UNIQUE : https://www.youtube.com/"+tmp);
                }
                code=code.substring(12);
            }
            System.out.println("GOT LINKS : "+this.songList.size());
            //return this.songList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("GOT LINKS ERROR");
            //return links;
        }
	}
	
	private static String toString(InputStream inputStream) throws IOException
    {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")))
        {
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(inputLine);
            }

            return stringBuilder.toString();
        }
    }
	
	
}
