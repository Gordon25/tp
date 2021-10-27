package seedu.address.testutil;

import static seedu.address.logic.commands.general.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_TELEGRAM_AMY;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_TELEGRAM_BOB;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_ZOOM_AMY;
import static seedu.address.logic.commands.general.CommandTestUtil.VALID_ZOOM_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.contact.Contact;

/**
 * A utility class containing a list of {@code Contact} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Contact ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253").withTelegramHandle(null).withZoomLink(null)
            .withTags("friends").build();
    public static final Contact BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25").withTelegramHandle(null).withZoomLink(null)
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Contact CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withTelegramHandle(null).withZoomLink(null)
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Contact DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withTelegramHandle(null).withZoomLink(null)
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Contact ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withTelegramHandle(null).withZoomLink(null)
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Contact FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withTelegramHandle(null).withZoomLink(null)
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Contact GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withTelegramHandle(null).withZoomLink(null)
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Contact HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Contact IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Contact's details found in {@code CommandTestUtil}
    public static final Contact AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTelegramHandle(VALID_TELEGRAM_AMY)
            .withZoomLink(VALID_ZOOM_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Contact BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withZoomLink(VALID_ZOOM_BOB)
            .withTelegramHandle(VALID_TELEGRAM_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Contact contact : getTypicalPersons()) {
            ab.addContact(contact);
        }
        return ab;
    }

    public static List<Contact> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    public static List<String> getAliceContactDetails() {
        List<String> contactDetails = new ArrayList<>();
        contactDetails.add("Alice Pauline");
        contactDetails.add("alice@example.com");
        contactDetails.add("94351253");
        contactDetails.add("123, Jurong West Ave 6, #08-111");
        contactDetails.add("[friends]");


        return contactDetails;
    }
}
