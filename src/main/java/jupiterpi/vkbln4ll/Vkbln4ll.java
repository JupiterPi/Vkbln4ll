package jupiterpi.vkbln4ll;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class Vkbln4ll
{
    private static ConsoleOutput out = new ConsoleOutput();
    private static VocabulariesReader reader = new VocabulariesReader (".\\vocabularies.txt");
    private static Questioner questioner;

    public static void main (String[] args)
    {
        out.sendHello();
        questioner = new Questioner (reader.getVocabularies());

        out.testVocabulariesImported (reader.getVocabularies());
    }
}