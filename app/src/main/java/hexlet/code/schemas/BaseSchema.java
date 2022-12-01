package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected List<Predicate<Object>> checkList = new ArrayList<>();
    protected boolean required;
    //protected Predicate<Object> checkFormat;

//    public BaseSchema(Predicate<Object> predicate) {
//        addCheck(predicate);
//    }

    protected final void addCheck(Predicate<Object> check) {
        checkList.add(check);
    }

//    protected final void isRequired(Predicate<Object> required) {
//        this.required = required;
//    }

    public final boolean isValid(Object testObject) {
        if (testObject == null) {
            return !required;
        }
        for (Predicate<Object> check : checkList) {
            if (!check.test(testObject)) {
                return false;
            }
        }
        return true;
    }
}
