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

import java.util.Scanner;
public class Lab01 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the day (1-7):");
      System.out.println("Enter the time (0000-2359):");
      System.out.println("Enter the number of tickets:");
      

      String dayStr = input.nextLine();
      String timeStr = input.nextLine();
      String numStr = input.nextLine();
      int cost = 0;

      int day = Integer.parseInt(dayStr);
      int time = Integer.parseInt(timeStr);
      int num = Integer.parseInt(numStr);
      
      // monday 
      if (day == 1){
          if (time < 1700){
              cost = 11;
          } else {
              cost = 15;
          }
      }

      //tues 
      if (day == 2){
          if (time < 1700){
              cost = 8;
          } else {
              cost = 9;
          }
      }

      //wed - fri 
      else if (3 <= day & day <= 5){
          if (time < 1700){
              cost = 12;
          } else {
              cost = 13;
          }
      }

      //weekend 
      else if (6 <= day & day <= 7){
          if (time < 1700){
              cost = 15;
          } else {
              cost = 17;
          }
      }


      System.out.format("Total cost is: $" + cost * num + ".0");
   }
}

import java.util.Scanner;
public class Lab01 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the year");

      int year = input.nextInt();

      if (year % 400 == 0) {
          System.out.format("%d is a leap year.", year);
      }


      //not leap 
      else if ( year % 100 == 0){
          System.out.format("%d is not a leap year.", year);
      }


      else{
        //is leap 
            if (year % 4 == 0){
                System.out.format("%d is a leap year.", year);
            }
            else {
                System.out.format("%d is not a leap year.", year);
            }
      }
   }
}

import java.util.Scanner;
public class Lab01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter the start number:");
        System.out.println("Enter the end number:");
        
        int startNum  = input.nextInt();
        int endNum = input.nextInt();
        int ct = 0;
        
        for (int i = startNum; i < endNum + 1; i++){ 
            if (ct == 10){
                System.out.print("\n"); 
                ct = 0;
            }
            
            if (i % 7 != 0 && i % 5 == 0){
                System.out.print(i + " ");  
                ct += 1;
            } 
            
        }     
	}
}

import java.util.Scanner;
public class Lab01 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the first 9 International Standard Book Number: ");
      String num  = input.nextLine();

      int ans = 0;
      char [] charArr = num.toCharArray();

      for (int i = 0; i < num.length(); i++){ 
          int j = Integer.parseInt(String.valueOf(charArr[i]));
          ans += j * (i+1);
      }

      if (ans % 11 != 10){
          int new1 = ans % 11;
          String answer = "" + new1;
          String t = num + answer;
          System.out.print("The ISBN-10 number is " + t);
      } else {
          String t = num + "X";
          System.out.print("The ISBN-10 number is " + t);
      }
    
      
   }
}

import java.util.Scanner;
import java.lang.Object;

public class Lab01Scramble {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter a word:");
        System.out.println("Enter an integer:");

        String word  = input.nextLine();
        int num  = input.nextInt();
        
        Random rd = new Random();
        rd.setSeed(num);
        String res = "";
        StringBuilder temp = new StringBuilder(word);
        
        for (int i=0; i < word.length(); i++){
            //get random n
            int r = rd.nextInt(temp.length());
            
            //take char 
            char c = temp.charAt(r);
            // System.out.println("the sliced str now is " + c);
            
            //put into res
            res += c;
            
            // remove original letter
            temp.deleteCharAt(r);
        }
        
        System.out.println("The new word is " + res + ".");
        
	}
}

import java.util.Scanner;
public class Lab00 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int num  = input.nextInt();
        while (num != -999){
            System.out.format("The square of %d is %d. \n", num, num * num);
            System.out.println("Enter a number:");
            num  = input.nextInt();
        }
	}
}

import java.util.Scanner;
public class Lab01Print {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = input.nextInt();

        for (int i = n; i > 0; i--){
            for (int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }


	}
}











