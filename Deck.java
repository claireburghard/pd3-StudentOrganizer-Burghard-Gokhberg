import java.io.*;
import java.util.*;

public class Deck{
    private ArrayList<Flashcard> d = new ArrayList<Flashcard>();
    Scanner sc = new Scanner(System.in);

    //What constructor would we make?

    public void addCard(Flashcard f){
	//Adds card to the end of the Deck
	d.add(f);
    }

    public void reset(){
	//changes it so that all cards have not been marked as "correct"
	for (int x = 0; x < d.size(); x ++){
	    if (d.get(x).getCorrect() == true){
		d.get(x).setCorrect(false);
	    }
	}
    }

    public void test(){
	//Test allows the person to say whether or not they got the question right.
	//If they do get it right, the next time they run test, it will not test them on cards
	//that they have already gotten correct. To change this, they must reset the Deck
	System.out.println("TEST COMMENCING NOW...");
	System.out.println(".......................");
	System.out.println(".......................");
	for (int x = 0; x < d.size(); x ++){
	    if (d.get(x).getCorrect() == false){
		System.out.println(d.get(x).show());
		System.out.println("Enter any key when ready to flip.");
		String r = sc.nextLine();
		System.out.println(d.get(x).flip());
		System.out.println("Did you get this correct? (y)es or (n)o");
		String resp = sc.nextLine();
		if (resp.equals("y")){
		    d.get(x).setCorrect(true);
		}else if(!resp.equals("n")){
		    System.out.println( resp + " is not recognized.");
		}
	    }
	}
    }

    public void study(){
	//Allows the User to go through all of the cards and gives the User the option to change the 
	//fronts and backs of the cards as they wish.
	System.out.println("STUDY SESSION COMMENCED:");
	reset();
	for(int x = 0; x < d.size(); x ++){
	    System.out.println(d.get(x).show());
	    System.out.println("Would you like to change the front of this card? (y)es or (n)o. If 'no', the card will flip.");
	    String r = sc.nextLine();
	    if (r.equals("y")){
		System.out.println("What would you like to put on the front of the card?");
		String a = sc.nextLine();
		d.get(x).changeFront(a);
		System.out.println("Complete!");
	    }
	    System.out.println(d.get(x).flip());
	    System.out.println("Would you like to change the back of this card? (y)es or (n)o. If 'no', the next card in the deck will be shown.");
	    r = sc.nextLine();
	    if (r.equals("y")){
		System.out.println("What would you like to put on the back of the card?");
		//Would it be nextLine() or just next() ?
		String a = sc.nextLine();
		d.get(x).changeBack(a);
		System.out.println("Complete!");
	    }
	}
    }

    /* public static void main(String[] args){
	Deck D = new Deck();
	Flashcard A = new Flashcard("George Washington", "First President");
	Flashcard B = new Flashcard("Abraham Lincoln", "Seventeenth President");
	D.addCard(A);
	D.addCard(B);
       	D.study();
	D.study();
	D.test();
	D.test();
	D.reset();
    }
    */

}
	    
	
		
	
