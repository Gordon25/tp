package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class DescriptionTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Description(null));
    }

    @Test
    public void testEquals() {
        Description description = new Description("description 1");
        Description sameDescription = new Description("description 1");
        Description differentDescription = new Description("description 2");

        assertEquals(description, sameDescription);
        assertEquals(description, description);
        assertNotEquals(description, differentDescription);
    }
}