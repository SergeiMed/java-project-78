package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected List<Predicate<Object>> checkList = new ArrayList<>();
    protected boolean required;

    protected abstract Predicate<Object> checkFormat();

    protected final void addCheck(Predicate<Object> check) {
        checkList.add(check);
    }

    public final boolean isValid(Object testObject) {
        if (testObject == null) {
            return !required;
        }
        if (checkList.isEmpty()) {
            return checkFormat().test(testObject);
        }
        for (Predicate<Object> check : checkList) {
            if (!check.test(testObject)) {
                return false;
            }
        }
        return true;
    }
}
