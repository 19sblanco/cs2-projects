public class BinarySearchTree<E extends Comparable <E>> {
    private TreeNode root;

    public boolean insert(E value) {
        // special case for empty tree
        if (root == null) {
            this.root = new TreeNode(value);
        }
        else {
            TreeNode parent = null;
            TreeNode node = root;

            while (node != null) {
                parent = node;
                if (node.data.compareTo(value) < 0) {
                    node = node.right;
                }
                else if (node.data == value) {
                    return false;
                }
                else {
                    node = node.left;
                }
            }

            TreeNode nodeNew = new TreeNode(value);
            if (parent.data.compareTo(value) < 0) {
                parent.right = nodeNew;
            }
            else if (parent.data.compareTo(value) > 0){
                parent.left = nodeNew;
            }
        }
        return true;
    }

    // make work with values not in tree, if not in tree return false
    public boolean remove(E value) {
        // find the node to delete and the parent of the node to delete
        TreeNode parent = null;
        TreeNode node = root;
        boolean done = false;
        //////////
        while (!done) {
            if (node == null) {
                return false;
            }
            if (node.data.compareTo(value) < 0) {
                parent = node;
                node = node.right;
            }
            else if (node.data.compareTo(value) > 0) {
                parent = node;
                node = node.left;
            }
            else {
                done = true;
            }
        }

        // case 1: the node to delete has no left child
        if (node.left == null) {
            if (parent == null) {
                root = node.right;
            }
            else {
                if (parent.data.compareTo(value) < 0 ) {
                    parent.right = node.right;
                }
                else {
                    parent.left = node.right;
                }
            }
        }
        // case for left child
        else {
            TreeNode parentOfRight = node;
            TreeNode rightMost = node.left;
            // Traverse as far right as possible
            while (rightMost.right != null) {
                parentOfRight = rightMost;
                rightMost = rightMost.right;
            }
            node.data = rightMost.data;
            if (parentOfRight.right == rightMost) {
                parentOfRight.right = rightMost.left;
            }
            else {
                parentOfRight.left = rightMost.left;
            }
        }
        return true;
    }

    public boolean search(E value) {
        TreeNode node = root;
        while (node != null) {
            if (node.data.compareTo(value) == 0) {
                return true;
            }
            if (node.data.compareTo(value) < 0) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }

        return false;
    }

    public int numberNodes() {
        return numberNodesRecursion(root);
    }

    private int numberNodesRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + numberNodesRecursion(node.left) + numberNodesRecursion(node.right);
    }

    public int numberLeafNodes() {
        return numberLeafNodesRecursion(root);
    }

    private int numberLeafNodesRecursion(TreeNode node) {
        // base case
        if (node == null) {
            return 0;
        }
        if (node.right == null && node.left == null) {
            return 1;
        }

        // recursive step
        return numberLeafNodesRecursion(node.right) + numberLeafNodesRecursion(node.left);
    }

    public int height() {
        return heightRecursion(root) - 1;
    }

    private int heightRecursion(TreeNode node) {
        // base case
        if (node == null) {
            return 0;
        }

        // recursive step
        int left = 0;
        int right = 0;

        if (node.left != null) {
            left = heightRecursion(node.left);
        }
        if (node.right != null) {
            right = heightRecursion(node.right);
        }

        return Math.max(left, right) + 1;
    }

    public void display(String message) {
        System.out.println(message);
        traverseInOrder(root);
    }

    private void traverseInOrder(TreeNode node) {
        if (node == null) return;

        traverseInOrder(node.left);
        System.out.println(node.data);
        traverseInOrder(node.right);
    }

    private class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(E data) {
            this.data = data;
        }
    }
}
