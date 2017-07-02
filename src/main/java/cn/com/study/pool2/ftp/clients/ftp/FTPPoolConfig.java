package cn.com.study.pool2.ftp.clients.ftp;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class FTPPoolConfig extends GenericObjectPoolConfig {

	private int initialSize;

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

}
