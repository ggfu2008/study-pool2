/**
 * 
 */
package cn.com.study.pool2.socket.clients.socket.exceptions;

/**
 * @author Yangyf
 *
 */
public class SocketClientException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7028937478919121371L;

	/**
	 * 
	 */
	public SocketClientException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SocketClientException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public SocketClientException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SocketClientException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
