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

    public void printImportError() {
        o("Die Vokabeldatei konnte nicht eingelesen werden. Bitte nutze die Datei Liesmich.txt oder einen der Crash- oder Extended Courses auf unserer Website (kaye.zapto.org) zur Erklärung, nutze eine Vorlage auf der Website oder wende dich an den kostenlosen Support (siehe Website)!");
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
        return new Scanner (System.in).nextLine();
    }

    public String getInputFromGerman (Vocabulary vocabulary)
    {
        print (vocabulary.getGermanToString() + " | ");
        return new Scanner (System.in).nextLine();
    }

    public void printRight ()
    {
        o ("RICHTIG!\n");
    }

    public void printWrong (Vocabulary vocabulary)
    {
        o ("FALSCH!\n" + vocabulary.toString() + "\n");
    }

    public void printEndScore (int score)
    {
        print ("--- Vokabelabfrage beendet ---\nDu hast " + (int) score + "% richtig beantwortet. ");
        if (score == 0) print ("Wir wollen ja nicht unhöflich werden, aber das kann meine verstorbene Großmutter besser!");
        else if (score < 10.0f) print ("Mal nur so unter uns, das kannst du aber besser!");
        else if (score < 20.0f) print ("Üben solltest du noch!");
        else if (score < 30.0f) print ("Gut, aber üben solltest du trotzdem noch!");
        else if (score < 40.0f) print ("Das wird doch bestimmt eine gute Note!");
        else if (score < 50.0f) print ("Das ist gut!");
        else if (score < 60.0f) print ("Tja, fifty-fifty und aufwärts!");
        else if (score < 70.0f) print ("Einen Schüler wie dich will man haben!");
        else if (score < 80.0f) print ("Da kann man nur sagen: Sehr gut gemacht!");
        else if (score < 90.0f) print ("Wir wollen ja nicht unhöflich werden, aber das kann meine verstorbene Großmutter um Längen schlechter!");
        else if (score <= 100.0f) print ("Ich glaube, selbst ein Computer mit einer sehr, sehr großen Datenbank könnte das nicht viel besser!");
        print ("\n");
    }

    public void printNewFileCreated ()
    {
        o ("Neue Vokabeldatei erstellt (vocabularies.txt)!");
    }

    public void printEmptyFile (String fileName)
    {
        o ("Vokabeldatei (" + fileName + ") ist leer. Bitte fülle sie doch!");
    }
}