package cn.com.study.pool2.ftp.clients.ftp;

import org.apache.commons.net.ftp.FTPClient;

import cn.com.study.pool2.ftp.clients.util.Pool;

public class FTPPool extends Pool<FTPClient> {

	public FTPPool(FTPPoolConfig ftpPoolConfig,
			FTPClientConfigure ftpClientConfig) {
		super(ftpPoolConfig, new FTPPoolableObjectFactory(ftpClientConfig));
		super.addObject(ftpPoolConfig.getInitialSize());
	}

	@Override
	public FTPClient getResource() {
		return super.getResource();
	}

	@Override
	public void returnResource(FTPClient resource) {
		super.returnResource(resource);
	}

	@Override
	public void returnInvalidateResource(FTPClient resource) {
		super.returnInvalidateResource(resource);
	}

	
}
