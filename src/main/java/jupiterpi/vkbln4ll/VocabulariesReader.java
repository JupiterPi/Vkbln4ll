package jupiterpi.vkbln4ll;

import jupiterpi.vkbln4ll.filetool.FileTool;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class VocabulariesReader
{
    private FileTool vocabulariesFile;

    public VocabulariesReader (String vocabulariesFileName)
    {
        vocabulariesFile = new FileTool (vocabulariesFileName);
    }

    public List<Vocabulary> getVocabularies ()
    {
        List<String> vocabulariesStrings = vocabulariesFile.getFile();
        List<Vocabulary> returning = new ArrayList<Vocabulary>();
        for (String line : vocabulariesStrings)
        {
            String[] fields = line.split(":");
            List<String> german = new ArrayList<String>();
            for (String ufield : fields[1].split(";"))
            {
                german.add (ufield);
            }
            returning.add (new Vocabulary (fields[0], german));
        }
        return returning;
    }
}