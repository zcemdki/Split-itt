import java.util.Scanner;

public class MainMenu 
{
    public static final String SEPARATION = "**********************";
   
    public static void main(String[] args)
    {
        printMenu();
        selection();
    }

    public static void printMenu() 
    {
        //Printing the main menu//
        System.out.println(SEPARATION + "\n\tWelcome to Split-it\n" );
        System.out.println("\tAbout (A)");
        System.out.println("\tCreate Project (C)");
        System.out.println("\tEnter Votes (V)");
        System.out.println("\tShow Project (S)");
        System.out.println("\tQuit (Q)");
        System.out.print("\n\tPlease choose an option: ");
    }
   
    public static char selection()
    {
        Scanner scan = new Scanner(System.in);
    
        //Turns Lowercase letters to Uppercase and characters//
      
        char option = Selections.getSelection();
      
        //Checks for vaild input//
        while (option != 'Q')
        {
      
                while (option !='A' && option !='C' && option !='V' && option !='S' && option !='Q')
                {
                        System.out.print("Error: Invalid Input.\nChoose a valid option from above: ");
                        option = Selections.getSelection();
                }
        
                //Opens up the next page//
                switch (option)
                {
                    case 'A':
                        about();
                        break;
                    case 'C':
                        Selections.createProject();
                        break;
                    case 'V':
                        Selections.votes();
                        break;
                    case 'S':
                        Selections.showProject();
                    case 'Q':
                        Selections.quit();
                        break;
                }
        return option;
        }
        return option;
    }
  
    private static void about() 
    {
        Scanner scan = new Scanner(System.in);
        //Information about the program//
        System.out.println(SEPARATION + "\n");
        System.out.println("Welcome to Split-it\n");
        System.out.println("In the Main Menu:\nPress C to create a new project with your team members.\n");
        System.out.println("Press V to enter the ammount of votes for a project you have created.\n");
        System.out.println("Press S to view the project in more detail. You will be able to view the name of the project,\nname and ammount of team members and finally the voting for each individuaL.\n");
        System.out.println("Press Q to quit the application.\n");
        System.out.println("Press enter to return to Main Menu");
  
        //Press any enter to go back to main menu//
        String enterKey = scan.nextLine();
            printMenu();
            selection();
    }
  

}