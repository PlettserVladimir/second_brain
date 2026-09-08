
---

### Файл 9: 08-migration-guide.md

```markdown
# Руководство по миграции на Java 25

## Миграция с предыдущих версий

### Java 24 → Java 25

**Новые возможности**:
- Module Import Declarations (permanent)
- Compact Source Files (permanent)
- Flexible Constructor Bodies (permanent)
- Primitive Types in Patterns (3rd preview)

**Действия**:
1. Обновите JDK до версии 25
2. Протестируйте приложение
3. Рассмотрите использование новых возможностей

---

### Java 23 → Java 25

**Новые возможности**:
- Module Import Declarations (permanent)
- Compact Source Files (permanent)
- Flexible Constructor Bodies (permanent)

**Изменения**:
- Убедитесь, что preview features из Java 24 работают корректно
- Обновите зависимости

---

### Java 21 (LTS) → Java 25

**Новые возможности с Java 21**:
- Record Patterns (permanent)
- Pattern Matching for switch (permanent)
- Virtual Threads (permanent)
- Sequenced Collections
- String Templates (preview, withdrawn в Java 23)

**Breaking Changes**:
- Security Manager deprecated (с Java 17)
- Некоторые internal API могут быть недоступны

**Миграция**:
```bash
# Обновите build tool
# Maven
<java.version>25</java.version>

# Gradle
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}