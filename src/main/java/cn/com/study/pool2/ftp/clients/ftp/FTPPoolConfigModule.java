package cn.com.study.pool2.ftp.clients.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

public class FTPPoolConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		InputStream stream = this.getClass().getResourceAsStream("ftppool.config.properties");
        Properties p = new Properties();
        try {
            p.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            assert false;
        }
//        Enumeration e = p.keys();
//        while(e.hasMoreElements()) {
//            String key = (String)e.nextElement();
//            String value = (String)p.get(key);
//            bindConstant().annotatedWith(Names.named("key")).to(value);//类似于绑定了一个常量
//        }
        Names.bindProperties(binder(), p);
    }

	public static void main(String[] args) {
		 Injector injector = Guice.createInjector(new FTPPoolConfigModule());  
		 FTPPoolConfig poolConfig =injector.getInstance( FTPPoolConfig.class);
		 
		 System.out.println(poolConfig.toString());
	}
}
