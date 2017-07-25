/**
   Name: Andrew Givans
   Date: 2/22/2016
  
            Description: weddingInvitation Implementation class
     
     The purpose of this class is to ask the user for the name of the family 
   hosting the wedding. It then allows the user to create as many family 
   invitation objects as the users wishes. Once the list has been created, a
   menu is presented to the user allowing them to either rescind invitations,
   choose the food options for each family member, or exit the program.
   
**/

import javax.swing.JOptionPane;
public class weddingInvitation{
   public static void main(String [] args){
      final int MAX_NUM_INVITATIONS = 100;
      Invitation[] invitations = new Invitation[MAX_NUM_INVITATIONS];
         
      Invitation.setWeddingFamilyName (JOptionPane.showInputDialog("Please enter the name of the family hosting the wedding"));
      
      do{
         addFamily(invitations);
      }while(JOptionPane.showConfirmDialog(null,"Invite another family?")==JOptionPane.YES_OPTION);    
      
      int menuChoice = getMenuChoice();
      
      while(menuChoice != 5){
         switch(menuChoice){
            case 1: 
               rescindInvitation(invitations);
               //Invitation.getNumInvitations() = Invitation.setNumInvitations();
               break;
            
            case 2:
               recordResponse(invitations);
               break;
            
            case 3:
               printFamilyReport(invitations);
               break;
            
            case 4:
               printCatererReport();
               break;
         
         } 
         
         menuChoice = getMenuChoice();
       }
         
   JOptionPane.showMessageDialog(null, "Congratulations " + Invitation.getWeddingFamilyName() + " family!");
   
   }
   
   //Purpose: Provides a list of invited families that have not 
   //         responded and allows the user to remove a family 
   //         from the array of families.    
   //Parameters: invitations
   //Return type: void
   private static void rescindInvitation(Invitation[] invitations){
      String familyList = "Families Invited: \n\n";
      
         for (int x = 0; x < Invitation.getNumInvitations(); x++){
            familyList += x + ". " + invitations[x].getFamilyName() + "\n";
         }  
           int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Please choose a family uninvite: \n\n" + familyList));
         
         if (choice < 0 || choice > Invitation.getNumInvitations()){
           JOptionPane.showMessageDialog(null, "Please choose a number from the list");
         }
         else{
            choice++;
            invitations[choice] = invitations[choice-1];
            //Invitations.length - 1;
            //numInvitations--;   
         }
  
   //return numInvitations;
   }
   
   //Purpose: For the user to choose a family that has not confirmed 
   //         they are attending yet and fill out the food choice for 
   //         each individual family member.
   //Parameters: invitations
   //Return type: void
   private static void recordResponse(Invitation[] invitations){
      String familyList = "Families Invited: \n\n";
      
         for (int x = 0; x < Invitation.getNumInvitations(); x++){
            familyList += x + ". " + invitations[x].getFamilyName() + "\n";
         }  
           int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Please choose a family to choose food options for: \n\n" + familyList));
         
         if (choice < 0 || choice > Invitation.getNumInvitations()){
           JOptionPane.showMessageDialog(null, "Please choose a number from the list");
         }
         else{
            invitations[choice].setFamTotalChicken(Integer.parseInt(JOptionPane.showInputDialog("How many Chicken dishes does your family want?")));
            invitations[choice].setFamTotalVegetarian(Integer.parseInt(JOptionPane.showInputDialog("How many Vegetarian dishes does your family want?")));
         }
   }
   
   //Purpose: To provide a list of the families that have been invited 
   //         and based on user input, the user should choose which 
   //         family invitation details they would like to see. 
   //Parameters: invitations
   //Return type: void
   private static void printFamilyReport(Invitation[] invitations){
      String familyList = "Families Invited: \n\n";
      
         for (int x = 0; x < Invitation.getNumInvitations(); x++){
            familyList += x + ". " + invitations[x].getFamilyName() + "\n";
         }  
           int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Please choose a family for invitation details: \n\n" + familyList));
         
         if (choice < 0 || choice > Invitation.getNumInvitations()){
           JOptionPane.showMessageDialog(null, "Please choose a number from the list");
         }
         else{
           JOptionPane.showMessageDialog(null, invitations[choice].toString());
         }
   }
   
   //Purpose: To output a message informing the caterer of the name of 
   //         the family hosting the wedding, the number of people 
   //         attending, and the totals for both chicken and vegetarian dishes.
   //Parameters: 
   //Return type: void
   private static void printCatererReport(){
   
         JOptionPane.showMessageDialog(null, "     " + Invitation.getWeddingFamilyName() + " Family\n"
                                             + "\n Total attendees: " + Invitation.getAttendeeTotal()
                                             + "\n Chicken dishes total: " + Invitation.getTotalChicken() 
                                             + "\n Vegetarian dishes total:  " + Invitation.getTotalVegetarian());
   }
   
   //Purpose: To add invitation objects for each family invited 
   //         to the wedding.
   //Parameters: invitations
   //Return type: void
   private static void addFamily(Invitation[] invitations){
      int numInv = Invitation.getNumInvitations();
      if (Invitation.getNumInvitations() < invitations.length){
         invitations[numInv] = new Invitation();
         invitations[numInv].setFamilyName(JOptionPane.showInputDialog("Name of family invited: "));
         //do{
         try{
         invitations[numInv].setNumFamilyMembers(Integer.parseInt(JOptionPane.showInputDialog("Number of family members: ")));    
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Must enter an integer");
         }
         //}while(invitations[numInv].getNumFamilyMembers() = 0);
         
      }
   }
   
   //private int calculateAttendeeTotal(){
   //   Invitation.setAttendeeTotal() = Invitation.getAttendeeTotal() + invitations[numInv].getNumFamilyMembers();
   //}
    
   //Purpose: To present the user with a menu to choose from and 
   //         return the choice in order to trigger a method for 
   //         that choice from the main method.
   //Parameters: None
   //Return type: int
   private static int getMenuChoice(){
      int menuChoice;
        
        do{
        
         menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Please choose an option: "
               + "\n(1) Rescind Invitation"
               + "\n(2) Record Response"
               + "\n(3) Print Family Report"
               + "\n(4) Print Caterer Report"
               + "\n(5) Exit Program"
            ));
            
         if (menuChoice < 1 || menuChoice > 5) {
            JOptionPane.showMessageDialog(null, "Please enter an option between 1 and 5.");
         }
      
         }while(menuChoice < 1 || menuChoice > 5);
         
      return menuChoice;
   }

}