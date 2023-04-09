import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<iPhone> iPhoneStream = Stream.of(
                new iPhone("iPhone", 2007),
                new iPhone("iPhone5", 2012),
                new iPhone("iPhoneSE", 2016),
                new iPhone("iPhoneX", 2017),
                new iPhone("iPhone13", 2021));
        BiConsumer<iPhone, iPhone> biConsumer = (min, max) -> System.out.println(max.toString() + ", " + min.toString());
        Comparator<iPhone> iPhoneComparator = Comparator.comparing((iPhone iPhone) -> iPhone.getYearOfIssue()).thenComparing(iPhone -> iPhone.getModel());
        findMinMax(iPhoneStream, iPhoneComparator, biConsumer);

        System.out.println(" ");

        List <Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(12);
        integerList.add(123);
        integerList.add(1_234);
        integerList.add(12_345);

        findAmountEvenNumbers(integerList);

    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List <T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get((list.size()-1)));
        }
    }

    public static void findAmountEvenNumbers (List<Integer> list) {

        Stream <Integer> stream = list.stream();
        Predicate <Integer> predicate;
        Stream <Integer> integerStream = stream.filter((n) -> (n % 2) == 0);
        System.out.println("Четных чисел в списке - " + integerStream.count());
    }
}







