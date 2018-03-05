import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;

public class Selections 
{
    
    static String[] members;
    static int NumberOfMembers = 0;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
  
    public static final String SEPARATION = "********";
      
    
  
    public static char getSelection()
    {
         //Turns Lowercase letters to Uppercase and characters//
         Scanner scan = new Scanner(System.in);
         String optionString = scan.nextLine();
         if (optionString.length()==0)
         {
             return ' ';
         }            
         return optionString.toUpperCase().charAt(0);
    }
  
    public static void createProject() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(SEPARATION);

        //Asks for the name of the project//
        System.out.print("\nEnter the project name: ");
        String projectName = scan.nextLine();
        //Project newProject = new Project(projectName);
     
        //Asks for the number of team members and keeps this as int "n"//
        System.out.print("Enter the number of team members: ");
      
        while (!scan.hasNextInt())
        {
            scan.next();
            System.out.print("Please enter an integer value: ");
        }
      
        int NumberOfMembers = scan.nextInt(); //Ensures you take an integer//
        //newProject.setNoTeamMembers(NumberOfMembers);
        scan.nextLine();
        
           
        
        while ( NumberOfMembers <= 1 )
        {
            System.out.print("ERROR! Please enter a value above 1: ");  
            NumberOfMembers = scan.nextInt();
            //newProject.setNoTeamMembers(NumberOfMembers);
            scan.nextLine();
        } 
       
      
        //Asks for the names of each member and stores the names in an array//
        String[] members = new String[NumberOfMembers];
        for (int i = 0; i < NumberOfMembers; i++)
        
        {
            System.out.print("\tEnter the name of team member " + (i+1) + ": ");
            members[i] = scan.nextLine();
            //newProject.setMemberName(newMember);
        }
            

        
        /*
        System.out.print("This members name is: " + ANSI_RED + newMember.getName() + ANSI_RESET + ". What score will you give them? ");
      
        int score = scan.nextInt();
        newMember.setScore(score);
      
        System.out.println("You gave " + ANSI_RED + newMember.getName() + ANSI_RESET + " a score of: " + ANSI_CYAN + newMember.getScore() + ANSI_RESET + "!" );
       
        */

        //EXTRA: sequentially print the names in a sentence//
       
      
       try
        {
            PrintWriter pr = new PrintWriter(new FileWriter("Team & Member Names.csv",true));    
            pr.print(projectName + ",");
            pr.print(NumberOfMembers + ",");
            
            //Prints all members into file//
            for (int i=0; i<NumberOfMembers ; i++)
            {
                pr.print(members[i] + ",");
            }
            pr.print("\n");
            pr.close();
        }
        //If file doesn't exist catches error//
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("No such file exists.");
            }
        scan.close(); 
        
          
        //Return back to main menu//
        Scanner scan2 = new Scanner(System.in);

        System.out.print("\nEnter any key and press enter to go back to the menu: ");
        String useless = scan2.nextLine();
        if (scan2.nextLine() != null) 
        { 
        MainMenu.printMenu();
        MainMenu.selection();
        }
      
    }
  
    public static void votes() 
    {
        line = inputStream.nextLine();
    String[] record = line.split(",");

    System.out.println("\nThere are " + project.getTheTeamSize() + " team members. ");

     PrintWriter outputStream = makeOutputStream();

    //int m = Integer.parseInt(record[1]);                  

    for (int lineCount = 2; lineCount <= project.getTheTeamSize()+1; lineCount++)                 
    {                 
      System.out.println("Enter " + record[lineCount] + "'s votes, points must add up to 100: ");                    
      outputStream.print(record[lineCount] + ",") ;                                         
      for (int initialA = 2; initialA < lineCount ; initialA++)                        

      {                        
        System.out.print("\tEnter " + record[lineCount] + "'s points for " + record[initialA] + ": ");                         
        String points = scan.nextLine();                        
        outputStream.print(record[initialA] + "," + points + ",");                   
      }

      for (int initialB = lineCount + 1 ; initialB <= project.getTheTeamSize()+1; initialB++)                   
      {          
        System.out.print("\tEnter " + record[lineCount] + "'s points for " + record[initialB] + ": ");                    
        String points = scan.nextLine();    
        outputStream.print(record[initialB] + "," + points + ",");            
      }                                  
    }
        System.out.println("Press any key followed by <Enter> to return to the main menu: ");
    }
  
    public static void showProject() 
    {
        //Returns back to the Main Menu//
        System.out.println(SEPARATION + "\n");
        MainMenu.printMenu();
        MainMenu.selection();
    }
  
    public static void quit() 
    {
        //Exit the application//
        
        System.out.println(SEPARATION + "\n\n\tThank you for using Split-it. Hope to see you soon.\n");
        System.exit(1);
    }
}
