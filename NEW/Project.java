/**
 * This class represents a Project
 * @author Tariq
 * 
 */
class Project {
    
    public static final int MAXMEMBERS = 5;
    public static final int MINMEMBERS = 3;
    public static final int MAXNAMELENGTH = 30;
    public static final int MINNAMELENGTH = 1;


    private String name;
    private String[] teamNames = new String[MAXMEMBERS];
    
    /** Creates a project with the specified name, number of participants and 
     *  team members.
     * @param theName The project name.
     * @param theNumberOfParticipants The number of people in a team
     * @param theTeam The names of team members.
     */
    
    Project (String theName, int theNumberOfParticipants, String [] theTeam)
    {
        if (validateName(theName))
        {
            name = theName;
        }
        else
        {
            fatalError("Constructor passed malformed project name.");
        }
        
        
        if (validateNumberOfMembers(theNumberOfParticipants) )
        {
            NumberOfMembers = theNumberOfParticipants;
        }       
        else
        {
            fatalError("Constructor passed invalid number of participants.");
        }
        
        
        if (validateTheTeam(theTeam, theNumberOfParticipants))
        {
            teamNames = theTeam;  
        }
        else
        {
            fatalError("Constructor passed malformed team names.");
        }
        
    }

    /** Error generated when constructor is passed invalid parameter.
     *  The program will terminate. 
    */
    public static void fatalError(String errorMessage)
    {
        System.out.println("Fatal error: " + errorMessage);
        // A non-zero status indicates an abnormal termination.
        System.exit(1);
    }
    
    
    /** Create a String to represent a Project object.
    */    
    @Override
    public String toString()
    {
        return ("\nProject name: " + name 
                + ", has " 
                + NumberOfMembers + " team members named: "
                + getTeamNames());
    }

    
    /**
     * 
     * @return The project name
     */
    public String getName()   
    {
        return name;
    }
    
   /**
     * 
     * @return The number of team members
     */
    public int getNumberOfTeamMembers()   
    {
        return NumberOfMembers;
    }    
 
   /**
     * 
     * @return The names of all team members
     */
    public String getTeamNames()   
    {
        String theNames = "";
        
        for (int i = 0; i < NumberOfMembers; i++)
        {
            theNames += teamNames[i];
            if (i < (NumberOfMembers - 1))
            {
                theNames += ", ";
            }
        }
        return theNames;
    }    
        
    /**
     * Validate a name.
     * Check whether the name is empty. 
     * Check whether the name is composed of alphanumeric characters.
     * Note: There are many different ways to accomplish these checks.
     * @param theName The name might represent a project or team member.
     * @return A boolean value indicating whether the name was valid or not.
    */
    public static boolean validateName(String theName)
    {
        boolean valid = true;

        if (theName.isEmpty())
        {
            valid = false;
        }

        for (int i = 0; i < theName.length(); i++)          
        {
            if (!Character.isLetterOrDigit(theName.charAt(i)))
                valid = false;   
        }
          
        return valid;
    }

    /*
     * Check whether the number of team members is between MINMEMBERS and 
     * MAXMEMBERS.
     * @param theNumberOfMembers
    */
    static boolean validateNumberOfMembers(int theNumberOfMembers) {
        return (theNumberOfMembers >= MINMEMBERS && theNumberOfMembers <= MAXMEMBERS);
    }
    
    /**
     * Validate the names of team members.
     * For each name in the array, up to the number of participants:
     * <ul>
     * <li> Check whether the name is empty. 
     * <li> Check whether the name is composed of alphanumeric characters.
     * </ul>
     * Note: There are many different ways to accomplish these checks, this is 
     * just one way.
     * @param theTeam An array containing the names of team members.
     * @param theNumberOfParticipants The number of team members.
     * @return A boolean value indicating whether the names are valid or not.
    */
    private boolean validateTheTeam(String[] theTeam, int theNumberOfParticipants) 
    {
        String theName;       
        boolean valid = true;
      
        if (valid)
        {
            for (int i = 0; i < theNumberOfParticipants; i++)
            {
                theName = theTeam[i];
                valid = validateName(theName);
            }
        }  
        return valid;
    }
}