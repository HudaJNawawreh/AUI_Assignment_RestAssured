import java.util.List;

public class GeneralMethods {

    /**
     * This method will print the user name depending on his\her id
     * @param id the id your looking for
     * @param dataList the data list you get from the API request
     */
    public static void gettingUserNameFromId(String id, List<Object> dataList){
        String firstName="";
        String lastName="";
        String fullName;
        Boolean found=false;

        //Looking for a user with the id you sent
        for(int i=0;i<dataList.size();i++)
        {
            if(dataList.get(i).toString().contains("id="+id)) {
                String[] userData=dataList.get(i).toString().split(",");
                for(int x=0;x<userData.length;x++)
                {
                    if(userData[x].contains("first_name"))
                        firstName=userData[x].split("=")[1];
                    else if(userData[x].contains("last_name"))
                        lastName=userData[x].split("=")[1];
                }
                found =true;
                break;
            }
        }

        fullName=firstName+" "+lastName;

        if(!found)
            System.out.println("No user has ID#"+ id);
        else
            System.out.println("The user with ID#"+id+" is " + fullName);
    }
}
