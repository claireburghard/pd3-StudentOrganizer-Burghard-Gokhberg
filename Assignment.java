import java.util.*;
import java.io.*;

public class Assignment{
    private boolean isCompleted;
    private DueDate due;

    public Assignment(DueDate d){
	due = d;
	isCompleted = false;
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
