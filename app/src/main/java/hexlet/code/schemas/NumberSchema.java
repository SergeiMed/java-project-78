package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        checkList.add(isNotEmpty());
        return this;
    }

    public Predicate<Object> isNotEmpty() {
        return x -> x instanceof Integer;
    }

    public NumberSchema positive() {
        checkList.add(x -> Integer.parseInt(x.toString()) > 0);
        return this;
    }

    public NumberSchema range(int beginNumber, int endNumber) {
        checkList.add(x -> beginNumber <= Integer.parseInt(x.toString())
                && Integer.parseInt(x.toString()) <= endNumber);
        return this;
    }
}
