package edu.rice.habanero.benchmarks.astar;

import edu.rice.habanero.benchmarks.BenchmarkRunner;
import edu.rice.habanero.concurrent.executors.PriorityWstTaskExecutor;
import edu.rice.habanero.concurrent.executors.TaskExecutor;
import edu.rice.habanero.concurrent.wstdeque.PoolType;

/**
 * @author <a href="http://shams.web.rice.edu/">Shams Imam</a> (shams@rice.edu)
 */
public class PriorityWstCilkDequeBenchmark extends AbstractBenchmark {

    public static void main(final String[] args) {
        BenchmarkRunner.runBenchmark(args, new PriorityWstCilkDequeBenchmark());
    }

    @Override
    protected TaskExecutor createTaskExecutor() {
        final int numThreads = BenchmarkRunner.numThreads();
        final int minPriorityInc = BenchmarkRunner.minPriority();
        final int maxPriorityInc = BenchmarkRunner.maxPriority();
        return new PriorityWstTaskExecutor(
                PoolType.CILK, numThreads, minPriorityInc, maxPriorityInc);
    }
}
