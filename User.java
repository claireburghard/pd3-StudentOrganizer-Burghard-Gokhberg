import java.io.*;
import java.util.*;

public class User{
    private static Scanner sc = new Scanner(System.in);
    private Backpack b;
    
    public void welcome(){
	System.out.println("Welcome to your Backpack! Have you ever used this program before? (y)es or (n)o");
	String response = sc.nextLine();
	if (response.equals("y")){
	    b = new Backpack(false);
	}
	else{
	    b = new Backpack(true);
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
    
    public void retrieveBackpack(){
	try{
	    // Read from disk using FileInputStream
	    FileInputStream f_in = new FileInputStream("mybackpack.data");
	    
	    // Read object using ObjectInputStream
	    ObjectInputStream obj_in = new ObjectInputStream (f_in);
	    
	    // Read an object
	    Object obj = obj_in.readObject();
	    
	    if (obj instanceof Backpack){
		    // Cast object to a "Serialization
		    b = (Backpack) obj;
	    }
	}catch (Exception e){}
    }

    public void addAnAsmt(){
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

    public void openAnAsmt(){
	//oof this is going to need some research
    }

    public void deleteAnAsmt(String key){
        System.out.println("What is the name of the assignment you would like to delete?");
	String a = sc.nextLine();
	if (key.equals("assignments")){
	    b.deleteAssignment1(a);
	}
	if (key.equals("planner")){
	    int index = b.getPlanner().find(a);
	    b.getPlanner().remove(index);
	}
	if (key.equals("completed")){
	    b.deleteAssignment2(a);
	}
    }	

    public void addAsmtToPlanner(){
	System.out.println("What assignment would you like to add to your planner?");
	String aname = sc.nextLine();
	int i=0;
	while (b.assignments.get(i).getName() != aname){
	    i++;
	}
	if (i<b.getAsmtLength()){
	    b.getPlanner().add(b.assignments.get(i));
	    System.out.println("This assignment has been sucessfully inserted into the planner.");
	}
	else{
	    System.out.println("I'm sorry, this assignment does not currently exist.");
	}	    
    }

    public void makeComplete(){
	System.out.println("What assignment would you like to make complete?");
	String aname = sc.nextLine();
	int i=0;
	while (b.assignments.get(i).getName() != aname){
	    i++;
	}
	if (i<b.getAsmtLength()){
	    b.completeAssignment(b.assignments.get(i).getName());
	    System.out.println("This assignment has been sucessfully completed.");
	}
	else{
	    System.out.println("I'm sorry, this assignment does not currently exist.");
	}	    
    }
    

    public void changeDueDate(){
        System.out.println("What assignment would you like to change the due date of?");
	String aname = sc.nextLine();
	int i=0;
	while (b.assignments.get(i).getName() != aname){
	    i++;
	}
	if (i<b.getAsmtLength()){
	    System.out.println("What is the due date of your assignment?");
	    System.out.println("Please enter the date in this order:");
	    System.out.println("DAY, MONTH, YEAR, HOUR, MINUTE");
	    int d = sc.nextInt();
	    int m = sc.nextInt();
	    int y = sc.nextInt();
	    int h = sc.nextInt();
	    int min = sc.nextInt();
	    DueDate date = new DueDate(y, m, d, h, min);
	    b.assignments.get(i).changeDueDate(date);
	    System.out.println("The due date of this assignment has been sucessfully changed.");
	}
	else{
	    System.out.println("I'm sorry, this assignment does not currently exist.");
	}
    }


    public static void main(String[] args){
	User u = new User();
	u.welcome();
	//LEVEL 1
	System.out.println("Where would you like to go?");
	System.out.println("Manage assignments(1)");//Assignments
	System.out.println("Manage My Planner(2)");//Planner
	System.out.println("View my completed assignments(3)");//Completed Assignments
	System.out.println("Manage my Flashcards(4)");
	System.out.println("Exit or save(5)");//Exit or Save
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
	        u.addAnAsmt();
	    }
	    if (response2.equals("2")){
	        u.openAnAsmt();
	    }
	    if (response2.equals("3")){
		u.deleteAnAsmt("assignments");
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
		u.addAsmtToPlanner();
	    }
	    if (response2.equals("2")){
	        u.makeComplete();
	    }
	    if (response2.equals("3")){
	        u.changeDueDate();
	    }
	}
	if (response1.equals("3")){
	    //Completed assignments
	    System.out.println("View a completed assignment(1)");//View a completed assignment
	    System.out.println("Delete a completed assignment(2)");//Delete a completed assignment
	    String response2 = sc.nextLine();

	    //TO BE CONTINUED

	}

	    //LEVEL 3
	    if (response2.equals("1")){
	        u.openAnAsmt();
	    }
	    if (response2.equals("2")){
	        u.deleteAnAsmt("completed");
	    }
	}
	if (response1.equals("4")){
	    //Manage Flashcards
	    System.out.println("Create a new Flashcard to add to the Deck(create)");
	    System.out.println("Study Flashcards in Deck(study)");
	    System.out.println("Test yourself using current Deck of cards(test)");
	    String response2 = sc.nextLine();
	    
	    //LEVEL3
	if (response1.equals("5")){
	    //Exit or save
	    System.out.println("Save the contents of My Backpack (save)");
	    System.out.println("Exit My Backpack (exit)");
	    String response2 = sc.nextLine();

	    //LEVEL 3
	    if (response2.equals("save")){
	        u.saveBackpack();
	    }
	    if (response2.equals("2")){
	        u.saveBackpack();
		//exit the program
	    }
	}

	
    }
    
    
    
}


    
