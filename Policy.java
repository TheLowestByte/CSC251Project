import java.util.*;
import java.io.*;
public class Policy{
   static Scanner scan = new Scanner(System.in);
   static int number;
   static String provider;
   static String firstName;
   static String lastName;
   static int age;
   static String smokingStatus;
   static float height;
   static float weight;
   
   static int smokers = 0;
   static int nonsmokers = 0;
   ArrayList<Policy> policies = new ArrayList<Policy>();
   public static void main(String[] args){
      try 
      {
         File file = new File("Policy.txt");
                                    
         Scanner inputFile = new Scanner(file);
               String courseNumber = "", courseName = "", fileInput = " ";
         double contactHours = 0.0, creditHours = 0.0, totalTuitionCost = 0.0;
         while(inputFile.hasNext())       
         { 
            number = Integer.parseInt(inputFile.nextLine());
            provider = inputFile.nextLine();
            firstName = inputFile.nextLine();
            lastName = inputFile.nextLine();
            age = Integer.parseInt(inputFile.nextLine());
            smokingStatus = inputFile.nextLine();
            height = Float.parseFloat(inputFile.nextLine());
            weight = Float.parseFloat(inputFile.nextLine());
            if(inputFile.hasNext())
            { 
               inputFile.nextLine();
            }
            
            prntl("Policy Number: " + number);
            prntl("Provider Name: " + provider);
            prntl("Policyholder's First Name: " + firstName);
            prntl("Policyholder's Last Name: " + lastName);
            prntl("Policyholder's Age: " + age);
            prntl("Policyholder's Smoking Status: " + smokingStatus);
            if(smokingStatus.equals("smoker"))smokers++;
            else nonsmokers++;
            prntl("Policyholder's Height: " + height);
            prntl("Policyholder's Weight: " + weight);
            prntl("Policyholder's BMI:" + BMI(weight, height));
            prntl("Policy Price: $" + Price(age, smokingStatus == "smoker", weight, height));
            prntl("");

         }      
         inputFile.close();
               
      }
      catch(IOException ex)
      {
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }
      
      prntl("The number of policies with a smoker is: " + smokers);
      prntl("The number of policies with a non-smoker is: " + nonsmokers);
      
   }
   Policy()
   {
      number = 0;
      provider = "Unspeecified";
      firstName = "Unspecified";
      lastName = "Unspecified";
      age = 39; //average age because I didn't know what the defaults should be so they are all approximately the national averages.
      smokingStatus = "non-smoker";
      height = 67;
      weight = 185;
   }
   Policy(int number, String provider, String firstName, String lastName, int age, String smokingStatus, float height, float weight)
   {
      this.number = number;
      this.provider = provider;
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age; 
      this.smokingStatus = smokingStatus;
      this.height = height;
      this.weight = weight;
   }
   /**
   * Calculates the price of a policy.
   * @param age The age of the policy holder.
   * @param smokes Weather or not they smoke.
   * @param w how much they weigh in pounds.
   * @param h how tall they are in inches.
   * @return the cost in dollars as a string.
   */
   public static String Price(int age, boolean smokes, float w, float h){
      float fixedFee = 600;
      float oldFee = age >= 50 ? 75 : 0;
      float bmi = BMI(w,h);
      float bmiFee = bmi > 35 ? (bmi-35)*20 : 0;
      float smokerFee = smokes ? 100 : 0;
      float totalFee = fixedFee + oldFee + bmiFee;
      totalFee = (Math.round(totalFee * 100f) / 100f);
      String totalFeeS = String.valueOf(totalFee);
      for(int i = 0; i < totalFeeS.length(); i++){
         if(totalFeeS.charAt(i) == '.'){
            while(i + 2 >= totalFeeS.length())totalFeeS = totalFeeS + "0";
         }
      }
      return totalFeeS;
   }
   
   /**
   * Calculates the BMI of someone.
   * @param w how much they weigh in pounds.
   * @param h how tall they are in inches.
   * @return BMI.
   */
   public static float BMI(float w, float h){
      return w*702/(h*h);
   }
   
   
   
   //Copied IO utilities from previous work.
   public static void prnt(String s){
      System.out.print(s); //This is just to make printing things easier to type. If it impacts performance I'd appreciate if you told me in the feedback.
   }
   public static void prntl(String s){
      System.out.println(s); //This is just to make printing things easier to type. If it impacts performance I'd appreciate if you told me in the feedback.
   }
   public static String ask(String s){
      prnt("Please enter the " + s + ": ");
      s = scan.nextLine();
      return s;
   }
   public static String askO(String s, String[] options){
      String s2 = "";
      for(int i = 0; i < options.length; i++){
         s2 += "/" + options[i];
      }
      String s3;
      boolean done = false;
      while (!done){
         prnt("Please enter the " + s + ": ");
         s3 = scan.nextLine();
         for(int i = 0; i < options.length; i++){
            if(s3.equals(options[i])){
               done = true;
               return s3;
            }
         }
      }
      return "";
   }
   public static int askI(String s){
      int o = 0;
      String s2;
      boolean done = false;
      while (!done){
         prnt("Please enter the " + s + ": ");
         s2 = scan.nextLine();
         try{
            o = Integer.parseInt(s2);
            done = true;
         }catch(Exception e) {
            prntl("Please enter a whole number.");
         }

      }
      return o;
   }
   public static float askF(String s){
      float o = 0;
      String s2;
      boolean done = false;
      while (!done){
         prnt("Please enter the " + s + ": ");
         s2 = scan.nextLine();
         try{
            o = Float.valueOf(s2);
            done = true;
         }catch(Exception e) {
            prntl("Please enter a number.");
         }

      }
      return o;
   }

}