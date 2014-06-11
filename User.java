import java.io.*;
import java.util.*;

public class User{
    private static String username = "";
    private static Scanner sc = new Scanner(System.in);
    
    public static void welcome(){
	
	if (username.equals("")){
	    System.out.println("Welcome to your Student Organizer! Enter a new username!");
	    username = sc.nextLine();
	    System.out.println("Hello "+ username + "!");
	}else{
	    System.out.println("Welcome back " + username);
	}
    }


    public static void main(String[] args){
	welcome();
	System.out.println("What would you like to do?");
	System.out.println("Add an assignment (add)");
	System.out.println("See your To-Do List (todo)");
	System.out.println("Change a due date (change)");
	System.out.println("Check a due date (check)");
	System.out.println("Write an essay (essay)");
	String response = sc.nextLine();
	
	
    }
}

    
