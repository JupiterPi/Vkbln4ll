package jupiterpi.vkbln4ll;

import java.util.List;
import java.util.ArrayList;

public class ConsoleOutput
{
    public void o (String message)
    {
        System.out.println (message);
    }

    public void sendHello ()
    {
        o ("\n--- Vkbln4ll ---\nv0.0 (beta-test)\nCopyright (c) Kaye mGmbH\n");
    }

    public void printVocabularies (List<Vocabulary> vocabularies)
    {
        o ("Test der importierten Vokabeln:");
        if (vocabularies.size() == 0) o (" - (keine Vokabeln)");
        o (vocabularies.size() + " Vokabeln vorhanden. ");
        for (Vocabulary vocabulary : vocabularies)
        {
            o (" - " + vocabulary.toString());
        }
        o ("Ende der Liste\n");
    }
}