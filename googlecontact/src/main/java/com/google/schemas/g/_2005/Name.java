//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.20 at 03:03:46 PM CST 
//


package com.google.schemas.g._2005;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://schemas.google.com/g/2005}additionalName"/>
 *         &lt;element ref="{http://schemas.google.com/g/2005}familyName"/>
 *         &lt;element ref="{http://schemas.google.com/g/2005}fullName"/>
 *         &lt;element ref="{http://schemas.google.com/g/2005}givenName"/>
 *         &lt;element ref="{http://schemas.google.com/g/2005}namePrefix"/>
 *         &lt;element ref="{http://schemas.google.com/g/2005}nameSuffix"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "additionalNameOrFamilyNameOrFullName"
})
@XmlRootElement(name = "name")
public class Name {

    @XmlElementRefs({
        @XmlElementRef(name = "additionalName", namespace = "http://schemas.google.com/g/2005", type = AdditionalName.class, required = false),
        @XmlElementRef(name = "fullName", namespace = "http://schemas.google.com/g/2005", type = FullName.class, required = false),
        @XmlElementRef(name = "namePrefix", namespace = "http://schemas.google.com/g/2005", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "familyName", namespace = "http://schemas.google.com/g/2005", type = FamilyName.class, required = false),
        @XmlElementRef(name = "givenName", namespace = "http://schemas.google.com/g/2005", type = GivenName.class, required = false),
        @XmlElementRef(name = "nameSuffix", namespace = "http://schemas.google.com/g/2005", type = JAXBElement.class, required = false)
    })
    protected List<Object> additionalNameOrFamilyNameOrFullName;

    /**
     * Gets the value of the additionalNameOrFamilyNameOrFullName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalNameOrFamilyNameOrFullName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalNameOrFamilyNameOrFullName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalName }
     * {@link FullName }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link FamilyName }
     * {@link GivenName }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Object> getAdditionalNameOrFamilyNameOrFullName() {
        if (additionalNameOrFamilyNameOrFullName == null) {
            additionalNameOrFamilyNameOrFullName = new ArrayList<Object>();
        }
        return this.additionalNameOrFamilyNameOrFullName;
    }

}