package jupiterpi.vkbln4ll;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Questioner
{
    private ConsoleOutput out = new ConsoleOutput();
    
    public boolean askFromGerman (Vocabulary vocabulary)
    {
        String input = out.getInputFromGerman (vocabulary);
        if (input.equals (vocabulary.getLatin()))
        {
            out.printRight();
            return true;
        }
        else
        {
            out.printWrong (vocabulary);
            return false;
        }
    }

    public boolean askFromLatin(Vocabulary vocabulary) {
        String input = out.getInputFromLatin(vocabulary);
        String[] inputSplitted = input.split(", ");
        List<String> germans = new ArrayList<String>();
        for (String german : inputSplitted) {
            germans.add(german);
        }

        int score = vocabulary.isGerman(germans);
        if (score >= 50) {
            if (score == 100) out.printRight();
            else out.printRight(vocabulary);
            return true;
        } else if (score != 0) {
            out.printImperfect(vocabulary);
            return (score > 35);
        } else {
            out.printWrong(vocabulary);
            return false;
        }
    }
}