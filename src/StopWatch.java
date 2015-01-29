/**
 * Created by lyz on 15-1-28.
 */
public class StopWatch {
    private final long start_time;

    public StopWatch() {
        start_time = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long stop_time = System.currentTimeMillis();
        return (stop_time - start_time) / 1000.0;
    }
}
