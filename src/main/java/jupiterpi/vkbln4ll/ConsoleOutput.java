package jupiterpi.vkbln4ll;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleOutput
{
    public void o (String message)
    {
        System.out.println (message);
    }

    public void print (String message)
    {
        System.out.print (message);
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

    public String getInputFromLatin (Vocabulary vocabulary)
    {
        print (vocabulary.getLatin() + " | ");
        return new Scanner (System.in).next();
    }

    public String getInputFromGerman (Vocabulary vocabulary)
    {
        print (vocabulary.getGermanToString() + " | ");
        return new Scanner (System.in).next();
    }

    public void printRight ()
    {
        o ("RICHTIG!");
    }

    public void printWrong (Vocabulary vocabulary)
    {
        o ("FALSCH!\n" + vocabulary.toString());
    }

    public void printEndScore (int score)
    {
        o ("--- Vokabelabfrage beendet ---\nDu hast " + score + "% richtig beantwortet. Herzlichen Glückwunsch!");
    }
}