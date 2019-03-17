package jupiterpi.vkbln4ll;

import java.util.List;
import java.util.ArrayList;

public class ConsoleOutput
{
    private void o (String message)
    {
        System.out.println (message);
    }

    public void sendHello ()
    {
        o ("\n--- Vkbln4ll ---\nv0.0 (beta-test)\nCopyright (c) Kaye mGmbH\n\n");
    }

    public void testVocabulariesImported (List<Vocabulary> vocabularies)
    {
        for (Vocabulary vocabulary : vocabularies)
        {
            o (vocabulary.toString());
        }
    }
}