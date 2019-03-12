package heaps;

public class Word implements Comparable<Word>
{
    private String word;
    private int priority;

    public Word(String word, int priority)
    {
        this.word = word;
        this.priority = priority;
    }

    public String getWord()
    {
        return word;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    @Override
    public int compareTo(Word other)
    {
        return this.priority - other.priority;
    }
}
