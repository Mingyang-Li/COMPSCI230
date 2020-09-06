static String getSignature(String s){
//toLowerCase is to change the string s to lowe case
String strings=s.toLowerCase();
  
//arrange the letters in alphabetical order
char charArray[] = strings.toCharArray();
Arrays.sort(charArray);
String str=new String(charArray);
int[] freq = new int[str.length()];
int i, j;
String result="";

  
  
//Converts given string into character array
char string[] = str.toCharArray();
  
for(i = 0; i <str.length(); i++) {
freq[i] = 1;
for(j = i+1; j <str.length(); j++) {
if(string[i] == string[j]) {
freq[i]++;
  
//Set string[j] to 0 to avoid printing visited character
string[j] = '0';
}
}
}
  
//for get the final result string
//combine the strings and with their
// frequencies
for(i = 0; i <freq.length; i++) {
if(string[i] != ' ' && string[i] != '0')
result+=freq[i]+"" +string[i] ;
}

//return the result
return result;
}