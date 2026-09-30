private final ConcurrentHashMap<String, Integer> counts =
        new ConcurrentHashMap<>();
void record(String word) {
  counts.merge(word, 1, Integer::sum);
  //use compute, computeIfAbsent, putIfAbsent, ,merge for thread safe operations
}
