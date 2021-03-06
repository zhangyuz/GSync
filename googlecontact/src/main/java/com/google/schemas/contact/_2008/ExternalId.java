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
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * Describes an ID of the contact in an external system of some kind. This element may be repeated.
 * @label?	xs:string	A simple string value used to name this ID.
 * @rel	xs:string	A programmatic value that identifies the type of external ID.
 * @value	xs:string	The value of this external ID.
 *
 * Rel values
 * Value	Description
 * account	Contact's account number.
 * customer	Contact's customer ID.
 * network	Network identifier of the contact.
 * organization	Identifier related to an organization the contact is associated with.
 */
public class ExternalId {

    @Attribute(name = "label", required = false)
    protected String label;
    @Attribute(name = "rel", required = false)
    protected String rel;
    @Attribute(name = "value", required = true)
    protected String value;

    /**
     * Gets the value of the label property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the rel property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRel() {
        return rel;
    }

    /**
     * Sets the value of the rel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRel(String value) {
        this.rel = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

}
