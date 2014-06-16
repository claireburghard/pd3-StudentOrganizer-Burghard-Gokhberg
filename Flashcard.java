import java.io.*;
import java.util.*;

public class Flashcard{
    private String front, back;
    private boolean correct;

    public Flashcard(){
	front = "";
	back = "";
	correct = false;
    }

    public Flashcard(String f, String b){
	front = f;
	back = b;
	correct = false;
    }

    public String show(){
	return front;
    }

    public String flip(){
	return back;
    }

    public void changeFront(String f){
	front = f;
    }

    public void changeBack(String b){
	back = b;
    }

    public boolean getCorrect(){
	return correct;
    }

    public void setCorrect(boolean b){
	correct = b;
    }
}

    
