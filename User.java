import java.io.*;
import java.util.*;

public class User{
    private static String username = "";
    private static Scanner sc = new Scanner(System.in);
    private static ToDoList todo = new ToDoList();
    
    public static void welcome(){
	
	if (username.equals("")){
	    System.out.println("Welcome to your Backpack! Enter a new username!");
	    username = sc.nextLine();
	    System.out.println("Hello "+ username + "!");
	}else{
	    System.out.println("Welcome back " + username);
	}
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
	System.out.println("Adding your assignment now...");
	DueDate date = new DueDate(y, m, d, h, min);
	Assignment a = new Assignment(name, date);
	//Claire can you add the part of the code that adds this assignment to the ToDoList?
	//THANKS :D
    }

    public static void readToDo(){
	// Would this be correct?
	System.out.println(todo.toString());
    }

    public static void main(String[] args){
	welcome();
	System.out.println("What would you like to do?");
	System.out.println("Add an assignment (add)");
	System.out.println("See your To-Do List (todo)");
	System.out.println("Change a due date (change)");
	System.out.println("Check a due date (check)");
	System.out.println("Write an essay (essay)");
	System.out.println("Save the contents of My Backpack (save)");
	System.out.println("Exit My Backpack (exit)");
	String response = sc.nextLine();
	if (response.equals("add")){
		addAnAsmt();
	}else if (response.equals("todo")){
		readToDo();
	}
	
    }
    
    
    
}


    
