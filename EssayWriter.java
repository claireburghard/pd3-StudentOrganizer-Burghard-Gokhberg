import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;

public class EssayWriter{

    public EssayWriter(){
    
    }

    public static void main( String[] args ){
	Scanner sc = new Scanner(System.in);
	EssayWriter E = new EssayWriter();
	
	System.out.println("What would you like to do?");
	System.out.println("Create a new file(1)");
	System.out.println("Work on an existing file(2)");
	String r1 = sc.nextLine();

	if (r1.equals("1")){
	    System.out.println("Would you like to simply create a new file(1)");
	    System.out.println("or would you like to work on it after creating it(2)?");
	    String r2 = sc.nextLine();
	    
	    System.out.println("What would you like to name your file? (include '.txt' at the end of the name you'd like to use.");
	    String name1 = sc.nextLine();
	    try {
		
		File file = new File(name1);
		
		if (file.createNewFile()){
		    System.out.println("File is created!");
		}else{
		    System.out.println("File already exists.");
		}
		
	    } catch (IOException e) {
		e.printStackTrace();
	    }if(r2.equals("2")){
		E.open(name1);
	    }
	}else{
	    System.out.println("What is the name of the file you'd like to work on? (Include '.txt' in the end please)");
	    String name1 = sc.nextLine();
	    E.open(name1);
	}
	    
    }
		

    public static void open (File document) throws IOException {
	Desktop dt = Desktop.getDesktop();
	dt.open(document);
    }
}
