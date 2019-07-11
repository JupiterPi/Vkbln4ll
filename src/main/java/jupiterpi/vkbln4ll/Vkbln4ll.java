package jupiterpi.vkbln4ll;

import jupiterpi.vkbln4ll.filetool.FileToolForVkbln4ll;

import javax.swing.JOptionPane;
import java.io.IOException;
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

    private static List<Vocabulary> wrongVocabularies = new ArrayList<Vocabulary>();

    public static void main (String[] args) throws Exception
    {
        define (args);
        out.sendHello();
        askVocabularies();
        out.printEndScore (finalScore);
        printWrongVocabularies(wrongVocabularies, args);
        askRunAgain();
    }

    private static void define (String[] args) throws Exception
    {
        out = new ConsoleOutput ();
        if (args.length == 0) reader = new VocabulariesReader (".\\vocabularies.txt");
        else reader = new VocabulariesReader (args[0]);
        questioner = new Questioner();
        List<Vocabulary> importedVocabularies = new ArrayList<Vocabulary>();
        try {
            importedVocabularies = reader.getVocabularies();
        } catch (Exception x) {
            out.printImportError();
            System.exit(0);
        }
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
            if (questioner.askFromGerman (vocabulary)) {
                score++;
            } else {
                wrongVocabularies.add(vocabulary);
            }
        }
        finalScore = (int) ((score / (float) vocabularies.size()) * 100);
    }

    private static void printWrongVocabularies(List<Vocabulary> wrongVocabularies, String[] args) throws Exception {
        String wrongVocabulariesFileName;
        if (args.length == 3) wrongVocabulariesFileName = args[2];
        else wrongVocabulariesFileName = "wrongVocabularies.txt";
        FileToolForVkbln4ll wrongVocabulariesFile = new FileToolForVkbln4ll(wrongVocabulariesFileName, true);

        /* TEST */ System.out.println(wrongVocabularies.toString());

        int i = 0;
        for (Vocabulary vocabulary : wrongVocabularies) {
            wrongVocabulariesFile.setLine(i,vocabulary.toStringForFile());
            i++;
        }
        boolean bool = wrongVocabulariesFile.deleteLinesFrom(i);

        /* TEST */ System.out.println(bool);

        wrongVocabulariesFile.saveFile();
    }

    private static void askRunAgain() throws IOException {
        System.out.println("----------------------");
        Runtime rt = Runtime.getRuntime();
        rt.exec(new String[]{"cmd.exe", "echo hallo"});
    }
}