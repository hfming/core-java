package com.hfm.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileTest {

	public static void main(String[] args) throws IOException {
		File file = new File("src/com/edu/cjlu/hfm/file/test.txt");
		File dir = new File("src");
		System.out.println(file.getCanonicalPath());
		System.out.println(file.exists());
		if (!file.exists()) {
			file.createNewFile();
		}
		// 创建
		System.out.println("创建一个空文件：" + file.createNewFile());
		System.out.println("创建一个单级文件夹：" + dir.mkdir());
		System.out.println("创建一个多级文件夹：" + dir.mkdirs());
		System.out.println("重命名文件名：" + file.renameTo(new File("Test.txt")));
		/*
		 * 操作文件：如果源文件与目标文件在同一级路径下，那么renameTo方法的作用是重命名，
		 * 如果源文件与目标文件不在同一级目录下，那么renameTo 的作用就是剪切。
		 * 操作文件夹：如果源文件夹与目标文件夹在同一级路径下，那么renameTo方法的作用是重命名,
		 * 如果源文件夹与目标文件夹不在同一级目录下,那么 renameTo不起作用（不能用于剪切文件夹）。
		 */
		// 删除
		// file.delete();删除文件或一个空文件夹，如果是文件夹且不为空，则不能删除，成功返回 true，失败返回 false。
		// file.deleteOnExit();在虚拟机终止时，请求删除此抽象路径名表示的文件或目录，保证程序异常时创建的临时文件也可以被删除
		// 判断
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.isAbsolute());
		System.out.println(file.isHidden());
		// 获取
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.length());
		System.out.println(file.getParent());

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println("最后的修改时间：" + dateFormat.format(file.lastModified()));
		// 文件夹相关
		String[] arr = dir.list();// 返回目录下的文件或者目录名，包含隐藏文件。对于文件这样操作会返回 null。
		for (String str : arr) {
			System.out.println(str);
		}
		File[] files = File.listRoots();// 列出所有的盘符
		for (File f : files) {
			System.out.println(f);
		}
		File[] f2 = dir.listFiles(); // 把子文件与子目录存储到一个数组中返回。
		for (File fileItem : f2) {
			System.out.println(fileItem.getName());
		}
	}
}
