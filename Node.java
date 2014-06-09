public class Node{
    private Assignment asmt;
    private Node next;
    
    public Node(Assignment a){
	asmt = a;
	next = null;
    }
    
    public void setAsmt(Assignment a){
	asmt = a;
    }

    public String getAsmt(){
	return asmt;
    }

    public void setNext(Node n){
	next = n;
    }

    public Node getNext(){
	return next;
    }

    public String toString(){
	return asmt.getName();
    }

    

}