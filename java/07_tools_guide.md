
---

### Файл: `07_tools_guide.md`

```markdown
# Руководство по инструментам JDK

В этом разделе описаны основные инструменты, входящие в JDK 25: компилятор, запускатор, JShell, Javadoc, jpackage и другие.

## Компиляция и запуск

- **javac** – компилятор.
  ```bash
  javac -d out src/*.java
  javac --enable-preview -source 25 src/*.java   # для preview