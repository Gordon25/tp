package seedu.address.logic.commands.contact;

import static seedu.address.logic.commands.general.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.general.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.contact.ContactDisplaySetting;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class CListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new CListCommand(ContactDisplaySetting.DEFAULT_SETTING), model,
            CListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        assertCommandSuccess(new CListCommand(ContactDisplaySetting.DEFAULT_SETTING),
            model, CListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
