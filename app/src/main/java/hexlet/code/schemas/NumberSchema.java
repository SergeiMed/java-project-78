package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        checkList.add(isNotEmpty());
        return this;
    }

    public Predicate<Object> isNotEmpty() {
        return Objects::nonNull;
    }

    public NumberSchema positive() {
        checkList.add(x -> (Integer) x > 0);
        return this;
    }

    public NumberSchema range(int beginNumber, int endNumber) {
        checkList.add(x -> beginNumber <= (Integer) x && (Integer) x <= endNumber);
        return this;
    }
}
