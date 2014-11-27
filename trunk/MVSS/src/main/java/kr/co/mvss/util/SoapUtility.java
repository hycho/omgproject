package kr.co.mvss.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

public class SoapUtility {
	String wsdlURL;
	String namespace;
	String serviceName;

	Service service;
	QName serviceQN;

	public SoapUtility() {
	}

	public SoapUtility(String wsdlURL, String namespace, String serviceName) throws MalformedURLException, ServiceException {
		this.wsdlURL = wsdlURL;
		this.namespace = namespace;
		this.serviceName = serviceName;
		init();
	}

	public void init() throws ServiceException, MalformedURLException {
		ServiceFactory serviceFactory = ServiceFactory.newInstance();
		this.service = serviceFactory.createService(new URL(wsdlURL), serviceQN);
		this.serviceQN = new QName(namespace, serviceName);
	}

	public void init(String wsdlURL, String namespace, String serviceName, QName serviceQN) throws MalformedURLException, ServiceException {
		this.wsdlURL = wsdlURL;
		this.namespace = namespace;
		this.serviceName = serviceName;
		init();
	}

	public SOAPMessage sendSoapMessage(Map<String, Object> parameters) {
		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage requestMessage = messageFactory.createMessage();
			
			javax.xml.soap.MimeHeaders headers = requestMessage.getMimeHeaders();
			if(parameters.get("SOAPAction") != null)
				headers.setHeader("SOAPAction", (String) parameters.get("SOAPAction"));

			javax.xml.soap.SOAPPart soapPart = requestMessage.getSOAPPart();

			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
			envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
			envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
			if(parameters.get("namespace") != null)
				envelope.addNamespaceDeclaration("ws", (String) parameters.get("namespace"));
			if(parameters.get("encodingStyle") != null)
				envelope.setEncodingStyle((String) parameters.get("encodingStyle"));

			SOAPFactory soapFactory = SOAPFactory.newInstance();

			SOAPHeader header = envelope.getHeader();
			
			if(parameters.get("header") != null) {
				Map<String, Object> inputHeader = (Map<String, Object>) parameters.get("header");
				
				SOAPHeaderElement headerElement = null;
				Name name;
				
				if(inputHeader.get("name") != null) {
					name = soapFactory.createName((String) inputHeader.get("name"));
					headerElement = header.addHeaderElement(name);
				}
				if(inputHeader.get("actor") != null) {
					headerElement.setActor((String) inputHeader.get("actor"));
				}
				if(inputHeader.get("mustUnderstand") != null) {
					headerElement.setMustUnderstand(Boolean.valueOf((String)inputHeader.get("mustUnderstand")));
				}
				if(inputHeader.get("elements") != null) {
					Map<String, Object> elements = (Map<String, Object>) inputHeader.get("elements");
			        for (String key : elements.keySet()) {
						name = soapFactory.createName(key);
						SOAPElement element = headerElement.addChildElement(name);
						element.addTextNode((String) elements.get(key));
			        }
				}
			}

			SOAPBody body = envelope.getBody();

			if(parameters.get("body") != null) {
				Map<String, Object> inputBody = (Map<String, Object>) parameters.get("body");
				
				SOAPBodyElement bodyElement = null;
				Name name;
				
				if(inputBody.get("name") != null) {
					name = soapFactory.createName((String) inputBody.get("name"), null, null); //soapFactory.createName("CheckUserAccount", null, (String) parameters.get("namespace"));
					bodyElement = body.addBodyElement(name);
				}
				if(inputBody.get("elements") != null) {
					Map<String, Object> elements = (Map<String, Object>) inputBody.get("elements");
			        for (String key : elements.keySet()) {
						name = soapFactory.createName(key);
						SOAPElement element = bodyElement.addChildElement(name);
						if(elements.get(key) instanceof Map)
							addSubElement(soapFactory, element, (Map<String, Object>) elements.get(key));
						else
							element.addTextNode((String) elements.get(key));
			        }
				}
			}

/*			
			URL url = new URL("file:///home/kwon37xi/.vimrc");
			String contentId = "attached_image";

			DataHandler dataHandler = new DataHandler(url);
			AttachmentPart attachment =
			requestMessage.createAttachmentPart(dataHandler);
			attachment.setContentId(contentId);

			requestMessage.addAttachmentPart(attachment);
			
			SOAPFault fault = body.addFault();
			fault.setFaultCode(envelope.getPrefix() + ":Client");

			fault.setFaultActor("http://www.mincheol.com/auth");
			fault.setFaultString("Message does not have necessary info");
			Detail detail = fault.addDetail();
			Name entryName = soapFactory.createName("content"); 
			DetailEntry entry = detail.addDetailEntry(entryName);
			entry.addTextNode("userid element does not have a value");
*/
	        System.out.println("-----------------------------------------------------");
	        requestMessage.writeTo(System.out);
	        System.out.println("-----------------------------------------------------");

			return sendSoapMessage((String) parameters.get("endpoint"), requestMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addSubElement(SOAPFactory soapFactory, SOAPElement parent, Map<String, Object> elements) throws SOAPException {
        for (String key : elements.keySet()) {
			Name name = soapFactory.createName(key);
			SOAPElement element = parent.addChildElement(name);
			if(elements.get(key) instanceof Map)
				addSubElement(soapFactory, element, (Map<String, Object>) elements.get(key));
			else
				element.addTextNode((String) elements.get(key));
        }
	}
	
	public SOAPMessage sendSoapMessage(String endpoint, SOAPMessage requestMessage) throws SOAPException {
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection connection = soapConnectionFactory.createConnection();
	
		return connection.call(requestMessage, endpoint);
	}
}