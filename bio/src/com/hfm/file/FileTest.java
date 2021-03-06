package com.hfm.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author hfm
 * @Description 文件类常用方法使用
 * @date 2021-06-15
 */
public class FileTest {
    /**
     * 静态成员：系统默认路径分隔符与系统默认名称分隔符
     */
    @Test
    public void staticFiled() {
        // 系统默认路径分隔符
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        // 系统默认名称分隔符
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }

    /**
     * 构造函数：三种构造函数创建 File 对象
     */
    @Test
    public void getFile() {
        // main 方法的当前目录为工程根目录
        // @Test junit 单元测试方法的当前目录为当前module 模块的目录

        /// 构造方法一：通过路径名，创建 file 对象，file 对象代表文件
        File file = new File("Resources\\txt\\test.txt");
        // 获取文件名
        System.out.println(file.getName());

        /// 构造方法二：通过子父路径创建file 类对象
        String parentPath = "Resources\\txt";
        String child = "test.txt";
        File file2 = new File(parentPath, child);
        // 获取文件名
        System.out.println(file2.getName());

        /// 构造方法三：通过父目录创建file 对象
        // 创建父目录
        File parentDir = new File("Resources\\txt");
        File file3 = new File(parentDir, child);
        // 获取文件名
        System.out.println(file3.getName());
    }

    /**
     * 获取方法:获取文件或者文件夹的相关信息
     */
    @Test
    public void getFunction() throws IOException {
        // 通过路径名，创建file 对象，file对象代表目录
        File dir = new File("Resources\\txt");
        // 获取路径/文件名
        System.out.println(dir.getName());
        // 返回此抽象路径名称的绝对形式。
        System.out.println(dir.getAbsoluteFile());
        // 获取绝对路径
        System.out.println(dir.getAbsolutePath());
        // 获取相对路径
        System.out.println(dir.getPath());
        // 返回此抽象路径名称的规范路径名称字符串。
        System.out.println(dir.getCanonicalPath());
        // 返回此抽象路径名称的规范形式。
        System.out.println(dir.getCanonicalFile());
        // 返回此抽象路径名称命名的分区中未分配的字节数。
        System.out.println(dir.getFreeSpace());
        // 获取父路径
        System.out.println(dir.getParent());
        // 返回此抽象路径名称的父目录的抽象路径名称，或者如果此路径名不命名父目录。
        System.out.println(dir.getParentFile());
        // 返回由此抽象路径名称命名的分区的大小。
        System.out.println(dir.getTotalSpace());
        // 返回此抽象路径名称命名的分区上可用于此虚拟机的字节数。
        System.out.println(dir.getUsableSpace());

        // 返回此抽象路径名称表示的文件的大小。
        System.out.println("文件大小" + dir.length());

        // 最后修改时间
        File file = new File("Resources\\txt\\test.txt");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println("最后的修改时间：" + dateFormat.format(file.lastModified()));

        // 创建时间戳对象，并转化为 toLocalDateTime对象
        System.out.println("最后的修改时间：" + new Timestamp(file.lastModified()).toLocalDateTime());
    }

    /**
     * 判断方法
     */
    @Test
    public void judgeFunction() throws IOException {
        File file = new File("Resources\\txt\\test.txt");

        // 判断文件是否存在
        System.out.println(file.exists());
        // 判断是否为文件
        System.out.println(file.isFile());
        // 判断是否为文件夹
        System.out.println(file.isDirectory());
        // 判断是否为绝对路径
        System.out.println(file.isAbsolute());
        // 判断是否隐藏
        System.out.println(file.isHidden());
        // 判断是否可以执行
        System.out.println(file.canExecute());
        // 判断是否可读
        System.out.println(file.canRead());
        // 判断是否可写
        System.out.println(file.canWrite());

        // 如果文件不存在创建新的空文件
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     * 创建方法
     */
    @Test
    public void createFile() throws IOException {
        File file = new File("Resources\\txt\\test.txt");
        File dir = new File("Resources\\txt");

        // 如果文件不存在，创建此文件
        System.out.println("创建一个空文件：" + file.createNewFile());
        // 如果目录不存在，创建由此抽象路径名称命名的目录。
        System.out.println("创建一个单级文件夹：" + dir.mkdir());
        // 创建由此抽象路径名称命名的目录，包括任何必要但不存在的父目录。
        System.out.println("创建一个多级文件夹：" + dir.mkdirs());
    }

    /**
     * 重命名
     */
    @Test
    public void renameFile() {
        File file = new File("Resources\\txt\\test.txt");

        // 重命名由此抽象路径名称表示的文件。
        /*
         * 操作文件：如果源文件与目标文件在同一级路径下，那么renameTo方法的作用是重命名，
         * 如果源文件与目标文件不在同一级目录下，那么renameTo 的作用就是剪切。
         * 操作文件夹：如果源文件夹与目标文件夹在同一级路径下，那么renameTo方法的作用是重命名,
         * 如果源文件夹与目标文件夹不在同一级目录下,那么 renameTo不起作用（不能用于剪切文件夹）。
         */
        System.out.println("重命名文件名：" + file.renameTo(new File("bio\\Resources\\txt\\Test.txt")));
    }

    /**
     * 删除方法
     */
    @Test
    public void deleteFile() {
        File file = new File("Resources\\txt\\test.txt");

        // 删除文件或一个空文件夹，如果是文件夹且不为空，则不能删除，成功返回 true，失败返回 false。
        file.delete();
        // 在虚拟机终止时，请求删除此抽象路径名表示的文件或目录，保证程序异常时创建的临时文件也可以被删除
        file.deleteOnExit();
    }

    /**
     * 设置方法
     */
    public void setFile() {
        File file = new File("Resources\\txt\\test.txt");

        // 设置可执行
        file.setExecutable(true);
        // 设置仅当前用户可执行
        file.setExecutable(true, true);
        // 设置最后修改时间
        file.setLastModified(System.currentTimeMillis());
        // 设置可读
        file.setReadable(true);
        // 设置仅当前用户可读
        file.setReadable(true, true);
        // 设置仅读
        file.setReadOnly();
        // 设置可写
        file.setWritable(true);
        // 设置仅当前用户可写
        file.setWritable(true, true);
    }

    /**
     * 文件夹相关
     */
    @Test
    public void dirFunction() {
        File dir = new File("Resources\\txt");

        // 返回目录下的文件或者目录名，包含隐藏文件。对于文件这样操作会返回 null。
        String[] arr = dir.list();
        for (String str : arr) {
            System.out.println(str);
        }
        // 列出所有的盘符
        File[] files = File.listRoots();
        for (File f : files) {
            System.out.println(f);
        }
        // 把子文件与子目录存储到一个数组中返回。
        File[] f2 = dir.listFiles();
        for (File fileItem : f2) {
            System.out.println(fileItem.getName());
        }
    }
}
