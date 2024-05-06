import java.util.*;

public interface MediaRentalInt {
	
	public String addCustomer(String name, String address, String plan, String ID, String mobileNumber);
	public boolean addMovie(String title, int copiesAvailable, String rating,String code);
	public boolean addGame(String title, int copiesAvailable, double weight,String code);
	public boolean addAlbum(String title, int copiesAvailable, String artist, String songs,String code);
	public void setLimitedPlanLimit(int value);
	public String getAllCustomerInfo();
	public String getAllMediaInfo();
	public boolean addtoCart(String customerName, String mediaTitle);
	public boolean removeFromCart(String customerName, String mediaTitle);
	public String processRequests();
	public boolean returnMedia(String customerName, String mediaTitle);
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs);

}

