package hashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shubhamsharma on 4/6/2015.
 */
public class MyHashMapTest {

        public static void main(String[] s)
        {
            MyHashMap<String, Duck>  myMap = new MyHashMap<String,Duck>();
            System.out.println(myMap.put("111", new Duck("swan", 10)));
            System.out.println(myMap.get("111"));
            System.out.println(myMap.put("1", new Duck("swan1", 20)));
            System.out.println(myMap.get("1"));
            System.out.println(myMap.put("111", new Duck("swan2", 30)));
            System.out.println(myMap.get("111"));
            System.out.println(myMap.put(null, new Duck("swan1", 220)));
            //	myMap.put(null, new Duck("sas", 2));
            System.out.println(myMap.get(null));

            Iterator<Entry<String,Duck>> it = myMap.getEntrySet();

            while (it.hasNext())
            {
                System.out.println("from iterator=="+it.next().getValue());
            }

            List<String> keys =new ArrayList<String>(3);
            List<Duck> vals =new ArrayList<Duck>(3);

           /* keys.add("shubham");keys.add("ashish");keys.add("nikhil");
            vals.add(new Duck("shubham",10));
            vals.add(new Duck("ashish",20));
            vals.add(new Duck("nikhil",40));
            myMap.putAll(keys,vals);*/
            System.out.println("size of map == "+myMap.size());

        }

    }

/**
 * A simple Util class
 **/
class Duck {
    private String name;
    private int weight;

    public Duck(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName(){return name;}
    public int getWeight(){return weight;}

    @Override
    public String toString(){
        return String.format("name:"+name+"  weight:"+weight);
    }
}//class



