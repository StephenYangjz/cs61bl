package enigma;

/** Class that represents a rotor that has no ratchet and does not advance.
 *  @author
 */
class FixedRotor extends Rotor {

    // This needs other methods or constructors.

    FixedRotor(String type) {
        if (PermutationData.ROTOR_SPECS[8][0].equals(type)) {
            uppermapping = PermutationData.ROTOR_SPECS[8][1];
            lowermapping = PermutationData.ROTOR_SPECS[8][2];
        } else {
            uppermapping = PermutationData.ROTOR_SPECS[9][1];
            lowermapping = PermutationData.ROTOR_SPECS[9][2];
        }
    }
    @Override
    boolean advances() {
        return false;
    }

    @Override
    boolean atNotch() {
        return false;
    }

    /** Fixed rotors do not advance. */
    @Override
    void advance() {
        return;
    }

}
