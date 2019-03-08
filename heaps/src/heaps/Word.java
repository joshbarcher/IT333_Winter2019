package heaps;

public class Word implements Comparable<Word>
{
    private String messageBody;
    private int priority;

    public Word(String messageBody, int priority)
    {
        this.messageBody = messageBody;
        this.priority = priority;
    }

    public String getMessageBody()
    {
        return messageBody;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setMessageBody(String messageBody)
    {
        this.messageBody = messageBody;
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
