// This is a SUGGESTED skeleton file.  Throw it away if you don't use it.
package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
class Reflector extends Rotor {

    Reflector(String type) {
        if (PermutationData.ROTOR_SPECS[10][0].equals(type)) {
            lowermapping = PermutationData.ROTOR_SPECS[10][1];
        } else lowermapping = PermutationData.ROTOR_SPECS[11][1];
    }

    // This needs other methods or constructors.

    @Override
    boolean hasInverse() {
        return false;
    }

    /** Returns a useless value; should never be called. */
    @Override
    int convertBackward(int unused) {
        if (0 <= unused && unused < ALPHABET_SIZE) {
            return lowermapping.charAt(unused) - 65;
        }
        throw new UnsupportedOperationException();
    }

}
