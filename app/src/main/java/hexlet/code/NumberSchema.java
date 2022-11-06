package hexlet.code;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        options.add(isEmpty());
        return this;
    }

    public final NumberSchema positive() {
        options.add(isPositive());
        return this;
    }

    public final NumberSchema range(int beginNumber, int endNumber) {
        options.add(isInRange(beginNumber, endNumber));
        return this;
    }

    private Predicate<Integer> isInRange(int beginNumber, int endNumber) {
        return x -> beginNumber <= x && x <= endNumber;
    }

    private Predicate<Integer> isEmpty() {
        return Objects::nonNull;
    }

    private Predicate<Integer> isPositive() {
        return x -> x > 0;
    }
}
