package practice;

//an alternative to generic classes
public class ObjectStorage
{
    private Object data;

    public ObjectStorage(Object data)
    {
        this.data = data;
    }

    public Object getData()
    {
        return data;
    }
}
