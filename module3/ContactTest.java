import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact(
                "Ada Lovelace",
                "+1 617 555 0101"
        );
    }

    @Test
    public void getName_returnsContactName() {
        assertEquals(
                "Ada Lovelace",
                contact.getName()
        );
    }

    @Test
    public void getPhone_returnsContactPhone() {
        assertEquals(
                "+1 617 555 0101",
                contact.getPhone()
        );
    }

    @Test
    public void toString_returnsFormattedContact() {
        assertEquals(
                "Ada Lovelace | +1 617 555 0101",
                contact.toString()
        );
    }

    @Test
    public void getName_isNotNull() {
        assertNotNull(contact.getName());
    }

    @Test
    public void getPhone_isNotNull() {
        assertNotNull(contact.getPhone());
    }
}