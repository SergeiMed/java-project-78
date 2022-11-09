package hexlet.code.schemas;

import hexlet.code.BaseSchema;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        checkList.add(isNotEmpty());
        return this;
    }

    public Predicate<String> isNotEmpty() {
        return x -> x != null && !x.equals("");
    }

    public StringSchema contains(String testString) {
        checkList.add(x -> x.contains(testString));
        return this;
    }

    public StringSchema minLength(int minLength) {
        checkList.add(x -> x.length() >= minLength);
        return this;
    }
}
