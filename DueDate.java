import java.util.*;
import java.io.*;

public class DueDate{
    private int month; // 1 - 12
    private int day; // 1 - 30 or 1-31 or 1-29??? WE HAVE TO FIGURE THIS OUT
    private int year;
    private int hour; // 0 - 23;
    private int min; // 0 - 59;

    public DueDate (int y, int mon, int d, int h, int min){
	year = y;
	month = mon;
	day = d;
	hour = h;
	this.min = min;
    }

    public String toString(){
	return month + "/" + day + "/" + year + ", " + hour +":" + min;
    }

    public int totalMinutes(){
	int total = 0;
	total = total + year*365*24*60;
	total = total + month*30*24*60;
	total = total + day*24*60*60;
	total = total + hour*60;
	total = total + min;
    }

}
