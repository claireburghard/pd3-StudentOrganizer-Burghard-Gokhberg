import java.util.*;
import java.io.*;

public class Assignment{  
    private boolean isCompleted; 
    private DueDate due; 
    private String name; //keep in mind, the name is a path. So it has to be "biology_homework.txt" or "compsci_project.java" 

    public Assignment(){
	isCompleted = false;
    }

    public Assignment(String n, DueDate d){
	name = n;
	due = d;
	isCompleted = false;
    }

    public String getName(){
	return name;
    }

    public void setName(String s){
	name = s;
    }

    public boolean isCompleted(){
	return isCompleted;
    }

    public DueDate getDueDate(){
	return due;
    }

    public void changeDueDate(DueDate n){
	due = n;
    }
}
