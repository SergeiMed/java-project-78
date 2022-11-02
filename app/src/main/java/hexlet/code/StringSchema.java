package hexlet.code;


import java.util.HashMap;
import java.util.Map;

public class StringSchema {

    private final Map<String, Object> options = new HashMap<>();

    public StringSchema() {
        options.put("empty", true);
        options.put("contain", "");
        options.put("minLength", 0);
    }

    public boolean isValid(String string) {
        boolean requiredEmpty = (boolean) options.get("empty");
        String contain = (String) options.get("contain");
        int minLength = (int) options.get("minLength");
        return isEmpty(string) == requiredEmpty && isContains(string, contain) && isMinLength(string, minLength);
    }

    public StringSchema required() {
        options.put("empty", false);
        return this;
    }

    public StringSchema contains(String string) {
        options.put("contain", string);
        return this;
    }

    public StringSchema minLength(int minLength) {
        options.put("minLength", minLength);
        return this;
    }

    private boolean isContains(String string, String contain) {
        if (string == null && contain.equals("")) {
            return true;
        } else if (string == null) {
            return false;
        }
        return string.contains(contain);
    }

    private static boolean isEmpty(String string) {
        return string == null || string.equals("");
    }

    private static boolean isMinLength(String string, int minLength) {
        if (string == null && minLength == 0) {
            return true;
        } else if (string == null) {
            return false;
        }
        return string.length() >= minLength;
    }
}
