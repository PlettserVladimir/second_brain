import java.util.concurrent.ScopedValue;

private static final ScopedValue<String> USER = ScopedValue.newInstance();

void main() {
    ScopedValue.where(USER, "alice").run(() -> {
        System.out.println("User: " + USER.get());
        // В виртуальных потоках значение наследуется
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            scope.fork(() -> { System.out.println(USER.get()); return ""; });
            scope.join();
        } catch (Exception e) { /* ... */ }
    });
}