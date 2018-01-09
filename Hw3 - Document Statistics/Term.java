/*
 CSE 17
 JohnDerek Daniels
 Jrd319
 Homework #3     DEADLINE: September 30 2016
 Program Description: Document Statistics
*/ 

class Term {
  
  private String token;
  private int frequency;
  
  public Term (String t, int freq){
    token = t;
    frequency = freq;
  }
  
  public Term (String t){
    token = t;
    frequency = 1;
  }
  
  public String getToken (){
    return token;
  }
  
  public int getFreq () {
    return frequency;
  }
  
  public void addToFrequency (int i){
    frequency += i;
  }
  
  public int getLetterCount (String a) {
    int totalCount;
    int counter = 0;
    for(int i = 0; i < token.length(); i++){
      if(String.valueOf(token.charAt(i)).equals(a)){
        counter++;
      }
    }
    totalCount = counter * frequency;
    return totalCount;
  }
  
}
