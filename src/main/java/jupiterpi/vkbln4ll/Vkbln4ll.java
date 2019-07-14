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

    public static void main (String[] args) throws Exception {
        String[] rebootArgs = new String[1];
        rebootArgs[0] = "wrongVocabularies.txt";
        if (args.length == 3) {
            rebootArgs[0] = args[1];
            rebootArgs[1] = args[1];
        }

        if (run(args)) {
            while (true) {
                if (!(run(rebootArgs))) System.exit(0);
            }
        }
    }

    public static boolean run (String[] args) throws Exception
    {
        if (args.length == 0) define("vocabularies.txt");
        else define(args[0]);
        out.sendHello();
        askVocabularies();
        out.printEndScore (finalScore);
        writeWrongVocabularies(wrongVocabularies, args);

        int wrongVocabulariesAmount = wrongVocabularies.size();
        if (wrongVocabulariesAmount == 0) return false;
        else return out.askRunAgain(wrongVocabularies.size());
    }

    private static void define (String vocabulariesFileName) throws Exception
    {
        out = new ConsoleOutput ();
        reader = new VocabulariesReader (vocabulariesFileName);
        questioner = new Questioner();
        finalScore = 0;
        vocabularies = new ArrayList<Vocabulary>();
        wrongVocabularies = new ArrayList<Vocabulary>();

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
        /* TEST */ System.out.println("Vokabeln: " + vocabularies.toString());
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

    private static void writeWrongVocabularies(List<Vocabulary> wrongVocabularies, String[] args) throws Exception {
        String wrongVocabulariesFileName;
        if (args.length == 3) wrongVocabulariesFileName = args[2];
        else wrongVocabulariesFileName = "wrongVocabularies.txt";
        FileToolForVkbln4ll wrongVocabulariesFile = new FileToolForVkbln4ll(wrongVocabulariesFileName, true);

        int i = 0;
        for (Vocabulary vocabulary : wrongVocabularies) {
            wrongVocabulariesFile.setLine(i,vocabulary.toStringForFile());
            i++;
        }
        wrongVocabulariesFile.deleteLinesFrom(i);

        wrongVocabulariesFile.saveFile();
    }
}