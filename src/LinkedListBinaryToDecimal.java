/**
 * Created by YSingh on 30/04/17.
 */
class LinkedListNode {
    int val;
    LinkedListNode next;

    public LinkedListNode(int val) {
        this.val = val;
        this.next = null;
    }
};
public class LinkedListBinaryToDecimal {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.next = new LinkedListNode(0);
        head.next.next = new LinkedListNode(1);
        head.next.next.next = new LinkedListNode(1);
        head.next.next.next.next = new LinkedListNode(0);
        head.next.next.next.next.next = new LinkedListNode(1);
        head.next.next.next.next.next.next = new LinkedListNode(0);
        System.out.println(getNumber(head));
    }
    static long getNumber(LinkedListNode binary) {
        LinkedListNode node = reverseLinkedList(binary);
        long sum = 0;
        long index = 0;
        while (node != null) {
            sum = sum + (node.val * (long)Math.pow(2, index));
            node = node.next;
            index++;
        }
        return sum;
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode currentNode) {
        LinkedListNode previousNode = null;
        LinkedListNode nextNode;
        while(currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next=previousNode;
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return previousNode;
    }
}
