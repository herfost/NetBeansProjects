package security;

import org.apache.commons.codec.digest.DigestUtils;

final public class SHA256Encrypter implements IEncryption {

    public SHA256Encrypter() {
    }

    @Override
    public String encrypt(String data) {
        return DigestUtils.sha256Hex(data);
    }
}
