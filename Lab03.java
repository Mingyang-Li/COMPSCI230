class Pig{

    private int height;
    // no args constructor
    Pig() {
        height = 1;
    }
    
    Pig(int customHeight) {
        height = customHeight;
    }
     
    public String toString() {
        return String.format("I am a Pig. My height is %d", height);
    }

    public int getHeight() {
        return this.height;
    }
        
    public void setHeight(int height) {
        if (height >= 0){
            this.height = height;
        }
    }
        
    public void speak() {
        System.out.println("Oink");
    }  
}


class Rugby{

    private String countryName ;
    private int points;

    // no args constructor
    Rugby() {
        countryName = "N/A";
        points = 0;
    }
    
    //overloaded init with 2 values
    Rugby(String newCountryName,int newPoints) {
        this.points = newPoints;
        this.countryName = newCountryName;
    }

    // overloaded init with 1 value
    Rugby(String newCountryName) {
        this.countryName = newCountryName;
    }

    public int getPoints() {
        return this.points;
    }
        
    public void setPoints(int newPoints) {
        if (newPoints >= 0){
            this.points += newPoints;
        }
    }
        
    public String getCountryName() {
        return this.countryName;
    }
        
    public void setCountryName(String newCountryName) {
        this.countryName = newCountryName;
    }

    public String toString() {
        return String.format("Country: %s(%d)", this.countryName, this.points);
    }
}

class QuadraticEquation {

    private double coeff_a;
    private double coeff_b;
    private double coeff_c;

    // default constructor
    QuadraticEquation() {
        coeff_a = 0;
        coeff_b = 0;
        coeff_c = 0;
    }
    
    //overloaded init with 3 values
    QuadraticEquation(double co_a, double co_b, double co_c) {
        this.coeff_a = co_a;
        this.coeff_b = co_b;
        this.coeff_c = co_c;
    }

    //accessor  for 3 coefficients
    public double getCoeff_a() {
        return this.coeff_a;
    }
    public double getCoeff_b() {
        return this.coeff_b;
    }
    public double getCoeff_c() {
        return this.coeff_c;
    }

    // mutators  
    public void setCoeff_a(double newData) {
        this.coeff_a = newData;
    }
    public void setCoeff_b(double newData) {
        this.coeff_b = newData;
    }
    public void setCoeff_c(double newData) {
        this.coeff_c = newData;
    }

    //get discriminant 
    public double getDiscriminant(){
        return (this.getCoeff_b() * this.getCoeff_b()) - 4 * this.getCoeff_a() * this.getCoeff_c();
    }

    //root 1
    public double getRoot1(){
        return (-this.getCoeff_b() + Math.sqrt(this.getDiscriminant())) / (2 * this.getCoeff_a());
    }

    //root 2
    public double getRoot2(){
        return (-this.getCoeff_b() - Math.sqrt(this.getDiscriminant())) / (2 * this.getCoeff_a());
    }

    //check if solution exists
    public boolean hasSolution(){
        if (this.getDiscriminant() >= 0){
            return true;
        } else {
            return false;
        }
    }

    //string method 
    public String toString(){
        if (this.hasSolution() == false){
            return "No real solutions.";
        } else {
            return String.format("root1=%.2f, root2=%.2f", this.getRoot1(), this.getRoot2());
        }
    }
}

class Traffic  {

    private String location;
    private int numberOfCars;

    // default constructor
    Traffic() {
        location = null;
        numberOfCars = 0;
    }
    
    //overloaded init
    Traffic(String location) {
        this.location = location;
    }

    //accessor  for location
    public String getLocation() {
        return this.location;
    }
    //accessor  for num of cars
    public int getNumberOfCars() {
        return this.numberOfCars;
    }
    
    // mutator for location 
    public void setLocation(String newData) {
        this.location = newData;
    }
    // mutator for num of cars 
    public void setNumberOfCars(int newData) {
        this.numberOfCars = newData;
    }

    public String toString(){
        return String.format("There are %d cars in %s.", this.numberOfCars, this.location);
    }

    public boolean isTrafficJam(){
        if (this.numberOfCars > 100){
            return true;
        } else {
            return false;
        }
    }
}

class Room  {
    private int secretCode;
    private int roomIndex;
    public static int nextIndex = 1;

    // default constructor
    Room(int inputCode) {
        this.secretCode = inputCode;
        this.roomIndex += this.nextIndex;
        nextIndex += 1;
    }

    public int getRoomIndex(){
        return this.roomIndex;
    }

    public String toString(){
        String roomNum = Integer.toString(this.roomIndex);
        return "Room:00" + roomNum;
    }

    public boolean openDoor(int code){
        if (code == this.secretCode){
            return true;
        } else {
            return false;
        }
    }
}

class Security  {
    private ArrayList<Integer> usedCode = new ArrayList<>();
    private Random randObj;
    public static int MAX_CODE = 999;
    // default constructor
    Security(){
        randObj = new Random();
        randObj.setSeed(30);
    }
    public int getNextCode(){
        
        int r = randObj.nextInt(this.MAX_CODE);
        this.usedCode.add(r);
        return r;
    }
    public String toString(){
        return "The max range is " + MAX_CODE + " and the current code list is: " + usedCode;
    }
    public ArrayList<Integer> getListOfUsedCode(){
        return this.usedCode;
    }
}

class Staff{
    private String name;
    private String staffID;
    private Room office;
    // default constructor
    Staff(String name, String staffID, int nextCode){
        this.name = name;
        this.staffID = staffID;
        this.office = new Room(nextCode);
    }
    
    public String toString(){
        return String.format("The occupant of Room:00%d is %s", this.office.getRoomIndex(), this.name);
    }
    
    public boolean openDoor(int code){
        return (this.office.openDoor(code));
    }
}

class ShoppingItem{
    
    private String itemDescription;
    private double price;
    private boolean byWeight;
    private int quantity;
    private double weight;

    // default constructor
    ShoppingItem(String itemDescription, double price, double weight){
        this.itemDescription = itemDescription;
        this.weight = weight;
        this.price = price;
        this.byWeight = true;
    }

    // overloaded constructor Q9
    ShoppingItem(String itemDescription, double price, int quantity){
        this.itemDescription = itemDescription;
        this.price = price;
        this.quantity = quantity;
        this.byWeight = false;
    }

    // overloaded constructor Q10
    ShoppingItem (String longDescription, double unitPrice){
        if (longDescription.contains("kg")){
            this.byWeight = true;
            int i = longDescription.indexOf("kg");
            this.itemDescription = longDescription.substring(i+3, longDescription.length());
            this.weight = Double.parseDouble(longDescription.substring(0, i));
            this.price = unitPrice * this.weight;

        } else {
            this.byWeight = false;
            int i = longDescription.indexOf(" ");
            this.itemDescription = longDescription.substring(i+1, longDescription.length());
            this.quantity = Integer.parseInt(longDescription.substring(0, i));
            this.price = unitPrice * this.quantity;
        }
    }

    public double getItemCost(){
        if (this.byWeight == true){
            return this.weight * this.price;
        } else {
            return this.quantity * this.price;
        }
    }

    // accesors
    public String getItemDescription(){
        return this.itemDescription;
    }
    public double getPrice(){
        return this.price;
    }
    public double getWeight(){
        return this.weight;
    }
    public int getQuantity(){
        return this.quantity;
    }

    // mutators
    public void setItemDescription(String itemDescription){
        if (itemDescription != ""){
            this.itemDescription = itemDescription;
        }
    }
    public void setPrice(double newData){
        if (newData >= 0){
            this.price = newData;
        }
    }
    public void setWeight(double newData){
        if (newData >= 0){
            this.weight = newData;
        }
    }
    public void setQuantity(int newData){
        if (newData >= 0){
            this.quantity = newData;
        }
    }

    public String toString(){
        if (this.byWeight == true){
            return String.format("The cost of %.2fkg of %s = $%.2f", this.weight, this.itemDescription, this.getItemCost());
        } else {
            return String.format("The cost of %d %s = $%.2f", this.quantity, this.itemDescription, this.getItemCost());
        }

        /*
        if (this.byWeight == true){
            return String.format("%s, weight = %.2f, price = $%.2f", this.itemDescription, this.weight, this.price);
        } else {
            return String.format("%s, quantity = %d, price = $%.2f", this.itemDescription, this.quantity, this.price);
        }
         */

    }
}
class ShoppingList {
    
    private String name;
    private int uniqueID;
    private ArrayList<ShoppingItem> items = new ArrayList<>();

    // default constructor
    ShoppingList(String name, int uniqueID){
        this.name = name;
        this.uniqueID = uniqueID;
    }

    public double getTotalCost(){
        double cost = 0.00;
        for (int i = 0; i < this.items.size(); i++){
            cost += this.items.get(i).getItemCost();
        }
        return cost;
    }

    public String getShoppingList(){
        // The cost of 1.50kg of Bananas = $4.35
        // The cost of 3 Tissues = $5.70
        String output = "";
        for (int i = 0; i < this.items.size(); i++){
            output += this.items.get(i) + "\n";
        }
        return output;
    }

    public void add(ShoppingItem item){
        this.items.add(item);
    }

    public String toString(){
        return String.format("The total cost of the shopping list for %s is $%.2f.", this.name, this.getTotalCost());
    }
}



















