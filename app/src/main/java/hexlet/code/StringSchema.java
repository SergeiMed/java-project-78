package hexlet.code;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public final StringSchema required() {
        options.add(isEmpty());
        return this;
    }

    public final StringSchema contains(String testString) {
        options.add(isContain(testString));
        return this;
    }

    public final StringSchema minLength(int minLength) {
        options.add(isMinLength(minLength));
        return this;
    }

    private Predicate<String> isMinLength(int minLength) {
        return x -> (x.length() > minLength);
    }

    private Predicate<String> isContain(String containString) {
        return x -> x.contains(containString);
    }

    private Predicate<String> isEmpty() {
        return x -> x != null && !x.equals("");
    }

}
