import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class EssayWriter{ 
   
    public static void open(File document) throws IOException {
	Desktop dt = Desktop.getDesktop();
	dt.open(document);
    }

    public static void main (String args[]){
	try{
	    EssayWriter e = new EssayWriter();
	    File f = new File("backpacktemplate.txt");
	    e.open(f);
	}catch (Exception e){}
    }
}
