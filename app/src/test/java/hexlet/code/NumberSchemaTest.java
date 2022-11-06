package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {

    private NumberSchema numberSchema;
    private static final int MIN_NUMBER = -50;
    private static final int MAX_NUMBER = 50;
    private static final int TEST_NUMBER_ZERO = 0;
    private static final int TEST_NUMBER_POSITIVE_TEN = 10;
    private static final int TEST_NUMBER_NEGATIVE_TEN = -10;
    private static final int TEST_NUMBER_TWENTY = 20;
    private static final int TEST_NUMBER_SIXTY = 60;


    @BeforeEach
    private void setup() {
        numberSchema = new Validator().number();
    }

    @Test
    public void testEmptySchema() {
        Assertions.assertTrue(numberSchema.isValid(null));
        Assertions.assertTrue(numberSchema.isValid(TEST_NUMBER_ZERO));
    }

    @Test
    public void testRequiredSchema() {
        Assertions.assertTrue(numberSchema.required().isValid(TEST_NUMBER_NEGATIVE_TEN));
        Assertions.assertTrue(numberSchema.required().isValid(TEST_NUMBER_POSITIVE_TEN));
        Assertions.assertFalse(numberSchema.isValid(null));
    }

    @Test
    public void testPositiveSchema() {
        Assertions.assertTrue(numberSchema.positive().isValid(TEST_NUMBER_POSITIVE_TEN));
        Assertions.assertFalse(numberSchema.isValid(TEST_NUMBER_NEGATIVE_TEN));
    }

    @Test
    public void testRangeSchema() {
        Assertions.assertTrue(numberSchema.range(TEST_NUMBER_ZERO, MAX_NUMBER).isValid(TEST_NUMBER_TWENTY));
        Assertions.assertTrue(numberSchema.isValid(MAX_NUMBER));
        Assertions.assertFalse(numberSchema.isValid(TEST_NUMBER_SIXTY));
    }

    @Test
    public void testNumberSchema() {
        numberSchema.required().positive().range(MIN_NUMBER, MAX_NUMBER);
        Assertions.assertTrue(numberSchema.isValid(TEST_NUMBER_TWENTY));
        Assertions.assertFalse(numberSchema.isValid(null));
        Assertions.assertFalse(numberSchema.isValid(TEST_NUMBER_SIXTY));
        Assertions.assertFalse(numberSchema.isValid(TEST_NUMBER_NEGATIVE_TEN));
    }
}
