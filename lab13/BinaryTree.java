import java.util.Iterator;
import java.util.*;

public class BinaryTree {

    private TreeNode root;
    // Contains nodes already seen in the traversal.
    private ArrayList alreadySeen = new ArrayList();

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode t) {
        root = t;
    }

    public TreeNode getRoot() {
        return root;
    }

    // Print the values in the tree in preorder: root value first,
    // then values in the left subtree (in preorder), then values
    // in the right subtree (in preorder).
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printPreorder();
            System.out.println();
        }
    }

    // Print the values in the tree in inorder: values in the left
    // subtree first (in inorder), then the root value, then values
    // in the right subtree (in inorder).
    public void printInorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printInorder();
            System.out.println();
        }
    }

    public void fillSampleTree1() {
        TreeNode temp = new TreeNode("a");
        root = new TreeNode("a", temp, temp);
    }

    public void fillSampleTree2() {
        root = new TreeNode("a", new TreeNode("b", new TreeNode("d",
                new TreeNode("e"), new TreeNode("f")), null), new TreeNode("c"));
    }

    public void fillSampleTree3() {
        root = new TreeNode("A", new TreeNode("B"), new TreeNode("C",
                new TreeNode("D"), new TreeNode("E")));
    }

    public void fillSampleTree4() {
        root = new TreeNode("A", new TreeNode("B"), new TreeNode("C",
                new TreeNode("D"), new TreeNode("E",root, root)));
    }

    public void fillSampleTree5() {
        root = new TreeNode("A");
        root.left = root;
    }

    public void print() {
        if (root != null) {
            root.print(0);
        }
    }

    public boolean check() {
        try {
            isOK(root);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    private void isOK(TreeNode t) throws IllegalStateException {
            if (alreadySeen.contains(t)) {
                throw new IllegalStateException("Error");
            }
            alreadySeen.add(t);
        if (t.left != null) {
            isOK(t.left);
        }
        if (t.right != null) {
            isOK(t.right);
        }

    }

    public static BinaryTree fibTree(int n) {
        BinaryTree result = new BinaryTree();
        if (n <= 1) {
            result.root = new TreeNode(n);
        } else {
            TreeNode left = fibTree(n - 1).root;
            TreeNode right = fibTree(n - 2).root;
            result.root = new TreeNode((int)left.item + (int)right.item, left, right);
        }
        return result;
    }

    public static BinaryTree exprTree(String s) {
        BinaryTree result = new BinaryTree();
        result.root = result.exprTreeHelper(s);
        return result;
    }

    // Return the tree corresponding to the given arithmetic expression.
    // The expression is legal, fully parenthesized, contains no blanks,
    // and involves only the operations + and *.
    private TreeNode exprTreeHelper(String expr) {
        if (expr.charAt(0) != '(') {
            if (Character.isLetter(expr.charAt(0))) {
                return new TreeNode(expr.charAt(0));
            } else {
                return new TreeNode(new Integer(Character.getNumericValue(expr.charAt(0))));
            }// you fill this in
        } else {
            // expr is a parenthesized expression.
            // Strip off the beginning and ending parentheses,
            // find the main operator (an occurrence of + or * not nested
            // in parentheses, and construct the two subtrees.
            int nesting = 0;
            int opPos = 0;
            for (int k = 1; k < expr.length() - 1; k++) {
                if (expr.charAt(k) == '(') {
                    nesting++;
                } else if (expr.charAt(k) == ')') {
                    nesting--;
                } else if (nesting == 0 && (expr.charAt(k) == '+'||expr.charAt(k) == '*')) {
                    opPos = k;
                }
            }
            String opnd1 = expr.substring(1, opPos);
            String opnd2 = expr.substring(opPos + 1, expr.length() - 1);
            String op = expr.substring(opPos, opPos + 1);
            System.out.println("expression = " + expr);
            System.out.println("operand 1  = " + opnd1);
            System.out.println("operator   = " + op);
            System.out.println("operand 2  = " + opnd2);
            System.out.println();
            return new TreeNode(op, exprTreeHelper(opnd1), exprTreeHelper(opnd2));
        }
    }

    public void optimize() {
        optimizeHelper(root);
    }

    private void optimizeHelper(TreeNode node) {
        if (node.left != null) {
            optimizeHelper(node.left);
        } if (node.right != null) {
            optimizeHelper(node.right);
        } if (node.item instanceof String) {
            if (node.left.item instanceof Integer && node.right.item instanceof Integer) {
                String op = (String) node.item;
                Integer left_comp = (Integer)node.left.item;
                Integer right_comp = (Integer)node.right.item;
                if (op.charAt(0) == '+') {
                    node.item = new Integer(left_comp+right_comp).toString();
                } else if (op.charAt(0) == '*') {
                    node.item = new Integer(left_comp*right_comp).toString();
                }
                node.right = null;
                node.left = null;
                return;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree t;
        t = new BinaryTree();
        t.fillSampleTree5();
        //t.print();
        System.out.println(t.check());
        for (Object i : t.alreadySeen) {
            System.out.println(i);
        }
       // print(t, "the empty tree");
        t.fillSampleTree1();
       // print(t, "sample tree 1");
        t.fillSampleTree2();
        //print(t, "sample tree 2");
        t.fillSampleTree3();

        //t.print();
        //fibTree(5).print();
        //exprTree("((a+(5*(a+b)))+(6*5))").print();
        //BinaryTree a = exprTree("((a+(5*(9+1)))+(6*5))");
        //a.optimize();
        //a.print();
    }

    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    public static class TreeNode {

        public Object item;
        public TreeNode left;
        public TreeNode right;
        private static final String indent1 = "    ";

        public TreeNode(Object obj) {
            item = obj;
            left = right = null;
        }

        public TreeNode(Object obj, TreeNode left, TreeNode right) {
            item = obj;
            this.left = left;
            this.right = right;
        }

        private void printPreorder() {
            System.out.print(item + " ");
            if (left != null) {
                left.printPreorder();
            }
            if (right != null) {
                right.printPreorder();
            }
        }

        private void printInorder() {
            if (left != null) {
                left.printInorder();
            }
            System.out.print(item + " ");
            if (right != null) {
                right.printInorder();
            }
        }

        private void print(int indent) {
            // TODO your code here
            if (right != null) {
                right.print(indent + 1);
            }
            println (item, indent);
            // TODO your code here
            if (left != null) {
                left.print(indent + 1);
            }
        }

        private static void println(Object obj, int indent) {
            for (int k=0; k<indent; k++) {
                System.out.print(indent1);
            }
            System.out.println(obj);
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public Object getItem() {
            return item;
        }
    }
}
