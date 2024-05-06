import javafx.scene.*;

import javafx.application.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.*;
import java.util.*;



public class Main extends Application   {

	
	MediaRentalManager test = new MediaRentalManager();

	Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

	Button Customer = new Button("Customer");
	Button Media = new Button("Media");
	Button Rent = new Button("Rent");
	
	Button cBack = new Button();
	Button mBack = new Button();
	Button rBack = new Button();
	
	Button cAdd = new Button();
	Button cDelete = new Button();
	Button cUpdate = new Button();
	Button cSearch = new Button();
	
	Button mAdd = new Button();
	Button mDelete = new Button();
	Button mUpdate = new Button();
	Button mSearch = new Button();
	Button mPrint = new Button();
	
	Button rentForm = new Button();
	Button printCart = new Button();
	Button printRented = new Button();
	Button returnRented = new Button();
	
	Button Return = new Button();
	
	int index; //variable for update customer. needed to create this variable as a global variable due to a bug with lambda expression and if-else statement
	int index2;
	boolean flag1;
	boolean flag2;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
//		test.addCustomer("test", "test@", "UNLIMITED", "111", "1234");
//		test.addMovie("Batman",10,"HR","1");
//		test.addMovie("Spiderman",10,"DR","2");
//		test.addGame("Black ops", 2, 30,"3");
//		test.addGame("Halo", 15, 30,"4");
//		test.addAlbum("Lost", 23, "Fergie", "Why do i, bring me back, ihi, where the hood at, jamalia ","5");
		
		primaryStage.setScene(mainMenu());
		primaryStage.setTitle("Main Menu");
		
		Customer.setOnAction((event)->{
			primaryStage.setScene(customer());
			primaryStage.setTitle("Customer Menu");
		});
		cBack.setOnAction((event)->{
			primaryStage.setScene(customer());
			primaryStage.setTitle("Customer Menu");
		});
		cAdd.setOnAction((event)->{
			primaryStage.setScene(addCustomer());
			primaryStage.setTitle("Add a Customer");
		});
		cDelete.setOnAction((event)->{
			primaryStage.setScene(delCustomer());
			primaryStage.setTitle("Delete a Customer");
		});
		cSearch.setOnAction((event)->{
			primaryStage.setScene(searchCustomer());
			primaryStage.setTitle("Search for a Customer");
		});
		cUpdate.setOnAction((event)->{
			primaryStage.setScene(updateCustomer());
			primaryStage.setTitle("Update a Customer's Information");
		});
		Media.setOnAction((event)->{
			primaryStage.setScene(media());
			primaryStage.setTitle("Media Menu");
		});
		mBack.setOnAction((event)->{
			primaryStage.setScene(media());
			primaryStage.setTitle("Media Menu");
		});
		mAdd.setOnAction((event)->{
			primaryStage.setScene(addMedia());
			primaryStage.setTitle("Add a Media");
		});
		mDelete.setOnAction((event)->{
			primaryStage.setScene(delMedia());
			primaryStage.setTitle("Delete a Media");
		});
		mUpdate.setOnAction((event)->{
			primaryStage.setScene(updateMedia());
			primaryStage.setTitle("Update a Media's Information");
		});
		mSearch.setOnAction((event)->{
			primaryStage.setScene(searchMedia());
			primaryStage.setTitle("Search for a Media");
		});
		mPrint.setOnAction((event)->{
			primaryStage.setScene(printMedia());
			primaryStage.setTitle("All Media Information");
		});
		Rent.setOnAction((event)->{
			primaryStage.setScene(rent());
			primaryStage.setTitle("Rent Menu");
		});
		rBack.setOnAction((event)->{
			primaryStage.setScene(rent());
			primaryStage.setTitle("Rent Menu");
		});
		rentForm.setOnAction((event)->{
			primaryStage.setScene(rentForm());
			primaryStage.setTitle("Rent Form");
		});
		printCart.setOnAction((event)->{
			primaryStage.setScene(printCart());
			primaryStage.setTitle("Check a Customer's Cart");
		});
		printRented.setOnAction((event)->{
			primaryStage.setScene(printRented());
			primaryStage.setTitle("Check What a Customer has Rented");
		});
		returnRented.setOnAction((event)->{
			primaryStage.setScene(returnRented());
			primaryStage.setTitle("Return a Rented Media");
		});
		Return.setOnAction((event)->{
			primaryStage.setScene(mainMenu());
			primaryStage.setTitle("Main Menu");
		});
		
		//primaryStage.setScene(returnRented()); to test each stage individually 
		
		primaryStage.setMaximized(true);
		primaryStage.show();
	}
	public Scene mainMenu() {

		HBox Main = new HBox();
		VBox Buttons = new VBox();
		VBox Images = new VBox();
		StackPane Title = new StackPane();
		StackPane Frame = new StackPane();
		Rectangle rectangle = new Rectangle(100,50);
		Rectangle mFrame = new Rectangle(350,140);
		Rectangle frame = new Rectangle(250,100);
		Rectangle title = new Rectangle(200,30);
		Text tTitle = new Text("Rental Media System");
		
		title.setFill(Color.WHITE);
		title.setStroke(Color.CORNFLOWERBLUE);
		title.setStrokeWidth(2);
		frame.setStroke(Color.CORNFLOWERBLUE);
		frame.setStrokeWidth(2);
		mFrame.setFill(Color.WHITE);
		mFrame.setStroke(Color.STEELBLUE);
		mFrame.setStrokeWidth(2);

		Image pic = new Image("file:///c:./Media.jpg");
		frame.setFill(new ImagePattern(pic));
		
		Frame.getChildren().addAll(mFrame,frame);
		Title.getChildren().addAll(title,tTitle);
		
		rectangle.setArcWidth(20.0); 
	    rectangle.setArcHeight(20.0);
		
		Customer.setPrefSize(100, 50);
		Media.setPrefSize(100, 50);
		Rent.setPrefSize(100, 50);
		
		Customer.setShape(rectangle);
		Customer.setStyle("-fx-background-color:#5b9bd5 ;-fx-border-color:#48769e ; -fx-border-width: 2px");
		Media.setShape(rectangle);
		Media.setStyle("-fx-background-color:#5b9bd5 ;-fx-border-color:#48769e ; -fx-border-width: 2px");
		Rent.setShape(rectangle);
		Rent.setStyle("-fx-background-color:#5b9bd5 ;-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		Images.getChildren().addAll(Frame,Title);
		Images.setSpacing(10);
		Buttons.getChildren().addAll(Customer,Media,Rent);
		Buttons.setSpacing(20);
		Main.setSpacing(50);
		
		
		Images.setAlignment(Pos.CENTER);
		Buttons.setAlignment(Pos.CENTER);
		Main.setAlignment(Pos.CENTER);
		
		Main.getChildren().addAll(Buttons,Images);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	}
	
	public Scene customer() {
		
		HBox Main = new HBox();
		VBox Buttons = new VBox();
		
		Text tAdd = new Text("Add new Customer");
		tAdd.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text tDelete = new Text("Delete Customer");
		tDelete.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text tUpdate = new Text("Update Information about Customer");
		tUpdate.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text tSearch = new Text("Search a Customer by id");
		tSearch.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text tReturn = new Text("Return to main page");
		tReturn.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		
		
		cAdd.setGraphic(tAdd);
		cDelete.setGraphic(tDelete);
		cUpdate.setGraphic(tUpdate);
		cSearch.setGraphic(tSearch);
		Return.setGraphic(tReturn);
		
		
		cAdd.setStyle("-fx-background-color:#f4f4f4"  );
		cDelete.setStyle("-fx-background-color:#f4f4f4" );
		cUpdate.setStyle("-fx-background-color:#f4f4f4" );
		cSearch.setStyle("-fx-background-color:#f4f4f4" );
		Return.setStyle("-fx-background-color:#f4f4f4" );

		
		Buttons.getChildren().addAll(cAdd,cDelete,cUpdate,cSearch,Return);
		Main.getChildren().addAll(Buttons);
		
		Buttons.setSpacing(10);
		Buttons.setAlignment(Pos.CENTER_LEFT);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	}
	
	public Scene addCustomer() {
		
		HBox Main = new HBox();
		HBox CustomerID = new HBox();
		HBox CustomerName = new HBox();
		HBox CustomerAdd = new HBox();
		HBox CustomerMobile = new HBox();
		HBox Buttons = new HBox();
		HBox CustomerPlan = new HBox();
		VBox center = new VBox();
		VBox errmsg = new VBox();
		Text error = new Text();
		
		Button add = new Button();
		
		TextField ID = new TextField();
		TextField Name = new TextField();
		TextField Add = new TextField();
		TextField Mob = new TextField();
		TextField Plan = new TextField();

		Text cID = new Text("Customer ID:");
		Text cName = new Text("Customer Name:");
		Text cAdd = new Text("Customer Address:");
		Text cMob = new Text("Customer Mobile:");
		Text cPlan = new Text("Customer Plan");

		ID.setOnAction((event)->{
			if(ID.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfields!");
			}
			if(!ID.getText().isEmpty()) {
				Name.setEditable(true);
			}
		});
		Name.setOnAction((event)->{
			if(Name.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfields!");
			}

			if(!Name.getText().isEmpty()) {
				Plan.setEditable(true);
				error.setText("");
			}
		});
		Add.setOnAction((event)->{
			if(Add.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfields!");
			}
			if(!Add.getText().isEmpty()) {
				Mob.setEditable(true);
				error.setText("");
			}
		});
		Mob.setOnAction((event)->{
			if(Mob.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfields!");
			}
			if(!Mob.getText().isEmpty()) {
				add.setDisable(false);
				error.setText("");
			}

		});
		Plan.setOnAction((event)->{
			if(Plan.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfields!");
			}
			if(!Plan.getText().isEmpty()) {
				if(Plan.getText().equals("LIMITED")||Plan.getText().equals("UNLIMITED")) {
					Add.setEditable(true);
					error.setText("");
				}
				else {
					error.setText("Make sure the plan is either LIMITED or UNLIMITED");
				}
			}
		});
		
		add.setOnAction((event)->{
			
			boolean addCheck = test.addCustomer(Name.getText(),Add.getText(),Plan.getText(),ID.getText(),Mob.getText());
			if (!addCheck)
				error.setText("Error could not add the customer to\nthe Database because another customer has the same ID.");
			else {
				error.setText("Successfully added the customer.");
				Name.setText("");
				Plan.setText("");
				Add.setText("");
				Mob.setText("");
				Name.setEditable(false);
				Add.setEditable(false);
				Mob.setEditable(false);
				Plan.setEditable(false);
				add.setDisable(true);
				
			}
		});

		Name.setEditable(false);
		Add.setEditable(false);
		Mob.setEditable(false);
		Plan.setEditable(false);
		add.setDisable(true);
		
		
		add.setGraphic(new ImageView("file:///c:./plus.png"));
		add.setStyle("-fx-background-color:#f4f4f4" );
		cBack.setGraphic(new ImageView("file:///c:./back.png"));
		cBack.setStyle("-fx-background-color:#f4f4f4" );

		Text pBack = new Text("Back");
		Text pAdd = new Text("Add");
		Buttons.getChildren().addAll(pAdd,add,pBack,cBack);
		Buttons.setMargin(pAdd,(new Insets(12,5,0,110)));
		Buttons.setMargin(add,(new Insets(0,0,0,0)));
		Buttons.setMargin(pBack,(new Insets(12,5,0,80)));

		CustomerID.getChildren().addAll(cID,ID);
		CustomerName.getChildren().addAll(cName,Name);
		CustomerAdd.getChildren().addAll(cAdd,Add);
		CustomerMobile.getChildren().addAll(cMob,Mob);
		CustomerPlan.getChildren().addAll(cPlan,Plan);
		CustomerID.setSpacing(41);
		CustomerName.setSpacing(21);
		CustomerAdd.setSpacing(10);
		CustomerMobile.setSpacing(15);
		CustomerPlan.setSpacing(32);
		errmsg.setAlignment(Pos.CENTER);
		errmsg.getChildren().add(error);



		center.getChildren().addAll(CustomerID,CustomerName,CustomerPlan,CustomerAdd,CustomerMobile,Buttons);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(15);
		Main.getChildren().addAll(center,errmsg);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");

		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	}
	
	public Scene delCustomer() {
		
		HBox Main = new HBox();
		HBox CustomerID = new HBox();
		HBox CustomerName = new HBox();
		HBox CustomerAdd = new HBox();
		HBox CustomerMobile = new HBox();
		HBox Buttons = new HBox();
		HBox CustomerPlan = new HBox();
		VBox center = new VBox();
		VBox errmsg = new VBox();
		Text error = new Text();
		
		Button delete = new Button();
		Button find = new Button();
		
		TextField ID = new TextField();
		TextField Name = new TextField();
		TextField Add = new TextField();
		TextField Mob = new TextField();
		TextField Plan = new TextField();

		Text cID = new Text("Customer ID:");
		Text cName = new Text("Customer Name:");
		Text cAdd = new Text("Customer Address:");
		Text cMob = new Text("Customer Mobile:");
		Text cPlan = new Text("Customer Plan");

		ID.setOnAction((event)->{
			find.setDisable(true);
			delete.setDisable(true);
			error.setText("");
			Name.setText("");
			Plan.setText("");
			Add.setText("");
			Mob.setText("");
			if(ID.getText().isEmpty()) {
				error.setText("Make sure the ID textfield are not empty!");
			}
			if(!ID.getText().isEmpty()) {
				find.setDisable(false);
			}
		});
		find.setOnAction((event)->{
			if(test.searchCustomer(ID.getText())==-1) {
				error.setText("There are no customers in the database with that ID.");
				Name.setText("");
				Plan.setText("");
				Add.setText("");
				Mob.setText("");
				
				delete.setDisable(true);
				find.setDisable(true);
			}
			else {				
				index = test.searchCustomer(ID.getText());
	
				Name.setText(test.CustomerList.get(index).getName());
				Plan.setText(test.CustomerList.get(index).getPlan());
				Add.setText(test.CustomerList.get(index).getAddress());
				Mob.setText(test.CustomerList.get(index).getMobileNumber());
				
				delete.setDisable(false);
				find.setDisable(true);
			}
		});
		
		delete.setOnAction((event)->{
			
			test.delCustomer(index);
			error.setText("Customer has been deleted successfully.");
			
			delete.setDisable(true);
			find.setDisable(true);
			
		
		});
		
		
		find.setOnAction((event)->{
			if(test.searchCustomer(ID.getText())==-1) {
				error.setText("There are no customers in the database with that ID.");
				Name.setText("");
				Plan.setText("");
				Add.setText("");
				Mob.setText("");
			}
			else {
				int index = test.searchCustomer(ID.getText());
	
				Name.setText(test.CustomerList.get(index).getName());
				Plan.setText(test.CustomerList.get(index).getPlan());
				Add.setText(test.CustomerList.get(index).getAddress());
				Mob.setText(test.CustomerList.get(index).getMobileNumber());
				
				delete.setDisable(false);
			}
		});

		Name.setEditable(false);
		Add.setEditable(false);
		Mob.setEditable(false);
		Plan.setEditable(false);
		delete.setDisable(true);
		find.setDisable(true);
		
		
		delete.setGraphic(new ImageView("file:///c:./delete.png"));
		delete.setStyle("-fx-background-color:	#f4f4f4" );
		cBack.setGraphic(new ImageView("file:///c:./back.png"));
		cBack.setStyle("-fx-background-color:#f4f4f4" );
		find.setGraphic(new ImageView("file:///c:./find.png"));
		find.setStyle("-fx-background-color:#f4f4f4" );

		Text pBack = new Text("Back");
		Text pDelete = new Text("Delete");
		Text pFind = new Text("Find");
		Buttons.getChildren().addAll(pFind,find,pDelete,delete,pBack,cBack);
		
		Buttons.setMargin(pFind,(new Insets(12,5,0,15)));
		Buttons.setMargin(pDelete,(new Insets(12,5,0,30)));
		Buttons.setMargin(pBack,(new Insets(12,5,0,70)));

		CustomerID.getChildren().addAll(cID,ID);
		CustomerName.getChildren().addAll(cName,Name);
		CustomerAdd.getChildren().addAll(cAdd,Add);
		CustomerMobile.getChildren().addAll(cMob,Mob);
		CustomerPlan.getChildren().addAll(cPlan,Plan);
		CustomerID.setSpacing(41);
		CustomerName.setSpacing(21);
		CustomerAdd.setSpacing(10);
		CustomerMobile.setSpacing(15);
		CustomerPlan.setSpacing(32);
		errmsg.setAlignment(Pos.CENTER);
		errmsg.getChildren().add(error);



		center.getChildren().addAll(CustomerID,CustomerName,CustomerPlan,CustomerAdd,CustomerMobile,Buttons);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(15);
		Main.getChildren().addAll(center,errmsg);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");

		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	
	}	

	public Scene searchCustomer() {
		
		HBox Main = new HBox();
		HBox CustomerID = new HBox();
		HBox CustomerName = new HBox();
		HBox CustomerAdd = new HBox();
		HBox CustomerMobile = new HBox();
		HBox Buttons = new HBox();
		HBox CustomerPlan = new HBox();
		VBox center = new VBox();
		VBox errmsg = new VBox();
		Text error = new Text();
		
		Button find = new Button();
		
		TextField ID = new TextField();
		TextField Name = new TextField();
		TextField Add = new TextField();
		TextField Mob = new TextField();
		TextField Plan = new TextField();

		Text cID = new Text("Customer ID:");
		Text cName = new Text("Customer Name:");
		Text cAdd = new Text("Customer Address:");
		Text cMob = new Text("Customer Mobile:");
		Text cPlan = new Text("Customer Plan");

		ID.setOnAction((event)->{
			error.setText("");
			Name.setText("");
			Plan.setText("");
			Add.setText("");
			Mob.setText("");
			if(ID.getText().isEmpty()) {
				error.setText("Make sure the ID textfield are not empty!");
			}
			if(!ID.getText().isEmpty()) {
				find.setDisable(false);
			}
		});
		
		find.setOnAction((event)->{
			if(test.searchCustomer(ID.getText())==-1) {
				error.setText("There are no customers in the database with that ID.");
				Name.setText("");
				Plan.setText("");
				Add.setText("");
				Mob.setText("");
			}
			else {
				int index = test.searchCustomer(ID.getText());
	
				Name.setText(test.CustomerList.get(index).getName());
				Plan.setText(test.CustomerList.get(index).getPlan());
				Add.setText(test.CustomerList.get(index).getAddress());
				Mob.setText(test.CustomerList.get(index).getMobileNumber());
				
			}
		});

		Name.setEditable(false);
		Add.setEditable(false);
		Mob.setEditable(false);
		Plan.setEditable(false);
		find.setDisable(true);
		
		
		cBack.setGraphic(new ImageView("file:///c:./back.png"));
		cBack.setStyle("-fx-background-color:#f4f4f4" );
		find.setGraphic(new ImageView("file:///c:./find.png"));
		find.setStyle("-fx-background-color:#f4f4f4" );

		Text pBack = new Text("Back");
		Text pFind = new Text("Find");
		Buttons.getChildren().addAll(pFind,find,pBack,cBack);
		
		Buttons.setMargin(pFind,(new Insets(12,5,0,110)));
		Buttons.setMargin(pBack,(new Insets(12,5,0,80)));

		CustomerID.getChildren().addAll(cID,ID);
		CustomerName.getChildren().addAll(cName,Name);
		CustomerAdd.getChildren().addAll(cAdd,Add);
		CustomerMobile.getChildren().addAll(cMob,Mob);
		CustomerPlan.getChildren().addAll(cPlan,Plan);
		CustomerID.setSpacing(41);
		CustomerName.setSpacing(21);
		CustomerAdd.setSpacing(10);
		CustomerMobile.setSpacing(15);
		CustomerPlan.setSpacing(32);
		errmsg.setAlignment(Pos.CENTER);
		errmsg.getChildren().add(error);



		center.getChildren().addAll(CustomerID,CustomerName,CustomerPlan,CustomerAdd,CustomerMobile,Buttons);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(15);
		Main.getChildren().addAll(center,errmsg);
		Main.setAlignment(Pos.CENTER);

		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");

		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	
	}	
	
	public Scene updateCustomer() {
		
		
		HBox Main = new HBox();
		HBox CustomerID = new HBox();
		HBox CustomerName = new HBox();
		HBox CustomerAdd = new HBox();
		HBox CustomerMobile = new HBox();
		HBox Buttons = new HBox();
		HBox CustomerPlan = new HBox();
		VBox center = new VBox();
		VBox errmsg = new VBox();
		Text error = new Text();
		
		Button update = new Button();
		Button find = new Button();
		
		TextField ID = new TextField();
		TextField Name = new TextField();
		TextField Add = new TextField();
		TextField Mob = new TextField();
		TextField Plan = new TextField();

		Text cID = new Text("Customer ID:");
		Text cName = new Text("Customer Name:");
		Text cAdd = new Text("Customer Address:");
		Text cMob = new Text("Customer Mobile:");
		Text cPlan = new Text("Customer Plan");

		ID.setOnAction((event)->{
			find.setDisable(true);
			update.setDisable(true);
			error.setText("");
			Name.setText("");
			Plan.setText("");
			Add.setText("");
			Mob.setText("");
			if(ID.getText().isEmpty()) {
				error.setText("Make sure the ID textfield are not empty!");
			}
			if(!ID.getText().isEmpty()) {
				find.setDisable(false);
			}
		});
		
		find.setOnAction( (event) ->{
			
			
			if(test.searchCustomer(ID.getText())==-1) {
				error.setText("There are no customers in the database with that ID.");
				Name.setText("");
				Plan.setText("");
				Add.setText("");
				Mob.setText("");
				
				Name.setEditable(false);
				Add.setEditable(false);
				Mob.setEditable(false);
				Plan.setEditable(false);
				update.setDisable(true);
				find.setDisable(true);
			}
			else {
				
			 index = test.searchCustomer(ID.getText());
				
				Name.setText(test.CustomerList.get(index).getName());
				Plan.setText(test.CustomerList.get(index).getPlan());
				Add.setText(test.CustomerList.get(index).getAddress());
				Mob.setText(test.CustomerList.get(index).getMobileNumber());
				
				update.setDisable(false);
				Name.setEditable(true);
				Add.setEditable(true);
				Mob.setEditable(true);
				Plan.setEditable(true);
				
			}
		});
		
		update.setOnAction((event)->{
			
			if(ID.getText().isEmpty()||Name.getText().isEmpty()||Plan.getText().isEmpty()||Add.getText().isEmpty()||Mob.getText().isEmpty()) {
				error.setText("Make sure none of the textfields are empty!");
			}
			else {
				if(!(Plan.getText().equals("LIMITED")||Plan.getText().equals("UNLIMITED"))) {
					error.setText("Make sure the plan is either LIMITED or UNLIMITED");
				}
				else {
					boolean updateCheck = test.updateCustomer(index, ID.getText(), Name.getText(), Plan.getText(), Add.getText(), Mob.getText());
					if (updateCheck) {
						error.setText("Information has been updated successfully.");
					}
					else {
						error.setText("Could not update the information because that ID belongs to another customer.");
					}
				}
			}

		});
		

		Name.setEditable(false);
		Add.setEditable(false);
		Mob.setEditable(false);
		Plan.setEditable(false);
		update.setDisable(true);
		find.setDisable(true);
		
		
		update.setGraphic(new ImageView("file:///c:./update.png"));
		update.setStyle("-fx-background-color:	#f4f4f4" );
		cBack.setGraphic(new ImageView("file:///c:./back.png"));
		cBack.setStyle("-fx-background-color:#f4f4f4" );
		find.setGraphic(new ImageView("file:///c:./find.png"));
		find.setStyle("-fx-background-color:#f4f4f4" );

		Text pBack = new Text("Back");
		Text pUpdate = new Text("Update");
		Text pFind = new Text("Find");
		Buttons.getChildren().addAll(pFind,find,pUpdate,update,pBack,cBack);
		
		Buttons.setMargin(pFind,(new Insets(12,5,0,15)));
		Buttons.setMargin(pUpdate,(new Insets(12,5,0,30)));
		Buttons.setMargin(pBack,(new Insets(12,5,0,70)));

		CustomerID.getChildren().addAll(cID,ID);
		CustomerName.getChildren().addAll(cName,Name);
		CustomerAdd.getChildren().addAll(cAdd,Add);
		CustomerMobile.getChildren().addAll(cMob,Mob);
		CustomerPlan.getChildren().addAll(cPlan,Plan);
		CustomerID.setSpacing(41);
		CustomerName.setSpacing(21);
		CustomerAdd.setSpacing(10);
		CustomerMobile.setSpacing(15);
		CustomerPlan.setSpacing(32);
		errmsg.setAlignment(Pos.CENTER);
		errmsg.getChildren().add(error);

		center.getChildren().addAll(CustomerID,CustomerName,CustomerPlan,CustomerAdd,CustomerMobile,Buttons);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(15);
		Main.getChildren().addAll(center,errmsg);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");

		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
			
	}
	
	public Scene media() {
		
		HBox Main = new HBox();
		VBox Buttons = new VBox();
		
		Text madd = new Text("Add new Media");
		madd.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text mdelete = new Text("Delete Media");
		mdelete.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text mupdate = new Text("Update Information about Media");
		mupdate.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text msearch = new Text("Search a Media by code");
		msearch.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text mprint = new Text("Print All Media information");
		mprint.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text mreturn = new Text("Return to main page");
		mreturn.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		
		
		mAdd.setGraphic(madd);
		mDelete.setGraphic(mdelete);
		mUpdate.setGraphic(mupdate);
		mSearch.setGraphic(msearch);
		mPrint.setGraphic(mprint);
		Return.setGraphic(mreturn);
		
		mAdd.setStyle("-fx-background-color:#f4f4f4"  );
		mDelete.setStyle("-fx-background-color:#f4f4f4" );
		mUpdate.setStyle("-fx-background-color:#f4f4f4" );
		mSearch.setStyle("-fx-background-color:#f4f4f4" );
		mPrint.setStyle("-fx-background-color:#f4f4f4" );
		Return.setStyle("-fx-background-color:#f4f4f4" );
		
		Buttons.getChildren().addAll(mAdd,mDelete,mUpdate,mSearch,mPrint,Return);
		Main.getChildren().addAll(Buttons);
		
		Buttons.setSpacing(10);
		Buttons.setAlignment(Pos.CENTER_LEFT);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
		
		
	}
	
	public Scene addMedia() {
		
		HBox Main = new HBox();

		HBox MediaCode = new HBox();
		HBox MediaTitle = new HBox();
		HBox MediaCopiesAvailable = new HBox();

		HBox Weight = new HBox();
		HBox Artist = new HBox();
		HBox Songs = new HBox();
		HBox Rating = new HBox();

		HBox Buttons = new HBox();

		VBox center = new VBox();		
		VBox errmsg = new VBox();
		Text error = new Text();

		Button add = new Button();

		TextField code = new TextField();
		TextField title = new TextField();
		TextField copiesAvailable = new TextField();
		TextField weight = new TextField();
		TextField artist = new TextField();
		TextField songs = new TextField();
		TextField rating = new TextField();

		Text tCode = new Text("Media Code:");
		Text tCopiesAvailable = new Text("Copies Available:");

		Text moTitle = new Text("Movie Title:");
		Text gTitle = new Text("Game Title:");
		Text aTitle = new Text("Album Title:");
		Text tWeight = new Text("Game Weight:");
		Text tArtist = new Text("Album Artist:");
		Text tSongs = new Text("Album Songs:");
		Text tRating = new Text("Movie Rating:");

		ComboBox<String> mediaTypes = new ComboBox<>();
		mediaTypes.getItems().addAll("Movie","Game","Album");
		mediaTypes.setValue("Choose a media Type");
		center.getChildren().addAll(mediaTypes,Buttons);
		
		mediaTypes.setOnAction((event)->{

			error.setText("");
			add.setDisable(true);
			title.setEditable(false);
			copiesAvailable.setEditable(false);
			weight.setEditable(false);
			artist.setEditable(false);
			songs.setEditable(false);
			rating.setEditable(false);
			code.setText("");
			title.setText("");
			copiesAvailable.setText("");
			weight.setText("");
			artist.setText("");
			songs.setText("");
			rating.setText("");

			center.getChildren().remove(Buttons);
			MediaTitle.getChildren().removeAll(gTitle,aTitle,moTitle,title);
			
			if(mediaTypes.getValue().equals("Movie")) {
				
				center.getChildren().removeAll(MediaCode,MediaTitle,MediaCopiesAvailable,Weight,Artist,Songs,Rating);

				MediaTitle.getChildren().addAll(moTitle,title);
				MediaTitle.setSpacing(38);
				center.getChildren().addAll(MediaCode,MediaTitle,MediaCopiesAvailable,Rating);

			}

			if(mediaTypes.getValue().equals("Game")) {

				center.getChildren().removeAll(MediaCode,MediaTitle,MediaCopiesAvailable,Weight,Artist,Songs,Rating);

				MediaTitle.getChildren().addAll(gTitle,title);
				MediaTitle.setSpacing(40);
				center.getChildren().addAll(MediaCode,MediaTitle,MediaCopiesAvailable,Weight);

			}
			
			if(mediaTypes.getValue().equals("Album")) {

				center.getChildren().removeAll(MediaCode,MediaTitle,MediaCopiesAvailable,Weight,Artist,Songs,Rating);

				MediaTitle.getChildren().addAll(aTitle,title);
				MediaTitle.setSpacing(36);
				center.getChildren().addAll(MediaCode,MediaTitle,MediaCopiesAvailable,Artist,Songs);

			}
			center.getChildren().add(Buttons);
		});
		

		code.setOnAction((event)->{
			if(code.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfieds!");
			}
			if(!code.getText().isEmpty()) {
				title.setEditable(true);
			}
		});
		title.setOnAction((event)->{
			if(title.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfieds!");
			}

			if(!title.getText().isEmpty()) {
				copiesAvailable.setEditable(true);
				error.setText("");
			}
		});
		
		copiesAvailable.setOnAction((event)->{
			if(!copiesAvailable.getText().isEmpty()) {

				if(copiesAvailable.getText().chars().allMatch( Character::isDigit)) {
					rating.setEditable(true);
					weight.setEditable(true);
					artist.setEditable(true);
					error.setText("");
				}
				else {
					error.setText("The copies available is a number.");
				}
			}
			else {
				error.setText("Make sure the textfields are not empty and to submit all textfieds!");
			}
			
		});
		
		artist.setOnAction((event)->{
			if(artist.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfieds!");
			}
			if(!artist.getText().isEmpty()) {
				songs.setEditable(true);
				error.setText("");
			}
		});
		
		songs.setOnAction((event)->{
			if(songs.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfieds!");
			}
			if(!artist.getText().isEmpty()) {
				add.setDisable(false);
				error.setText("");
			}
		});
		
		rating.setOnAction((event)->{
			if(rating.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfieds!");
			}
			if(!rating.getText().isEmpty())
				add.setDisable(false);
				error.setText("");

		});
		
		weight.setOnAction((event)->{
			if(weight.getText().isEmpty()) {
				error.setText("Make sure the textfields are not empty and to submit all textfieds!");
			}
			if(!weight.getText().isEmpty()) {
				if(weight.getText().chars().allMatch( Character::isDigit)) {
					weight.setEditable(true);
					add.setDisable(false);
					error.setText("");
				}
				else {
					error.setText("The weight has to be a number");
				}
			}

		});
		
		add.setOnAction((event)->{
			//mediaTypes.setValue("Choose a media Type");
			boolean addCheck = true;
			if(mediaTypes.getValue().equals("Movie")) {

				 addCheck = test.addMovie(title.getText(),Integer.parseInt(copiesAvailable.getText()),rating.getText(),code.getText());
			}
			if(mediaTypes.getValue().equals("Game")) {
				 addCheck = test.addGame(title.getText(),Integer.parseInt(copiesAvailable.getText()),Double.parseDouble(weight.getText()),code.getText());
			}
			if(mediaTypes.getValue().equals("Album")) {
				 addCheck = test.addAlbum(title.getText(),Integer.parseInt(copiesAvailable.getText()),artist.getText(),songs.getText(),code.getText());
			}
			if (!addCheck)
				error.setText("Error could not add the media to\nthe Database because another media has the same code.");
			else {
				error.setText("Successfully added the media.");
				center.getChildren().removeAll(MediaCode,MediaTitle,MediaCopiesAvailable,Weight,Artist,Songs,Rating);
	
			}
		});
		add.setDisable(true);

		add.setGraphic(new ImageView("file:///c:./plus.png"));
		add.setStyle("-fx-background-color:#f4f4f4" );
		mBack.setGraphic(new ImageView("file:///c:./back.png"));
		mBack.setStyle("-fx-background-color:#f4f4f4" );

		Text pBack = new Text("Back");
		Text pAdd = new Text("Add");
		Buttons.getChildren().addAll(pAdd,add,pBack,mBack);
		Buttons.setMargin(pAdd,(new Insets(12,5,0,110)));
		Buttons.setMargin(add,(new Insets(0,0,0,0)));
		Buttons.setMargin(pBack,(new Insets(12,5,0,80)));
		
		MediaCode.getChildren().addAll(tCode,code);
		MediaCopiesAvailable.getChildren().addAll(tCopiesAvailable,copiesAvailable);

		Weight.getChildren().addAll(tWeight,weight);
		Artist.getChildren().addAll(tArtist,artist);
		Songs.getChildren().addAll(tSongs,songs);
		Rating.getChildren().addAll(tRating,rating);
		

		MediaCode.setSpacing(33);

		MediaCopiesAvailable.setSpacing(10);
		Rating.setSpacing(27);
		Weight.setSpacing(24);
		Artist.setSpacing(32);
		Songs.setSpacing(27);
		
		errmsg.setAlignment(Pos.CENTER);
		errmsg.getChildren().add(error);

		center.setAlignment(Pos.CENTER);
		center.setSpacing(15);
		Main.getChildren().addAll(center,errmsg);
		Main.setAlignment(Pos.CENTER);

		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");

		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	}
	
	public Scene delMedia() {
		
		HBox Main = new HBox();

		HBox MediaCode = new HBox();
		HBox MediaTitle = new HBox();
		HBox MediaCopiesAvailable = new HBox();

		HBox Weight = new HBox();
		HBox Artist = new HBox();
		HBox Songs = new HBox();
		HBox Rating = new HBox();

		HBox Buttons = new HBox();

		VBox center = new VBox();		
		VBox errmsg = new VBox();
		Text error = new Text();

		Button find = new Button();
		Button delete = new Button();

		TextField code = new TextField();
		TextField title = new TextField();
		TextField copiesAvailable = new TextField();
		TextField weight = new TextField();
		TextField artist = new TextField();
		TextArea songs = new TextArea();
		TextField rating = new TextField();

		Text tCode = new Text("Media Code:");
		Text tCopiesAvailable = new Text("Copies Available:");

		Text moTitle = new Text("Movie Title:");
		Text gTitle = new Text("Game Title:");
		Text aTitle = new Text("Album Title:");
		Text tWeight = new Text("Game Weight:");
		Text tArtist = new Text("Album Artist:");
		Text tSongs = new Text("Album Songs:");
		Text tRating = new Text("Movie Rating:");
		
		songs.setWrapText(true);
		songs.setPrefSize(250, 100);
	
		code.setOnAction((event)->{
			
			find.setDisable(true);
			delete.setDisable(true);
			
			error.setText("");
			title.setText("");
			copiesAvailable.setText("");
			weight.setText("");
			artist.setText("");
			songs.setText("");
			rating.setText("");
			
			center.getChildren().removeAll(MediaTitle,MediaCopiesAvailable,Rating,Weight,Artist,Songs);
			
			if(code.getText().isEmpty()) {
				error.setText("Make sure the ID textfield are not empty!");
			}
			if(!code.getText().isEmpty()) {
				find.setDisable(false);
			}
		});
		find.setOnAction((event)->{
			if(test.searchMedia(code.getText())==-1) {
				error.setText("There isn't a media in the database with that code.");

				title.setText("");
				copiesAvailable.setText("");
				weight.setText("");
				artist.setText("");
				songs.setText("");
				rating.setText("");
				
				delete.setDisable(true);
				find.setDisable(true);
			}
			else {
				
				index = test.searchMedia(code.getText());
				
				center.getChildren().removeAll(MediaTitle,MediaCopiesAvailable,Rating,Weight,Artist,Songs,Buttons);
				MediaTitle.getChildren().removeAll(moTitle,gTitle,aTitle,title);
				
				if(test.mediaTypeChecker(index)==1) {

					MediaTitle.getChildren().addAll(moTitle,title);
					MediaTitle.setSpacing(38);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Rating,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					rating.setText(((Movie) test.MediaList.get(index)).getRating());
					
				}
				if(test.mediaTypeChecker(index)==2) {
					MediaTitle.getChildren().addAll(gTitle,title);
					MediaTitle.setSpacing(40);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Weight,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					weight.setText(((Game) test.MediaList.get(index)).getWeight()+"");
				}
				if(test.mediaTypeChecker(index)==3) {
					
					MediaTitle.getChildren().addAll(aTitle,title);
					MediaTitle.setSpacing(36);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Artist,Songs,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					artist.setText(((Album)test.MediaList.get(index)).getArtist());
					songs.setText(((Album)test.MediaList.get(index)).getSongs());
				}
				
				delete.setDisable(false);
				find.setDisable(true);
			}
		});
		
		delete.setOnAction((event)->{
			
			test.delMedia(index);
			error.setText("Media has been deleted successfully.");
			
			title.setText("");
			copiesAvailable.setText("");
			weight.setText("");
			artist.setText("");
			songs.setText("");
			rating.setText("");
			
			center.getChildren().removeAll(MediaTitle,MediaCopiesAvailable,Rating,Weight,Artist,Songs);
			
			delete.setDisable(true);
			find.setDisable(true);
		
		});
		
		delete.setDisable(true);
		find.setDisable(true);
		
		title.setEditable(false);
		copiesAvailable.setEditable(false);
		weight.setEditable(false);
		artist.setEditable(false);
		songs.setEditable(false);
		rating.setEditable(false);
		
		delete.setGraphic(new ImageView("file:///c:./delete.png"));
		delete.setStyle("-fx-background-color:	#f4f4f4" );
		mBack.setGraphic(new ImageView("file:///c:./back.png"));
		mBack.setStyle("-fx-background-color:#f4f4f4" );
		find.setGraphic(new ImageView("file:///c:./find.png"));
		find.setStyle("-fx-background-color:#f4f4f4" );

		Text pBack = new Text("Back");
		Text pDelete = new Text("Delete");
		Text pFind = new Text("Find");
		Buttons.getChildren().addAll(pFind,find,pDelete,delete,pBack,mBack);
		
		Buttons.setMargin(pFind,(new Insets(12,5,0,15)));
		Buttons.setMargin(pDelete,(new Insets(12,5,0,30)));
		Buttons.setMargin(pBack,(new Insets(12,5,0,70)));

		errmsg.setAlignment(Pos.CENTER);
		errmsg.getChildren().add(error);
		
		MediaCode.getChildren().addAll(tCode,code);
		MediaCopiesAvailable.getChildren().addAll(tCopiesAvailable,copiesAvailable);

		Weight.getChildren().addAll(tWeight,weight);
		Artist.getChildren().addAll(tArtist,artist);
		Songs.getChildren().addAll(tSongs,songs);
		Rating.getChildren().addAll(tRating,rating);

		MediaCode.setSpacing(33);

		MediaCopiesAvailable.setSpacing(10);
		Rating.setSpacing(27);
		Weight.setSpacing(24);
		Artist.setSpacing(32);
		Songs.setSpacing(27);
		
		center.getChildren().addAll(MediaCode,Buttons);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(10);
		Main.getChildren().addAll(center,errmsg);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");

		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	
	}
	
	public Scene updateMedia() {
		
		HBox Main = new HBox();

		HBox MediaCode = new HBox();
		HBox MediaTitle = new HBox();
		HBox MediaCopiesAvailable = new HBox();

		HBox Weight = new HBox();
		HBox Artist = new HBox();
		HBox Songs = new HBox();
		HBox Rating = new HBox();

		HBox Buttons = new HBox();

		VBox center = new VBox();		
		VBox errmsg = new VBox();
		Text error = new Text();

		Button find = new Button();
		Button update = new Button();

		TextField code = new TextField();
		TextField title = new TextField();
		TextField copiesAvailable = new TextField();
		TextField weight = new TextField();
		TextField artist = new TextField();
		TextArea songs = new TextArea();
		TextField rating = new TextField();

		Text tCode = new Text("Media Code:");
		Text tCopiesAvailable = new Text("Copies Available:");

		Text moTitle = new Text("Movie Title:");
		Text gTitle = new Text("Game Title:");
		Text aTitle = new Text("Album Title:");
		Text tWeight = new Text("Game Weight:");
		Text tArtist = new Text("Album Artist:");
		Text tSongs = new Text("Album Songs:");
		Text tRating = new Text("Movie Rating:");
		
		songs.setWrapText(true);
		songs.setPrefSize(250, 100);
	
		code.setOnAction((event)->{
			
			find.setDisable(true);
			update.setDisable(true);
			
			error.setText("");
			
			if(code.getText().isEmpty()) {
				error.setText("Make sure the media textfield are not empty!");
			}
			if(!code.getText().isEmpty()) {
				find.setDisable(false);
			}
		});
		find.setOnAction((event)->{
			if(test.searchMedia(code.getText())==-1) {
				error.setText("There isn't a media in the database with that code.");

				title.setText("");
				copiesAvailable.setText("");
				weight.setText("");
				artist.setText("");
				songs.setText("");
				rating.setText("");
				
				update.setDisable(true);
				find.setDisable(true);
			}
			else {
				
				error.setText("");
				index = test.searchMedia(code.getText());
				
				center.getChildren().removeAll(MediaTitle,MediaCopiesAvailable,Rating,Weight,Artist,Songs,Buttons);
				MediaTitle.getChildren().removeAll(moTitle,gTitle,aTitle,title);
				
				if(test.mediaTypeChecker(index)==1) {

					MediaTitle.getChildren().addAll(moTitle,title);
					MediaTitle.setSpacing(38);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Rating,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					rating.setText(((Movie) test.MediaList.get(index)).getRating());
					
				}
				if(test.mediaTypeChecker(index)==2) {
					MediaTitle.getChildren().addAll(gTitle,title);
					MediaTitle.setSpacing(40);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Weight,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					weight.setText(((Game) test.MediaList.get(index)).getWeight()+"");
				}
				if(test.mediaTypeChecker(index)==3) {
					
					MediaTitle.getChildren().addAll(aTitle,title);
					MediaTitle.setSpacing(36);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Artist,Songs,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					artist.setText(((Album)test.MediaList.get(index)).getArtist());
					songs.setText(((Album)test.MediaList.get(index)).getSongs());
				}
				
				update.setDisable(false);
				find.setDisable(true);
			}
		});
		
		update.setOnAction((event)->{
			if((code.getText().isEmpty()||title.getText().isEmpty()||copiesAvailable.getText().isEmpty()||rating.getText().isEmpty())&&(code.getText().isEmpty()||title.getText().isEmpty()||copiesAvailable.getText().isEmpty()||weight.getText().isEmpty())&&(code.getText().isEmpty()||title.getText().isEmpty()||copiesAvailable.getText().isEmpty()||artist.getText().isEmpty()||songs.getText().isEmpty())) {
				error.setText("Make sure none of the textfields are empty!");

			}
			else {

				double temp=0;
				if(weight.getText().isEmpty()) {
					temp=0;
				}
				else {
					temp=Double.parseDouble(weight.getText());
				}


				test.updateMedia(index,code.getText(),title.getText(),Integer.parseInt(copiesAvailable.getText()),temp,rating.getText(),artist.getText(),songs.getText());
				error.setText("Media has been updated successfully.");

				title.setText("");
				copiesAvailable.setText("");
				weight.setText("");
				artist.setText("");
				songs.setText("");
				rating.setText("");

				center.getChildren().removeAll(MediaTitle,MediaCopiesAvailable,Rating,Weight,Artist,Songs);

				update.setDisable(true);
				find.setDisable(true);
			}
		
		});
		
		find.setDisable(true);
		
		update.setGraphic(new ImageView("file:///c:./update.png"));
		update.setStyle("-fx-background-color:	#f4f4f4" );
		mBack.setGraphic(new ImageView("file:///c:./back.png"));
		mBack.setStyle("-fx-background-color:#f4f4f4" );
		find.setGraphic(new ImageView("file:///c:./find.png"));
		find.setStyle("-fx-background-color:#f4f4f4" );

		Text pBack = new Text("Back");
		Text pUpdate = new Text("Update");
		Text pFind = new Text("Find");
		Buttons.getChildren().addAll(pFind,find,pUpdate,update,pBack,mBack);
		
		Buttons.setMargin(pFind,(new Insets(12,5,0,15)));
		Buttons.setMargin(pUpdate,(new Insets(12,5,0,30)));
		Buttons.setMargin(pBack,(new Insets(12,5,0,70)));

		errmsg.setAlignment(Pos.CENTER);
		errmsg.getChildren().add(error);
		
		MediaCode.getChildren().addAll(tCode,code);
		MediaCopiesAvailable.getChildren().addAll(tCopiesAvailable,copiesAvailable);

		Weight.getChildren().addAll(tWeight,weight);
		Artist.getChildren().addAll(tArtist,artist);
		Songs.getChildren().addAll(tSongs,songs);
		Rating.getChildren().addAll(tRating,rating);

		MediaCode.setSpacing(33);

		MediaCopiesAvailable.setSpacing(10);
		Rating.setSpacing(27);
		Weight.setSpacing(24);
		Artist.setSpacing(32);
		Songs.setSpacing(27);
		
		center.getChildren().addAll(MediaCode,Buttons);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(10);
		Main.getChildren().addAll(center,errmsg);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");

		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
		
	}
	
	public Scene searchMedia() {
		
		HBox Main = new HBox();

		HBox MediaCode = new HBox();
		HBox MediaTitle = new HBox();
		HBox MediaCopiesAvailable = new HBox();

		HBox Weight = new HBox();
		HBox Artist = new HBox();
		HBox Songs = new HBox();
		HBox Rating = new HBox();

		HBox Buttons = new HBox();

		VBox center = new VBox();		
		VBox errmsg = new VBox();
		Text error = new Text();

		Button find = new Button();

		TextField code = new TextField();
		TextField title = new TextField();
		TextField copiesAvailable = new TextField();
		TextField weight = new TextField();
		TextField artist = new TextField();
		TextArea songs = new TextArea();
		TextField rating = new TextField();

		Text tCode = new Text("Media Code:");
		Text tCopiesAvailable = new Text("Copies Available:");

		Text moTitle = new Text("Movie Title:");
		Text gTitle = new Text("Game Title:");
		Text aTitle = new Text("Album Title:");
		Text tWeight = new Text("Game Weight:");
		Text tArtist = new Text("Album Artist:");
		Text tSongs = new Text("Album Songs:");
		Text tRating = new Text("Movie Rating:");
		
		songs.setWrapText(true);
		songs.setPrefSize(250, 100);
	
		code.setOnAction((event)->{
			
			find.setDisable(true);
			
			error.setText("");
			title.setText("");
			copiesAvailable.setText("");
			weight.setText("");
			artist.setText("");
			songs.setText("");
			rating.setText("");
			
			center.getChildren().removeAll(MediaTitle,MediaCopiesAvailable,Rating,Weight,Artist,Songs);
			
			if(code.getText().isEmpty()) {
				error.setText("Make sure the code textfield are not empty!");
			}
			if(!code.getText().isEmpty()) {
				find.setDisable(false);
			}
		});
		find.setOnAction((event)->{
			title.setEditable(false);
			copiesAvailable.setEditable(false);
			weight.setEditable(false);
			artist.setEditable(false);
			songs.setEditable(false);
			rating.setEditable(false);
			if(test.searchMedia(code.getText())==-1) {
				error.setText("There isn't a media in the database with that code.");

				title.setText("");
				copiesAvailable.setText("");
				weight.setText("");
				artist.setText("");
				songs.setText("");
				rating.setText("");
				
				find.setDisable(true);
			}
			else {
				
				error.setText("");
				index = test.searchMedia(code.getText());
				
				center.getChildren().removeAll(MediaTitle,MediaCopiesAvailable,Rating,Weight,Artist,Songs,Buttons);
				MediaTitle.getChildren().removeAll(moTitle,gTitle,aTitle,title);
				
				if(test.mediaTypeChecker(index)==1) {

					MediaTitle.getChildren().addAll(moTitle,title);
					MediaTitle.setSpacing(38);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Rating,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					rating.setText(((Movie) test.MediaList.get(index)).getRating());
					
				}
				if(test.mediaTypeChecker(index)==2) {
					MediaTitle.getChildren().addAll(gTitle,title);
					MediaTitle.setSpacing(40);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Weight,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					weight.setText(((Game) test.MediaList.get(index)).getWeight()+"");
				}
				if(test.mediaTypeChecker(index)==3) {
					
					MediaTitle.getChildren().addAll(aTitle,title);
					MediaTitle.setSpacing(36);
					center.getChildren().addAll(MediaTitle,MediaCopiesAvailable,Artist,Songs,Buttons);
					
					title.setText(test.MediaList.get(index).getTitle());
					copiesAvailable.setText(test.MediaList.get(index).getCopiesAvailable()+"");
					artist.setText(((Album)test.MediaList.get(index)).getArtist());
					songs.setText(((Album)test.MediaList.get(index)).getSongs());
				}
				
				find.setDisable(true);
			}
		});
		
		find.setDisable(true);
	
		mBack.setGraphic(new ImageView("file:///c:./back.png"));
		mBack.setStyle("-fx-background-color:#f4f4f4" );
		find.setGraphic(new ImageView("file:///c:./find.png"));
		find.setStyle("-fx-background-color:#f4f4f4" );

		Text pBack = new Text("Back");
		Text pFind = new Text("Find");
		Buttons.getChildren().addAll(pFind,find,pBack,mBack);
		
		Buttons.setMargin(pFind,(new Insets(12,5,0,110)));
		Buttons.setMargin(pBack,(new Insets(12,5,0,80)));

		errmsg.setAlignment(Pos.CENTER);
		errmsg.getChildren().add(error);
		
		MediaCode.getChildren().addAll(tCode,code);
		MediaCopiesAvailable.getChildren().addAll(tCopiesAvailable,copiesAvailable);

		Weight.getChildren().addAll(tWeight,weight);
		Artist.getChildren().addAll(tArtist,artist);
		Songs.getChildren().addAll(tSongs,songs);
		Rating.getChildren().addAll(tRating,rating);

		MediaCode.setSpacing(33);

		MediaCopiesAvailable.setSpacing(10);
		Rating.setSpacing(27);
		Weight.setSpacing(24);
		Artist.setSpacing(32);
		Songs.setSpacing(27);
		
		center.getChildren().addAll(MediaCode,Buttons);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(10);
		Main.getChildren().addAll(center,errmsg);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");

		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
		
	}
	
	public Scene printMedia() {

		
		HBox Main = new HBox();
		
		VBox center = new VBox();
		
		HBox Buttons = new HBox();
		
		TextArea mediaInfo = new TextArea();
		Text info = new Text("All Media Information:");
		
		Text Back = new Text("back");
		mBack.setGraphic(new ImageView("file:///c:./back.png"));
		mBack.setStyle("-fx-background-color:#f4f4f4" );
		
		Buttons.getChildren().addAll(Back,mBack);
		center.getChildren().addAll(info,mediaInfo,Buttons);
		Main.getChildren().add(center);
		
		mediaInfo.setText(test.getAllMediaInfo());
		
		center.setAlignment(Pos.CENTER);
		Main.setAlignment(Pos.CENTER);
		Buttons.setAlignment(Pos.CENTER);
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	}
	
	public Scene rent() {
		
		HBox Main = new HBox();
		VBox Buttons = new VBox();
		
		Text tRent = new Text("Rent an item");
		tRent.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text tpCart = new Text("Print the cart of a customer");
		tpCart.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text tpRented = new Text("Print the rented items of a customer");
		tpRented.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text trReturn = new Text("Return a customer's rented media");
		trReturn.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		Text tReturn = new Text("Return to main page");
		tReturn.setFont(Font.font("Calibri",FontWeight.BOLD,16));
		
		
		rentForm.setGraphic(tRent);
		printCart.setGraphic(tpCart);
		printRented.setGraphic(tpRented);
		returnRented.setGraphic(trReturn);
		Return.setGraphic(tReturn);
		
		
		rentForm.setStyle("-fx-background-color:#f4f4f4"  );
		printCart.setStyle("-fx-background-color:#f4f4f4" );
		printRented.setStyle("-fx-background-color:#f4f4f4" );
		returnRented.setStyle("-fx-background-color:#f4f4f4" );
		Return.setStyle("-fx-background-color:#f4f4f4" );

		
		Buttons.getChildren().addAll(rentForm,printCart,printRented,returnRented,Return);
		Main.getChildren().addAll(Buttons);
		
		Buttons.setSpacing(10);
		Buttons.setAlignment(Pos.CENTER_LEFT);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		rBack.setText("");
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	}
	
	public Scene rentForm() {
		
		HBox Main = new HBox();
		
		VBox center = new VBox();
		
		HBox CustomerID = new HBox();
		HBox CustomerInfo = new HBox();
		HBox MediaCode = new HBox();
		HBox MediaInfo = new HBox();
		HBox RentedDate = new HBox();
		HBox Buttons = new HBox();
		Rectangle rectangle = new Rectangle(75,40);

	    Text error = new Text();
	    
	    Button adda = new Button("Add To Cart");
	    Button proccess = new Button("Proccess Carts");
	    rBack.setText("Back");
		
		rectangle.setArcWidth(10.0); 
	    rectangle.setArcHeight(10.0);
	    
	    rBack.setGraphic(null);
	    
	    rBack.setStyle("-fx-background-color:#f4f4f4 ;-fx-border-color:#48769e ; -fx-border-width: 2px");
	    adda.setStyle("-fx-background-color:#f4f4f4 ;-fx-border-color:#48769e ; -fx-border-width: 2px");
	    proccess.setStyle("-fx-background-color:#f4f4f4 ;-fx-border-color:#48769e ; -fx-border-width: 2px");
	    
	    rBack.setShape(rectangle);
	    adda.setShape(rectangle);
	    proccess.setShape(rectangle);
	    	
		TextField customerID = new TextField();
		TextArea customerInfo = new TextArea();
		TextField mediaCode = new TextField();
		TextArea mediaInfo = new TextArea();
		TextField rentedDate = new TextField();
		
		Text customerid = new Text("Customer ID:");
		Text mediacode = new Text("Media Code:");
		Text renteddate = new Text("Rented Date:");
		
		
		CustomerID.getChildren().addAll(customerid,customerID);
		MediaCode.getChildren().addAll(mediacode,mediaCode);
		CustomerInfo.getChildren().addAll(customerInfo);
		MediaInfo.getChildren().addAll(mediaInfo);
		RentedDate.getChildren().addAll(renteddate,rentedDate);
		
		Buttons.getChildren().addAll(adda,proccess,rBack);
		center.getChildren().addAll(CustomerID,CustomerInfo,MediaCode,MediaInfo,RentedDate,Buttons,error);
		Main.getChildren().addAll(center);
		
		CustomerInfo.setMargin(customerInfo,new Insets(0,0,0,69));
		MediaInfo.setMargin(mediaInfo,new Insets(0,0,0,69));
		Buttons.setMargin(adda,new Insets(0,15,0,30));
		Buttons.setMargin(rBack,new Insets(0,0,0,340));
		
		customerID.setOnAction(e ->{
			error.setText("");
			customerInfo.setText("");
			adda.setDisable(true);
			flag1=false;
			if(customerID.getText().isEmpty()) {
				error.setText("Make sure the customer ID textfield is not empty!");
				customerInfo.setText("");
				
			}
			else {
				 index = test.searchCustomer(customerID.getText());
				if(index!=-1) {
					customerInfo.setText(test.CustomerList.get(index).toString());
					flag1 = true;
				}
				else {
					error.setText("There isn't a customer with that ID.");
					
				}
			}
			if(flag1&&flag2) {
				adda.setDisable(false);
			}
		});

		mediaCode.setOnAction(e -> {
			error.setText("");
			adda.setDisable(true);
			flag2 = false;
			if(mediaCode.getText().isEmpty()) {
				error.setText("Make sure the media code textfield is not empty!");
				mediaInfo.setText("");
				
			}
			else {
				
				 index2 = test.searchMedia(mediaCode.getText());
				if(index2!=-1) {
					mediaInfo.setText(test.MediaList.get(index2).toString());
					flag2 = true;
				}
				else {
					error.setText("There isn't a media with that code.");
					mediaInfo.setText("");
				
				}
			}
			if(flag1&&flag2) {
				adda.setDisable(false);
			}
		});
		
	

		
		adda.setOnAction(e -> {
			
			
			int i = test.searchCustomer(customerID.getText());
			int j = test.searchMedia(mediaCode.getText());
			
			rentedDate.setText((new Date()).toString());
			int z = test.addtoCart(test.CustomerList.get(i).getName(), test.MediaList.get(j).getTitle());
			
			if(z==0) {
				error.setText("Media has been added to the cart successfully.");
				customerInfo.setText(test.CustomerList.get(index).toString()); // wanted to do the same for media but because of the copies available and process requests method requested by the project could not do it
			}
			if(z==1) {
				error.setText("The media does not exist in the database"); // won't run
			}
			if(z==2) {
				error.setText("There is already a copy of the media in the cart");
			}
			if(z==3) {
				error.setText("Could not find the customer in the database");// won't run added z==1 and z==3 just in case i need to adjust the code to include them
			}
		});
		
		proccess.setOnAction(e -> {	
			//Main.getChildren().remove(prog);
			error.setText("");
			customerInfo.setText("");
			if(test.CustomerList.get(index).getCart().isEmpty()) {
				error.setText("The customer's cart is empty.");
			}
			else {
				String prss = test.processRequests();
				if(!prss.equals(null)) {
					customerInfo.setText(prss);
					customerID.setText("");
					mediaInfo.setText("");
					mediaCode.setText("");
				}
				else {
					customerInfo.setText("all carts are empty");
				
				
					rentedDate.setText((new Date()).toString());
				}
			}
				
		});
		
		CustomerID.setSpacing(4);
		MediaCode.setSpacing(6);
		RentedDate.setSpacing(5);
		
		
		CustomerInfo.setMargin(customerInfo, new Insets(0,0,0,73));
		MediaInfo.setMargin(mediaInfo, new Insets(0,0,0,74));
		
		
		customerInfo.setWrapText(true);
		mediaInfo.setWrapText(true);
		
		CustomerID.setAlignment(Pos.CENTER_LEFT);
		MediaCode.setAlignment(Pos.CENTER_LEFT);
		RentedDate.setAlignment(Pos.CENTER_LEFT);

		
		rentedDate.setPrefWidth(200);
		
		adda.setDisable(true);
		customerInfo.setEditable(false);
		mediaInfo.setEditable(false);
		rentedDate.setEditable(false);
		
		center.setSpacing(5);
		
		Buttons.setAlignment(Pos.CENTER);
		center.setAlignment(Pos.CENTER);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
	}

	public Scene printCart() {
		
		HBox Main = new HBox();
		
		VBox center = new VBox();
		
		HBox CustomerID = new HBox();
		HBox cCart = new HBox();
		HBox Buttons = new HBox();
		
		TextArea Cart = new TextArea();
		TextField customerID = new TextField();
		
		Text customerid = new Text("Customer ID:");
		Text cart = new Text("Cart:");
		Text error = new Text();
		
		Text back = new Text("Back");
		rBack.setGraphic(new ImageView("file:///c:./back.png"));
		rBack.setStyle("-fx-background-color:#f4f4f4" );
		
		Buttons.getChildren().addAll(back,rBack);
		cCart.getChildren().addAll(cart,Cart);
		CustomerID.getChildren().addAll(customerid,customerID);
		center.getChildren().addAll(CustomerID,cCart,Buttons);
		Main.getChildren().addAll(center,error);
		
		Buttons.setMargin(rBack,new Insets(0,0,0,0));
		cCart.setMargin(cart, new Insets(5,0,0,0));
		cCart.setMargin(Cart, new Insets(5,0,0,50));
		CustomerID.setSpacing(5);
		
		Cart.setEditable(false);
		
		customerID.setOnAction(e->{
			Cart.setText("");
			error.setText("");
			if(customerID.getText().isEmpty()) {
				error.setText("Make sure the customer ID textfield is not empty!");
			}
			else {
				index = test.searchCustomer(customerID.getText());
				if(index==-1) {
					error.setText("There is no customer in the database with that ID");
				}
				else {
					if(test.CustomerList.get(index).getCart().isEmpty()) {
						Cart.setText("The cart is empty");
					}
					else {
						Cart.setText(test.CustomerList.get(index).printCart());
					}
				}
			}
		});
		
		Buttons.setAlignment(Pos.CENTER);
		CustomerID.setAlignment(Pos.CENTER_LEFT);
		center.setAlignment(Pos.CENTER);
		Main.setAlignment(Pos.CENTER);
		
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
		
	}

	public Scene printRented() {

		HBox Main = new HBox();
		
		VBox center = new VBox();
		
		HBox CustomerID = new HBox();
		HBox cRented = new HBox();
		HBox Buttons = new HBox();
		
		TextArea Rented = new TextArea();
		TextField customerID = new TextField();
		
		Text customerid = new Text("Customer ID:");
		Text rented = new Text("Rented:");
		Text error = new Text();
		
		Text back = new Text("Back");
		rBack.setGraphic(new ImageView("file:///c:./back.png"));
		rBack.setStyle("-fx-background-color:#f4f4f4" );
		
		Buttons.getChildren().addAll(back,rBack);
		cRented.getChildren().addAll(rented,Rented);
		CustomerID.getChildren().addAll(customerid,customerID);
		center.getChildren().addAll(CustomerID,cRented,Buttons);
		Main.getChildren().addAll(center,error);
		
		Buttons.setMargin(rBack,new Insets(0,0,0,0));
		cRented.setMargin(rented, new Insets(5,0,0,0));
		cRented.setMargin(Rented, new Insets(5,0,0,33));
		CustomerID.setSpacing(5);
		
		Rented.setEditable(false);
		
		customerID.setOnAction(e->{
			Rented.setText("");
			error.setText("");
			if(customerID.getText().isEmpty()) {
				error.setText("Make sure the customer ID textfield is not empty!");
			}
			else {
				index = test.searchCustomer(customerID.getText());
				if(index==-1) {
					error.setText("There is no customer in the database with that ID");
				}
				else {
					System.out.println(test.CustomerList);
					if(test.CustomerList.get(index).getRented().isEmpty()) {
						Rented.setText("The customer is not renting anything");
					}
					else {
						Rented.setText(test.CustomerList.get(index).printRented());
					}
				}
			}
		});
		
		Buttons.setAlignment(Pos.CENTER);
		CustomerID.setAlignment(Pos.CENTER_LEFT);
		center.setAlignment(Pos.CENTER);
		Main.setAlignment(Pos.CENTER);
		
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
		
	
	}

	public Scene returnRented() {
		
		HBox Main = new HBox();
		
		VBox center = new VBox();
		
		HBox CustomerID = new HBox();
		HBox CustomerInfo = new HBox();
		HBox MediaName = new HBox();

		HBox Buttons = new HBox();
		Rectangle rectangle = new Rectangle(75,40);

	    Text error = new Text();
	    
	    Button	returnM = new Button("Return Media");
	    
	    rBack.setText("Back");
		
		rectangle.setArcWidth(10.0); 
	    rectangle.setArcHeight(10.0);
	    
	    rBack.setGraphic(null);
	    
	    rBack.setStyle("-fx-background-color:#f4f4f4 ;-fx-border-color:#48769e ; -fx-border-width: 2px");
	    returnM.setStyle("-fx-background-color:#f4f4f4 ;-fx-border-color:#48769e ; -fx-border-width: 2px");
	   
	    
	    rBack.setShape(rectangle);
	    returnM.setShape(rectangle);

	    	
		TextField customerID = new TextField();
		TextArea customerInfo = new TextArea();
		TextField mediaName = new TextField();
		TextField rentedDate = new TextField();
		
		Text customerid = new Text("Customer ID:");
		Text medianame = new Text("Media Title:");
		Text renteddate = new Text("Rented Date:");
		Text prog = new Text();
		
		
		CustomerID.getChildren().addAll(customerid,customerID);
		MediaName.getChildren().addAll(medianame,mediaName);
		CustomerInfo.getChildren().addAll(customerInfo);

		
		Buttons.getChildren().addAll(returnM,rBack);
		center.getChildren().addAll(CustomerID,CustomerInfo,MediaName,Buttons,error);
		Main.getChildren().addAll(center);
		
		CustomerInfo.setMargin(customerInfo,new Insets(0,0,0,69));
		Buttons.setMargin(returnM,new Insets(0,0,0,0));
		Buttons.setMargin(rBack,new Insets(0,0,0,470));
		
		flag1=false;
		flag2=false;
		
		customerID.setOnAction(e ->{
			error.setText("");
			prog.setText("");
			returnM.setDisable(true);
			flag1=false;
			if(customerID.getText().isEmpty()) {
				error.setText("Make sure the customer ID textfield is not empty!");
				customerInfo.setText("");
				
			}
			else {
				 index = test.searchCustomer(customerID.getText());
				if(index!=-1) {
					customerInfo.setText(test.CustomerList.get(index).toString());
					flag1 = true;
				}
				else {
					error.setText("There isn't a customer with that ID.");
					
				}
			}
			if(flag1&&flag2) {
				returnM.setDisable(false);
			}
		});

		mediaName.setOnAction(e -> {
			error.setText("");
			prog.setText("");
			returnM.setDisable(true);
			flag2 = false;
			if(mediaName.getText().isEmpty()) {
				error.setText("Make sure the media name textfield is not empty!");
			}
			else {
				flag2 = true;
			}
			if(flag1&&flag2) {
				returnM.setDisable(false);
			}
		});
		
		returnM.setOnAction(e -> {
			
			prog.setText("");
			int z = test.returnMedia(customerID.getText(), mediaName.getText());
			
			if(z==0) {
				customerInfo.setText(test.CustomerList.get(index).toString());
				error.setText("Rented item has been returned");
			}
			if(z==1||z==2) {
				error.setText("This item has not been rented by the customer"); 
			}
//			if(z==2) {
//				error.setText("Could not find that media");
//			}
		});
		
		CustomerID.setSpacing(4);
		MediaName.setSpacing(11);

		CustomerInfo.setMargin(customerInfo, new Insets(0,0,0,73));

		customerInfo.setWrapText(true);

		
		CustomerID.setAlignment(Pos.CENTER_LEFT);
		MediaName.setAlignment(Pos.CENTER_LEFT);

		rentedDate.setPrefWidth(200);
		
		returnM.setDisable(true);
		customerInfo.setEditable(false);

		rentedDate.setEditable(false);
		
		center.setSpacing(5);
		
		Buttons.setAlignment(Pos.CENTER);
		center.setAlignment(Pos.CENTER);
		Main.setAlignment(Pos.CENTER);
		
		Main.setStyle("-fx-border-color:#48769e ; -fx-border-width: 2px");
		
		return new Scene(Main,screenSize.getWidth(),screenSize.getHeight());
		
	}
}

