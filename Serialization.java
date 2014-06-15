import java.io.*;
import java.util.*;

public class Serialization implements Serializable{
    
    private int data = 123456;
    private String name = "Claire";
    private ArrayList<Integer> numbers = new ArrayList<Integer>();

    public Serialization(int i){
	numbers.add(i);
	numbers.add(i*2);
	numbers.add(i+5);
    }
    
    public int getData(){
	return data;
    }

    public String getName(){
	return name;
    }

    public String numberString(){
	String answer = "";
	for (int i=0; i<numbers.size(); i++){
	    answer = answer + numbers.get(i);
	}
	return answer;
    }

    public static void main(String args[]){

	try{
	Serialization s = new Serialization(10);
	// Write to disk with FileOutputStream
	FileOutputStream f_out = new FileOutputStream("myobject.data");
	// Write object with ObjectOutputStream
	ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
	// Write object out to disk
	obj_out.writeObject(s); 
	}catch (Exception e){}

	try{
	    // Read from disk using FileInputStream
	    FileInputStream f_in = new FileInputStream("myobject.data");
	    
	    // Read object using ObjectInputStream
	    ObjectInputStream obj_in = new ObjectInputStream (f_in);
	    
	    // Read an object
	    Object obj = obj_in.readObject();
	    
	    if (obj instanceof Serialization)
		{
		    // Cast object to a "Serialization
		    Serialization s = (Serialization) obj;
		    System.out.println(s.getData());
		    System.out.println(s.getName());
		    System.out.println(s.numberString());
		}
	}catch (Exception e){}
    }
}
    
    
