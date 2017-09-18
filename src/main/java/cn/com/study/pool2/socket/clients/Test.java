package cn.com.study.pool2.socket.clients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;


public class Test {

	
	 private static class Client {
	        @Inject
	        @Named("server.ip")
	        private String IP;
	        
	        @Inject
	        @Named("server.port")
	        private int port;
	        
	        @Inject
	        @Named("server.username")
	        private String username;
	        
	        @Inject
	        @Named("server.password")
	        private String password;

	        public void work() {
	            System.out.println("ip=" + IP);
	            System.out.println("port=" + port);
	            System.out.println("username=" + username);
	            System.out.println("password=" + password);
	            //
	        }
	    }
	 
	  public static void main(String[] args) {
	        Injector injector = Guice.createInjector(new Module() {
	            @SuppressWarnings("unchecked")
	            public void configure(Binder binder) {
	            	InputStream stream = this.getClass().getResourceAsStream("socketpool.config.properties");
	                Properties p = new Properties();
	                try {
	                    p.load(stream);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    assert false;
	                }
//	                Enumeration e = p.keys();
//	                while(e.hasMoreElements()) {
//	                    String key = (String)e.nextElement();
//	                    String value = (String)p.get(key);
//	                    binder.bindConstant().annotatedWith(Names.named("config." + key)).to(value);
//	                }
	                
	                Names.bindProperties(binder, p);
	            }
	        });
	        
	        Client client = injector.getInstance(Client.class);
	        client.work();
	    }
}
