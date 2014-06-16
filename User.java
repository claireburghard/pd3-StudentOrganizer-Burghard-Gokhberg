import java.io.*;
import java.util.*;

public class User{
    private static Scanner sc = new Scanner(System.in);
    private Backpack b = new Backpack();
    
    public static void welcome(){
	
	if (username.equals("")){
	    System.out.println("Welcome to your Backpack! Enter a new username!");
	    username = sc.nextLine();
	    System.out.println("Hello "+ username + "!");
	}else{
	    System.out.println("Welcome back " + username);
	}
    }

    public void saveBackpack(){
	try{
	    // Write to disk with FileOutputStream
	    FileOutputStream f_out = new FileOutputStream("mybackpack.data");
	    // Write object with ObjectOutputStream
	    ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
	    // Write object out to disk
	    obj_out.writeObject(b); 
	}catch (Exception e){}
    }
    
    public Backpack retrieveBackpack(){
	try{
	    // Read from disk using FileInputStream
	    FileInputStream f_in = new FileInputStream("mybackpack.data");
	    
	    // Read object using ObjectInputStream
	    ObjectInputStream obj_in = new ObjectInputStream (f_in);
	    
	    // Read an object
	    Object obj = obj_in.readObject();
	    
	    if (obj instanceof Backpack)
		{
		    // Cast object to a "Serialization
		    b = (Backpack) obj;
		}
	}catch (Exception e){}
    }

    public static void addAnAsmt(){
	System.out.println("What is the name of your assignment?");
	String name = sc.nextLine();
	System.out.println("What is the due date of your assignment?");
	System.out.println("Please enter the date in this order:");
	System.out.println("DAY, MONTH, YEAR, HOUR, MINUTE");
	int d = sc.nextInt();
	int m = sc.nextInt();
	int y = sc.nextInt();
	int h = sc.nextInt();
	int min = sc.nextInt();
	//We also have to add something about the type of assignment (essay, flashcards, etc) 
	System.out.println("Adding your assignment now...");
	DueDate date = new DueDate(y, m, d, h, min);
	Assignment a = new Assignment(name, date);
        b.addAssignment(a);
    }

    public static void openAnAsmt(){
	//oof this is going to need some research
    }

    public static void deleteAnAsmt(String key){
        System.out.println("What is the name of the assignment you would like to delete?");
	String a = sc.nextLine();
	if (key.equals("assignments")){
	    b.deleteAssignment1(a);
	}
	if (key.equals("planner")){
	    b.getPlanner().remove(a);
	}
	if (key.equals("completed")){
	    b.deleteAssignment2(a);
	}
    }	

    public static void addAsmtToPlanner(){
	//gotta write this
    }

    public static void makeComplete(){
	//gotta write this
    }

    public static void changeDueDate(){
    }


    public static void main(String[] args){
	welcome();
	//LEVEL 1
	System.out.println("Where would you like to go?");
	System.out.println("View all of my assignments(1)");//Assignments
	System.out.println("View My Planner(2)");//Planner
	System.out.println("View my completed assignments(3)");//Completed Assignments
	System.out.println("Exit or save(4)");//Exit or Save
	String response1 = sc.nextLine();

	//LEVEL 2
	if (response1.equals("1")){
	    //Assigments
	    System.out.println("Add an assignment(1)");//Add an assignment
	    System.out.println("Open an assignment(2)");//Open an assignment
	    System.out.println("Delete an assignment(3)");//Delete an assignment
	    String response2 = sc.nextLine();
	    
	    //LEVEL 3
	    if (response2.equals("1")){
	        this.addAnAsmt();
	    }
	    if (response2.equals("2")){
	        this.openAnAsmt();
	    }
	    if (response2.equals("3")){
		this.deleteAnAsmt();
	    }
	}
	if (response1.equals("2")){
	    //My Planner
	    System.out.println("Add an assignment to My Planner(1)");//Add an assignment to My Planner
	    System.out.println("Declare an assignment completed(2)");//Declare an assignment completed
	    System.out.println("Change a due date(3)");//Change a due date
	    String response2 = sc.nextLine();
	    //LEVEL 3
	    if (response2.equals("1")){
		this.addAsmtToPlanner();
	    }
	    if (response2.equals("2")){
	        this.makeComplete();
	    }
	    if (response2.equals("3")){
	        this.changeDueDate();
	    }
	}
	if (response1.equals("3")){
	    //Completed assignments
	    System.out.println("View a completed assignment(1)");//View a completed assignment
	    System.out.println("Delete a completed assignment(2)");//Delete a completed assignment
	    String response2 = sc.nextLine();

	    //LEVEL 3
	    if (response2.equals("1")){
	        this.openAnAsmt();
	    }
	    if (response.equals("2")){
	        this.deleteAnAsmt();
	    }
	}
	if (repsonse1.equals("4")){
	    //Exit or save
	    System.out.println("Save the contents of My Backpack (save)");
	    System.out.println("Exit My Backpack (exit)");
	    String response2 = sc.nextLine();

	    //LEVEL 3
	    if (response2.equals("save")){
	        this.saveBackpack();
	    }
	    if (response2.equals("2")){
	        this.saveBackpack();
		//exit the program
	    }
	}

	
    }
    
    
    
}


    
