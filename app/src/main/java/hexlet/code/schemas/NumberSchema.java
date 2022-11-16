package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        checkList.add(isNotEmpty());
        return this;
    }

    public Predicate<Integer> isNotEmpty() {
        return Objects::nonNull;
    }

    public NumberSchema positive() {
        checkList.add(x -> x > 0);
        return this;
    }

    public NumberSchema range(int beginNumber, int endNumber) {
        checkList.add(x -> beginNumber <= x && x <= endNumber);
        return this;
    }
}
