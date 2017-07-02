package cn.com.study.pool2.socket.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			port = Integer.getInteger(args[1]);
		}

		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedReader reader = null;

		try {
			socket = new Socket("127.0.0.1", port);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(System.in));

			String msg;
			while (true) {
				msg = reader.readLine();
				out.println(msg);
				out.flush();
				if (msg.equals("bye")) {
					break;
				}
				System.out.println(in.readLine());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("The echo client close");
			if (out != null) {
				out.close();
				out = null;
			}

			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				socket = null;
			}
		}

	}

}
