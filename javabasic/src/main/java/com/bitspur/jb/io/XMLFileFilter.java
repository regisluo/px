package com.bitspur.jb.io;

import java.io.File;
import java.io.FilenameFilter;

public class XMLFileFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {

		return name != null && name.endsWith(".xml");
	}

}
