// This is a SUGGESTED skeleton file.  Throw it away if you don't use it.
package enigma;

/** Class that represents a rotor in the enigma machine.
 *  @author
 */
class Rotor {
    // This needs other methods, fields, and constructors.

    /** Size of alphabet used for plaintext and ciphertext. */
    static final int ALPHABET_SIZE = 26;
    protected String uppermapping, lowermapping, notch;


    Rotor() {

    }

    Rotor(String type) {
        if (type .equals("I") || type .equals("II")
                || type .equals("III") || type .equals("IV")
                || type .equals("V") || type .equals("VI")
                || type .equals("VII")  || type .equals("VIII")) {
            for (int i = 0; i < 8; i++) {
                if (PermutationData.ROTOR_SPECS[i][0].equals(type)) {
                    uppermapping = PermutationData.ROTOR_SPECS[i][1];
                    lowermapping = PermutationData.ROTOR_SPECS[i][2];
                    notch = PermutationData.ROTOR_SPECS[i][3];
                    break;
                }
            }
        } else throw new EnigmaException("Illegal input");
    }

    /** Assuming that P is an integer in the range 0..25, returns the
     *  corresponding upper-case letter in the range A..Z. */
    static char toLetter(int p) {
        return (char) (p + 65);  // FIXME
    }

    /** Assuming that C is an upper-case letter in the range A-Z, return the
     *  corresponding index in the range 0..25. Inverse of toLetter. */
    static int toIndex(char c) {
        return (int) (c - 65);  // FIXME
    }

    /** Returns true iff this rotor has a ratchet and can advance. */
    boolean advances() {
        if (notch != null) {
            return true;
        }
        return false;
    }

    /** Returns true iff this rotor has a left-to-right inverse. */
    boolean hasInverse() {
        if (lowermapping != null) {
            return true;
        }
        return false;
    }

    /** Return my current rotational setting as an integer between 0
     *  and 25 (corresponding to letters 'A' to 'Z').  */
    int getSetting() {
        return _setting;
    }

    /** Set getSetting() to POSN.  */
    void set(int posn) {
        assert 0 <= posn && posn < ALPHABET_SIZE;
        _setting = posn;
    }

    /** Return the conversion of P (an integer in the range 0..25)
     *  according to my permutation. */
    int convertForward(int p) {
        int tmp = (p + _setting) % 26;
        int result = (uppermapping.charAt(tmp >= 0 ? tmp : tmp + 26) - 65 - _setting) % 26;
        return result >= 0 ? result : result + 26; // FIXME
    }

    /** Return the conversion of E (an integer in the range 0..25)
     *  according to the inverse of my permutation. */
    int convertBackward(int e) {
        int tmp = (e + _setting) % 26;
        int result = (lowermapping.charAt(tmp >= 0 ? tmp : tmp + 26) - 65 - _setting) % 26;
        return result >= 0 ? result : result + 26;  // FIXME
    }

    /** Returns true iff I am positioned to allow the rotor to my left
     *  to advance. */
    boolean atNotch() {
        for (int i = 0; i < notch.length(); i++) {
            if (_setting == notch.charAt(i) - 65) {
                return true;
            }
        }
        return false; // FIXME
    }

    /** Advance me one position. */
    void advance() {
        // FIXME
        _setting = (_setting + 1) % 26;
    }

    /** My current setting (index 0..25, with 0 indicating that 'A'
     *  is showing). */
    private int _setting;

}
