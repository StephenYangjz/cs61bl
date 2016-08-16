
/** A class implementing a BST.
  * @author CS 61BL Staff.
  */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
	
	/* Constructs an empty BST. */
	public BinarySearchTree() {
		//YOUR CODE HERE
		super();
	}

	/* Constructs a BST with root MYROOT. */
	public BinarySearchTree(TreeNode root) {
		//YOUR CODE HERE
		super(root);
	}
	
	/* Returns true if and only if KEY is in the BST. */
	public boolean contains(T key) {
		return contains_helper(root, key);
	}

	public boolean contains_helper (TreeNode t, T key) {
		if (t == null) {
			return false;
		} else if (t.item.equals(key)) {
			return true;
		} else if (key.compareTo(t.item) < 0) {
			return contains_helper(t.left, key);
		} else {
			return contains_helper(t.right, key);
		}
	}

	/* Adds a node for KEY iff it isn't in the BST already. */
	public void add(T key) {
		//YOUR CODE HERE
		if(!contains(key)) {
			root = add_helper(root, key);
		}
	}

	public TreeNode add_helper(TreeNode t, T key) {
		if (t == null) {
			return new TreeNode(key);
		} else if (key.compareTo(t.item) < 0) {
			t.left = add_helper(t.left, key);
			return t;
		} else {
			t.right = add_helper(t.right, key);
			return t;
		}
	}

	/* Deletes the node with KEY. */
	public T delete(T key) {
		TreeNode parent = null;
		TreeNode curr = root;
		TreeNode delNode = null;
		TreeNode replacement = null;
		boolean rightSide = false;
		
		while (curr != null && !curr.item.equals(key)) {
			if (((Comparable<T>) curr.item).compareTo(key) > 0) {
				parent = curr;
				curr = curr.left;
				rightSide = false;
			} else {
				parent = curr;
				curr = curr.right;
				rightSide = true;
			}
		}
		delNode = curr;
		if (curr == null) {
			return null;
		}
		
		if (delNode.right == null) {
			if (root == delNode) {
				root = root.left;
			} else {
				if (rightSide) {
					parent.right = delNode.left;
				} else {
					parent.left = delNode.left;
				}
			}
		} else {
			curr = delNode.right;
			replacement = curr.left;
			if (replacement == null) {
				replacement = curr;
			} else {
				while (replacement.left != null) {
					curr = replacement;
					replacement = replacement.left;
				}
				curr.left = replacement.right;
				replacement.right = delNode.right;
			}
			replacement.left = delNode.left;
			if (root == delNode) {
				root = replacement;
			} else {
				if (rightSide) {
					parent.right = replacement;
				} else {
					parent.left = replacement;
				}
			}
		}
		return delNode.item;
	}
	
}