import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ContactManagerTests {

    @Nested
    @DisplayName("ContactManager adds contact to Contact")

    class ContactManagerAddsToContact {
        @Test
        public void testAddContact(){
            ContactManager contactManager = new ContactManager();
            Contact contact = new Contact("Harry Potter", "harrypotter@hogwarts.co.uk", "1234567890");

            contactManager.addContact(contact);

            assertTrue(ContactManager.getContacts().contains(contact));
        }

    }
}
