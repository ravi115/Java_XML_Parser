/*This package contains the  parsing of XML String implementation. 
 */

package com.xmlStringparsing.org;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * This class implements the parsing of XML String and reads the value of each
 * element.
 * 
 * @author ravi ranjan kumar
 * @since 2017-04-05
 * @version 1.0
 *
 */
public class XmlStringParser {

	/**
	 * This method will parse an XML from XML File.
	 */
	private static void parseXMLStringFromFile() {
		// creating document factory instance.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			/*
			 * instance of new document builder which builds a document for any
			 * file or string.
			 */
			DocumentBuilder builder = factory.newDocumentBuilder();
			// parsing the XML string from a given file.
			Document doc = builder.parse("student.xml");
			/*
			 * getting all kind of node( Like : parent node, child node, sibling
			 * node e.t.c) associated of which XML element we choose.
			 */
			NodeList xmlTagName = doc.getElementsByTagName("student");
			// iterating through each node of chosen XML Element.
			for (int i = 0; i < xmlTagName.getLength(); i++) {
				// retrieving each associated Element which we've chosen.
				Node tagName = xmlTagName.item(i);
				// checking whether the present node is an Element or not.
				if (tagName.getNodeType() == Node.ELEMENT_NODE) {
					/*
					 * getting the exactly element of that selected node in the
					 * nodeList.
					 */
					Element element = (Element) tagName;
					// retrieving the attribute of each child node.
					final String attribute = element.getAttribute("id");
					// now retrieve the all child node in a node List.
					NodeList childNodeList = element.getChildNodes();
					// iterating through each child node of chosen XML Element.
					for (int j = 0; j < childNodeList.getLength(); j++) {
						// retrieving each associated Element which we've
						// chosen.
						Node childTagName = childNodeList.item(j);
						// checking whether the present node is an Element or
						// not.
						if (childTagName.getNodeType() == Node.ELEMENT_NODE) {
							/*
							 * getting the exactly element of that selected node
							 * in the nodeList.
							 */
							Element childElement = (Element) childTagName;
							// now display all the id and child node with it's
							// value.
							System.out.println("student - Id : " + attribute + ": " + childElement.getTagName() + ": "
									+ childElement.getTextContent());
						}
					}

					/*
					 * printing the XML element tag name as well as it's
					 * corresponding values.
					 */
					System.out.println(element.getTagName() + ":" + element.getTextContent());
				}
			}

		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * This method will parse an XML from XML String.
	 */
	private static void parseXMLString() {
		// XML string.
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><dmslogin><status>1</status><message>successfully</message><sessionid>abc-45df-jh9d-sdfd</sessionid></dmslogin>";
		System.out.println("the xml String is : " + xmlString);

		// creating document factory instance.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			/*
			 * instance of new document builder which builds a document for any
			 * file or string.
			 */
			DocumentBuilder builder = factory.newDocumentBuilder();
			// instance of input source.
			InputSource iSource = new InputSource();
			iSource.setCharacterStream(new StringReader(xmlString));
			// parsing the XML string.
			Document doc = builder.parse(iSource);
			/*
			 * getting all kind of node( Like : parent node, child node, sibling
			 * node e.t.c) associated of which XML element we choose.
			 */
			NodeList xmlTagName = doc.getElementsByTagName("sessionid");
			// iterating through each node of chosen XML Element.
			for (int i = 0; i < xmlTagName.getLength(); i++) {
				// retrieving each associated Element which we've chosen.
				Node tagName = xmlTagName.item(i);
				// checking whether the present node is an Element or not.
				if (tagName.getNodeType() == Node.ELEMENT_NODE) {
					/*
					 * getting the exactly element of that selected node in the
					 * nodeList.
					 */
					Element element = (Element) tagName;
					/*
					 * printing the XML element tag name as well as it's
					 * corresponding values.
					 */
					System.out.println(element.getTagName() + ":" + element.getTextContent());
				}
			}

		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This is main method which is responsible to perform all kind of operation
	 * to parse an XML string. this XML String is not being parsed from any
	 * file. in fact it is just a string written in XML ways.
	 * 
	 * @param args
	 *            reads command line input.
	 */
	public static void main(String[] args) {

		// parse an XML string.
		parseXMLString();

		// parse an XML string from file.
		parseXMLStringFromFile();
	}

}
