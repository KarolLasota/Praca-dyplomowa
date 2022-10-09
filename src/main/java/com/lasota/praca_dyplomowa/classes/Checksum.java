package com.lasota.praca_dyplomowa.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class Checksum {

    public static String getChecksum(MessageDigest messageDigest, File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] byteBuffer = new byte[512];
        int length;
        while ((length = fileInputStream.read(byteBuffer)) > -1) {
            messageDigest.update(byteBuffer,0, length);
        }
        byte[] hashBytes = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashBytes)
        {
            stringBuilder.append(String.format("%02X", b));
        }
        return stringBuilder.toString();
    }
}
