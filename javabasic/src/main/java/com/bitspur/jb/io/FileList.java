package com.bitspur.jb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Enumeration;

public class FileList implements Enumeration<InputStream> {

	private File[] files;
	private int index = 0;

	public FileList(File... files) {
		super();
		this.files = files;
	}

	@Override
	public boolean hasMoreElements() {
		return index < files.length;
	}

	@Override
	public InputStream nextElement() {
		InputStream in = null;
		try {
			in = new FileInputStream(files[index]);
			index++;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return in;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
