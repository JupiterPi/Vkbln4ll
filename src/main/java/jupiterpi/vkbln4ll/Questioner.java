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
}