package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected List<Predicate<Object>> checkList = new ArrayList<>();

    public abstract Predicate<Object> isNotEmpty();

    public final boolean isValid(Object testObject) {
        if (testObject == null) {
            return !checkList.contains(isNotEmpty());
        }
        for (Predicate<Object> check : checkList) {
            if (!check.test(testObject)) {
                return false;
            }
        }
        return true;
    }
}
