package jupiterpi.vkbln4ll;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Vkbln4ll
{
    private static ConsoleOutput out;
    private static VocabulariesReader reader;
    private static Questioner questioner;

    private static int finalScore;
    private static List<Vocabulary> vocabularies = new ArrayList<Vocabulary>();

    public static void main (String[] args) throws Exception
    {
        define();
        out.sendHello();
        askVocabularies();
        out.printEndScore (finalScore);
    }

    private static void define () throws Exception
    {
        out = new ConsoleOutput();
        reader = new VocabulariesReader (".\\vocabularies.txt");
        questioner = new Questioner();
        List<Vocabulary> importedVocabularies = reader.getVocabularies();
        int importedVocabulariesSize = importedVocabularies.size();
        for (int i = 0; i < importedVocabulariesSize; i++)
        {
            Random random = new Random();
            Vocabulary vocabulary = importedVocabularies.get (random.nextInt(importedVocabularies.size()));
            importedVocabularies.remove (vocabulary);
            vocabularies.add (vocabulary);
        }
    }

    private static void askVocabularies ()
    {
        float score = 0;
        for (Vocabulary vocabulary : vocabularies)
        {
            if (questioner.askFromGerman (vocabulary)) score++;
        }
        finalScore = (int) ((score / (float) vocabularies.size()) * 100);
    }
}