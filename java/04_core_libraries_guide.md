
---

### Файл: `04_core_libraries_guide.md`

```markdown
# Руководство по Core Libraries Java

Этот раздел охватывает фундаментальные библиотеки Java SE, а также новые возможности JDK 25: Scoped Values и Structured Concurrency.

## Основные пакеты

### java.lang
- `Object`, `String`, `StringBuilder`, `Math`, классы-обёртки.

### java.util
- **Collections Framework**: `List`, `Set`, `Map`, `ArrayList`, `HashMap`, итераторы.
- **Stream API**: функциональные операции над потоками.
- **Optional**: контейнер для nullable значений.

### java.io и java.nio
- Потоки байт и символов, каналы, буферы, файловые системы.

### java.time (JSR-310)
- `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `Duration`, `Period`.

### java.net
- Сокеты, URL, HTTP-клиент (с Java 11).

## 🚀 Новые возможности Core Libraries в Java 25

### Scoped Values (JEP 506)

Scoped Values – это типизированные, неизменяемые контейнеры для передачи данных в потоках. Они пришли на смену `ThreadLocal` для виртуальных потоков, так как не требуют очистки и эффективны.

**Пример: передача контекста пользователя**

```java
import java.util.concurrent.ScopedValue;
import java.util.concurrent.StructuredTaskScope;

public class ScopedValueExample {
    private static final ScopedValue<String> USER_ID = ScopedValue.newInstance();
    private static final ScopedValue<Map<String, String>> HEADERS = ScopedValue.newInstance();

    void main() {
        Map<String, String> headers = Map.of("X-Request-Id", "abc123");
        ScopedValue.where(USER_ID, "user-456")
                   .where(HEADERS, headers)
                   .run(() -> processRequest());
    }

    void processRequest() {
        String userId = USER_ID.get();
        var headers = HEADERS.get();
        System.out.println("Processing for " + userId + ", headers: " + headers);

        // Виртуальный поток наследует значения автоматически
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            scope.fork(() -> {
                System.out.println("Child thread user: " + USER_ID.get());
                return "done";
            });
            scope.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}