package cn.com.study.pool2.socket.clients.socket;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class SocketPoolConfig extends GenericObjectPoolConfig {

	private int initialSize;

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

}
