package cn.com.study.pool2.ftp.clients.ftp;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.Set;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeMBeanException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FTPPoolTest {

	public FTPPool ftpPool;

	@Before
	public void getFTPPool() {
		FTPPoolConfig ftpPoolConfig = new FTPPoolConfig();

		// 最小空闲连接
		ftpPoolConfig.setMinIdle(5);

		// 最大空闲连接
		ftpPoolConfig.setMaxIdle(10);

		// 最大池容量
		ftpPoolConfig.setMaxTotal(15);

		// 从池中取对象达到最大时,继续创建新对象.
//		ftpPoolConfig.setBlockWhenExhausted(false);
		ftpPoolConfig.setBlockWhenExhausted(true);

		// 池为空时取对象等待的最大毫秒数.
		ftpPoolConfig.setMaxWaitMillis(60 * 1000);

		// 取出对象时验证(此处设置成验证ftp是否处于连接状态).
		ftpPoolConfig.setTestOnBorrow(true);

		// 还回对象时验证(此处设置成验证ftp是否处于连接状态).
		ftpPoolConfig.setTestOnReturn(true);
		

		// 初始化连接数
		ftpPoolConfig.setInitialSize(ftpPoolConfig.getMaxIdle());

		FTPClientConfigure ftpClientConfig = new FTPClientConfigure();
		ftpClientConfig.setHost("127.0.0.1");
		ftpClientConfig.setPort(21);
		ftpClientConfig.setUsername("yangy11");
		ftpClientConfig.setPassword("yangyf");
		ftpClientConfig.setPassiveMode(true);

		ftpPool = new FTPPool(ftpPoolConfig, ftpClientConfig);
	}

	@After
	public void closeFTPPool() {
		try {
			 Thread.sleep(300 * 1000);
			ftpPool.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		}
	}

	@Test
	public void testGetNumActive() {
		System.out.println(ftpPool.getNumActive());
	}

	@Test
	public void testGetNumIdle() {
		System.out.println(ftpPool.getNumIdle());
	}

	@Test
	public void testGetNumWaiters() {
		System.out.println(ftpPool.getNumWaiters());
	}

}
