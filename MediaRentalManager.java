import java.util.*;
import java.io.*;
import java.io.FileWriter;


public class MediaRentalManager {
	
	File CustomerFile = new File(".\\Customers.txt");
	File MediaFile = new File(".\\Media.txt");
	
	protected ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	protected ArrayList<Media> MediaList = new ArrayList<Media>();
	protected int limitedPlanLimit=3;
	
	
	public MediaRentalManager()  {
		readingCustomerFile();
		readingMediaFile();
	}
	
	private void readingCustomerFile() {
		
		int i=0;
		try {
    		Scanner reader = new Scanner(CustomerFile);
    		ArrayList<Customer> temp = new ArrayList<Customer>();
    		while(reader.hasNextLine()) {
    			
    			
    			String line = reader.nextLine();
    			String[] lines = line.split("\\|");
    			
    			temp.add(new Customer());
    	
    			temp.get(i).setID(lines[0]);
    			temp.get(i).setName(lines[1]);
    			temp.get(i).setPlan(lines[2]);
    			temp.get(i).setAddress(lines[3]);
    			temp.get(i).setMobileNumber(lines[4]);
    			
    			String[] Cart={" "};
    			String[] Rented={" "};;
    			
    			if(lines.length==5) {
    				Cart[0]=null;
    			}
    			else {
    				Cart = lines[5].split(",");
    			}
    			if(lines.length==6) {
    				Rented[0]=null;
        		}
    			else {
    				Rented = lines[6].split(",");
    			}
    			
    			System.out.println(Arrays.toString(Rented));
    			System.out.println(Arrays.toString(Cart));
    			
    			temp.get(i).setCart(new ArrayList<String>(Arrays.asList(Cart)));
    			temp.get(i).setRented(new ArrayList<String>(Arrays.asList(Rented)));
    			
    			System.out.println(temp.get(i).getRented().size());
    			System.out.println(temp.get(i).getCart().size());
    			
    			System.out.println();
    			
    			i++;
    			
    		}
    		CustomerList = new ArrayList<Customer>(temp);
    		reader.close();
    		}
    		catch(Exception ex) {
    			System.out.println(ex);
    		}
		
	
		
	}
	private void writingCustomerFile() {
		try {
			PrintWriter CustomerWriting = new PrintWriter(CustomerFile);
			for(int i=0 ; i<CustomerList.size();i++) {
				CustomerWriting.println(CustomerList.get(i).getID()+"|"+CustomerList.get(i).getName()+"|"+CustomerList.get(i).getPlan()+"|"+CustomerList.get(i).getAddress()+"|"+CustomerList.get(i).getMobileNumber()+"|"+CustomerList.get(i).printCart()+"|"+CustomerList.get(i).printRented());
			}
			CustomerWriting.close();
			
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}
	private void readingMediaFile() {
		
		int i=0;
		try {
    		Scanner reader = new Scanner(MediaFile);
    		ArrayList<Media> temp = new ArrayList<Media>();
    		while(reader.hasNextLine()) {
    			
    			String line = reader.nextLine();
    			String[] lines = line.split("\\|");
    			
    			if(lines[0].equals("Movie")) {
    				temp.add(new Movie());
    				temp.get(i).setTitle(lines[1]);
        			temp.get(i).setCopiesAvailable(Integer.parseInt(lines[2]));
        			((Movie)temp.get(i)).setRating(lines[3]);
        			temp.get(i).setCode(lines[4]);
    			}
    			if(lines[0].equals("Game")) {
    				temp.add(new Game());
    				temp.get(i).setTitle(lines[1]);
        			temp.get(i).setCopiesAvailable(Integer.parseInt(lines[2]));
        			((Game)temp.get(i)).setWeight(Double.parseDouble(lines[3]));
        			temp.get(i).setCode(lines[4]);
        			
    			}
    			if(lines[0].equals("Album")) {
    				temp.add(new Album());
    				temp.get(i).setTitle(lines[1]);
        			temp.get(i).setCopiesAvailable(Integer.parseInt(lines[2]));
        			((Album)temp.get(i)).setArtist(lines[3]);
        			((Album)temp.get(i)).setSongs(lines[4]);
        			temp.get(i).setCode(lines[5]);
    			}
    			
    			i++;
    			
    		}
    		MediaList = new ArrayList<Media>(temp);
    		reader.close();
    		}
    		catch(Exception ex) {
    			System.out.println(ex);
    		}
		
		
	}
	private void writingMediaFile() {
		try {
			PrintWriter MediaWriting = new PrintWriter(MediaFile);

			for(int i=0 ; i<MediaList.size();i++) {
				int j = mediaTypeChecker(i);
				if(j==1) {
					MediaWriting.println("Movie|"+MediaList.get(i).getTitle()+"|"+MediaList.get(i).getCopiesAvailable()+"|"+((Movie)MediaList.get(i)).getRating()+"|"+MediaList.get(i).getCode());
				}
				if(j==2) {
					MediaWriting.println("Game|"+MediaList.get(i).getTitle()+"|"+MediaList.get(i).getCopiesAvailable()+"|"+((Game)MediaList.get(i)).getWeight()+"|"+MediaList.get(i).getCode());
				}
				if(j==3) {
					MediaWriting.println("Album|"+MediaList.get(i).getTitle()+"|"+MediaList.get(i).getCopiesAvailable()+"|"+((Album)MediaList.get(i)).getArtist()+"|"+((Album)MediaList.get(i)).getSongs()+"|"+MediaList.get(i).getCode());
				}
			}

			MediaWriting.close();
			
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public boolean addCustomer(String name, String address, String plan,String ID, String mobileNumber) {
		
		int i=0;
		for(i=0;i<CustomerList.size();i++) {
			if(CustomerList.get(i).getID().equals(ID)) {
				return false;
			}
		}
	
        CustomerList.add(new Customer(name,address,plan,ID,mobileNumber)); 
        writingCustomerFile();
    	
		return true;
		
	}
	
	public boolean delCustomer(int index) {
		
		CustomerList.remove(index);
		writingCustomerFile();
		
		return true;
	}
	
	public	int searchCustomer(String ID) {
		
		int i=0;
		for (i=0;i<CustomerList.size();i++) {
			if(CustomerList.get(i).getID().equals(ID)) {
			return i;
			}
			
		}
	
		
		return -1;
	}
	
	public boolean updateCustomer(int index ,String ID, String Name , String Plan, String Address, String Mobile ) {
		
		int i=0;
		for(i=0;i<CustomerList.size();i++) {
			if(i==index)
				continue;
			if(CustomerList.get(i).getID().equals(ID)) {
				return false;
			}
		}
		CustomerList.get(index).setName(Name);
		CustomerList.get(index).setAddress(Address);
		CustomerList.get(index).setPlan(Plan);
		CustomerList.get(index).setID(ID);
		CustomerList.get(index).setMobileNumber(Mobile);
		
		writingCustomerFile();
		
		return true;
	}
	
	public boolean addMovie(String title, int copiesAvailable, String rating, String code) {
		
		int i=0;
		for(i=0;i<MediaList.size();i++) {
			if(MediaList.get(i).getCode().equals(code)) {
				return false;
			}
		}
		MediaList.add(new Movie(title, copiesAvailable, rating, code));
		writingMediaFile();
		return true;
	}
	
	public boolean addGame(String title, int copiesAvailable, double weight, String code) {
		int i=0;
		for(i=0;i<MediaList.size();i++) {
			if(MediaList.get(i).getCode().equals(code)) {
				return false;
			}
		}
		MediaList.add(new Game(title, copiesAvailable, weight, code));
		writingMediaFile();
		return true;
	}
	
	public boolean addAlbum(String title, int copiesAvailable, String artist, String songs, String code) {

		int i=0;
		for(i=0;i<MediaList.size();i++) {
			if(MediaList.get(i).getCode().equals(code)) {
				return false;
			}
		}
		MediaList.add(new Album(title, copiesAvailable, artist, songs, code));
		writingMediaFile();
		return true;
	}
	
	public	int searchMedia(String Code) {
		
		int i=0;
		for (i=0;i<MediaList.size();i++) {
			if(MediaList.get(i).getCode().equals(Code)) {
			return i;
			}
		}
		
		return -1;
	}
	
	public int mediaTypeChecker(int index) {
		
		if(MediaList.get(index)instanceof Movie)
			return 1;
		if(MediaList.get(index) instanceof Game)
			return 2;
		if(MediaList.get(index) instanceof Album)
			return 3;

		return -1;
	}
	
	public boolean delMedia(int index) {
		
		this.MediaList.remove(index);
		writingMediaFile();
		
		return true;
		
	}
	
	public boolean updateMedia(int index, String code , String title, int copiesAvailable, double weight, String rating, String artist, String songs) {
		
		int mediaCheck = this.mediaTypeChecker(index);
		
		if(mediaCheck==1) {
		((Movie)this.MediaList.get(index)).setCode(code);
		((Movie)this.MediaList.get(index)).setTitle(title);
		((Movie)this.MediaList.get(index)).setCopiesAvailable(copiesAvailable);
		((Movie)this.MediaList.get(index)).setRating(rating);
		}
		if(mediaCheck==2) {
			((Game) this.MediaList.get(index)).setCode(code);
			((Game) this.MediaList.get(index)).setTitle(title);
			((Game) this.MediaList.get(index)).setCopiesAvailable(copiesAvailable);
			((Game) this.MediaList.get(index)).setWeight(weight);
		}
		if(mediaCheck==3) {
			((Album)this.MediaList.get(index)).setCode(code);
			((Album)this.MediaList.get(index)).setTitle(title);
			((Album)this.MediaList.get(index)).setCopiesAvailable(copiesAvailable);
			((Album)this.MediaList.get(index)).setArtist(artist);
			((Album)this.MediaList.get(index)).setSongs(songs);
		}
		if(mediaCheck==-1)
			return false;
		
		writingMediaFile();
		return true;
	}
	
	public void setLimitedPlanLimit(int value) {
		
		limitedPlanLimit = value;
	}
	
	public String getAllCustomerInfo() {
		
		int i=0;
		for(i=0;i<CustomerList.size()-1;i++) {
			if(CustomerList.get(i).getName().compareToIgnoreCase(CustomerList.get(i+1).getName())>0) {
				Collections.swap(CustomerList,i,i+1);
				i=-1;
			}
		}
		return CustomerList.toString();	
	}
	
	public String getAllMediaInfo() {
		
		int i=0;
		for(i=0;i<MediaList.size()-1;i++) {
			if(MediaList.get(i).getTitle().compareToIgnoreCase(MediaList.get(i+1).getTitle())>0) {
				Collections.swap(MediaList,i,i+1);
				i=-1;
			}
		}
		String str = MediaList.toString().replace(",","").replace("[","").replace("]","").trim();
		
		
		return str;	
	}
	
	public int addtoCart(String customerName, String mediaTitle) {
		
		int i=0,j=0;
		boolean flag=true;
		for(i=0;i<MediaList.size();i++) {
			if(MediaList.get(i).getTitle().equals(mediaTitle)){
				flag=false;
				break;
			}
		} 
		if(flag)
			return 1;
		for(i=0;i<CustomerList.size();i++) {
			if(customerName.equals(CustomerList.get(i).getName())) {
				if(CustomerList.get(i).getCart()==null) {
					CustomerList.get(i).getCart().add(mediaTitle);
					writingCustomerFile();
					writingMediaFile();
					return 0;
				}
				for(j=0;j<CustomerList.get(i).getCart().size();j++) {
					if((mediaTitle.equals(CustomerList.get(i).getCart().get(j)))) {
						return 2;
					}
				}
				CustomerList.get(i).getCart().add(mediaTitle);
				writingCustomerFile();
				writingMediaFile();
				return 0;
			}
		}
		return 3;
	}
	
	public boolean removeFromCart(String customerName, String mediaTitle) {
		
		int i=0, j=0;
		for(i=0;i<CustomerList.size();i++) {
			if(customerName.equals(CustomerList.get(i).getName())) {
				if(CustomerList.get(i).getCart()==null) {
					writingCustomerFile();
					writingMediaFile();
					return true;
				}
				for(j=0;j<CustomerList.get(i).getCart().size();j++) {
					if(CustomerList.get(i).getCart().get(j).equals(mediaTitle)) {
						CustomerList.get(i).getCart().remove(j);
						writingCustomerFile();
						writingMediaFile();
						return true;
					}	
				}
			}
		}
		return false;
	}
	
	public String processRequests() {
		
		int i=0,j=0,k=0;
		boolean flag=false;
		String Success="";
		for(i=0;i<CustomerList.size()-1;i++) {
			if(CustomerList.get(i).getName().compareToIgnoreCase(CustomerList.get(i+1).getName())>0) {
				Collections.swap(CustomerList,i,i+1);
				i=-1;
			}
		}
		for(i=0;i<CustomerList.size();i++) {
			if(CustomerList.get(i).getCart().isEmpty())
				continue;
			if((CustomerList.get(i).getPlan().equals("LIMITED")&&((CustomerList.get(i).getRented().size()<limitedPlanLimit)))||(CustomerList.get(i).getPlan().equals("UNLIMITED"))) {
				for(j=0;j<CustomerList.get(i).getCart().size();j++) {
					if((CustomerList.get(i).getPlan().equals("LIMITED")&&((CustomerList.get(i).getRented().size()>=limitedPlanLimit))))
						break;
					for(int w=0;w<CustomerList.get(i).getRented().size();w++) {
						if(CustomerList.get(i).getCart().get(j).equals(CustomerList.get(i).getRented().get(w))){
							flag=true;
							break;
						}else flag=false;
					}
					if(flag) {
						Success+="Customer is already renting "+CustomerList.get(i).getCart().get(j);
						CustomerList.get(i).getCart().remove(j);
						continue;
					}
					for(k=0;k<MediaList.size();k++) {
						if(CustomerList.get(i).getCart().get(j).equals(MediaList.get(k).getTitle())) {

							if(MediaList.get(k).getCopiesAvailable()>0) {
								CustomerList.get(i).getRented().add(CustomerList.get(i).getCart().get(j));
								Success = Success +"Sending "+CustomerList.get(i).getCart().get(j)+" to "+CustomerList.get(i).getName()+"\n";
								MediaList.get(k).setCopiesAvailable(MediaList.get(k).getCopiesAvailable()-1);
								break;
							}
							else {
								Success=Success+"Could not send " + MediaList.get(k).getTitle()+".";
							}
						}
					}
					CustomerList.get(i).getCart().remove(j);
					j-=1;
				}
			}else continue;
		}
		writingCustomerFile();
		writingMediaFile();
		return Success;
	}
	
	public int returnMedia(String ID, String mediaTitle) {
		
		int i=0,j=0,k=0;
		for(i=0;i<CustomerList.size();i++) {
			if(ID.equals(CustomerList.get(i).getID())) {
				if(CustomerList.get(i).getRented().size()==0) {
					return 1;
				}
				for(j=0;j<CustomerList.get(i).getRented().size();j++) {
					if(CustomerList.get(i).getRented().get(j).equals(mediaTitle)) {
						CustomerList.get(i).getRented().remove(j);
						for(k=0;k<MediaList.size();k++) {
							if(MediaList.get(k).getTitle().equals(mediaTitle)) {
							MediaList.get(k).setCopiesAvailable(MediaList.get(k).getCopiesAvailable()+1);
							}
						}
						writingCustomerFile();
						writingMediaFile();
						return 0;
					}	
				}
			}
		}
		return 2;
	}
	
	public ArrayList<String> searchMedia(String title,String rating, String artist,String songs){

		ArrayList<String> Found = new ArrayList<String>();
		int i=0;
		for(i=0;i<MediaList.size()-1;i++) {
			if(MediaList.get(i).getTitle().compareToIgnoreCase(MediaList.get(i+1).getTitle())>0) {
				Collections.swap(MediaList,i,i+1);
				i=-1;
			}
		}

		if(title==null&&rating==null&&artist==null&&songs==null) {
			for(i=0;i<MediaList.size();i++) {
				Found.add(MediaList.get(i).toString());		
			}
		}

		if(title!=null&&rating==null&&artist==null&&songs==null) {

			for(i=0;i<MediaList.size();i++) {
				if(MediaList.get(i).getTitle().equals(title)) {
					Found.add(MediaList.get(i).toString());	
				}
			}
		}
		if(title!=null&&rating!=null&&artist==null&&songs==null) {

			for(i=0;i<MediaList.size();i++) {

				int temp = this.mediaTypeChecker(i);
				if (temp==1) {
					if(MediaList.get(i).getTitle().equals(title)&&((Movie)MediaList.get(i)).getRating().equals(rating)) {
						Found.add(MediaList.get(i).toString());		
					}
				}
			}
		}
		if(title==null&&rating!=null&&artist==null&&songs==null) {
			for(i=0;i<MediaList.size();i++) {
				int temp = this.mediaTypeChecker(i);
				if (temp==1) {
					if(((Movie)MediaList.get(i)).getRating().equals(rating)) {
						Found.add(MediaList.get(i).toString());		
					}
				}
			}
		}
		if(title!=null&&rating==null&&artist!=null&&songs==null) {
			for(i=0;i<MediaList.size();i++) {

				int temp = this.mediaTypeChecker(i);
				if (temp==3) {
					if(MediaList.get(i).getTitle().equals(title)&&((Album)MediaList.get(i)).getArtist().equals(artist)) {
						Found.add(MediaList.get(i).toString());		
					}
				}
			}
		}
		if(title==null&&rating==null&&artist!=null&&songs==null) {
			for(i=0;i<MediaList.size();i++) {
				int temp = this.mediaTypeChecker(i);
				if (temp==3) {
					if(((Album)MediaList.get(i)).getArtist().equals(artist)) {
						Found.add(MediaList.get(i).toString());		
					}
				}
			}
		}
		if(title==null&&rating==null&&artist==null&&songs!=null) {
			for(i=0;i<MediaList.size();i++) {
				int temp = this.mediaTypeChecker(i);
				if(temp==3) {
					if(songs.equals(((Album)MediaList.get(i)).getSongs())) {
						Found.add(MediaList.get(i).toString());
						continue;
					}
					String[] s1 = ((Album)MediaList.get(i)).getSongs().split(",");
					String[] s2 = songs.split(",");
					boolean check = true;
					
					for(int j=0;j<s2.length;j++) {
						for(int k=0;k<s1.length;k++) {
							if(!s2[j].equals(s1[k])){
								check=false;
							}
						}
					}
					if(check)
						Found.add(MediaList.get(i).toString());
				}
			}
		}
		if(title==null&&rating==null&&artist!=null&&songs!=null) {
			for(i=0;i<MediaList.size();i++) {
				int temp = this.mediaTypeChecker(i);
				if (temp==3) {
					if(songs.equals(((Album)MediaList.get(i)).getSongs())) {
						Found.add(MediaList.get(i).toString());
						continue;
					}
					String[] s1 = ((Album)MediaList.get(i)).getSongs().split(",");
					String[] s2 = songs.split(",");
					boolean check = true;
					
					for(int j=0;j<s2.length;j++) {
						for(int k=0;k<s1.length;k++) {
							if(!s2[j].equals(s1[k])){
								check=false;
							}
						}
					}
					if(check)
						Found.add(MediaList.get(i).toString());
				}
				
			}
		}
		if(title!=null&&rating==null&&artist!=null&&songs!=null) {
			for(i=0;i<MediaList.size();i++) {
				int temp = this.mediaTypeChecker(i);
				if (temp==3) {
					if(songs.equals(((Album)MediaList.get(i)).getSongs())) {
						Found.add(MediaList.get(i).toString());
						continue;
					}
					String[] s1 = ((Album)MediaList.get(i)).getSongs().split(",");
					String[] s2 = songs.split(",");
					boolean check = true;
					
					for(int j=0;j<s2.length;j++) {
						for(int k=0;k<s1.length;k++) {
							if(!s2[j].equals(s1[k])){
								check=false;
							}
						}
					}
					if(check)
						Found.add(MediaList.get(i).toString());
				}
				
			}
		}

		return Found;
	}

}
