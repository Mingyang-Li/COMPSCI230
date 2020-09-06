public static boolean isEmbedded(String needle, String haystack) {
    String copyOfH = haystack;
    for (int i=0; i<needle.length(); i++){
        char c = needle.charAt(i);
        String s = Character.toString(c);
        if (copyOfH.contains(s) == false){
            return false;
        } else {
            copyOfH = copyOfH.substring(i+1);
        }
    }
    return true;
}


public static boolean isEmbedded(String needle,String haystack){
    if(needle==null){
        return true;
    }
    if(needle!=null && haystack==null){
        return false; 
    }
    int j=0;
    for(int i=0; i<haystack.length(); i++){
        if(needle.charAt(j) == haystack.charAt(i)){
            j++;
        }
    }
    if(needle.length() == j){
        return true;
    }
    return false;  
}



class Gingle {
    private String name;
    private int numberOfLegs;
    private double weight;
    //dafault init
    Gingle(String name){
        this.name = name;
        this.numberOfLegs = 1;
        this.weight = 0;
    }
    //overloaded 1
    Gingle(String name, int numberOfLegs, double weight){
        this.name = name;
        this.numberOfLegs = numberOfLegs;
        this.weight = weight;
    }
    public String toString(){
        return String.format("Name is %s. It has %d number of legs and weight is %.2f.", this.name, this.numberOfLegs, this.weight);
    }
    //accessors 
    String getName(){
        return this.name;
    }
    int getNumberOfLegs(){
        return this.numberOfLegs;
    }
    double getWeight(){
        return this.weight;
    }
    //mutators 
    void setName(String name){
        this.name = name;
    }
    void setNumberOfLegs(int numberOfLegs){
        if (numberOfLegs > 0){
            this.numberOfLegs = numberOfLegs;
        }
    }
    void setWeight(double weight){
        if (weight > 0){
            this.weight = weight;
        }
    }
    boolean canRun(){
        return this.numberOfLegs > 2;
    }
}




class WindSpeed {
   private ArrayList<String> data;
   public WindSpeed(String s) {
       splitValues(s);
   }
   public void splitValues(String line) {
       data = new ArrayList<String>();
       for(String s : line.split(",")) {
           data.add(s);
       }
   }
   public ArrayList<String> getWindSpeedValues(){
       return data;
   }
   public void addWindSpeedValues(String line) {

   }
   public int getAverageWindSpeed() {
       int overallSpeed = 0;
       for (int i=0; i<this.data.size(); i++){
           int n = Integer.parseInt(this.data.get(i));
           overallSpeed += m;
       } 
       return Math.round(overallSpeed / this.data.size());
   }
   public String getDescription(){
       String tier = "";
       int avg = this.getAverageWindSpeed();
       if (avg <= 2){
           tier = "Light Air";
       }
       else if (avg >= 3 && avg <= 5){
           tier = "Light breeze";
       }
       else if (avg >= 6 && avg <= 9){
           tier = "Gentle breeze";
       }
       else if (avg >= 10 && avg <= 14){
           tier = "Moderate breeze";
       }
       else if (avg >= 15 && avg <= 19){
           tier = "Fresh breeze";
       }
       else if (avg <= 20){
           tier = "Strong breeze";
       }
       return tier;
   }
   public String toString{
       return String.format("The average wind speed is %dkm/h (%s)", this.getAverageWindSpeed(), this.getDescription());
   }
}
import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter number of yards: ");
        int yard = input.nextInt();
        System.out.println("Enter number of feet: ");
        int feet = input.nextInt();

        feet = feet + (yard * 3);
        double m = 0.3048 * feet;
        System.out.println("Metres: " + Math.round(m));
   } 
} 

class Movie {
    private int movie_id;
    private String title;
    private int yearOfRelease;
    private int lengthOfMovie;
    private String rating;
    protected double pricePerDay;
    public static int count = 101;
    Movie(String title, int yearOfRelease, int lengthOfMovie, String rating){
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.lengthOfMovie = lengthOfMovie;
        this.rating = rating;
        this.pricePerDay = 5.00;
        this.movie_id = this.count;
        this.count ++;
    }
    int getMovieId(){
        return this.movie_id;
    }
    public String toString(){
        return String.format("%s(%d,R), daily rental charges:$%.2f", this.title, this.yearOfRelease, this.pricePerDay);
    }
}