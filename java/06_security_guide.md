
---

### Файл: `06_security_guide.md`

```markdown
# Руководство по безопасности Java

Этот раздел охватывает криптографические API, управление политиками безопасности, SSL/TLS и новые функции JDK 25: KDF (JEP 510) и PEM (JEP 470).

## Java Cryptography Architecture (JCA)

JCA предоставляет набор API для шифрования, хеширования, подписей и генерации ключей.

**Основные классы:**
- `MessageDigest` – хеширование (SHA-256, SHA-512).
- `Signature` – цифровые подписи (RSA, ECDSA).
- `Cipher` – шифрование (AES, RSA).
- `KeyGenerator`, `KeyPairGenerator` – генерация ключей.
- `SecretKeyFactory`, `KeyFactory` – преобразование ключевых спецификаций.

**Пример: шифрование AES**
```java
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

void main() throws Exception {
    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(256);
    SecretKey key = keyGen.generateKey();

    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encrypted = cipher.doFinal("Secret data".getBytes());
    System.out.println(Base64.getEncoder().encodeToString(encrypted));
}