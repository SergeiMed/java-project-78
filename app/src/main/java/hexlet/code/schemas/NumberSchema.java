package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck(value -> (int) value > 0);
        return this;
    }

    public NumberSchema range(int beginNumber, int endNumber) {
        addCheck(value -> beginNumber <= (int) value && (int) value <= endNumber);
        return this;
    }
}
