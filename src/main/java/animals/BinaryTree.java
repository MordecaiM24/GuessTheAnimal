package animals;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    Scanner input = new Scanner(System.in);

    Node root;

    public BinaryTree(String question){
        this.root = new Node(question);
    }

    class Node {
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
            right = null;
            left = null;
        }

        public String getValue() {
            return value;
        }


    }

    public static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }


    public void replace(HashMap<String, String> info) {
        Node current = new Node(info.get("question"));
        current.left = new Node(info.get("false"));
        current.right = new Node(info.get("true"));

        root = current;
    }


    public String getAnimal(String animal) {
        return containsNodeRecursive(root);
    }

    private String containsNodeRecursive (Node current) {
        if (!isLeaf(current)){
            System.out.println(current.getValue());
            String answer = input.nextLine().toLowerCase();
            return answer.equals("no") ?
                    containsNodeRecursive(current.left) :
                    containsNodeRecursive(current.right);
        } else {
            return current.value;
        }

    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }



}
