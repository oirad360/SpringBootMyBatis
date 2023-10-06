package com.example.springbootmybatis.soapclient;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.springbootmybatis.wsdl.Addizione;
import com.example.springbootmybatis.wsdl.AddizioneResponse;

public class MySOAPClient extends WebServiceGatewaySupport{
	public AddizioneResponse addizione(int a, int b) {
		Addizione request = new Addizione();
		request.setArg0(a);
		request.setArg1(b);
		AddizioneResponse response = (AddizioneResponse) getWebServiceTemplate()
		        .marshalSendAndReceive("http://localhost:8080/MyWebProject/MySOAPWS", request);

		    return response;
	}
}
