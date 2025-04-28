import java.util.*;
import java.io.*;
public class PolicyHolder{
    Scanner scan = new Scanner(System.in);
    String provider;
    String firstName;
    String lastName;
    int age;
    String smokingStatus;
    float height;
    float weight;
    int number;
   
   
    static int smokers = 0;
    static int nonsmokers = 0;
    static int policyAmount = 0;
   
   public  void main(String[] args){
         
   }
   
   PolicyHolder()
   {
      policyAmount++;
      number = 0;
      provider = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0;
      weight = 0;
   }
   PolicyHolder(int number, String provider, String firstName, String lastName, int age, String smokingStatus, float height, float weight)
   {
      policyAmount++;
      this.number = number;
      this.provider = provider;
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age; 
      this.smokingStatus = smokingStatus;
      this.height = height;
      this.weight = weight;
   }
   public String Price(){
      float fixedFee = 600;
      float oldFee = age >= 50 ? 75 : 0;
      float bmi = BMI();
      float bmiFee = bmi > 35 ? (bmi-35)*20 : 0;
      float smokerFee = smokingStatus.equals("smoker") ? 100 : 0;
      float totalFee = fixedFee + oldFee + bmiFee;
      totalFee = (Math.round(totalFee * 100f) / 100f);
      String totalFeeS = Float.toString(totalFee);
      
      return totalFeeS;
   }
   float BMI()
   {
      float CONVFACTOR = 703;
      
      return (weight * CONVFACTOR) / (height * height);
   }
}