/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.openejb.jee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * web-facesconfig_2_0.xsd
 *
 * <p>Java class for faces-config-managed-propertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faces-config-managed-propertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://java.sun.com/xml/ns/javaee}descriptionGroup"/>
 *         &lt;element name="property-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="property-class" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="map-entries" type="{http://java.sun.com/xml/ns/javaee}faces-config-map-entriesType"/>
 *           &lt;element name="null-value" type="{http://java.sun.com/xml/ns/javaee}faces-config-null-valueType"/>
 *           &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="list-entries" type="{http://java.sun.com/xml/ns/javaee}faces-config-list-entriesType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faces-config-managed-propertyType", propOrder = {
    "descriptions",
    "displayNames",
    "icon",
    "propertyName",
    "propertyClass",
    "mapEntries",
    "nullValue",
    "value",
    "listEntries"
})
public class FacesManagedProperty {

    @XmlTransient
    protected TextMap description = new TextMap();
    @XmlTransient
    protected TextMap displayName = new TextMap();
    @XmlElement(name = "icon", required = true)
    protected LocalCollection<Icon> icon = new LocalCollection<Icon>();
    @XmlElement(name = "property-name", required = true)
    protected java.lang.String propertyName;
    @XmlElement(name = "property-class")
    protected java.lang.String propertyClass;
    @XmlElement(name = "map-entries")
    protected FacesMapEntries mapEntries;
    @XmlElement(name = "null-value")
    protected FacesNullValue nullValue;
    protected java.lang.String value;
    @XmlElement(name = "list-entries")
    protected FacesListEntries listEntries;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    @XmlElement(name = "description", required = true)
    public Text[] getDescriptions() {
        return description.toArray();
    }

    public void setDescriptions(Text[] text) {
        description.set(text);
    }

    public String getDescription() {
        return description.get();
    }

    @XmlElement(name = "display-name", required = true)
    public Text[] getDisplayNames() {
        return displayName.toArray();
    }

    public void setDisplayNames(Text[] text) {
        displayName.set(text);
    }

    public String getDisplayName() {
        return displayName.get();
    }

    public Collection<Icon> getIcons() {
        if (icon == null) {
            icon = new LocalCollection<Icon>();
        }
        return icon;
    }

    public Map<String,Icon> getIconMap() {
        if (icon == null) {
            icon = new LocalCollection<Icon>();
        }
        return icon.toMap();
    }

    public Icon getIcon() {
        return icon.getLocal();
    }

    /**
     * Gets the value of the propertyName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the value of the propertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPropertyName(java.lang.String value) {
        this.propertyName = value;
    }

    /**
     * Gets the value of the propertyClass property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPropertyClass() {
        return propertyClass;
    }

    /**
     * Sets the value of the propertyClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPropertyClass(java.lang.String value) {
        this.propertyClass = value;
    }

    /**
     * Gets the value of the mapEntries property.
     * 
     * @return
     *     possible object is
     *     {@link FacesMapEntries }
     *     
     */
    public FacesMapEntries getMapEntries() {
        return mapEntries;
    }

    /**
     * Sets the value of the mapEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacesMapEntries }
     *     
     */
    public void setMapEntries(FacesMapEntries value) {
        this.mapEntries = value;
    }

    /**
     * Gets the value of the nullValue property.
     * 
     * @return
     *     possible object is
     *     {@link FacesNullValue }
     *     
     */
    public FacesNullValue getNullValue() {
        return nullValue;
    }

    /**
     * Sets the value of the nullValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacesNullValue }
     *     
     */
    public void setNullValue(FacesNullValue value) {
        this.nullValue = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    /**
     * Gets the value of the listEntries property.
     * 
     * @return
     *     possible object is
     *     {@link FacesListEntries }
     *     
     */
    public FacesListEntries getListEntries() {
        return listEntries;
    }

    /**
     * Sets the value of the listEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacesListEntries }
     *     
     */
    public void setListEntries(FacesListEntries value) {
        this.listEntries = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

}
