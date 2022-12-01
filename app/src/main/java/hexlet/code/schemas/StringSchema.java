package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    @Override
    protected Predicate<Object> checkFormat() {
        return value -> value instanceof String;
    }

    public StringSchema required() {
        required = true;
        addCheck(checkFormat());
        addCheck(value -> !value.equals(""));
        return this;
    }

    public StringSchema contains(String testString) {
        addCheck(value -> value instanceof String && ((String) value).contains(testString));
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck(value -> value instanceof String && ((String) value).length() >= minLength);
        return this;
    }
}
