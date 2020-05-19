package com.hfm.fileutils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-05 11:57
 */
public class FileUtilsTest {
    public static void main(String[] args) throws IOException {
        File fileInput = new File("file-io\\Resources\\Image\\IMG_1.jpg");
        File fileout = new File("file-io\\Resources\\Image\\IMG_10.jpg");
        // 使用第三方包
        FileUtils.copyFile(fileInput, fileout);
    }
}
