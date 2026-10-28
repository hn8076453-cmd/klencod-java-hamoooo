package gggv.hamo;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HCDecryptor {

    // جدول أسماء الحقول المطابق لثوابت البوت
    public static final Map<Integer, String> TOKEN_MAP = new HashMap<Integer, String>() {{
        put(0, "payload");
        put(1, "proxy");
        put(2, "lockAllConfig");
        put(3, "blockedByRoot");
        put(4, "expiryTime");
        put(5, "noteEnabled");
        put(6, "notes");
        put(7, "sshField");
        put(8, "mobileDataAndLockProvider");
        put(9, "unlockUserAndPass");
        put(10, "ovpnConfig");
        put(11, "ovpnUserAndPass");
        put(12, "sni");
        put(13, "unlockUserAndPass2");
        put(14, "unknown14");
        put(15, "blockedByHwid");
        put(16, "cloudconfig");
        put(17, "psiphon");
        put(18, "name");
        put(19, "blockArea");
        put(20, "connectionMode");
        put(21, "blockedByPassword");
        put(22, "unknown22");
        put(23, "extraSniffer");
        put(24, "psiphon2");
        put(25, "v2rayEnabled");
        put(26, "v2rayConfig");
        put(27, "version");
        put(28, "slowdnsEnabled");
        put(29, "slowdnsServer");
        put(30, "slowdnsPublickey");
        put(31, "dnsResolver");
    }};

    // دالة استخراج المحتوى الأولي من الملف
    public static String extractInitialPayload(byte[] fileBytes, String hexKey) {
        try {
            byte[] keyBytes = HCConstants.hexStringToByteArray(hexKey);
            int kLen = keyBytes.length;
            byte[] decryptedBytes = new byte[fileBytes.length];
            
            for (int i = 0; i < fileBytes.length; i++) {
                decryptedBytes[i] = (byte) (fileBytes[i] ^ keyBytes[i % kLen]);
            }
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    // دالة فك التشفير العامة التي ستربط كل العمليات ببعضها
    public static String executeDecryption(byte[] fileBytes) {
        String hexPayload = extractInitialPayload(fileBytes, "e382e4b8adc386f09f9293");
        if (hexPayload == null || hexPayload.isEmpty()) {
            return "❌ فشل استخراج البيانات الأولية من الملف.";
        }
        
        // سيتم ربط باقي الخوارزميات هنا تباعاً
        return "✅ تم قراءة البيانات بنجاح، وجاري استكمال خوارزميات الفك.";
    }
}
