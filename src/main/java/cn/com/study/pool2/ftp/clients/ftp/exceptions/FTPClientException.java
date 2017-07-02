/**
 * 
 */
package cn.com.study.pool2.ftp.clients.ftp.exceptions;

/**
 * @author Yangyf
 *
 */
public class FTPClientException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7028937478919121371L;

	/**
	 * 
	 */
	public FTPClientException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public FTPClientException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public FTPClientException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FTPClientException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
