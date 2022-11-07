package com.aurora.aurorawallet.utils

import org.bouncycastle.util.encoders.Base64
import javax.crypto.*
import javax.crypto.spec.SecretKeySpec

object AESEncryptor {

    fun encrypt(input: String, password: String): String {
        val keySpec = SecretKeySpec(password.toByteArray(Charsets.UTF_8),"AES")
        val cipher = Cipher.getInstance("AES/ECB/PKCS7Padding")
        cipher.init(Cipher.ENCRYPT_MODE, keySpec)
        val encrypt = cipher.doFinal(input.toByteArray())
        return String(Base64.encode(encrypt))
    }
}