package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    protected List<Predicate<T>> options = new ArrayList<>();

    public final boolean isValid(T testObject) {
        if (!options.isEmpty() && testObject == null) {
            return false;
        }
        for (Predicate<T> option : options) {
            if (!option.test(testObject)) {
                return false;
            }
        }
        return true;
    }
}
