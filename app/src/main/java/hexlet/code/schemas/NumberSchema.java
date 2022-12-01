package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    @Override
    protected Predicate<Object> checkFormat() {
        return value -> value instanceof Integer;
    }

    public NumberSchema required() {
        required = true;
        addCheck(checkFormat());
        return this;
    }

    public NumberSchema positive() {
        addCheck(value -> value instanceof Integer && ((int) value) > 0);
        return this;
    }

    public NumberSchema range(int beginNumber, int endNumber) {
        addCheck(value -> value instanceof Integer && beginNumber <= ((int) value) && ((int) value) <= endNumber);
        return this;
    }
}
