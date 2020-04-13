package com.hfm.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EcodingAndDecoding {
    /**
     * 编码与解码
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            // 编码：字符串—->字节数组
            "String".getBytes();
            "String".getBytes("UTF-8");
            // 解码：字节数组-->字符串
            // 使用系统默认码表
            new String(new byte[1024]);
            new String(new byte[1024], "GBK");
            // 乱码
            System.out.println(new String("中文".getBytes("utf-8"), "GBK"));
            System.out.println(new String("中文".getBytes("utf-8"), "utf-8"));

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String str = "中国";
        // 编码 看得懂的变成看不懂的...
        // gbk
        byte[] buf = str.getBytes();
        // [-42, -48, -71, -6]
        System.out.println("gbk 码表编码值：" + Arrays.toString(buf));
        // 使用 utf-8 码表进行编码
        buf = str.getBytes("utf8");
        System.out.println("utf-8 码表编码值：" + Arrays.toString(buf));
        // 【-28, -72, -83, -27,-101,-67】
        // 解码过程
        // gbk
        String result = new String(buf, "utf-8");
        System.out.println("解码的结果：" + result);
        /*
         * 出现了乱码数据都可以还原数据成功吗？不是，如果码表范围小的化不能还原
         */
        String str2 = "中国";
        // 使用了 gbk 码表进行编码 [-42, -48, -71, -6]
        buf = str2.getBytes("gbk");
        // 使用拉丁码表解码
        str2 = new String(buf, "iso8859-1");
        // 需求：使用还原中国。
        // 第一步：找到这四个字符对应的数字
        buf = str2.getBytes("iso8859-1");
        str2 = new String(buf, "gbk");
        System.out.println(str2);
        // -2, -1, 是 utf-16 的标识位。
        // [-2, -1, 93, -34, 0, 97, 94, 127]
        String str3 = "州a广";
        byte[] buf2 = str3.getBytes("unicode");
        // 注意：编码的时候如果使用了 unicode 码表，那么默认就会使用 utf-16 码表
        System.out.println("字节数组：" + Arrays.toString(buf2));
    }
}
