import java.io.*;
import java.util.*;

public class ToDoList{
    private Node head = new Node();
    private Node tail = new Node();
    private Node temp = new Node();
    private Node temp2 = new Node();

    public ToDoList(){
	Assignment h = new Assignment();
	head = new Node(h);
	tail = head;
    }

    //We only need to add to the end. #FIFOislife-o
    public void add(Assignment a){
	temp = new Node(a);
	tail.setNext(temp);
	tail = temp;
    }

    public String toString(){
	String answer = "";
	temp = head.getNext();
	while (temp!=null){
	    answer += temp.getAsmt() + "\n";
	    temp = temp.getNext();
	}
	return answer;
    }

    public String get (int n){
	// returns the name of the Assignment that is nth on the To-Do list. 
	// Works
	temp = head.getNext();
	for (int pos = 0; pos <n; pos++){
	    temp = temp.getNext();
	}
	return temp.toString();
    }

    public int find (String n){
	// returns the location of the Assignment with name n
	// or -1 if not found.
	// Works
	temp = head.getNext();
	int pos = 0;
        while (temp != null){
	    if (temp.getAsmt().equals(n)){
		return pos;
	    }else{
		pos++;
		temp = temp.getNext();
	    }
	}
	return -1;
    }
    
    public int length(){
	//Works
	int counter = 0;
	temp = head.getNext();
	while (temp != null){
	    counter++;
	    temp = temp.getNext();
	}
	return counter;
    }
 

    public void setRight(Assignment a){
	//inserts Assignment a in its correct spot based on due date
	DueDate d = new DueDate();
	d = a.getDueDate();
	int total = d.totalMinutes();
	temp = head.getNext();
        boolean done = false;
	while (done != true){
	    int t = temp.getAsmt().getDueDate().totalMinutes();
	    if (t <= total){
		temp = temp.getNext();
	    }
	    else{
		temp2 = temp.getNext();
		Node z = new Node(a);
		temp.setNext(z);
		temp.getNext().setNext(temp2);
	        done = true;
	    }
	}
	    
    }


    public Assignment remove (int x){
	//remove and return the String at x
	int pos = 0;
	temp = head.getNext();
	temp2 = temp.getNext();
	while (pos < x - 1){
	    temp = temp.getNext();
	    temp2 = temp2.getNext();
	    pos++;
	}
	Assignment res = temp2.getAsmt();
	temp.setNext(temp2.getNext());
	return res;
    }
	
}

    
