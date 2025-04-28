import java.util.*;
import java.io.*;
public class Policy{
   static Scanner scan = new Scanner(System.in);
   static ArrayList<PolicyHolder> policies = new ArrayList<PolicyHolder>();
   public static void main(String[] args){
      try 
      {
         File file = new File("Policy.txt");
        
         Scanner inputFile = new Scanner(file);
         int p = 0;
         while(inputFile.hasNext())       
         { 
            policies.add(new PolicyHolder());
            policies.get(p).number = Integer.parseInt(inputFile.nextLine());
            policies.get(p).provider = inputFile.nextLine();
            policies.get(p).firstName = inputFile.nextLine();
            policies.get(p).lastName = inputFile.nextLine();
            policies.get(p).age = Integer.parseInt(inputFile.nextLine());
            policies.get(p).smokingStatus = inputFile.nextLine();
            if(policies.get(p).smokingStatus == "smoker") policies.get(p).smokers++;
            else policies.get(p).nonsmokers++;
            policies.get(p).height = Float.parseFloat(inputFile.nextLine());
            policies.get(p).weight = Float.parseFloat(inputFile.nextLine());
            if(inputFile.hasNext())
            { 
               inputFile.nextLine();
            }
            p++;
         }
         inputFile.close();


         for (int i = 0; i < policies.size(); i++)
         {
            prntl("Policy Number: " + policies.get(i).number);
            prntl("Provider Name: " + policies.get(i).provider);
            prntl("Policyholder's First Name: " + policies.get(i).firstName);
            prntl("Policyholder's Last Name: " + policies.get(i).lastName);
            prntl("Policyholder's Age: " + policies.get(i).age);
            prntl("Policyholder's Smoking Status: " + policies.get(i).smokingStatus);
            prntl("Policyholder's Height: " + policies.get(i).height);
            prntl("Policyholder's Weight: " + policies.get(i).weight);
            prntl("Policyholder's BMI:" + policies.get(i).BMI());
            prntl("Policy Price: $" + policies.get(i).Price());
            prntl("");
         }
      }
      catch(IOException ex)
      {
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }
      
      prntl("The number of policies with a smoker is: " + policies.get(0).smokers);
      prntl("The number of policies with a non-smoker is: " + policies.get(0).nonsmokers);
      
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