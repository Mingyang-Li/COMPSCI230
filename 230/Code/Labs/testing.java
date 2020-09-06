import java.awt.Point;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Stone s = new Stone("Stone");
        System.out.println(s);
	}
}

//interface for q15
interface Comparable<Rugby> {
  int compareTo(Rugby o)
}
//Q15
import java.util.*;
class Rugby implements Comparable<Rugby>{
    private String countryName = "N/A";
    private int points=0;
    public Rugby(String name, int pts) {
        this.countryName = name;
        this.points = pts;
    }
    public Rugby(String name) { this(name, 0); }
    public Rugby() {}
    public String getCountryName() { return countryName; }
    public int getPoints() {return points; }
    public void setCountryName(String name) { countryName = name; }
    public void setPoints(int p) {if (p>0) points = p; }
    public String toString() { return String.format("Country: %s(%d)", countryName, points); }
    @Override
    public int compareTo(Rugby o){
        if (this.points != o.points){
            return this.points - o.points;
        } else {
            return this.countryName.toLowerCase().compareTo(o.getCountryName().toLowerCase());
        }
    }
}




