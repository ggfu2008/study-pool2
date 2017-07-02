package cn.com.study.pool2.ftp.clients.util;

import java.io.Closeable;
import java.io.IOException;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import cn.com.study.pool2.ftp.clients.ftp.exceptions.FTPClientException;

public abstract class Pool<T> implements Closeable {

	protected GenericObjectPool<T> internalPool;

	public Pool() {
	}

	public Pool(GenericObjectPoolConfig poolConfig,
			PooledObjectFactory<T> factory) {
		initPool(poolConfig, factory);
	}

	private void initPool(GenericObjectPoolConfig poolConfig,
			PooledObjectFactory<T> factory) {
		if (this.internalPool != null)
			try {
				closeInternalPool();
			} catch (Exception localException) {
			}
		this.internalPool = new GenericObjectPool<T>(factory, poolConfig);
	}

	protected void closeInternalPool() {
		try {
			this.internalPool.close();
		} catch (Exception e) {
			throw new FTPClientException("Could not destroy the pool", e);
		}
	}

	public void close() throws IOException {
		closeInternalPool();
	}

	public boolean isClosed() {
		return this.internalPool.isClosed();
	}

	public T getResource() {
		try {
			return this.internalPool.borrowObject();
		} catch (Exception e) {
			throw new FTPClientException(
					"Could not get a resource from the pool", e);
		}
	}

	public void returnResource(T resource) {
		if (resource == null) {
			return;
		}
		try {
			this.internalPool.returnObject(resource);
		} catch (Exception e) {
			throw new FTPClientException(
					"Could not return the resource to the pool", e);
		}
	}

	public void returnInvalidateResource(T resource) {
		if (resource == null) {
			return;
		}
		try {
			this.internalPool.invalidateObject(resource);
		} catch (Exception e) {
			throw new FTPClientException(
					"Could not return the resource to the pool", e);
		}
	}

	public void addObject(int count) {
		try {
			for (int i = 0; i < count; i++) {
				this.internalPool.addObject();
			}
		} catch (Exception e) {
			throw new FTPClientException("Error trying to add idle objects", e);
		}
	}

	public int getNumActive() {
		if (poolInactive()) {
			return -1;
		}
		return this.internalPool.getNumActive();
	}

	public int getNumIdle() {
		if (poolInactive()) {
			return -1;
		}

		return this.internalPool.getNumIdle();
	}

	public int getNumWaiters() {
		if (poolInactive()) {
			return -1;
		}

		return this.internalPool.getNumWaiters();
	}

	public long getMeanBorrowWaitTimeMillis() {
		if (poolInactive()) {
			return -1L;
		}

		return this.internalPool.getMeanBorrowWaitTimeMillis();
	}

	public long getMaxBorrowWaitTimeMillis() {
		if (poolInactive()) {
			return -1L;
		}

		return this.internalPool.getMaxBorrowWaitTimeMillis();
	}

	private boolean poolInactive() {
		return ((this.internalPool == null) || (this.internalPool.isClosed()));
	}

}
