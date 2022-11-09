package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTest {

    private MapSchema mapSchema;
    private Map<String, Object> data;
    private static final int TEST_NUMBER_POSITIVE_TEN = 10;
    private static final int TEST_NUMBER_NEGATIVE_TEN = -10;

    @BeforeEach
    private void setup() {
        mapSchema = new Validator().map();
        data = new HashMap<>();
        data.put("key1", "value1");
    }

    @Test
    public void testEmptySchema() {
        Assertions.assertTrue(mapSchema.isValid(null));
        Assertions.assertTrue(mapSchema.isValid(data));
    }

    @Test
    public void testNotEmptySchema() {
        Assertions.assertTrue(mapSchema.required().isValid(data));
        Assertions.assertFalse(mapSchema.isValid(null));
    }

    @Test
    public void testSizeOfSchema() {
        Assertions.assertFalse(mapSchema.sizeof(2).isValid(data));
        data.put("key2", "value2");
        Assertions.assertTrue(mapSchema.isValid(data));
    }

    @Test
    public void testShapeSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", TEST_NUMBER_POSITIVE_TEN);
        Assertions.assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        Assertions.assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        Assertions.assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", TEST_NUMBER_NEGATIVE_TEN);
        Assertions.assertFalse(schema.isValid(human4));
    }
}
