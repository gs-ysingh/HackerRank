import java.util.*;

public class TaleOfStack {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if(stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
                return null;
            }

            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }

            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if(stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
                return null;
            }

            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }

            return stackOldestOnTop.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

/*
Input:

110186788
110186788
110186788
110186788
110186788
110186788
739711408
803703507
643797161
538560826
538560826
490282285
893666727
595679828
99908215
99908215
333969117
333969117
604624143
604624143

Output:

100
1 92118642
2
1 107858633
1 110186788
1 883309178
1 430939631
2
1 739711408
1 803703507
1 643797161
1 538560826
3
1 595864615
1 490282285
1 558095366
1 893666727
1 595679828
3
1 99908215
3
1 333969117
1 604624143
1 88712599
1 224459820
3
1 153072902
3
3
2
1 156974087
2
1 387224973
1 154628865
1 256130200
1 704295204
2
3
1 928499989
2
3
2
1 319507446
1 323714081
1 772087837
1 350417458
1 193303587
1 213700781
3
1 565379092
1 284925173
2
1 794176274
3
1 766929345
3
2
1 42983700
2
1 156768862
1 205008057
1 93223219
3
2
1 17818922
1 917626659
1 829031126
1 346173907
1 78065001
2
3
2
3
1 565004472
1 753139390
2
1 629441479
1 935933973
1 650043630
3
1 158726470
1 206429620
3
1 590439448
1 139555053
1 78707344
1 989497950
1 880166047
2
1 137608768
3
1 861823671
1 625166323
1 431218849
3
1 570007363
2
3
3
2
1 978253366*/
