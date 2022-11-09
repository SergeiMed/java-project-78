package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {

    private StringSchema stringSchema;
    private static final int MIN_LENGTH = 15;

    @BeforeEach
    private void setup() {
        stringSchema = new Validator().string();
    }

    @Test
    public void testEmptySchema() {
        Assertions.assertTrue(stringSchema.isValid(""));
        Assertions.assertTrue(stringSchema.isValid(null));
        Assertions.assertTrue(stringSchema.isValid("some text"));
    }

    @Test
    public void testNotEmptySchema() {
        Assertions.assertTrue(stringSchema.required().isValid("some text"));
        Assertions.assertFalse(stringSchema.isValid(""));
        Assertions.assertFalse(stringSchema.isValid(null));
    }

    @Test
    public void testContainsSchema() {
        Assertions.assertTrue(stringSchema.required().contains("some").isValid("some text"));
        Assertions.assertFalse(stringSchema.isValid("hello"));
    }

    @Test
    public void testIsValid() {
        stringSchema.required().contains("example").minLength(MIN_LENGTH);
        Assertions.assertTrue(stringSchema.isValid("String for example"));
        Assertions.assertFalse(stringSchema.isValid(""));
        Assertions.assertFalse(stringSchema.isValid("for example"));
        Assertions.assertFalse(stringSchema.isValid("string string string exam"));
        Assertions.assertFalse(stringSchema.isValid(null));
    }
}
