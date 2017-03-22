import java.util.Scanner;

/**
 * Created by YSingh on 23/03/17.
 */

public class Contacts {
    public static class Node {
        int size;
        Node [] nodes;

        public Node() {
            this.size = 0;
            this.nodes = new Node[26];
        }

        public int findCount(String contact) {
            return findCount(contact, 0);
        }

        private int findCount(String contact, int index) {
            if(contact.length() == index) {
                return size;
            }

            char c = contact.charAt(index);
            int i = c - 'a';
            Node node = nodes[i];

            if(node == null) {
                return 0;
            }

            return node.findCount(contact, index + 1);
        }

        public void add(String contact) {
            add(contact, 0);
        }

        private void add(String contact, int index) {
            size++;
            if(contact.length() == index) {
                return;
            }
            char c = contact.charAt(index);
            int i = c - 'a';
            Node node = nodes[i];

            if(node == null) {
                node = new Node();
                this.nodes[i] = node;
            }
            node.add(contact, index + 1);
        }
    }

    public static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void add(String contact) {
            this.root.add(contact.toLowerCase());
        }

        public int findCount(String contact) {
            if(contact.length() == 0) {
                return 0;
            }
            return this.root.findCount(contact.toLowerCase());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Trie t = new Trie();

        for(int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) {
                t.add(contact);
            }
            else {
                System.out.println(t.findCount(contact));
            }
        }
    }
}
