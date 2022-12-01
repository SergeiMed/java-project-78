package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    @Override
    protected Predicate<Object> checkFormat() {
        return value -> value instanceof Map<?, ?>;
    }

    public MapSchema required() {
        required = true;
        addCheck(checkFormat());
        return this;
    }

    public MapSchema sizeof(int minSize) {
        addCheck(testMap -> testMap instanceof Map<?, ?> && ((Map<?, ?>) testMap).size() >= minSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        addCheck(testMap -> testMap instanceof Map<?, ?> && ((Map<?, ?>) testMap).keySet().stream()
                .allMatch(value -> map.get(value).isValid(((Map<?, ?>) testMap).get(value))));
        return this;
    }


}
