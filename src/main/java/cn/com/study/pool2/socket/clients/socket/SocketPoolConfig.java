package cn.com.study.pool2.socket.clients.socket;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class SocketPoolConfig extends GenericObjectPoolConfig {
	@Inject(optional=true)
	@Override
	public void setMaxIdle(@Named("maxIdle") int maxIdle) {
		// TODO Auto-generated method stub
		super.setMaxIdle(maxIdle);
	}

	@Inject(optional=true)
	@Override
	public void setMaxTotal(@Named("maxTotal") int maxTotal) {
		// TODO Auto-generated method stub
		super.setMaxTotal(maxTotal);
	}

	@Inject(optional=true)
	@Override
	public void setMinIdle(@Named("minIdle") int minIdle) {
		// TODO Auto-generated method stub
		super.setMinIdle(minIdle);
	}

	@Inject(optional=true)
	@Override
	public void setBlockWhenExhausted(@Named("blockWhenExhausted") boolean blockWhenExhausted) {
		// TODO Auto-generated method stub
		super.setBlockWhenExhausted(blockWhenExhausted);
	}

	@Inject(optional=true)
	@Override
	public void setEvictionPolicyClassName(@Named("evictionPolicyClassName") String evictionPolicyClassName) {
		// TODO Auto-generated method stub
		super.setEvictionPolicyClassName(evictionPolicyClassName);
	}

	@Inject(optional=true)
	@Override
	public void setFairness(@Named("fairness") boolean fairness) {
		// TODO Auto-generated method stub
		super.setFairness(fairness);
	}

	@Inject(optional=true)
	@Override
	public void setJmxEnabled(@Named("jmxEnabled") boolean jmxEnabled) {
		// TODO Auto-generated method stub
		super.setJmxEnabled(jmxEnabled);
	}

	@Inject(optional=true)
	@Override
	public void setJmxNameBase(@Named("jmxNameBase") String jmxNameBase) {
		// TODO Auto-generated method stub
		super.setJmxNameBase(jmxNameBase);
	}

	@Inject(optional=true)
	@Override
	public void setJmxNamePrefix(@Named("jmxNamePrefix") String jmxNamePrefix) {
		// TODO Auto-generated method stub
		super.setJmxNamePrefix(jmxNamePrefix);
	}

	@Inject(optional=true)
	@Override
	public void setLifo(@Named("lifo") boolean lifo) {
		// TODO Auto-generated method stub
		super.setLifo(lifo);
	}

	@Inject(optional=true)
	@Override
	public void setMaxWaitMillis(@Named("maxWaitMillis") long maxWaitMillis) {
		// TODO Auto-generated method stub
		super.setMaxWaitMillis(maxWaitMillis);
	}

	@Inject(optional=true)
	@Override
	public void setMinEvictableIdleTimeMillis(@Named("minEvictableIdleTimeMillis") long minEvictableIdleTimeMillis) {
		// TODO Auto-generated method stub
		super.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	}
	
	@Inject(optional=true)
	@Override
	public void setNumTestsPerEvictionRun(@Named("numTestsPerEvictionRun") int numTestsPerEvictionRun) {
		// TODO Auto-generated method stub
		super.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
	}

	@Inject(optional=true)
	@Override
	public void setSoftMinEvictableIdleTimeMillis(
			@Named("softMinEvictableIdleTimeMillis") long softMinEvictableIdleTimeMillis) {
		// TODO Auto-generated method stub
		super.setSoftMinEvictableIdleTimeMillis(softMinEvictableIdleTimeMillis);
	}

	@Inject(optional=true)
	@Override
	public void setTestOnBorrow(@Named("testOnBorrow") boolean testOnBorrow) {
		// TODO Auto-generated method stub
		super.setTestOnBorrow(testOnBorrow);
	}

	@Inject(optional=true)
	@Override
	public void setTestOnCreate(@Named("testOnCreate") boolean testOnCreate) {
		// TODO Auto-generated method stub
		super.setTestOnCreate(testOnCreate);
	}

	@Inject(optional=true)
	@Override
	public void setTestOnReturn(@Named("testOnReturn") boolean testOnReturn) {
		// TODO Auto-generated method stub
		super.setTestOnReturn(testOnReturn);
	}

	@Inject(optional=true)
	@Override
	public void setTestWhileIdle(@Named("testWhileIdle") boolean testWhileIdle) {
		// TODO Auto-generated method stub
		super.setTestWhileIdle(testWhileIdle);
	}

	@Inject(optional=true)
	@Override
	public void setTimeBetweenEvictionRunsMillis(
			@Named("timeBetweenEvictionRunsMillis") long timeBetweenEvictionRunsMillis) {
		// TODO Auto-generated method stub
		super.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	}

	
	private int initialSize;

	public int getInitialSize() {
		return initialSize;
	}

	@Inject(optional=true)
	public void setInitialSize(@Named("initialSize") int initialSize) {
		this.initialSize = initialSize;
	}

	@Override
	public String toString() {
		return "SocketPoolConfig [initialSize=" + initialSize
				+ ", getInitialSize()=" + getInitialSize() + ", getMaxTotal()="
				+ getMaxTotal() + ", getMaxIdle()=" + getMaxIdle()
				+ ", getMinIdle()=" + getMinIdle() + ", getLifo()=" + getLifo()
				+ ", getFairness()=" + getFairness() + ", getMaxWaitMillis()="
				+ getMaxWaitMillis() + ", getMinEvictableIdleTimeMillis()="
				+ getMinEvictableIdleTimeMillis()
				+ ", getSoftMinEvictableIdleTimeMillis()="
				+ getSoftMinEvictableIdleTimeMillis()
				+ ", getNumTestsPerEvictionRun()="
				+ getNumTestsPerEvictionRun() + ", getTestOnCreate()="
				+ getTestOnCreate() + ", getTestOnBorrow()="
				+ getTestOnBorrow() + ", getTestOnReturn()="
				+ getTestOnReturn() + ", getTestWhileIdle()="
				+ getTestWhileIdle() + ", getTimeBetweenEvictionRunsMillis()="
				+ getTimeBetweenEvictionRunsMillis()
				+ ", getEvictionPolicyClassName()="
				+ getEvictionPolicyClassName() + ", getBlockWhenExhausted()="
				+ getBlockWhenExhausted() + ", getJmxEnabled()="
				+ getJmxEnabled() + ", getJmxNameBase()=" + getJmxNameBase()
				+ ", getJmxNamePrefix()=" + getJmxNamePrefix()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
