public class Counter {

    // choose the field/type yourself
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        // implement
        count.incrementAndGet();
    }

    public int getCount() {
        // implement
        return count.get();
    }
}
