package queues;

public class QueueUse {

	public static void main(String[] args) {
		try {
			QueueUsingLL<Integer> queue = new QueueUsingLL<>();

			queue.enqueue(8);
			queue.enqueue(200);
			queue.enqueue(5);
			queue.enqueue(2);
			queue.dequeue();
			queue.dequeue();
//			queue.dequeue();
			queue.enqueue(20);
			queue.enqueue(20);
			queue.enqueue(20);
			queue.enqueue(20);
			
//			System.out.println(queue.rear());
			while(!queue.isEmpty()) {
				System.out.println(queue.front());
				queue.dequeue();
			}
			
		}catch(QueueEmptyException qe) {
			qe.printStackTrace();
		}
		

	}

}
