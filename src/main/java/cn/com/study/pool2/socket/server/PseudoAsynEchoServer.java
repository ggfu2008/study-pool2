package cn.com.study.pool2.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PseudoAsynEchoServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			port = Integer.getInteger(args[0]);
		}

		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The echo server is start in port:" + port);

			Socket socket = null;
			EchoServerHandlerExecutePool singleExecutor = new EchoServerHandlerExecutePool(
					50, 10000);
			while (true) {
				socket = server.accept();
				System.out.println("The echo client connection successful, IP:"
						+ socket.getInetAddress());
				singleExecutor.execute(new EchoServerHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("The echo server close");
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
