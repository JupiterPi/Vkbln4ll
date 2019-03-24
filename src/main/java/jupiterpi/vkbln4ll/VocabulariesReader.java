package jupiterpi.vkbln4ll;

import jupiterpi.vkbln4ll.filetool.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class VocabulariesReader
{
    private FileToolForVkbln4ll vocabulariesFile;
    private ConsoleOutput out = new ConsoleOutput();

    public VocabulariesReader (String vocabulariesFileName) throws IOException
    {
        try
        {
            vocabulariesFile = new FileToolForVkbln4ll (vocabulariesFileName);
        }
        catch (CreatedNewFileException x)
        {
            out.sendHello();
            out.printNewFileCreated();
            out.printEmptyFile (vocabulariesFileName);
            System.exit(0);
        }
        catch (EmptyFileException x)
        {
            out.sendHello();
            out.printEmptyFile (vocabulariesFileName);
            System.exit(0);
        }
    }

    public List<Vocabulary> getVocabularies () throws Exception
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