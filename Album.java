
public class Album extends Media{
	

	protected String artist;
	protected String songs;
	
	public Album() {
		
	}

	public Album(String title, int copiesAvailable, String artist, String songs,String code ) {

		super(title,copiesAvailable,code);
		this.artist = artist;
		this.songs = songs;	
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Media code: "+code+", Album's title: " + title + ", copiesAvailable: " + copiesAvailable + ", artist: " + artist + ", songs: "
				+ songs + "\n";
	}
	
	
	
	
	


}
