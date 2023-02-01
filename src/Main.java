import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        findMinMax(Stream.of(5, 80, 156, -9, 1037, -15), Integer::compareTo, (min, max) -> {
            System.out.println("min: " + min + ", max: " + max);
        });

        List<Integer> numbers = List.of(1, 3, 6, 9, 18, 26, 57, 99);
        findAmountOfEvenIntegers(numbers);
    }

    // Задание 1
    private static <T> void findMinMax(Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
    }

    // Задание 2
    private static void findAmountOfEvenIntegers(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}