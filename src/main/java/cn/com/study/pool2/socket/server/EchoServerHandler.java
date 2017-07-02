package cn.com.study.pool2.socket.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoServerHandler implements Runnable {

	private Socket socket;

	private String encoding;

	public EchoServerHandler(Socket socket) {
		this(socket, "UTF-8");
	}

	public EchoServerHandler(Socket socket, String encoding) {
		this.socket = socket;
		this.encoding = encoding;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		BufferedWriter out = null;

		try {
			in = new BufferedReader(new InputStreamReader(
					this.socket.getInputStream(), this.encoding));
			out = new BufferedWriter(new OutputStreamWriter(
					this.socket.getOutputStream(), this.encoding));

			String getMsg;
			while ((getMsg = in.readLine()) != null
					&& !"bye".equalsIgnoreCase(getMsg)) {
				// 客户端未提出"bye"命令，则循环交流
				System.out.println("The echo server received message:" + getMsg
						+ " from client(" + socket.getLocalAddress() + ")");
				out.append("Hello [" + socket.getInetAddress()
						+ "],the echo server received your message:" + getMsg
						+ "\r\n");
				out.flush();
			}

		} catch (Exception e) {
			System.out.println("当前Socket连接结束......");
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				out = null;
			}

			if (this.socket != null) {
				try {
					this.socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				this.socket = null;
			}
		}
	}

}
