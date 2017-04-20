//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.20 at 03:03:46 PM CST 
//


package com.google.schemas.contact._2008;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.google.schemas.contact._2008 package. 
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

    private final static QName _MaidenName_QNAME = new QName("http://schemas.google.com/contact/2008", "maidenName");
    private final static QName _Occupation_QNAME = new QName("http://schemas.google.com/contact/2008", "occupation");
    private final static QName _Subject_QNAME = new QName("http://schemas.google.com/contact/2008", "subject");
    private final static QName _Nickname_QNAME = new QName("http://schemas.google.com/contact/2008", "nickname");
    private final static QName _Mileage_QNAME = new QName("http://schemas.google.com/contact/2008", "mileage");
    private final static QName _DirectoryServer_QNAME = new QName("http://schemas.google.com/contact/2008", "directoryServer");
    private final static QName _BillingInformation_QNAME = new QName("http://schemas.google.com/contact/2008", "billingInformation");
    private final static QName _Initials_QNAME = new QName("http://schemas.google.com/contact/2008", "initials");
    private final static QName _Hobby_QNAME = new QName("http://schemas.google.com/contact/2008", "hobby");
    private final static QName _ShortName_QNAME = new QName("http://schemas.google.com/contact/2008", "shortName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.google.schemas.contact._2008
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Birthday }
     * 
     */
    public Birthday createBirthday() {
        return new Birthday();
    }

    /**
     * Create an instance of {@link Website }
     * 
     */
    public Website createWebsite() {
        return new Website();
    }

    /**
     * Create an instance of {@link Gender }
     * 
     */
    public Gender createGender() {
        return new Gender();
    }

    /**
     * Create an instance of {@link GroupMembershipInfo }
     * 
     */
    public GroupMembershipInfo createGroupMembershipInfo() {
        return new GroupMembershipInfo();
    }

    /**
     * Create an instance of {@link UserDefinedField }
     * 
     */
    public UserDefinedField createUserDefinedField() {
        return new UserDefinedField();
    }

    /**
     * Create an instance of {@link ExternalId }
     * 
     */
    public ExternalId createExternalId() {
        return new ExternalId();
    }

    /**
     * Create an instance of {@link Language }
     * 
     */
    public Language createLanguage() {
        return new Language();
    }

    /**
     * Create an instance of {@link Priority }
     * 
     */
    public Priority createPriority() {
        return new Priority();
    }

    /**
     * Create an instance of {@link Jot }
     * 
     */
    public Jot createJot() {
        return new Jot();
    }

    /**
     * Create an instance of {@link CalendarLink }
     * 
     */
    public CalendarLink createCalendarLink() {
        return new CalendarLink();
    }

    /**
     * Create an instance of {@link Relation }
     * 
     */
    public Relation createRelation() {
        return new Relation();
    }

    /**
     * Create an instance of {@link Sensitivity }
     * 
     */
    public Sensitivity createSensitivity() {
        return new Sensitivity();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "maidenName")
    public JAXBElement<String> createMaidenName(String value) {
        return new JAXBElement<String>(_MaidenName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "occupation")
    public JAXBElement<String> createOccupation(String value) {
        return new JAXBElement<String>(_Occupation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "subject")
    public JAXBElement<String> createSubject(String value) {
        return new JAXBElement<String>(_Subject_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "nickname")
    public JAXBElement<String> createNickname(String value) {
        return new JAXBElement<String>(_Nickname_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "mileage")
    public JAXBElement<String> createMileage(String value) {
        return new JAXBElement<String>(_Mileage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "directoryServer")
    public JAXBElement<String> createDirectoryServer(String value) {
        return new JAXBElement<String>(_DirectoryServer_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "billingInformation")
    public JAXBElement<String> createBillingInformation(String value) {
        return new JAXBElement<String>(_BillingInformation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "initials")
    public JAXBElement<String> createInitials(String value) {
        return new JAXBElement<String>(_Initials_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "hobby")
    public JAXBElement<String> createHobby(String value) {
        return new JAXBElement<String>(_Hobby_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.google.com/contact/2008", name = "shortName")
    public JAXBElement<String> createShortName(String value) {
        return new JAXBElement<String>(_ShortName_QNAME, String.class, null, value);
    }

}
