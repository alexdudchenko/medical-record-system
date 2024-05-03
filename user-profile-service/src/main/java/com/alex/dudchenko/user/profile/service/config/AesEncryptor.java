package com.alex.dudchenko.user.profile.service.config;

import jakarta.persistence.AttributeConverter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Configuration
public class AesEncryptor implements AttributeConverter<Object, String> {

    @Value("${aes.encryption.key}")
    private String keyString;

    @Value("${aes.encryption.algo}")
    private String algo;

    private Key key;

    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(Object o) {
        if (o == null) return null;
        Cipher cipher = getInitializedCipher(Cipher.ENCRYPT_MODE);
        byte[] bytes = SerializationUtils.serialize(o);
        if (bytes == null) return null;
        return Base64.getEncoder().encodeToString(cipher.doFinal(bytes));
    }

    @Override
    @SneakyThrows
    public Object convertToEntityAttribute(String s) {
        if (s == null) return null;
        Cipher cipher = getInitializedCipher(Cipher.DECRYPT_MODE);
        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(s));
        return SerializationUtils.deserialize(bytes);
    }

    @SneakyThrows
    private Cipher getInitializedCipher(int encryptionMode) {
        Cipher cipher = Cipher.getInstance(algo);
        cipher.init(encryptionMode, getKey());
        return cipher;
    }

    private Key getKey() {
        if (keyString == null || algo == null) throw new IllegalStateException("Properties haven't been set");
        if (key == null) {
            key = new SecretKeySpec(keyString.getBytes(), algo);
        }
        return key;
    }
}
