// Name: Andrew Chou
// Class: CSS430
// ------------------------------------------SyncQueue.java----------------------------------------------
// This SyncQueue.java implements the vectors to store vectors type item (consisting of thread ID)
//    The queue ("vector") are implemented based of the QueueNode.java file.
//	  This java file consists of initQueue functions, two constructors, enqueueAndSleep functions and
//    	2 dequeueAndWakeUp functions.
//
// -------------------------------------------------------------------------------------------------------


/*
 * This is a template of SyncQueue.java. Chagne this file name into SyncQueue.java and
 * complete the implementation
 */
public class SyncQueue {
    
	// don't add any new data members
	private QueueNode queue[] = null;
    private final int COND_MAX = 10;
    private final int NO_TID = -1;

	// don't change this private function
    private void initQueue( int condMax ) {
		queue = new QueueNode[ condMax ];
		for ( int i = 0; i < condMax; i++ )
			queue[i] = new QueueNode( );
	}

    public SyncQueue( ) {
	// You need to implement this constructor.
	// Assume SyncQueue( COND_MAX );
		queue = new QueueNode[COND_MAX];
		for(int i = 0; i < COND_MAX; i++){
			queue[i] = new QueueNode();
		}
    }

    public SyncQueue( int condMax ) {
	// You need to implement this constructor.
		queue = new QueueNode[condMax];
		for(int i = 0 ; i < condMax; i++){
			queue[i] = new QueueNode();
		}
    }

    int enqueueAndSleep( int condition ) {
	// Verify the correctness of condition.
		if(condition < queue.length){
	// Call the corresponding queue[ ].sleep( ).
	// Return the corresponding child thread ID.
			return queue[condition].sleep();
		}
		// error
		return -1;
    }

    void dequeueAndWakeup( int condition, int tid ) {
	// verify the correctness of condition.
		if(condition < queue.length){
	// Call the corresponding queue[ ].wakeup( ... );
			queue[condition].wakeup(tid);
		}
    }

    void dequeueAndWakeup( int condition ) {
	// Assume tid = 0.
		if(condition < queue.length){
			queue[condition].wakeup(NO_TID);
		}
    }
}
