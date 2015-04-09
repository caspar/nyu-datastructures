
public class QueueTester{

    public static void main(String[] args) {

        Queue<Integer> q = new Queue<Integer>();

        System.out.println(q.peek());
        System.out.println(q.enqueue(10)); //10
        System.out.println(q.enqueue(20)); //10, 20    "20"
        System.out.println(q.enqueue(30)); //10, 20, 30  "30"
        System.out.println(q.enqueue(40)); //10, 20, 30  "30"
        System.out.println(q.enqueue(50)); //10, 20, 30  "30"
        System.out.println(q);
        System.out.println(q.peek()); //"10"
        q.dequeue(); //20, 30
        System.out.println(q.peek()); //"20"
        q.dequeue(); //30
        System.out.println(q.peek()); //"30
        q.dequeue(); //30
        System.out.println(q.peek()); //"30
        q.dequeue(); //30
        System.out.println(q.peek()); //"30
        q.dequeue(); //30
        System.out.println(q.peek()); //"30
        q.dequeue(); //30
        System.out.println(q.peek()); 

    }
}
