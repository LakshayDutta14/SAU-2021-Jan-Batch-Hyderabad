package com.accolite.au.xmlprocessing;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLProcessingExample {

//	public static void main(String[] args) {
//		XMLProcessingExample xmlProcessingExample = new XMLProcessingExample();
////		xmlProcessingExample.domParser();
//		xmlProcessingExample.jaxBParser(); 
//	}

	void domParser() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("./src/com/accolite/au/xmlprocessing/assignment.xml"));
		
			System.out.println(doc.getDocumentElement().getNodeName());
            
		    NodeList nList = doc.getElementsByTagName("assignment");
		    for (int temp = 0; temp < nList.getLength(); temp++) {

		        Node nNode = nList.item(temp);
		                
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) nNode;
		            System.out.println("\nAssignment: " + eElement.getAttribute("id"));
		            System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
		            System.out.println("Review : " + eElement.getElementsByTagName("review").item(0).getTextContent());
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Assignments  jaxBParser() {
		try {
			File file = new File("src/xmlfile.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Assignments.class);

	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        Assignments assignments = (Assignments) jaxbUnmarshaller.unmarshal(file);
	        System.out.println(assignments);
	        return(assignments);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return(null);
	}
	
	public static void CreateXMLFileJava() throws SAXException, IOException   //QUESTION 1 ASSIGNMNET
	{
		 final String xmlFilePath="src/xmlfile.xml";
		 try {
			 
	            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	 
	            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	 
	            Document document = documentBuilder.newDocument();
	 
	            // root element
	            Element root = document.createElement("assignments");
	            document.appendChild(root);
	 
	            // employee element
	           
	            Document doc = documentBuilder.parse(new File("./src/com/accolite/au/xmlprocessing/assignment.xml"));
	            NodeList nList = doc.getElementsByTagName("assignment");
	            for (int temp = 0; temp < nList.getLength(); temp++)
	            {
	            	
	            	 Element employee = document.createElement("assignment");
	            	 
	 	           
	 	            
	            	 Node nNode = nList.item(temp);
	            	 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 		            Element eElement = (Element) nNode;
	 		           Element firstName = document.createElement("name");
	 		            firstName.appendChild(document.createTextNode(eElement.getElementsByTagName("name").item(0).getTextContent()));
	 		           employee.appendChild(firstName);
	 		           
	 		          Element lastname = document.createElement("id");
	 		            lastname.appendChild(document.createTextNode(eElement.getAttribute("id")));
	 		            employee.appendChild(lastname);
	 		            
	 		           Element email = document.createElement("statusupdate");
	 		            email.appendChild(document.createTextNode(eElement.getElementsByTagName("review").item(0).getTextContent()));
	 		            employee.appendChild(email);
	 		          
	 		        }
	            	 root.appendChild(employee);
	            }
	         
	            // create the xml file
	            //transform the DOM Object to an XML File
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource domSource = new DOMSource(document);
	            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
	 
	            // If you use
	            // StreamResult result = new StreamResult(System.out);
	            // the output will be pushed to the standard output ...
	            // You can use that for debugging 
	 
	            transformer.transform(domSource, streamResult);
	 
	            System.out.println("Done creating XML File");
	 
	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }
	    }
		 
	}


