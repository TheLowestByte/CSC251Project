import java.util.Scanner;
public class Policy{
   static Scanner scan = new Scanner(System.in);
   int number;
   String provider;
   String firstName;
   String lastName;
   int age;
   String smokingStatus;
   float height;
   float weight;
   public static void main(String[] args){
      Policy policy = new Policy(askI("Policy Number"), ask("Provider Name"), ask("Policyholder's First Name"), ask("Policyholder's Last Name"), askI("Policyholder's Age"), askO("Policyholder's Smoking Status (smoker/non-smoker)", new String[]{"smoker","non-smoker"}), askF("Policyholder's Height"), askF("Policyholder's Weight"));
      prntl("Policy Number: " + policy.number);
      prntl("Provider Name: " + policy.provider);
      prntl("Policyholder's First Name: " + policy.firstName);
      prntl("Policyholder's Last Name: " + policy.lastName);
      prntl("Policyholder's Age: " + policy.age);
      prntl("Policyholder's Smoking Status: " + policy.smokingStatus);
      prntl("Policyholder's Height: " + policy.height);
      prntl("Policyholder's Weight: " + policy.weight);
      prntl("Policyholder's BMI:" + BMI(policy.weight, policy.height));
      prntl("Policy Price: $" + Price(policy.age, policy.smokingStatus == "smoker", policy.weight, policy.height));
      
      
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