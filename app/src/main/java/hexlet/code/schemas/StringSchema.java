package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        checkList.add(isNotEmpty());
        return this;
    }

    public Predicate<Object> isNotEmpty() {
        return x -> x != null && !x.equals("");
    }

    public StringSchema contains(String testString) {
        checkList.add(x -> x.toString().contains(testString));
        return this;
    }

    public StringSchema minLength(int minLength) {
        checkList.add(x -> x.toString().length() >= minLength);
        return this;
    }
}
