package io.todak.study.modernjavainaction.ch03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionDescriptor {

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (p.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public <T> void forEach(List<T> list, Consumer<T> c) {
        for (T item : list) {
            c.accept(item);
        }
    }

    public <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(f.apply(item));
        }
        return result;
    }




    public static void main(String[] args) {
        FunctionDescriptor functionDescriptor = new FunctionDescriptor();

        List<String> filter = functionDescriptor.filter(List.of("a", "b", "c", ""), (str) -> !str.isEmpty());
        System.out.println(filter);

        functionDescriptor.forEach(Arrays.asList(1, 2, 3, 4, 5), System.out::println);

        List<Integer> map = functionDescriptor.map(Arrays.asList("labmdas", "in", "action"), String::length);
        System.out.println(map);
    }

}
