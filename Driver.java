import java.io.*;
import java.util.*;

public class Driver {

    public static void main (String[] args){

	Backpack b = new Backpack();
	Assignment a1,a2,a3,a4,a5;
	DueDate d1,d2,d3,d4,d5;
	d1 = new DueDate(2014,6,10,3,30);
	d2 = new DueDate(2014,6,11,3,30);
	d3 = new DueDate(2014,6,12,3,30);
	d4 = new DueDate(2014,6,13,3,30);
	d5 = new DueDate(2014,6,14,3,30);
	a1 = new Assignment("Bio-hw",d1);
	a2 = new Assignment("History-hw",d2);
	a3 = new Assignment("English-hw",d3);
	a4 = new Assignment("Math-hw",d4);
	a5 = new Assignment("Compsci-hw",d5);
	b.addAssignment(a1);
	b.addAssignment(a2);
	b.addAssignment(a3);
	b.addAssignment(a4);
	b.addAssignment(a5);
	b.getTDL().add(a1);
	b.getTDL().add(a4);
	b.getTDL().add(a2);
    }
}

	
