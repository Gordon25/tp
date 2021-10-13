package seedu.address.logic.commands.contact;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Clears all entries of contacts from SoConnect.
 */
public class CClearCommand extends Command {

    public static final String COMMAND_WORD = "cclear";
    public static final String MESSAGE_SUCCESS = "All entries of contacts have been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.resetContacts();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}