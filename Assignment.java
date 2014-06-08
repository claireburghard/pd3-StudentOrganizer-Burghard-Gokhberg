import java.util.*;
import java.io.*;

public class Assignment{
    private boolean isCompleted;
    private DueDate due;
    private String name;

    public Assignment(String n, DueDate d){
	name = n;
	due = d;
	isCompleted = false;
    }

    public String getName(){
	return name;
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
