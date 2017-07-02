/**
 * 
 */
package cn.com.study.pool2.socket.clients.socket;

import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author Yangyf
 *
 */
public class SocketPoolableObjectFactory extends
		BasePooledObjectFactory<Socket> {

	private final SocketClientConfig config;
	
	public SocketPoolableObjectFactory(SocketClientConfig config) {
		this.config = config;
	}

	@Override
	public Socket create() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PooledObject<Socket> wrap(Socket socket) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<Socket>(socket);
	}

	@Override
	public PooledObject<Socket> makeObject() throws Exception {
		Socket socket = new Socket();

        socket.setReuseAddress(config.isReuseAddress());
        
        socket.setKeepAlive(config.isKeepAlive());

        socket.setTcpNoDelay(config.isTcpNoDelay());

        socket.setSoLinger(config.isSoLinger(), 0);

        socket.connect(new InetSocketAddress(config.getHost(), config.getPort()), config.getConnectTimeout());
        
        socket.setSoTimeout(config.getSoTimeout());
		
		return wrap(socket);
	}

	@Override
	public void destroyObject(PooledObject<Socket> pooledSocket) throws Exception {
		Socket socket = (Socket) pooledSocket.getObject();
		if (isConnected(socket)){
			socket.close();
		}
	}

	@Override
	public boolean validateObject(PooledObject<Socket> pooledSocket) {
		Socket socket = (Socket) pooledSocket.getObject();
		return isConnected(socket);
	}

	@Override
	public void activateObject(PooledObject<Socket> pooledSocket) throws Exception {
		// TODO Auto-generated method stub
		super.activateObject(pooledSocket);
	}

	@Override
	public void passivateObject(PooledObject<Socket> pooledSocket) throws Exception {
		// TODO Auto-generated method stub
		super.passivateObject(pooledSocket);
	}

	
	private boolean isConnected(Socket socket) {
	    return ((socket != null) && (socket.isBound()) && (!(socket.isClosed())) && (socket.isConnected()) && 
	      (!(socket.isInputShutdown())) && (!(socket.isOutputShutdown())));
	}
}
