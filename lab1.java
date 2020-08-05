import java.util.Scanner;
public class Lab00String {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = input.nextLine();
		System.out.format("Welcome %s!", name);
	}
}

import java.util.Scanner;
public class Lab00String {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence:");
		String name = input.nextLine();
        String newName = "";
        char curr;
        String s;

        for (int i = 0; i < name.length(); i++){
            curr = name.charAt(i);
            if (Character.isUpperCase(curr)){
                s = Character.toString(Character.toLowerCase(curr));
                newName = newName.concat(s);
                
            } else {
                s = Character.toString(Character.toUpperCase(curr));
                newName = newName.concat(s);
            }
        }
 		System.out.println(newName);
	}
}

import java.util.Scanner;
public class Lab00String {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String w1 = input.nextLine();

        System.out.println("Enter another word: ");
        String w2 = input.nextLine();

        if (w1.length() != w2.length()){
            System.out.format("%s and %s are not anagrams of each other.", w1, w2);
        } else {
            boolean res = true;

            char[] Array1 = w1.toLowerCase().toCharArray();
            char[] Array2 = w2.toLowerCase().toCharArray();

            Arrays.sort(Array1);
            Arrays.sort(Array2);

            res = Arrays.equals(Array1, Array2);

            if (res){
                System.out.format("%s and %s are anagrams of each other.", w1, w2);
            } else {
                System.out.format("%s and %s are not anagrams of each other.", w1, w2);
            }
        }
	}
}

import java.util.Scanner;
public class Lab01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int num = input.nextInt();
        int boxes = 0;
        double n = num;

        if (num <= 10){

            if (num < 1){
                System.out.println("Invalid number!");
            }  
            else {
                if (num == 1){
                    System.out.format("You need 1 container for %d item.", num);
                } else {
                    System.out.format("You need 1 container for %d items.", num);
                }
            }
        }

        else if (num > 10){
            boxes = num % 10 != 0 ? num / 10 + 1 : num / 10;
            System.out.format("You need %d containers for %d items.", boxes, num);
        } 
	}
}



import java.util.Scanner;
public class Lab01 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter side1 of a triangle: ");
      System.out.println("Enter side2 of a triangle: ");
      System.out.println("Enter side3 of a triangle: ");

      double side1 = input.nextDouble();
      double side2 = input.nextDouble();
      double side3 = input.nextDouble();

      if (
          (side1 + side2) > side3 &&
          (side2 + side3) > side1 &&
          (side1 + side3) > side2
      ){
          System.out.println("Valid Triangle!");
      } else {
          System.out.println("Invalid Triangle!");
      }
   }
}