package cn.com.study.pool2.ftp.clients.ftp;

import org.apache.commons.net.ftp.FTPClientConfig;

public class FTPClientConfigure extends FTPClientConfig {
	private String host;
	private int port;
	private String username;
	private String password;
	private int connectTimeout;

	/*
	 * Set the time to wait between sending control connection keepalive
	 * messages when processing file upload or download.
	 */
	private int keepAliveTimeout;

	// Set the internal buffer size for buffered data streams.
	private int bufferSize;

	// Set how long to wait for control keep-alive message replies.
	private int keepAliveReplyTimeout;

	private String encoding;
	
//	enterLocalActiveMode()
//Set the current data connection mode to ACTIVE_LOCAL_DATA_CONNECTION_MODE.
//void	enterLocalPassiveMode()
//Set the current data connection mode to PASSIVE_LOCAL_DATA_CONNECTION_MODE .
	private boolean passiveMode;
	
	private int transferFileType;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getKeepAliveTimeout() {
		return keepAliveTimeout;
	}

	public void setKeepAliveTimeout(int keepAliveTimeout) {
		this.keepAliveTimeout = keepAliveTimeout;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public int getKeepAliveReplyTimeout() {
		return keepAliveReplyTimeout;
	}

	public void setKeepAliveReplyTimeout(int keepAliveReplyTimeout) {
		this.keepAliveReplyTimeout = keepAliveReplyTimeout;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean isPassiveMode() {
		return passiveMode;
	}

	public void setPassiveMode(boolean passiveMode) {
		this.passiveMode = passiveMode;
	}

	public int getTransferFileType() {
		return transferFileType;
	}

	public void setTransferFileType(int transferFileType) {
		this.transferFileType = transferFileType;
	}


}
