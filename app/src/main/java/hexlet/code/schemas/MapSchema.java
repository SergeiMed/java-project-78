package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {


    public Predicate<Object> isNotEmpty() {
        return Objects::nonNull;
    }

    public MapSchema required() {
        checkList.add(isNotEmpty());
        return this;
    }

    public MapSchema sizeof(int minSize) {
        checkList.add(x -> ((Map<?, ?>) x).size() >= minSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        checkList.add(x -> ((Map<?, ?>) x).keySet().stream()
                .allMatch(q -> map.get(q).isValid(((Map<?, ?>) x).get(q))));
        return this;
    }
}
