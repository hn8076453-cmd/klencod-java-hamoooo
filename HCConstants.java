package gggv.hamo;

public class HCConstants {
    
    // مفاتيح ChaCha20 المطابقة لكود بايثون
    public static final byte[][] CHACHA_KEYS = {
        hexStringToByteArray("2be4342943c6f91ff58987f41a1aafd179eeb4e053f5cea55b11d6a7db58bd7d"),
        hexStringToByteArray("3380aa278b744ba5b529a7f32fa803e48749280dae378345d9b526cf1dbce372"),
        hexStringToByteArray("cea9305c95168b162a335b137c61983b8df54e6375da01136547890f14c5fac3"),
        hexStringToByteArray("4beeace0e42bae8f29470cf40cf2dfacd5f4e1f751912bf52e803c8c85792193"),
        hexStringToByteArray("f8e5f6ebea90558eb32229da24fd0fb7d813091dafe89bb2954fda33b4c60f63"),
        hexStringToByteArray("81342f558a6273bac4548d473f54c4ffc7c41747dee81369acab9c787d41ab9c"),
        hexStringToByteArray("45635e6fc70486e2fd10d3c2b4780f02d0b4c5f4aa929fc54f86bb8fa4417944"),
        hexStringToByteArray("3d632a251c9820f2baf83e15498d27548fc67921cb437f8ce48505989378adea")
    };

    // مفاتيح RST
    public static final byte[][] RST_KEYS = {
        "JN1k3YHc2.6_v235".getBytes(), "JN1k3YHc_2.7_v71".getBytes(), "JN1k3YHc2.7.ps69".getBytes(),
        "JN1k3YHc2.7.6950".getBytes(), "Jn1K3yHc2.8.ps08".getBytes(), "Jn1K3yHc2.9.ps6c".getBytes(),
        "Zk:L7>WKaiK*s9>D".getBytes(), "!<f!&WIlM**R.B0X".getBytes(), "b4a5opinx2uloec6".getBytes()
    };

    public static final byte[] STATIC_NONCE = {
        (byte)0xdb, (byte)0xdb, (byte)0xdb, (byte)0xdb, 
        (byte)0xdb, (byte)0xdb, (byte)0xdb, (byte)0xdb
    };

    public static final byte[] RST_XOR_KEY = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 
        12, 13, 14, 15, 16, 17, 18, 19, 20, 21
    };

    // دالة مساعدة لتحويل الـ Hex إلى مصفوفة بايتات
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
