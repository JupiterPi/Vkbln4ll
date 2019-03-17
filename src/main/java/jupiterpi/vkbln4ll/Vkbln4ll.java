package jupiterpi.vkbln4ll;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Vkbln4ll
{
    private static ConsoleOutput out;
    private static VocabulariesReader reader;

    private static List<Vocabulary> vocabularies = new ArrayList<Vocabulary>();

    public static void main (String[] args)
    {
        out = new ConsoleOutput();
        reader = new VocabulariesReader (".\\vocabularies.txt");
        List<Vocabulary> importedVocabularies = reader.getVocabularies();
        /* TEST */ out.printVocabularies (importedVocabularies);
        for (int i = 0; i < importedVocabularies.size(); i++)
        {
            Random random = new Random();
            Vocabulary vocabulary = importedVocabularies.get (random.nextInt (importedVocabularies.size()));
            importedVocabularies.remove (vocabulary);
            vocabularies.add (vocabulary);
        }

        out.sendHello();

        /* TEST */ out.printVocabularies (vocabularies);
    }
}