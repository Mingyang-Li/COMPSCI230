public class L06Ex05{
	public static void main(String[] args) {
    int[] array = {0,0,0,0,0,0,1,2,4,2,1};
		System.out.println("Distribution");
		for (int counter=0; counter<array.length; counter++) {
			if (counter == 10){
                System.out.print("  100: ");
            } else {

                if (counter == 0){
                    System.out.print("00-09: ");
                } else {
                    System.out.printf("%d0-%d: ", counter, counter * 10 + 9); //set up the digit
                }
            }
            for (int i = 0; i < array[counter]; i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public static ArrayList<Integer> getUnique(int[] source) {
    ArrayList<Integer> uniqueList = new ArrayList<Integer>();
    for (int each: source){
        if (uniqueList.contains(each) == false){
            uniqueList.add(each);
        }
    }
    return uniqueList;
}

public static ArrayList<Integer> createArrayList(int n){
    ArrayList<Integer> arrList = new ArrayList<Integer>();
    for (int i = 1; i < n+1; i++){
        arrList.add(i * i);
    }
    return arrList;
}

class Employee {
  private String firstName;
  private String lastName;
  public static int count = 0;
 // complete this

  public Employee( String first, String last ) {
    firstName = first;
    lastName = last;
    count += 1;
  }

  //add the static method getCount
  public static int getCount(){
      return count;
  }

  public String toString() {
    return String.format("%s, %s%n", lastName, firstName);
  }
}

class MyPoint {
  private int x;
  private int y;

  public MyPoint() {
    this.x = 0;
    this.y = 0;

  }
  public MyPoint(int x, int y) {
    this.x = x;
    this.y = y;

  }

  public String toString() {
    return String.format("(%d, %d)", x, y);      
  }
}
