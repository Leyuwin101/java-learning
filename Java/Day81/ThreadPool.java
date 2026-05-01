package Day81;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Job implements Runnable {
    private static final Random random = new Random();

    /// Global completed counter
    /// A thread safe integer
    /**
     * WHY NOT int?
     * - int is NOT safe when multiple threads modify it at the same time
     * - Race conditions can happen (lost updates)
     * HOW AtomicInteger solves it:
     * - It uses low-level CPU operations (CAS = Compare-And-Swap)
     * - Ensures updates are done safely without locking
     */
    private static AtomicInteger completedJobs = new AtomicInteger(0);

    /// Per-thread counter
    /// A thread safe version of hashmap
    /**
     * WHY NOT HashMap?
     * - HashMap is NOT safe in multi-threading
     * - Can corrupt data if multiple threads write at the same time
     * HOW ConcurrentHashMap works:
     * - Allows multiple threads to read/write safely
     * - Uses internal segmentation / lock-free techniques
     * - Much faster than using synchronized HashMap
     */
    private static ConcurrentHashMap<String, AtomicInteger> threadJobCount = new ConcurrentHashMap<>();

    private int jobId;

    public Job(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        /// init thread counter if not exists
        /**
         * Ensures each thread has its own counter.
         * If the thread name is not yet in the map,
         * initialize it with a new AtomicInteger(0)
         */
        threadJobCount.putIfAbsent(threadName, new AtomicInteger(0));


        System.out.println(threadName + " started job " + jobId);

        try {
            Thread.sleep(random.nextInt(2000));

            if (random.nextInt(100) < 20) {
                throw new RuntimeException("Job " + jobId + " failed randomly");
            }

            /// mark success
            completedJobs.incrementAndGet();
            threadJobCount.get(threadName).incrementAndGet();

            System.out.println(threadName + " finished job " + jobId);
        } catch (InterruptedException e) {
            System.out.println("Job interrupted");
        }
    }

    public static void printStats() {
        System.out.println("\n===== FINAL STATS =====");
        System.out.println("Total completed job: " + completedJobs.get());

        threadJobCount.forEach((thread, count) -> {
            System.out.println(thread + " handled: " + count.get() + " jobs");
        });
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        /// Task → Queue → Thread Pool → Worker Threads execute

        /// 1. Fixed Thread Pool
        /// Executors.newFixedThreadPool(3);
        /// fixed number of threads
        /// best for controlled workloads


        /// 2. Cached Thread Pool
        /// Executors.newCachedThreadPool();
        /// creates threads as needed
        /// destroys idle ones
        /// can grow unlimited

        /// 3. Single Thread Executor
        /// Executors.newSingleThreadExecutor();
        /// one thread only
        /// tasks run sequentially

        /// 4. Scheduled Thread Pool
        /// Executors.newScheduledThreadPool(2);
        /// run delayed / repeated tasks
        /// like timers
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 12; i++) {
            pool.submit(new Job(i));
        }

        pool.shutdown();

        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Job.printStats();
    }
}
