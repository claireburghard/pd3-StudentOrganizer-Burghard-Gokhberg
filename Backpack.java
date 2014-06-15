import java.util.*;
import java.io.*;

public class Backpack {

    //the assignments ArrayList is just a pile of assignments that have been created. The planner is a priority queue that is a to-do list of assignments in the assignments ArrayList.
    //later, there will be a method that allows you to pick and choose assignments from the assignment ArrayList and add them to the planner. 
    //so, you can have assignments that are not listed in the planner; for example, assignments that have already been completed or assignments that aren't due for a while. 
    private ArrayList<Assignment> assignments;
    private ArrayList<Assignment> completed;
    private Planner planner = new Planner();

    public Backpack(boolean firsttime){
	if (firsttime == true){
	    this.createFile();
	    assignments = new ArrayList<Assignment>();
	    completed = new ArrayList<Assignment>();
	}
	else{
	    //read from the file, then do stuff
	}
    }

    public Backpack(boolean firsttime, Assignment a){
	if (firsttime == true){
	    //create the file first
	    assignments = new ArrayList<Assignment>();
	    assignments.add(a);
	}
	else{
	    //read from the file, then do stuff
	}
    }

    public Planner getPlanner() {
	return planner;
    }

    //creates the backpack file if it does not already exsist. The assignments and planner will be saved in this file.
    public void createFile(){
	PrinterWriter backpack = new PrintWriter("backpack.txt");
    }

    //reads the backpack file whenever the program is opened and re-inserts the contents of the backpack into the program.
    public void readFile(){
	String line;
	try{
	    BufferedReader reader = new BufferedReader(new FileReader(path));
	    while ((line = reader.readLine()) != "Planner")
		{
		    content += "\n" + line;
		}
	    content = content.substring(1);
	    reader.close();
	}catch (Exception e){}

    }
	
    //used when the backpack is closed. Takes the contents of the program and rewrites them to the backpack file. 				
    public void writeFile(){
	Printwriter out=null;
	try{
	    out = new PrintWriter(new BufferedWriter(new FileWriter("backpack.txt")));
	    for (int i=0; i<assignments.length; i++){
		out.prinln(assignments[i].getName());
	    }
	    out.println("Planner");
	    for (int i=0; i<planner.getLength(); i++){
		out.println(planner.get(i).getName());
	    }
	    out.println("Completed");
	    for (int i=0; i<completed.length; i++){
		out.println(completed[i].getName());
	    }
	}catch (Exception e){};
	out.close();
    }

	
    //creates an assignment. User gives a name and if an assignment with that name does not already exist, an assignment is created by that name.
    //return true if the assignment is added, false otherwise. 
    public boolean addAssignment(Assignment a){
	boolean answer = true;
	boolean another = false;
	for (int i=0; i<assignments.size(); i++){
	    if (assignments.get(i).getName() == a.getName()) {
		another = true;
	    }
	}
	if (another == false){
	    assignments.add(a);
	}
	else{
	    answer = false;
	}
	return answer;
    }
    
    //deletes an assignment; user gives a name and if an assignment exists with that name, it will be deleted.
    //returns true if the assignment has been deleted, false otherwise.
    //precondition: there are no assignments with identical names. This is ensured by the addAssignment method. 
    public void deleteAssignment (String n){ 
	Assignment todelete = new Assignment(); 
	for (int i=0; i<assignments.size(); i++){
	    if (assignments.get(i).getName() == n){
		todelete = assignments.get(i);
	    }
	}
	assignments.remove(todelete);
    }

    //Should we create some kind of method that goes through the list of assignments and moves the ones that are completed to the completed list? Or one that does it as soon as an assignment is completed?

    public void completeAssignment (String n){
	Assignment complete = new Assignment();
	for (int x = 0; x < assignments.size(); x++){
	    if (assignments.get(x).getName() == n){
		complete = assignments.get(x);
	    }
	}
	if (complete == null){
	    System.out.println("No such assignment exists in your Backpack.");
	}else{
	    completed.add(complete);
	    assignments.remove(completed);
	}
    }
	
	
}
