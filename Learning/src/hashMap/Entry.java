package hashMap;

/**
 * Created by shubhamsharma on 4/5/2015.
 */
public class Entry<K,V> {

    private final K key;
    private V value;
    private Entry next;

    public Entry(K key ,V value)
    {
        this.key = key;
        this.value =value;
    }

    public void setNext(Entry next)
    {
        this.next = next;
    }

    public Entry getNext()
    {
        return this.next;
    }
    public void setValue(V value)
    {
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

}
