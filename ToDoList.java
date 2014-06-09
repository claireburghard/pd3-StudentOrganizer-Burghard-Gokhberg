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
    
    /* public void addAtStart(String d){
	Node temp = new Node(d);
	//Works no matter what (even if the list is empty)
	temp.setNext(head.getNext()); //You have to do this first
	head.setNext(temp); // You have to do this second
    }
    */

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
 
    /*   
    public void add(int x, String s){
	//add s at a location x
	int pos = 0;
	temp = head;
	temp2 = temp.getNext();
	while (pos < x-1){
	    temp = temp.getNext();
	    temp2 = temp2.getNext();
	    pos++;
	}
	Node nuevo = new Node(s);
	nuevo.setNext(temp2);
	temp.setNext(nuevo);
    }
    

    public String set(int x, String s){
	//sets location x to String s
	//Works
	temp = head.getNext();
	int pos = 0;
	String res = "";
	while (temp != null){
	    if (pos == x){
		res = temp.getData();
		temp.setData(s);
		return res;
	    }else{
		temp = temp.getNext();
		pos++;
	    }
	}
	return "";
    }

    */

    public void setRight(Assignment a){
	//inserts Assignment a in its correct spot based on due date
	DueDate d = new DueDate(a.getDueDate());
	int total = d.totalMinutes();
	temp = head.getNext();
        boolean done = false;
	while (done != true){
	    int t = temp.getDueDate().totalMinutes();
	    if (t <= total){
		temp = temp.getNext();
	    }
	    else{
		temp2 = temp.getNext();
		temp.setNext(a);
		temp.getNext().setNext(temp2);
		boolean done = true;
	    }
	}
	    
    }


    public String remove (int x){
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

    
