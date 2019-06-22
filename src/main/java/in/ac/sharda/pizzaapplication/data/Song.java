package in.ac.sharda.pizzaapplication.data;

public class Song {
	
	private String url;
	private String title;
	private String author;
	private String mrl;
	
	public String getUrl() {
		return url;
	}

	private void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		this.author = author;
	}

	public String getMrl() {
		return mrl;
	}

	private void setMrl(String mrl) {
		this.mrl = mrl;
	}

	public Song(String link,String titl,String auth,String ml)
	{
		setUrl(link);
		setTitle(titl);
		setAuthor(auth);
		setMrl(ml);
	}
}
