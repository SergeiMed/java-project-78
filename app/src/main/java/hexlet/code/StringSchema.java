package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {

    private final List<Predicate<String>> options = new ArrayList<>();

    public final boolean isValid(String testString) {
        if (!options.isEmpty() && testString == null) {
            return false;
        }
        for (Predicate<String> option : options) {
            if (!option.test(testString)) {
                return false;
            }
        }
        return true;
    }

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
