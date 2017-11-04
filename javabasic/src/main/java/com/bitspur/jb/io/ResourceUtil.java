package com.bitspur.jb.io;

import java.io.Closeable;
import java.io.IOException;

public class ResourceUtil {
	public static void close(Closeable... resource) {
		if (resource != null && resource.length > 0) {
			for (Closeable r : resource) {
				try {
					if (r != null) {
						r.close();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void close(AutoCloseable... resource) {
		if (resource != null && resource.length > 0) {
			for (AutoCloseable r : resource) {
				try {
					if (r != null) {
						r.close();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
