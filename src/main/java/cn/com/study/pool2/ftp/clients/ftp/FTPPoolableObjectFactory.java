package cn.com.study.pool2.ftp.clients.ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class FTPPoolableObjectFactory extends
		BasePooledObjectFactory<FTPClient> {

	private final FTPClientConfigure config;

	public FTPPoolableObjectFactory(FTPClientConfigure config) {
		this.config = config;
	}

	@Override
	public void activateObject(PooledObject<FTPClient> pooledFTPClient)
			throws Exception {
		// TODO Auto-generated method stub
		super.activateObject(pooledFTPClient);
	}

	@Override
	public FTPClient create() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroyObject(PooledObject<FTPClient> pooledFTPClient)
			throws Exception {
		FTPClient ftpClient = (FTPClient) pooledFTPClient.getObject();
		try {
			if (ftpClient != null && ftpClient.isConnected()) {
				ftpClient.logout();
			}
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			// 注意,一定要在finally代码中断开连接，否则会导致占用ftp连接情况
			try {
				ftpClient.disconnect();
			} catch (IOException io) {
				// io.printStackTrace();
			}
		}
	}

	@Override
	public PooledObject<FTPClient> makeObject() throws Exception {
		FTPClient ftpClient = new FTPClient();
		ftpClient.configure(config);

		ftpClient.connect(config.getHost(), config.getPort());
		ftpClient.setConnectTimeout(config.getConnectTimeout());

		ftpClient.login(config.getUsername(), config.getPassword());
		if (config.isPassiveMode()) {
			ftpClient.enterLocalPassiveMode();
		} else {
			ftpClient.enterLocalActiveMode();
		}

		ftpClient.setControlEncoding(config.getEncoding());

		ftpClient.setFileType(config.getTransferFileType());

		return wrap(ftpClient);
	}

	@Override
	public void passivateObject(PooledObject<FTPClient> pooledFTPClient)
			throws Exception {
		super.passivateObject(pooledFTPClient);
	}

	@Override
	public boolean validateObject(PooledObject<FTPClient> pooledFTPClient) {
		FTPClient ftpClient = (FTPClient) pooledFTPClient.getObject();
		try {
			return ftpClient.sendNoOp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return false;
	}

	@Override
	public PooledObject<FTPClient> wrap(FTPClient ftpClient) {
		return new DefaultPooledObject<FTPClient>(ftpClient);
	}

}
