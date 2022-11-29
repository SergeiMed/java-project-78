package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        required = true;
        addCheck(value -> !value.equals(""));
        return this;
    }

    public StringSchema contains(String testString) {
        addCheck(value -> ((String) value).contains(testString));
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck(value -> ((String) value).length() >= minLength);
        return this;
    }
}
