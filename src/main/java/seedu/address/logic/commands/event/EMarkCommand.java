package seedu.address.logic.commands.event;

import static java.util.Objects.requireNonNull;

import java.util.Collections;
import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.Undoable;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;


public class EBookmarkCommand extends Command implements Undoable {

    public static final String COMMAND_WORD = "emark";

    public static final String PARAMETERS = "INDEX [INDEX]...\n";
    public static final String SYNTAX = COMMAND_WORD + " " + PARAMETERS;

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Marks all event(s) indexed at "
            + "the specified index(es) and displays them at the top of the event list.\n"
            + "Parameters: " + PARAMETERS
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Marked Event: %1$s";
    public static final String MESSAGE_ALREADY_MARKED = "Event Already Marked: %1$s";

    private final List<Index> indexesToMark;

    /**
     * Class constryctor, takes in a list of {@code index}
     */
    public EMarkCommand(List<Index> indexes) {
        requireNonNull(indexes);
        this.indexesToMark = indexes;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        String commandResult = "";
        List<Event> lastShownList = model.getFilteredEventList();
        Collections.reverse(indexesToMark);
        for (Index index : indexesToMark) {
            if (index.getZeroBased() >= lastShownList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_EVENT_DISPLAYED_INDEX);
            }
            Event event = lastShownList.get(index.getZeroBased());
            commandResult += String.format("%s", generateCommandResultMessage(event, event.getIsMarked()));
            model.setEvent(event, createMarkedEvent(event));
        }
        model.rearrangeEventsInOrder(indexesToMark, true);
        model.commitAddressBook();
        return new CommandResult(commandResult);
    }

    /**
     * Creates and returns a marked {@code Event} with the details of {@code eventToMark}
     */
    private static Event createMarkedEvent(Event eventToMark) {
        return new Event(eventToMark.getName(), eventToMark.getStartDateAndTime(), eventToMark.getEndDateAndTime(),
                eventToMark.getDescription(), eventToMark.getAddress(), eventToMark.getZoomLink(),
                eventToMark.getTags(), eventToMark.getUuid(), eventToMark.getLinkedContacts(), true);
    }

    private String generateCommandResultMessage(Event event,
                                              boolean isAlreadyMarked) {
        String message;
        if (isAlreadyMarked) {
            message = String.format(MESSAGE_ALREADY_MARKED, event);
        } else {
            message = String.format(MESSAGE_SUCCESS, event);
        }
        return message += "\n";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EMarkCommand // instanceof handles nulls
                && indexesToMark.equals(((EMarkCommand) other).indexesToMark)); // state check
    }
}
