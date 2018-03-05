
public class ArrayToFile
{
    
      
    public static void main(String[] args)
    {
      
    }

  public static void PrintFile(){
////Creates a file for the array//
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
        }
}
