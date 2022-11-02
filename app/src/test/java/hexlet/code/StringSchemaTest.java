package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {

    private StringSchema stringSchema;

    @BeforeEach
    private void setup() {
        stringSchema = new Validator().string();
    }

    @Test
    public void testStringSchemaEmptyStringIsValid() {
        Assertions.assertTrue(stringSchema.isValid(""));
        Assertions.assertTrue(stringSchema.isValid(null));
    }

    @Test
    public void testStringSchemaNotEmptyStringIsValid() {
        Assertions.assertTrue(stringSchema.required().isValid("something"));
    }

    @Test
    public void testStringSchemaContainsIsValid() {
        Assertions.assertTrue(stringSchema.required().contains("thin").isValid("something"));
        Assertions.assertFalse(stringSchema.isValid("Hello"));
    }

    @Test
    public void testIsValid() {
        stringSchema.required().contains("example").minLength(15);
        Assertions.assertTrue(stringSchema.isValid("String for example"));
        Assertions.assertFalse(stringSchema.isValid(""));
        Assertions.assertFalse(stringSchema.isValid("for example"));
        Assertions.assertFalse(stringSchema.isValid("string string string exam"));
    }
}
