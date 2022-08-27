// Name: Andrew Chou
// Class: CSS430
// ------------------------------------------QueueNode.java----------------------------------------------
// This QueueNode.java implements the vectors storage to store the threadID to be used by SyncQueue.java
//	  This java file consists of default constructor which is to initialize vector, sleep function to remove
//       item from queue, wakeup function to add item to queue.
//
// -------------------------------------------------------------------------------------------------------


/*
 * This is a template of QueueNode.java. Change this file name into QueueNode.java
 * and implement the logic.
 */

import java.util.*;

public class QueueNode {
    private Vector<Integer> tidQueue; // maintains a list of child TIDs who called wakeup( ).

    public QueueNode( ) {
	// Implement this constructor.
        // initialize vector
        tidQueue = new Vector();
    }

    public synchronized int sleep( ) {
	// If tidQueue has nothing, call wait( ).
    // Otherwise, get one child TID from tidQueue.
	// return it.
        if(tidQueue.size() == 0){
            wait();
            return tidQueue.remove(0);
	
        }
        return -1;
    }

    public synchronized void wakeup( int tid ) {
	// Add this child TID to tidQueue.
        tidQueue.add(tid);
	// Notify the parent.
        notify();
    }
}
