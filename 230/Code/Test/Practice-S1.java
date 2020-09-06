//Q1
public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a radius: ");
        String radius = input.nextLine();
        System.out.println("Enter a height: ");
        String height = input.nextLine();
        int r = Integer.parseInt(radius);		
        int h = Integer.parseInt(height);	
        int volumn = (int) Math.ceil(Math.PI * r * r * h/3);
    
        String myStr = String.format("Volume of cone is %d cubic cm.", volumn);
        System.out.println(myStr);
    }
}
//Q2
public class Q2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a sentence: ");
		String s = input.nextLine();
		String vowels = "aeiou";
		int ct = 0;
		for (int i=0; i<s.length(); i++) {
			if (vowels.indexOf(s.charAt(i)) != -1) {
				ct += 1;
			}
		}
		
		System.out.println("The number of vowel letters is " + ct + ".");
		
	}
}
//Q3
public class Q3 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = input.nextInt();
//		System.out.println(s);
//		System.out.println(n+2);
		float seriesSum = (float) 0.00;
		
		for (float i=1; i<=n; i++) {
			float curr = (float)i/(i+1);
			seriesSum += curr;
		}
		System.out.printf("The sum of this series is %.2f.", seriesSum);
	}
}
//Q4
import java.util.Scanner;
public class Q4 {
   public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   String rows;
		String columns;
		System.out.println("Enter number of rows: ");
		rows = input.nextLine();
		System.out.println("Enter number of columns: ");
		columns = input.nextLine();
		int r = Integer.parseInt(rows);
		int c = Integer.parseInt(columns);
		for (int i=0; i<r; i++) {
			for (int j=i+1; j<r; j++) {
				System.out.print(" ");
			}
			for (int j=0; j<c; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
   }
}
//Q5
public static int getMaxMultiple(int[] numbers, int m) {
	int largest = 0;
	for (int i=0; i<numbers.length; i++) {
		int curr = numbers[i];
		if (curr % m == 0) {
			if (curr > largest) {
				largest = curr;
			}
		}
	}
	return largest;
}
//Q6
public static int [] getZip(int[] array1, int[] array2) {
	int [] toReturn = new int [array1.length + array2.length];
	int index = 0;
    for (int i = 0; i < array1.length || i < array2.length; i++) {
        if (i < array1.length) {
        	toReturn[index++] = array1[i];
        }
        if (i < array2.length) {
        	toReturn[index++] = array2[i];
        }
    }
	return toReturn;
}
//Q7
public static ArrayList<String> createLongWordsArrayList(String[] words, int m){
	 ArrayList<String> toReturn = new ArrayList<String>();
	 for (String w: words) {
		 if (w.length() > m) {
			 toReturn.add(w);
		 }
	 }
	 return toReturn;
}
//Q8
class Rugby {
	private String countryName;
	private int points;

	Rugby(){
		this.countryName = "N/A";
		this.points = 0;
	}
	//overloaded 1
	Rugby (String countryName, int points){
		this.countryName = countryName;
		this.points = points;
	}
	//overloaded 2
	Rugby (String countryName){
		this.countryName = countryName;
		this.points = 0;
	}
	String getCountryName() {
		return this.countryName;
	}
	int getPoints() {
		return this.points;
	}
	void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	void setPoints(int p) {
		if (p>=0) {
			this.points = p;
		}
	}
	public String toString() {
		return String.format("Country: %s(%d)", this.countryName, this.points);
	}
}
//Q9
class Rugby implements Comparable<Rugby>{
	private String countryName;
	private int points;

	Rugby(){
		this.countryName = "N/A";
		this.points = 0;
	}
	//overloaded 1
	Rugby (String countryName, int points){
		this.countryName = countryName;
		this.points = points;
	}
	//overloaded 2
	Rugby (String countryName){
		this.countryName = countryName;
		this.points = 0;
	}
	String getCountryName() {
		return this.countryName;
	}
	int getPoints() {
		return this.points;
	}
	void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	void setPoints(int p) {
		if (p>=0) {
			this.points = p;
		}
	}
	public String toString() {
		return String.format("Country: %s(%d)", this.countryName, this.points);
	}
	public int compareTo(Rugby o){
		if (this.points != o.points) {
			return this.points - o.points;
		}
		return this.countryName.toLowerCase().compareTo(o.getCountryName().toLowerCase());
	}
}





