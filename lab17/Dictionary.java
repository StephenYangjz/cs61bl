import java.util.HashMap;

public class Dictionary {

	/*
	 * Since a trie node can have so many children, the children it has are
	 * stored in a map.
	 */
	private HashMap<Character, TrieNode> myStartingLetters;

	public Dictionary() {
		myStartingLetters = new HashMap<>();
	}

	/**
	 * Associates the input word with the input definition in the dictionary.
	 */
	public void addDefinition(String word, String definition) {
		// YOUR CODE HERE
		if (!myStartingLetters.containsKey(word.charAt(0))) {
			myStartingLetters.put(word.charAt(0), new TrieNode());
			if (word.length() == 1) {
				myStartingLetters.get(word.charAt(0)).myDefinition = definition;
				return;
			}
		}
			addHelper(word.substring(1), definition, myStartingLetters.get(word.charAt(0)));
	}

	public void addHelper(String sub, String def, TrieNode xia) {
		if(!xia.myNextLetters.containsKey(sub.charAt(0))) {
			xia.insert(sub);
		}
		if (sub.length() == 1) {
			xia.myNextLetters.get(sub.charAt(0)).myDefinition = def;
		} else {
			addHelper(sub.substring(1), def, xia.myNextLetters.get(sub.charAt(0)));
		}
	}

	/**
	 * Return the definition associated with this word in the Dictionary. Return
	 * null if there is no definition for the word.
	 */
	public String lookupDefinition(String word) {
		// YOUR CODE HERE
		if (!myStartingLetters.containsKey(word.charAt(0))) {
			return null;
		}
		if (word.length() == 1) {
			return myStartingLetters.get(word.charAt(0)).myDefinition;
		}
		return lookHelper(word.substring(1), myStartingLetters.get(word.charAt(0)));
	}

	public String lookHelper(String sub, TrieNode xia) {
		if (xia.myNextLetters == null) {
			return null;
		}
		if (sub.length() == 1) {
			if (xia.myNextLetters.containsKey(sub.charAt(0))) {
				return xia.myNextLetters.get(sub.charAt(0)).myDefinition;
			} else {
				return null;
			}
		}
		if (xia.myNextLetters.containsKey(sub.charAt(0))) {
			return lookHelper(sub.substring(1), xia.myNextLetters.get(sub.charAt(0)));
		} else {
			return null;
		}
	}

	private class TrieNode {
		private HashMap<Character, TrieNode> myNextLetters;

		// Leave this null if this TrieNode is not the end of a complete word.
		private String myDefinition;

		private TrieNode() {
			myNextLetters = new HashMap<>();
		}

		// FEEL FREE TO ADD ADDITIONAL METHODS.
		private void insert(String word) {
			if (word.length() == 1) {
				myNextLetters.put(word.charAt(0), new TrieNode());
				return;
			}
			myNextLetters.put(word.charAt(0), new TrieNode());
			insert(word.substring(1));
		}
	}
}