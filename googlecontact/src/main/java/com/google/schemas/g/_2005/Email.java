//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.20 at 03:03:46 PM CST 
//


package com.google.schemas.g._2005;


import org.simpleframework.xml.Attribute;

/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="address" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="primary" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public class Email {

    @Attribute(name = "address")
    protected String address;
    @Attribute(name = "displayName", required = false)
    protected String displayName;
    @Attribute(name = "label", required = false)
    protected String label;
    @Attribute(name = "primary", required = false)
    protected boolean primary;
    @Attribute(name = "rel", required = false)
    protected String rel;

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String value) {
        this.displayName = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String value) {
        this.label = value;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean value) {
        this.primary = value;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String value) {
        this.rel = value;
    }

}
