import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

void main() throws Exception {
    KeyGenerator keyGen = KeyGenerator.getInstance("HKDF");
    keyGen.init(256);
    byte[] ikm = "secret".getBytes();
    SecretKey key = keyGen.generateKey(ikm, "AES");
    System.out.println("Key algorithm: " + key.getAlgorithm());
}