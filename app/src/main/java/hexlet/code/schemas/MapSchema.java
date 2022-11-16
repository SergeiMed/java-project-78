package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<String, Object>> {

    public Predicate<Map<String, Object>> isNotEmpty() {
        return Objects::nonNull;
    }

    public MapSchema required() {
        checkList.add(isNotEmpty());
        return this;
    }

    public MapSchema sizeof(int minSize) {
        checkList.add(x -> x.size() >= minSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        checkList.add(x -> x.keySet().stream()
                .allMatch(q -> map.get(q).isValid(x.get(q))));
        return this;
    }
}
