
public class Game extends Media {
	
	protected double weight;
	
	public Game() {
		
	}	

	public Game(String title, int copiesAvailable, double weight,String code) {
		super(title,copiesAvailable,code);
		this.weight = weight;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Media Code: "+code+",Game's title: " + title + ",copiesAvailable: " + copiesAvailable + ",weight: " + weight + "\n";
	}
	
	
	

}
