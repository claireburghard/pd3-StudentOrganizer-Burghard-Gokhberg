import java.io.*;
import java.util.*;

public class Readtest {

    public String read(String path) {
	String content = "";
	String line;
	try{
	    BufferedReader reader = new BufferedReader(new FileReader(path));
	    while ((line = reader.readLine()) != null)
		{
		    content += "\n" + line;
		}
	    content = content.substring(1);
	    reader.close();
	}catch (Exception e){}
	return content;
    }

    public static void main(String args[]){
	Readtest r = new Readtest();
	System.out.println(r.read("testing.txt"));
    }
}

