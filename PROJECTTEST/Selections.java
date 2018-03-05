import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;

public class Selections 
{
    public static final String SEPARATION = "**************************************************************";
      
    public static void main(String[] args)
    {
    }
  
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
     
        //Asks for the number of team members and keeps this as int "n"//
        System.out.print("Enter the number of team members: ");
      
        while (!scan.hasNextInt())
        {
            scan.next();
            System.out.print("Please enter an integer value: ");
        }
      
        int memberNo = scan.nextInt(); //Ensures you take an integer//
        scan.nextLine();
    
        while ( memberNo <= 1 )
        {
            System.out.print("ERROR! Please enter a value above 1: ");  
            memberNo = scan.nextInt();
        }
      
        String [] names = new String[memberNo];
  
        //Asks for the names of each member and stores the names in an array//
        for (int i = 0; i < names.length; i++)
        {
            System.out.print("\tEnter the name of team member " + (i+1) + ": ");
            names[i] = scan.nextLine();
        }
      
        System.out.println();

        //EXTRA: sequentially print the names in a sentence//
        System.out.print("Welcome ");
      
        for (String i : names)
        { 
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println("Good luck on your project!");
        try
        {
            PrintWriter pr = new PrintWriter(new FileWriter("Team & Member Names.csv",true));    
            pr.print(projectName + ",");
            
            //Prints all members into file//
            for (int i=0; i<memberNo ; i++)
            {
                pr.print(names[i] + ",");
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
        MainMenu.printMenu();
        MainMenu.selection();
    }
  
    public static void votes() 
    {
        //Returns back to the Main Menu//
        System.out.println(SEPARATION + "\n");
        System.out.print("Enter the project name: ");
        
        //Enter project name//
        System.out.println("There are " + "the team name" + "team members.");
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
    }
}
  
  