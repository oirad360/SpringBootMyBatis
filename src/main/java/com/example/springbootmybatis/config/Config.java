package com.example.springbootmybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.example.springbootmybatis.soapclient.MySOAPClient;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	  public Jaxb2Marshaller marshaller() {
	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	    // this package must match the package in the <generatePackage> specified in
	    // pom.xml
	    marshaller.setContextPath("com.example.springbootmybatis.wsdl");
	    return marshaller;
	  }

	  @Bean
	  public MySOAPClient mySOAPClient(Jaxb2Marshaller marshaller) {
		MySOAPClient client = new MySOAPClient();
	    client.setDefaultUri("http://localhost:8080/MyWebProject/MySOAPWS");
	    client.setMarshaller(marshaller);
	    client.setUnmarshaller(marshaller);
	    return client;
	  }
}
