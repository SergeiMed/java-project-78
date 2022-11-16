package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected List<Predicate<T>> checkList = new ArrayList<>();

    public abstract Predicate<T> isNotEmpty();

    public final boolean isValid(T testObject) {
        if (testObject == null) {
            return !checkList.contains(isNotEmpty());
        }
        for (Predicate<T> check : checkList) {
            if (!check.test(testObject)) {
                return false;
            }
        }
        return true;
    }
}
