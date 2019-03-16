package jupiterpi.vkbln4ll;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Questioner
{
    private List<Vocabulary> remainingVocabularies = new ArrayList<Vocabulary>();
    private List<Vocabulary> askedVocabularies = new ArrayList<Vocabulary>();
    private Vocabulary actualVocabulary;

    private int random (int to)
    {
        return new Random().nextInt (to);
    }

    public Questioner (List<Vocabulary> vocabularies)
    {
        this.remainingVocabularies = vocabularies;
        this.actualVocabulary = remainingVocabularies.get(random(remainingVocabularies.size()));
    }
}