import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {

  public static void main(String[] args) {

    streamtest();
    functionalInterfaceTest();
    lambdaTest();
    OptionalTest();
  }
  public static void OptionalTest() {

    Details details = new Details();

    Optional<List<Integer>> part = Optional.ofNullable(details.getParts());

    System.out.println(part.orElse(new ArrayList<>()));

  }

  public static void lambdaTest() {

    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(11);
    list.add(12);
    list.add(13);
    list.add(13);


    Stream<Integer> listStream = list.stream().filter(ele -> ele > 12);
    int cconstant = 22;
    listStream.forEach(ele -> {
      //cconstant = 22; we cant change the variable as lambda can be called from multithreading.
      int fcconstant = 22; //local variable is over stack so that it si fine to change them.
      fcconstant = 23;
      System.out.println(ele + cconstant);
    });

  }
  public static void functionalInterfaceTest(){
    List<Integer> parts = new ArrayList<>();
    parts.add(21);
    parts.add(22);
    parts.add(23);
    parts.add(24);

    Details obj = new Details(parts);
    obj.listenMe();
    obj.checkMe();
  }

  public static void streamtest() {
    String[] arr = new String[]{"a", "b", "c"};

    Stream<String> stream = Arrays.stream(arr);

    System.out.println(stream.filter(String::isEmpty).count());

    System.out.println(Stream.of("a").toArray());

    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(11);
    list.add(12);
    list.add(13);
    list.add(13);
    //order is not defined.
    list.parallelStream().forEach(element -> {
      System.out.println(element);
    });

    System.out.println(list.stream().distinct().count());
    System.out.println(list.stream().anyMatch(ele -> ele > 10));

    Stream<Integer> listStream = list.stream().filter(ele -> ele > 12);

    List<Integer> parts = new ArrayList<>();
    parts.add(21);
    parts.add(22);
    parts.add(23);
    parts.add(24);


    System.out.println(parts.stream().reduce(100,(a,b)->a+b));

    System.out.println(parts.stream().map(ele->ele+Math.random()).collect(Collectors.toList()));
    List<Details> details = new ArrayList<>();

    details.add(new Details(parts));
    details.add(new Details(parts));
    details.add(new Details(parts));
    details.add(new Details(parts));

    // it is combining the streams to one.
    Stream<Integer> flatSteam = details.stream().flatMap(details1 -> details1.getParts().stream());

    flatSteam.forEach(el -> System.out.println("flatSteam" + el));


  }

  static class Details implements Vehicle{
    List<Integer> parts;

    Details()
    {

    }
    Details(List<Integer> parts) {
      this.parts = parts;
    }

    @Override
    public void checkMe() {
      System.out.println("check me");
    }

    List<Integer> getParts() {
      return parts;
    }
  }


  public interface Vehicle {
    static void callMe()
    {
      System.out.println("i am here");
    }

    default void listenMe()
    {
      System.out.println("listen");
    }

    public void checkMe();
  }
}
