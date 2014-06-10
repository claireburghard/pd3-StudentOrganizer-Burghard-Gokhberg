import java.io.*;
import java.util.*;

public class User{
    private static String username = "";
    private static Scanner sc = new Scanner(System.in);
    
    public static void welcome(){
	
	if (username.equals("")){
	    System.out.println("Welcome to your Student Organizer! Enter a new username!");
	    username = sc.nextLine();
	}else{
	    System.out.println("Welcome back " + username);
	}
    }


    public static void main(String[] args){
	welcome();
    }
}

    
