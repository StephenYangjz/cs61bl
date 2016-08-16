// This is a SUGGESTED skeleton file.  Throw it away if you want.
package enigma;

import java.io.*;

/** Enigma simulator.
 *  @author
 */
public final class Main {

    // WARNING: Not all methods that have code in them are complete!

    /** Process a sequence of encryptions and decryptions, as
     *  specified in the input from the standard input.  Print the
     *  results on the standard output. Exits normally if there are
     *  no errors in the input; otherwise with code 1. */
    public static void main(String[] args) {
        Machine M;
        BufferedReader input = null;
        try {
            input = new BufferedReader(
                    new InputStreamReader(new FileInputStream(args[0])));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file found.");
        }

        String outputFilename;
        if (args.length >= 2) {
            outputFilename = args[1];
        } else {
            outputFilename = "output.txt";
        }

        //buildRotors();

        M = null;

        try {
            String line = input.readLine();
            if (line == null) {
                return;
            }
            while (line.length() == 0) {
                line = input.readLine();
            }
            if (line.charAt(0) != '*') {
                throw new EnigmaException("No configuration!");
            }
            if (isConfigurationLine(line)) {
                M = new Machine();
                configure(M, line);
            }
            while (true) {
                line = input.readLine();
                if (line == null) {
                    break;
                }
                if (line.length() == 0) {
                    writeMessageLine("", outputFilename);
                    continue;
                }
                if (isConfigurationLine(line)) {
                    M = new Machine();
                    configure(M, line);
                } else {
                    writeMessageLine(M.convert(standardize(line)),
                                     outputFilename);
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }
    }

    /** Return true iff LINE is an Enigma configuration line. */
    private static boolean isConfigurationLine(String line) {
        if (line.charAt(0) == '*') {
            return true;
        }
        return false; // FIXME
    }

    /** Configure M according to the specification given on CONFIG,
     *  which must have the format specified in the assignment. */
    private static void configure(Machine M, String config) {
        // FIXME
        String[] s = new String[6];
        for (int i = 0; i < s.length; i++) {
            s[i] = "";
        }
        int index = 0;
        config = config.substring(2).trim();
        while (config.length() != 0) {
            if (config.charAt(0) != ' ') {
                s[index] += config.charAt(0);
                config = config.substring(1);
            } else {
                index++;
                config = config.trim();
            }
            if (index > 5) {
                throw new EnigmaException("Bad configure");
            }
        }
        if (index < 5) {
            throw new EnigmaException("Bad configure");
        }
        Rotor[]  rotors = new Rotor[5];
        rotors[0] = new Reflector(s[0]);
        rotors[1] = new FixedRotor(s[1]);
        for (int j = 2; j < 5; j++) {
            rotors[j] = new Rotor(s[j]);
            if (rotors[j] instanceof FixedRotor || rotors[j] instanceof Reflector) {
                throw new EnigmaException("Bad configure");
            }
        }
        M.replaceRotors(rotors);
        M.setRotors(s[5]);
    }

    /** Return the result of converting LINE to all upper case,
     *  removing all blanks and tabs.  It is an error if LINE contains
     *  characters other than letters and blanks. */
    private static String standardize(String line) {
        line = line.trim();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                line = line.substring(0, i).concat(line.substring(i + 1));
            }
        }
        return line.toUpperCase(); // FIXME
    }

    /** Write MSG in groups of five to out file (except that the last
     *  group may have fewer letters). */
    private static void writeMessageLine(String msg, String filename) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            String outputString = ""; 
            for (int i = 0; i < msg.length(); i += 5) {
                outputString += msg.substring(i, Math.min(i + 5, msg.length()));
                if (i + 5 < msg.length()) {
                    outputString += " ";
                }
            }

            writer.write(outputString + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("IOException when writing: " + e);
        }
    }

    /** Create all the necessary rotors. */
    private static void buildRotors() {
        // FIXME
    }

}

