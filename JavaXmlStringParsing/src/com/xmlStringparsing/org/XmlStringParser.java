/*This package contains the XML String parsing. 
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
 * This class implements the parsing of XML String and read the value of each
 * element.
 * 
 * @author ravi ranjan kumar
 * @since 2017-04-05
 * @version 1.0
 *
 */
public class XmlStringParser {

	/**
	 * This is main method which is responsible to all operation to parse an XML
	 * string. this XML String is not parsed from any file in fact it is just a
	 * string written in XML ways.
	 * 
	 * @param args
	 *            reads input.
	 */
	public static void main(String[] args) {

		// XML string.
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><dmslogin><status>1</status><message>successfully</message><sessionid>abc-45df-jh9d-sdfd</sessionid></dmslogin>";
		System.out.println("the xml String is : " + xmlString);

		// creating document factory instance.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			// instance of new document builder which builds a document.
			DocumentBuilder builder = factory.newDocumentBuilder();
			// instance of input source.
			InputSource iSource = new InputSource();
			iSource.setCharacterStream(new StringReader(xmlString));
			// parsing the XML string.
			Document doc = builder.parse(iSource);
			/*
			 * getting the all kind of node( Like : parent node, child node,
			 * sibling node e.t.c) associated of which XML element name we use.
			 */
			NodeList xmlTagName = doc.getElementsByTagName("sessionid");
			// iterating through each node of chosen XML Element.
			for (int i = 0; i < xmlTagName.getLength(); i++) {
				// retrieving each associated to the Element which we've chosen.
				Node tagName = xmlTagName.item(i);
				// checking whether the present node is an Element or not.
				if (tagName.getNodeType() == Node.ELEMENT_NODE) {
					// getting the exactly element of that selected node in
					// nodeList.
					Element element = (Element) tagName;
					// printing the XML element tag name as well as it's
					// corresponding values.
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

}
