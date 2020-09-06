public class Lab02 {
    public static int countPositiveEven(int [] numbers){
        int ct = 0;
        for (int n: numbers){
        if (n > 0 & n % 2 == 0) {
            ct += 1;
        }
        }
        if (ct == 0){
            return 0;
        }
        return ct;
    }
    


    public static int getIndexOfLargest(int []array){
        
        
        if (array.length == 0){
            return -1;
        }
        int index = 0;
        int largest = array[0];
    
        for (int i=1; i<array.length; i++){
            int curr = array[i];
        if (curr > largest) {
            largest = curr;
            index = i;
        }
        }
        return index;
    }
    
    public static int[] getLast4(int []array){

        return Arrays.copyOfRange(array, array.length-4, array.length);
    }
    
    public static int countLetterFrequency(String[] words, char letter) {
        if (words.length == 0){
            return 0;
        }
        
        int f = 0;
        for (int i=0; i<words.length; i++){
            for (int j=0; j<words[i].length(); j++){
                char c = words[i].charAt(j);
                if (c == letter){
                    f += 1;
                }
            }
        }
        return f;
    }
    


    public static int[] getMultiple(int[] nums, int n) {
        
        int newArr [] = new int [nums.length];
        int ct = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] % n == 0){
                newArr[ct] = nums[i];
                ct += 1;
            }
        }
        return Arrays.copyOfRange(newArr, 0, ct);
    }
    

    public static boolean noOdds(int[] nums) {
        
        for (int i=0; i<nums.length; i++){
            if (nums[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }
    
    public static int getColumnSum(int[][] numbers, int col){
        int s = 0;
        for (int i = 0; i < numbers.length; i++){
            s += numbers[i][col];
        }
        return s;
    }

    public static int sumOver(int[][] numbers, int target){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[i].length; j++){
                if (numbers[i][j] > target){
                    sum += numbers[i][j];
                }
            }
        }
        return sum;
    }

    public static int countNonEmptyPieces(String[][] lines){
        int ct = 0;
        for (int i = 0; i < lines.length; i++){
            for (int j = 0; j < lines[i].length; j++){
                if (lines[i][j] != ""){
                    ct += 1;
                }
            }
        }
        return ct;
    }

    public static int[][] generateArray(int[] numbers){
        int arrOfArr[][] = new int [numbers.length][numbers.length];
        int ct = 0;
        for (int i=numbers.length-1; i >= 0; i--){
            
            arrOfArr[ct] = Arrays.copyOfRange(numbers, i, numbers.length);
            ct += 1;
        }
        return arrOfArr;
    }

    public static ArrayList<Integer> getMultiple(int[] numbers, int m){
        ArrayList <Integer> newArr = new ArrayList<Integer>();
        for (int i=0; i<numbers.length; i++){
            if (numbers[i] % m == 0){
                newArr.add(numbers[i]);
            }
        }
        return newArr;
    }

    public static double getAveragePositive(ArrayList<Integer> values){
        double sum = 0.00;
        double ct = 0.00;
        for (int i=0; i<values.size(); i++){
            if (values.get(i) > 0){
                sum += values.get(i);
                ct += 1;
            }
        }
        double avg = sum / ct;
        return avg;
    }

    public static void removeDuplicates(ArrayList<Integer> values){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int n: values){
            if (!newList.contains(n)){
                newList.add(n);
            }
        }
        values.clear();
        values.addAll(newList);
        // System.out.println(values);
        return;
    }

    public static void removeNegatives(ArrayList<Integer> numbers){
        for (int i = numbers.size()-1; i >= 0; i--){
            if (numbers.get(i) < 0){
                numbers.remove(i);
            }
        }
        return;
    }

    public static ArrayList<Integer> uniqueUnion(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        for (int n : list1){
            if (!arrList.contains(n)){
                arrList.add(n);
            }
        }
        for (int n : list2){
            if (!arrList.contains(n)){
                arrList.add(n);
            }
        }
        return arrList;
    }
}