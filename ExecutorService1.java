public static List<Integer> calculateSquares(
        List<Integer> numbers) throws Exception {
  ExecutorService es = Executors.newFixedThreadPool(3);
  try {
    List<Future<Integer>> futures = new ArrayList<>();
    for (Integer num: numbers) {
      Future<Integer> future = es.submit(() -> num * num);
      futures.add(future);
    }
    List<Integer> res = new ArrayList<>();
    for(Future<Integer> f: futures) {
      res.add(f.get());
    }
    return res;
  }
  finally {
    es.shutdown();
  }
}
