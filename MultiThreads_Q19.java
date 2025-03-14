/*
19. Multithreaded programming:
Write a program MultiThreads that creates two threads-one thread with the name CSthread and the other thread named ITthread.

Each thread should
display its respective name and execute after a gap of 500 milliseconds. Each thread should also display a number indicating the number of times it got a chance to execute.
*/

public class MultiThreads {
    public static void main(String[] args) {
        // Create two thread objects
        Thread csThread = new Thread(new CustomThread("CSthread"));
        Thread itThread = new Thread(new CustomThread("ITthread"));
        
        // Set thread names
        csThread.setName("CSthread");
        itThread.setName("ITthread");
        
        // Start the threads
        csThread.start();
        itThread.start();
    }
}

// Custom thread class implementing Runnable interface
class CustomThread implements Runnable {
    private String threadName;
    private int executionCount;
    
    // Constructor
    public CustomThread(String name) {
        this.threadName = name;
        this.executionCount = 0;
    }
    
    @Override
    public void run() {
        try {
            // Run the thread 10 times
            for (int i = 1; i <= 10; i++) {
                // Increment execution count
                executionCount++;
                
                // Display thread name and execution count
                System.out.println(threadName + " executing - Count: " + executionCount);
                
                // Sleep for 500 milliseconds
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
        
        System.out.println(threadName + " completed execution.");
    }
} 