# Руководство по установке JDK 25

В этом разделе описана установка JDK 25 и JRE 25 на основные платформы.

## Системные требования

- **Windows**: Windows 10/11 (64-bit), минимум 2 ГБ ОЗУ.
- **macOS**: macOS 12 или новее (Apple Silicon и Intel).
- **Linux**: glibc 2.17+, 64-bit.

## Установка на Windows

1. Скачайте установщик `.exe` с [официального сайта](https://www.oracle.com/java/technologies/downloads/).
2. Запустите установщик и следуйте инструкциям.
3. После установки настройте переменные окружения:
   - `JAVA_HOME = C:\Program Files\Java\jdk-25`
   - Добавьте `%JAVA_HOME%\bin` в `PATH`.
4. Проверьте: `java -version` и `javac -version`.

## Установка на macOS

1. Скачайте `.dmg` файл.
2. Откройте его и перетащите JDK в папку `/Library/Java/JavaVirtualMachines/`.
3. Настройте переменные (добавьте в `~/.zshrc` или `~/.bash_profile`):
   ```bash
   export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-25.jdk/Contents/Home
   export PATH=$JAVA_HOME/bin:$PATH