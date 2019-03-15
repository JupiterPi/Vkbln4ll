package jupiterpi.vkbln4ll;

import java.util.List;
import java.util.ArrayList;

public class Vocabulary
{
    private String latin;
    private List<String> german = new ArrayList<String>();
    private String fullGerman;
    
    public Vocabulary (String latin, List<String> german)
    {
        this.latin = latin;
        this.german = german;
    }

    public Vocabulary (String latin, List<String> german, String fullGerman)
    {
        this.latin = latin;
        this.german = german;
        this.fullGerman = fullGerman;
    }

    public String getLatin ()
    {
        return latin;
    }
    
    public List<String> getGerman ()
    {
        return german;
    }

    public String toString ()
    {
        /*String germans = "";
        for (int i = 0; i < german.size(); i++)
        {
            if (i == 0) germans = german.get(i);
            else germans += ", " + german.get(i);
        }*/
        return latin + " | " + fullGerman;
    }
}