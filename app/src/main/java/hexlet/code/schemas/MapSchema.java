package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addCheck(value -> value instanceof Map<?, ?>);
        required = true;
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
