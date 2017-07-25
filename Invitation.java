/**
   Name: Andrew Givans
   Date: 2/22/2016
  
                     Description: Invitation DDC
                     
      The purpose of this class is to contain the instance variables 
    with their mutators and accessors as well as a default constructor 
    to create each instance of an invitation object. It also contains 
    validators for the instance variables.  
      
**/

public class Invitation{
   private static String weddingFamilyName;
   private static int numInvitations = 0;
   private static int attendeeTotal = 0;
   private static int totalChicken = 0;
   private static int totalVegetarian = 0;
   public static final int MAX_ATTENDEES = 250;
   
   private String familyName;
   private int numFamilyMembers;
   private int famTotalChicken;
   private int famTotalVegetarian;
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: weddingFamilyName
   //Return type: void
   public static void setWeddingFamilyName(String weddingFamilyName){
      Invitation.weddingFamilyName = weddingFamilyName;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: String
   public static String getWeddingFamilyName(){
      return weddingFamilyName;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public static int getAttendeeTotal(){
      return attendeeTotal;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public static int getTotalChicken(){
      return totalChicken;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public static int getTotalVegetarian(){
      return totalVegetarian;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public static int getNumInvitations(){
      return numInvitations;
   }

   //Purpose: The purpose of this default constructor is to create 
   //         a default Invitation object
   //Parameters: None
   //Return type: None
   public Invitation() {
   famTotalChicken = 0;
   famTotalVegetarian = 0;
   numInvitations++;
   }
   
   //Purpose: The purpose of this specific constructor is to create
   //         an Invitiaion object with a family name and the number of
   //          family members
   //Parameters: familyname, numFamilyMembers
   //Return type: None
   public Invitation(String familyName, int numFamilyMembers){
      this();
      this.familyName = familyName;
      this.numFamilyMembers = numFamilyMembers;
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: familyName
   //Return type: void
   public void setFamilyName(String familyName){
      this.familyName = familyName;
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: numFamilyMembers
   //Return type: void
   public void setNumFamilyMembers(int numFamilyMembers){
      this.numFamilyMembers = numFamilyMembers;
      Invitation.attendeeTotal += numFamilyMembers;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public int getNumFamilyMembers(){
      return this.numFamilyMembers;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: String
   public String getFamilyName(){
      return this.familyName;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int   
   public int getFamTotalChicken(){
      return this.famTotalChicken;
   }
   
   public void setFamTotalChicken(int famTotalChicken){
      this.famTotalChicken = famTotalChicken;
      Invitation.totalChicken += famTotalChicken;
   }  
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public int getFamTotalVegetarian(){
      return this.famTotalVegetarian;
   }
   
   public void setFamTotalVegetarian(int famTotalVegetarian){
      this.famTotalVegetarian = famTotalVegetarian;
      Invitation.totalVegetarian += famTotalVegetarian;
   }  

   //Purpose: The purpose of this method is to provide a String output for Invitation objects
   //Parameters: None
   //Return type: String   
   public String toString(){
       String output = "Family Name: " + this.familyName + "\n"
       + "Responded to invitation? " + responded() + "\n"
       + "Number of family members: " + this.numFamilyMembers + "\n"
       + "Chicken dishes total: " + this.famTotalChicken + "\n"
       + "Vegetarian dishes total:  " + this.famTotalVegetarian;
       
       return output;
   }

   //Purpose: The purpose of this special purpose method is to 
   //         determine if a family has responded to an invitation or not
   //Parameters: None
   //Return type: String   
   public String responded(){
      String response = "";
         if (this.famTotalChicken != 0 && this.famTotalVegetarian != 0){
            response = "Yes";
         }
         else{
            response = "No";
         }
   
   return response;
   }

}