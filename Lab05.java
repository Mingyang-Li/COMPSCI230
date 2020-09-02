//Q1
abstract class Animal{
    public abstract void canDo();
}
class Human extends Animal{
    Human(){}
    public void canDo(){
        System.out.println("I can walk and run");
    }
}
class Snake extends Animal{
    Snake(){}
    public void canDo(){
        System.out.println("I can crawl");
    }
}
class Dog extends Animal{
    Dog(){}
    public void canDo(){
        System.out.println("I can bark");
    }
}
class Lion extends Animal{
    Lion(){}
    public void canDo(){
        System.out.println("I can roar");
    }
}

//Q2
abstract class Enemy {
    protected String name;
    protected String color;
    protected String comesOut;

    Enemy(String EnemyName){
        this.name = EnemyName;
    }
    public String toString(){
        return String.format("%s is a Zombie in %s.", this.name, this.color);
    }
    void comesOut(){
        System.out.println("The " + this.getClass().getName() + " can come out at anytime.");
    }
    abstract void eats();
}
//Q3
class Zombie extends Enemy{
	//default init
	Zombie(String name){
		super(name);
		super.color = "green";
		super.comesOut = "at anytime";
	}
	//overloaded 1
	Zombie(String name, String color){
		super(name);
		super.color = color;
	}
	@Override
	public void eats() {
		String s = String.format("%s eats human.", super.name);
		System.out.println(s);
	}
}
//Q4
class Vampire  extends Enemy{
	//default init
	Vampire(String name){
		super(name);
		super.color = "red";
		super.comesOut = "at night";
	}
	//overloaded 1
	Vampire(String name, String color){
		super(name);
		super.color = color;
		super.comesOut = "at night";
	}
	@Override
	public void eats() {
		String s = String.format("%s drinks human blood.", super.name);
		System.out.println(s);
	}
}
//Q5
class Fighter  extends Enemy{
	//default init
	Fighter(String name){
		super(name);
		super.color = "any colour";
		super.comesOut = "after lunch";
	}
	//overloaded 1
	Fighter(String name, String color){
		super(name);
		super.color = color;
		super.comesOut = "after lunch";
	}
	@Override
	public void eats() {
		String s = String.format("%s eats food.", super.name);
		System.out.println(s);
	}
}

// default interface for Q6-Q7
interface ITurnable {
    public void turn();
}
//Q6
class Book implements ITurnable{
    private int pageNumber = 1;
    public void turn(){
        this.pageNumber += 1;
        System.out.println("To page " + this.pageNumber);
    }
}
//Q7
class Coin implements ITurnable{
    private boolean isHead = false;
    public void turn(){
        this.isHead = !this.isHead;
        if (this.isHead){
            System.out.println("Head");
        } else {
            System.out.println("Tail");
        }
        
    }
}

// INTERFACE FOR Q8-Q9
interface Measurable {
    public abstract double getArea();
    public abstract double getPerimeter();
}
//Q8
class Circle  implements Measurable{
    private int radius = 1;
    //dafault init 
    Circle(){}
    //overloaded 1
    Circle(int r){
        this.radius = r;
    }
    @Override 
    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }
    @Override 
    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }
}
//Q9
class Square  implements Measurable{
    private int side = 1;
    //dafault init 
    Square(){}
    //overloaded 1
    Square(int side){
        this.side = side;
    }
    @Override 
    public double getArea(){
        return this.side * this.side;
    }
    @Override 
    public double getPerimeter(){
        return this.side * 4;
    }
}
//interfaces for Q10 - Q11
interface FoundObject { } 
interface Edible { 
    public void eat(); 
}
//Q10
class Fruit implements FoundObject, Edible{
    private String name;
    //default init
    Fruit(String name){
        this.name = name;
    } 
    public String toString(){
        return this.name;
    } 
    public void eat(){
        System.out.println("Yummy! you ate an " + this.name);
    }
}
//Q11
class Stone implements FoundObject, Edible{
    private String name;
    //default init
    Stone(String name){
        this.name = name;
    } 
    public String toString(){
        return this.name;
    } 
    public void eat(){
    }
}
//interface for Q12 - Q14
interface Taxable{
  double getTaxValue();
}
//Q12
class TaxableCar extends Car implements Taxable{
    //deafult init 
    TaxableCar(String regnum, int tons){
        super(regnum, tons);
    }
    @Override
    public double getTaxValue(){
        return super.getNumberOfSeats() * 250;
    }
}
//Q13
class TaxableTruck extends Truck implements Taxable{
    //deafult init 
    TaxableTruck(String regnum, int tons){
        super(regnum, tons);
    }
    @Override
    public double getTaxValue(){
        return super.getTons() * 550;
    }
}
//Q14
class TaxableHouse extends House implements Taxable{
    //deafult init 
    TaxableHouse(String location, double value, double area){
        super(location, value, area);
    }
    @Override
    public double getTaxValue(){
        return super.estimatedValue / 100 * super.getArea() / 100;
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



