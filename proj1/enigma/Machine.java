// This is a SUGGESTED skeleton file.  Throw it away if you don't use it.
package enigma;

/** Class that represents a complete enigma machine.
 *  @author
 */
class Machine {

    // This needs other methods or constructors.
    private Rotor[] manyRotors = new Rotor[5];

    /** Set my rotors to (from left to right) ROTORS.  Initially, the rotor
     *  settings are all 'A'. */
    void replaceRotors(Rotor[] rotors) {
        // FIXME
        for (int i = 0; i < rotors.length; i++) {
            manyRotors[i] = rotors[i];
        }
    }

    /** Set my rotors according to SETTING, which must be a string of four
     *  upper-case letters. The first letter refers to the leftmost
     *  rotor setting.  */
    void setRotors(String setting) {
        // FIXME
        for (int i = 1; i < manyRotors.length; i++) {
            if (setting.charAt(i - 1) >= 65 && setting.charAt(i - 1) <= 90) {
                manyRotors[i].set(setting.charAt(i - 1) - 65);
            } else throw new EnigmaException("Illegal input");
        }
    }

    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) < 65 || msg.charAt(i) > 90) {
                throw new EnigmaException("Illegal input");
            }
        }
        int index = 0;
        String result = "";
        while (index < msg.length()) {
            int num = msg.charAt(index) - 65;
            if (manyRotors[4].atNotch() && !manyRotors[3].atNotch()) {
                manyRotors[4].advance();
                manyRotors[3].advance();
            } else if (manyRotors[3].atNotch()) {
                manyRotors[4].advance();
                manyRotors[3].advance();
                manyRotors[2].advance();
            } else manyRotors[4].advance();
            for (int i = manyRotors.length - 1; i > 0; i--) {
                num = manyRotors[i].convertForward(num);
            }
            for (int i = 0; i < manyRotors.length; i++) {
                num = manyRotors[i].convertBackward(num);
            }
            result += String.valueOf((char) (num + 65));
            index++;
        }
        return result;
            //return null;
            // FIXME
    }
}
