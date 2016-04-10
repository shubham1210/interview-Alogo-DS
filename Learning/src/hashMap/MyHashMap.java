package hashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shubhamsharma on 4/5/2015.
 */
public class MyHashMap<K,V> {

    private int DEFAULT_BUCKET_SIZE =10;
    private Entry<K,V> bucket[];

    public MyHashMap()
    {
        bucket = new Entry[DEFAULT_BUCKET_SIZE];
    }

    public MyHashMap(int capacity)
    {
        bucket = new Entry[capacity];
    }

    public void putAll(List<K> keys,List<V> values)
    {
        if(keys.size() == values.size())
        {
            int i=0;
            Iterator<K> it= keys.iterator();
            while (it.hasNext())
            {
                /*System.out.println("key "+it.next());
                System.out.println("value "+values.get(i));*/
                put(it.next(),values.get(i));
                i++;
            }
        }
    }

    public Iterator<K> getIteratorKey()
    {
        return getKeysList().iterator();
    }
    public V put(K key,V value)
    {
        System.out.println("here");
        if(key == null)
         return putForNullKey(key,value);

        int index = key.hashCode()%bucket.length;

        Entry<K,V> entry = bucket[index];

        if(entry!=null)
        {
            boolean done=false;
            while (!done)
            {
                System.out.println(entry.getKey() + "  == "+key);

                if(entry.getKey().equals(key))
                {
                    V oldValue = entry.getValue();
                    entry.setValue(value);
                    return oldValue;
                }
                else if(entry.getNext() == null)
                {
                    entry.setNext(new Entry<K,V>(key,value));
                    done=true;
                }
                entry = entry.getNext();
            }

        }
        else
            bucket[index] = new Entry<K,V>(key,value);
        return null;
    }

    public V putForNullKey(K key,V value)
    {

            Entry<K,V> entry = bucket[0];
            if(entry == null)
            {
                bucket[0] = new Entry(key,value);
                return null;
            }
            while(entry !=null)
            {
                if(entry.getKey() == null)
                {
                    V oldValue = entry.getValue();
                    entry.setValue(value);
                    return oldValue;
                }

                if(entry.getNext() == null)
                {
                    entry.setNext(new Entry(key,value));
                    return null;
                }
                entry = entry.getNext();
            }


        return null;
    }

    public List<K> getKeysList()
    {
        List<K> keys = new ArrayList<K>();
        for(int i=0;i< bucket.length;i++)
        {
            if(bucket[i]!=null)
            {
                Entry<K,V> entry = bucket[i];
                while (entry!=null)
                {
                    keys.add(entry.getKey());
                    entry = entry.getNext();
                }
            }
        }
        return keys;
    }
    public Iterator<Entry<K,V>> getEntrySet()
    {
        List<Entry<K,V>> keys = new ArrayList<Entry<K,V>>();
        for(int i=0;i< bucket.length;i++)
        {
            if(bucket[i]!=null)
            {
                Entry<K,V> entry = bucket[i];
                while (entry!=null)
                {
                    keys.add(entry);
                    entry = entry.getNext();
                }
            }
        }
        return keys.iterator();
    }
    public int size()
    {
        int count=0;
        List<K> keys = new ArrayList<K>();
        for(int i=0;i< bucket.length;i++)
        {
            if(bucket[i]!=null)
            {
                Entry<K,V> entry = bucket[i];
                while (entry!=null)
                {
                    count++;
                    keys.add(entry.getKey());
                    entry = entry.getNext();
                }
            }
        }
        return count;
    }

    public V get(K key)
    {
        if(key == null)return getForNULLKey(key);
        int index = key.hashCode()%bucket.length;

        Entry<K, V> entry = bucket[index];

        while(entry !=null && !entry.getKey().equals(key))
        {
            entry =entry.getNext();
        }
        return entry!=null?entry.getValue():null;

    }

    public V getForNULLKey(K key)
    {
        Entry<K,V> entry = bucket[0];
        while(entry!=null){
            if(entry.getKey() == null)
            {
                return entry.getValue();
            }
        }
        return null;
    }
}
