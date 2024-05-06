
public abstract class Media  {
	
	protected String title;
	protected int copiesAvailable;
	protected String code;
	
	
	public Media() {
		
	}
	
	public Media(String title, int copiesAvailable, String code) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
		this.code = code;
	}
	
	public String getTitle() {
		return title;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public abstract String toString();
	
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
