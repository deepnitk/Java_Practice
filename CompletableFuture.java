public static CompletableFuture<String> buildProfile() {

    CompletableFuture<String> userFuture =
            CompletableFuture.supplyAsync(() -> fetchUser());

    CompletableFuture<String> accountFuture =
            CompletableFuture.supplyAsync(() -> fetchAccount());

    return userFuture.thenCombine(
            accountFuture,
            (user, account) -> user + " - " + account
    );
}
