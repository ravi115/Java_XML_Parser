# Java_XML_Parser
In this repository, I'll be parsing XML  file as well as XML string to read it's attribute, value and tag name.

Two ways to parse XML String.
1 . Normal way using NodeList and Node and Then Element.
2 . XPath (easiest way of parsing). 

These are the below steps which tell us how to parse the XML string.

first of all we have to create an instance of 
### DocumentBuilderFactory class.
this DocumentBuilderFactory - Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
### DocumentBuilderFactory() : 
Protected constructor to prevent instantiation.
#see the syntax : 

#### DocumentBuilderFactory instance_variable_name = DocumentBuilderFactory.newInstance();  

### public static DocumentBuilderFactory newInstance()
Obtain a new instance of a DocumentBuilderFactory. This static method creates a new factory instance. This method uses the following ordered lookup procedure to determine the DocumentBuilderFactory implementation class to load:
Use the javax.xml.parsers.DocumentBuilderFactory system property.
Use the properties file "lib/jaxp.properties" in the JRE directory. This configuration file is in standard java.util.Properties format and contains the fully qualified name of the implementation class with the key being the system property defined above. The jaxp.properties file is read only once by the JAXP implementation and it's values are then cached for future use. If the file does not exist when the first attempt is made to read from it, no further attempts are made to check for its existence. It is not possible to change the value of any property in jaxp.properties after it has been read for the first time.
Use the Services API (as detailed in the JAR specification), if available, to determine the classname. The Services API will look for a classname in the file META-INF/services/javax.xml.parsers.DocumentBuilderFactory in jars available to the runtime.
Platform default DocumentBuilderFactory instance.
Once an application has obtained a reference to a DocumentBuilderFactory it can use the factory to configure and obtain parser instances.

then create a 
### DocumentBuilder instance using the instance of DocumentBuilderFactory class only.

#see the syntax : 

#### DocumentBuilder instance_varibale_name = instance_Of_DocumentBuilderFactory_Class.newDocumentBuilder();

Returns:
A new instance of a DocumentBuilder.
Throws:
ParserConfigurationException - if a DocumentBuilder cannot be created which satisfies the configuration requested.

Then parse the file in 
### Dcoument Object Model 
using the instance of DocumentBuilder class.
#see the syntax : -

#### Document instance_name = instance_of_DocumentBuilder.parse("FileName");

The Document interface represents the entire HTML or XML document. Conceptually, it is the root of the document tree, and provides the primary access to the document's data.
Since elements, text nodes, comments, processing instructions, etc. cannot exist outside the context of a Document, the Document interface also contains the factory methods needed to create these objects. The Node objects created have a ownerDocument attribute which associates them with the Document within whose context they were created.

so if we are not using XML file, instead we are using XML string. Like: # final String xmlString = "<student><name>Ravi</name><student>.
then we InputSource class a SAX application which we read this input stream and creates the document object.

#see the below syntax :

#### InputSource instance_variable_name = new InputSource();
#### instance_variable_name.setCharacterStream(new StringReader(an xml String));

The SAX parser will use the InputSource object to determine how to read XML input. If there is a character stream available, the parser will read that stream directly, disregarding any text encoding declaration found in that stream. If there is no character stream, but there is a byte stream, the parser will use that byte stream, using the encoding specified in the InputSource or else (if no encoding is specified) autodetecting the character encoding using an algorithm such as the one in the XML specification. If neither a character stream nor a byte stream is available, the parser will attempt to open a URI connection to the resource identified by the system identifier.

An InputSource object belongs to the application: the SAX parser shall never modify it in any way (it may modify a copy if necessary). However, standard processing of both byte and character streams is to close them on as part of end-of-parse cleanup, so applications should not attempt to re-use such streams after they have been handed to a parser.

using
### NodeList we will retrieve the all XML nodes.

#see the syntax
#### NodeList xmlTagList = doc.getElementsByTagName("any Tag from xml");

then we Node to get a single node from NodeList and checks whether that node is Element or not. if it is an element the get 
all it's child node tag name as well as value.

### XPath
An XPath object is not thread-safe and not reentrant. In other words, it is the application's responsibility to make sure that one XPath object is not used from more than one thread at any given time, and while the evaluate method is invoked, applications may not recursively call the evaluate method.

we have to create an Xpath instance.
#see the syntax : -
#### XPath xPath = XPathFactory.newInstance().newXPath();
this will create a new instance of XPath.

compile(String expression)
Compile an XPath expression for later evaluation.

evaluate(String expression, InputSource source)
Evaluate an XPath expression in the context of the specified InputSource and return the result as a String.

to fetch attribute value use the below syntax: 
#### xPath.compile("./@{attribute name}").evaluate(NodeList_instance_name.item(i)))

evaluate(String expression, InputSource source)
Evaluate an XPath expression in the context of the specified InputSource and return the result as a String.

to fetch it's child node value use the below syntax:
#### xPath.compile("./{child tag name}").evaluate(NodeList_instance_name.item(i)))

Basically use ./@ to fetch attribute value and use only ./ to fetch it's child node value.

--------------------------*****------------------------------------------
