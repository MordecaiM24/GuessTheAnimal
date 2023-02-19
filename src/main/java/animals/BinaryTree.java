package animals;

import java.util.Scanner;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTree {
    Scanner input = new Scanner(System.in);

    Node root;

    public BinaryTree(HashMap<String, String> initial){
        this.root = new Node(initial.get("question"));
        root.left = new Node (initial.get("false"));
        root.right = new Node (initial.get("true"));
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


    public void replace(HashMap<String, String> info, Node current) {
        current.value = info.get("question");
        current.left = new Node(info.get("false"));
        current.right = new Node(info.get("true"));
    }


    public void getAnimal() {
        Node expected = containsNodeRecursive(root);
        System.out.println("Is your animal " + expected.value);
        if(input.nextLine().equals("no")) {
            System.out.println("I give up. What animal do you have in mind?");

            HashMap<String, String> facts = Communication.animalInfo(expected.value, input.nextLine());
            System.out.println("I learned the following facts about animals: ");
            System.out.println(" - The " + facts.get("true") + " " + facts.get("fact"));
            System.out.println(" - The " + facts.get("false") + " " + Communication.negate(facts.get("fact")));
            System.out.print("I can distinguish these animals by asking the question: \n - ");
            System.out.println(facts.get("question") + "\n");

            replace(facts,expected);

        }
        System.out.println("Nice! I've learned so much about animals!\n");
        System.out.println("Would you like to play again");
    }

    private Node containsNodeRecursive (Node current) {
        if (!isLeaf(current)){
            System.out.println(current.getValue());
            String answer = input.nextLine().toLowerCase();
            return answer.equals("no") ?
                    containsNodeRecursive(current.left) :
                    containsNodeRecursive(current.right);
        } else {
            return current;
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
