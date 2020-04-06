package com.hfm.io;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterUtil implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				if (f.getName().endsWith(name)) {
					System.out.println(f.getName().toString());
				}
			} else if (f.isDirectory()) {
				accept(f,name);
			}
		}
		return false;
	}

}
