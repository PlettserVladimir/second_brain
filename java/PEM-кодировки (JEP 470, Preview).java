import java.util.Base64;
import java.security.KeyPairGenerator;
import java.security.KeyPair;

void main() throws Exception {
    KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
    kg.initialize(2048);
    KeyPair kp = kg.generateKeyPair();

    String pem = "-----BEGIN PUBLIC KEY-----\n" +
        Base64.getMimeEncoder(64, new byte[]{'\n'})
              .encodeToString(kp.getPublic().getEncoded()) +
        "\n-----END PUBLIC KEY-----";
    System.out.println(pem);
}