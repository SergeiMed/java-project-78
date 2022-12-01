package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        required = true;
        addCheck(value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addCheck(value -> value instanceof Integer && ((int) value) > 0);
        return this;
    }

    public NumberSchema range(int beginNumber, int endNumber) {
        addCheck(value -> value instanceof Integer && beginNumber <= ((int) value) && ((int) value) <= endNumber);
        return this;
    }
}
