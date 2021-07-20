package io.todak.study.modernjavainaction.ch02;

import org.junit.jupiter.api.Test;

import java.util.List;

class FilteringApplesTest {

    @Test
    public void pretty_print_apple_test() {

        List<Apple> apples = List.of(
                new Apple(15, Color.GREEN),
                new Apple(152, Color.RED),
                new Apple(153, Color.GREEN),
                new Apple(12, Color.RED),
                new Apple(114, Color.GREEN),
                new Apple(132, Color.RED),
                new Apple(112, Color.GREEN),
                new Apple(132, Color.RED),
                new Apple(55, Color.GREEN)
        );

        FilteringApples.prettyPrintApple(apples,
                (apple) -> String.join(",", String.valueOf(apple.getWeight()), String.valueOf(apple.getColor())));

        FilteringApples.prettyPrintApple(apples,
                (apple) -> new StringBuilder()
                        .append("weight : ")
                        .append(apple.getWeight())
                        .append(", ")
                        .append("color : ")
                        .append(apple.getColor().name())
                        .append("\t")
                        .toString());
    }

}