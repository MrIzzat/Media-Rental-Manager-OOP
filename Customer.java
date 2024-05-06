
import java.util.*;

public class Customer {
	
	protected String plan;
	protected String address;
	protected String name;
	protected String ID;
	protected String mobileNumber;
	protected ArrayList<String> Rented;
	protected ArrayList<String> Cart;
	
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Customer() {
		
	}
	
	public Customer(String name, String address, String plan, String ID, String mobileNumber) {
		
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.ID = ID;
		this.mobileNumber = mobileNumber;
		this.Cart = new ArrayList<String>();
		this.Rented = new ArrayList<String>();
		
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
//		String cart = Cart.toString().replace(",","").replace("[","").replace("]","").trim();
//		String rented = Rented.toString().replace(",","").replace("[","").replace("]","").trim();
		
		return "Customer's name: "+name+ ",Plan: "+plan+",Address: "+address+", ID: " +ID+",Mobile Number:" +mobileNumber+"Cart:" +printCart()+"Rented: "+printRented()+"\n";
	}

	public ArrayList<String> getRented() {
		return Rented;
	}

	public void setRented(ArrayList<String> rented) {
		Rented = new ArrayList<String>(rented);
	}

	public ArrayList<String> getCart() {
		return Cart;
	}

	public void setCart(ArrayList<String> cart) {
		Cart = new ArrayList<String>(cart);
	}
	public String printCart() {
		if(Cart==null || Cart.size()==0)
			return ",";

		else 
			return  Cart.toString().replace("[","").replace("]","").trim().replace(" ", "");
	}
	public String printRented() {
		
		if(Rented==null || Rented.size()==0)
			return ",";

		else 
			return  Rented.toString().replace("[","").replace("]","").trim().replace(" ", "");
		
	}
	

	
	
	

}
