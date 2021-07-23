package BinaryTree;

class Node {
    int elem;
    Node left;
    Node right;

    Node(int elem) {
        this.elem = elem;
    }
}

public class BinaryTree {
    Node root;

    public void addNode(int elem) {
        Node newNode = new Node(elem);
        Node root = this.root;

        if (root == null) {
            this.root = newNode;
        } else {
            insertNode(root, newNode);
        }
    }

    public void removeNode(int elem) {
        if (root == null) return;
        deleteNode(root, elem);
    }

    public void printAll() {
        inOrder(root);
    }

    private void insertNode(Node root, Node newNode) {
        if (root.elem < newNode.elem) {
            if (root.right == null) {
                root.right = newNode;
            }
            else {
                insertNode(root.right, newNode);
            }
        } else if (root.elem > newNode.elem){
            if (root.left == null) {
                root.left = newNode;
            } else {
                insertNode(root.left, newNode);
            }
        }
    }

    private Node deleteNode(Node root, int elem) {
        if (root == null) return null;

        if (root.elem > elem) {
            root.left = deleteNode(root.left, elem);
        } else if (root.elem < elem) {
            root.right = deleteNode(root.right, elem);
        } else {
            if (root.left == null && root.right == null) {
                if (this.root == root) {
                    this.root = null;
                } else {
                    root = null;
                }
            } else if (root.left == null) {
                if (this.root == root) {
                    this.root = root.right;
                } else {
                    root = root.right;
                }
            } else if (root.right == null) {
                if (this.root == root) {
                    this.root = root.left;
                } else {
                    root = root.left;
                }
            } else { // 양쪽 자식이 있을 때
                Node minNode = findMin(root.right);
                root.elem = minNode.elem;
                root.right = deleteNode(root.right, minNode.elem);
            }
        }

        return root;
    }

    private void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.elem + " ");
        inOrder(root.right);
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addNode(1);
        binaryTree.addNode(2);
        binaryTree.addNode(3);
        binaryTree.addNode(3);
        binaryTree.addNode(4);
        binaryTree.addNode(5);
        binaryTree.addNode(6);
        binaryTree.addNode(7);
        binaryTree.addNode(8);
        binaryTree.addNode(9);
        binaryTree.addNode(10);

        binaryTree.removeNode(1);
        binaryTree.removeNode(10);
        binaryTree.removeNode(5);
        binaryTree.removeNode(3);

        binaryTree.printAll();
    }
}
