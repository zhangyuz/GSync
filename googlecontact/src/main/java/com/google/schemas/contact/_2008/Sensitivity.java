//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.20 at 03:03:46 PM CST 
//


package com.google.schemas.contact._2008;

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
 *       &lt;attribute name="rel" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="confidential"/>
 *             &lt;enumeration value="normal"/>
 *             &lt;enumeration value="personal"/>
 *             &lt;enumeration value="private"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * <p>
 * Classifies sensitivity of the contact into the following categories:
 * rel	Specifies contact's sensitivity. Can be either confidential, normal, personal or private.
 */
public class Sensitivity {

    @Attribute(name = "rel", required = true)
    protected String rel;

    public String getRel() {
        return rel;
    }

    public void setRel(String value) {
        this.rel = value;
    }

}
