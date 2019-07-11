package jupiterpi.vkbln4ll;

import java.util.List;
import java.util.ArrayList;

public class Vocabulary
{
    private String latin;
    private List<String> german = new ArrayList<String>();
    private String fullGerman;
    private String line;
    
    public Vocabulary (String latin, List<String> german) throws Exception
    {
        if (!(latin.equals (""))) this.latin = latin;
        else throw new Exception ("IMPORTFEHLER: Bitte gib eine lateinische Vokabel an!");
        if (german.size() > 0) this.german = german;
        else throw new Exception ("IMPORTFEHLER: Bitte gib eine Deutsche Übersetzung an!");
    }

    public Vocabulary (String latin, List<String> german, String line) throws Exception
    {
        if (!(latin.equals (""))) this.latin = latin;
        else throw new Exception ("IMPORTFEHLER: Bitte gib eine lateinische Vokabel an!");
        if (german.size() > 0) this.german = german;
        else throw new Exception ("IMPORTFEHLER: Bitte gib eine Deutsche Übersetzung an!");
        this.line = line;
    }

    public String getLatin ()
    {
        return latin;
    }
    
    public List<String> getGerman ()
    {
        return german;
    }

    public String getGermanToString ()
    {
        String returning = german.get(0);
        if (german.size() > 1) for (int i = 1; i < german.size(); i++)
        {
            returning += ", " + german.get(i);
        }
        return returning;
    }

    public String toString ()
    {
        String germans = "";
        for (int i = 0; i < german.size(); i++)
        {
            if (i == 0) germans = german.get(i);
            else germans += ", " + german.get(i);
        }
        return latin + " | " + germans;
    }

    public String toStringForFile() {
        return line;
    }
}