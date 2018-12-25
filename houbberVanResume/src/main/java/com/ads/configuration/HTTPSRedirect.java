package com.ads.configuration;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HTTPSRedirect {
	
	/**
	 * 配置内置的servlet容器工厂为tomcat.
	 * 
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {

			@Override
			protected void postProcessContext(Context context) {

				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		// 添加连接配置，主要是http的配置信息.
		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	/**
	 * 配置一个http连接信息.
	 * 
	 * @return
	 */
	private Connector initiateHttpConnector() {
		Connector connector = new Connector(
				"org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		// Connector监听的http的端口号
		connector.setPort(8088);
		connector.setSecure(false);
		// 监听到http的端口号后转向到的https的端口号
		connector.setRedirectPort(8443);
		return connector;
	}
}
