package omo.sh.machines;

import java.util.Objects;

/**
 * Class represents machine's manual which is created only in case of machine's damage.
 */
public class Manual {

    /**
     * Manual's text.
     */
    private final String  text;

    /**
     * Class constructor.
     *
     * @param machine for which manual is created
     */
    public Manual(Machine machine) {
        Objects.requireNonNull(machine);
        this.text = machine.getName() + " Manual generated";
    }

    /**
     * @return manual's text
     */
    public String getText() {
        return text;
    }
}
