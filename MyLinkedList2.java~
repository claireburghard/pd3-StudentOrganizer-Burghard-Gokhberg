public class MyLinkedList2{
    private Node head, tail, temp, temp2;

    public MyLinkedList2(){
	head = new Node("i am a dummy");
	tail = head;
    }
    
    public void addAtStart(String d){
	Node temp = new Node(d);
	//Works no matter what (even if the list is empty)
	temp.setNext(head.getNext()); //You have to do this first
	head.setNext(temp); // You have to do this second
    }


    public void addAtEnd (String d){
	Node temp = new Node(d);
	tail.setNext(temp);
	tail = temp;
    }
    
    public String toString(){
	//Works
	String res = "{";
	temp = head.getNext();
	while (temp != null){
	    if (temp.getNext() != null){
		res += temp.getData() + ", ";
	    }
	    else{
		res += temp.getData();
	    }
	    temp = temp.getNext();
	}
	res += "}";
	return res;	       
    }
 

    public String get (int x){
	// returns the String @ location x.
	// Works
	temp = head.getNext();
	for (int pos = 0; pos < x; pos++){
	    temp = temp.getNext();
	}
	return temp.toString();
    }

    public int find (String s){
	// returns the location of the item with value s
	// or -1 if not found.
	// Works
	temp = head.getNext();
	int pos = 0;
        while (temp != null){
	    if (temp.getData().equals(s)){
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
	String res = temp2.getData();
	temp.setNext(temp2.getNext());
	return res;
    }
	
}

    
