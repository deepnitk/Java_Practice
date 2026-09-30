public static CompletableFuture<String> fetchUser(int id) {
    return CompletableFuture.completedFuture("John");
}

public static CompletableFuture<String> fetchOrders(String user) {
    return CompletableFuture.completedFuture(
            "Orders for " + user
    );
}

public static CompletableFuture<String> fetchUserOrders(int id) {
    // your code
  return fetchUser(id)
            .thenCompose(user -> fetchOrders(user));
}
