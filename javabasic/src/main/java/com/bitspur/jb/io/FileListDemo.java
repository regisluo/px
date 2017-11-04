package com.bitspur.jb.io;

import java.io.File;
import java.io.FilenameFilter;

public class FileListDemo {
	public static void main(String[] args) {
		File file = new File(".");

		System.out.println("case 1 ------------");
		String[] files0 = file.list();
		for (String f : files0) {
			System.out.println(f);
		}

		/*
		 * list the file with a filter
		 */
		System.out.println("\ncase 2 ------------");
		XMLFileFilter xmlFileFilter = new XMLFileFilter();
		String[] files = file.list(xmlFileFilter);
		for (String f : files) {
			System.out.println(f);
		}

		System.out.println("\ncase 3 ------------");
		String[] ss = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name != null && name.endsWith("classpath");
			}
		});
		for (String f : ss) {
			System.out.println(f);
		}
	}
}
