
public class Movie extends Media{
	
	protected String rating;
	
	public Movie(){
		
	}
	
	public Movie (String title, int copiesAvailable, String rating, String code) {
		
		super(title,copiesAvailable,code);
		
		this.rating = rating;
		
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Media code: "+code+",Movie's title: " + title + ",copiesAvailable: " + copiesAvailable + ",rating: " + rating + "\n";
	}
	
	

}
