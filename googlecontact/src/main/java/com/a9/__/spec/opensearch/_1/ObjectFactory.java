//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.20 at 03:03:46 PM CST 
//


package com.a9.__.spec.opensearch._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.a9.__.spec.opensearch._1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ItemsPerPage_QNAME = new QName("http://a9.com/-/spec/opensearch/1.1/", "itemsPerPage");
    private final static QName _StartIndex_QNAME = new QName("http://a9.com/-/spec/opensearch/1.1/", "startIndex");
    private final static QName _TotalResults_QNAME = new QName("http://a9.com/-/spec/opensearch/1.1/", "totalResults");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.a9.__.spec.opensearch._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://a9.com/-/spec/opensearch/1.1/", name = "itemsPerPage")
    public JAXBElement<Integer> createItemsPerPage(Integer value) {
        return new JAXBElement<Integer>(_ItemsPerPage_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://a9.com/-/spec/opensearch/1.1/", name = "startIndex")
    public JAXBElement<Integer> createStartIndex(Integer value) {
        return new JAXBElement<Integer>(_StartIndex_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://a9.com/-/spec/opensearch/1.1/", name = "totalResults")
    public JAXBElement<Integer> createTotalResults(Integer value) {
        return new JAXBElement<Integer>(_TotalResults_QNAME, Integer.class, null, value);
    }

}
