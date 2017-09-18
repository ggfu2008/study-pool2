package cn.com.study.pool2.socket.clients.socket;

import java.net.Socket;

import cn.com.study.pool2.socket.clients.util.Pool;


public class SocketPool extends Pool<Socket> {

	public SocketPool(SocketPoolConfig socketPoolConfig,
			SocketClientConfig socketClientConfig) {
		super(socketPoolConfig, new SocketFactory(socketClientConfig));
		super.addObject(socketPoolConfig.getInitialSize());
	}

	@Override
	public Socket getResource() {
		return super.getResource();
	}

	@Override
	public void returnResource(Socket resource) {
		super.returnResource(resource);
	}

	@Override
	public void returnInvalidateResource(Socket resource) {
		super.returnInvalidateResource(resource);
	}

	
}
