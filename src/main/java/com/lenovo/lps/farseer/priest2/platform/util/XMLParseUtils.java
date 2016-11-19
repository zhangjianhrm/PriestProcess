package com.lenovo.lps.farseer.priest2.platform.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;

public final class XMLParseUtils {

	private static final String EXP_MSG = "The xpath is not exit";
	
	/**
	 * 工具类不应该被实例化使用
	 */
	private XMLParseUtils(){}

	public static String getNodeAttributeValue(String document, String xpath) {
		String value = null;
		try {
			Document doc = DocumentHelper.parseText(document);
			List<?> nodes = doc.selectNodes(xpath);
			if (nodes.size() > 0) {
				for (Iterator<?> iterator = nodes.iterator(); iterator.hasNext();) {
					Object object = iterator.next();
					if (object instanceof Attribute) {
						Attribute attribute = (Attribute) object;
						value = attribute.getValue();
					} else if (object instanceof Element) {
						throw new PriestPlatformException("The xpath is not a element");
					}
				}
			} else {
				throw new PriestPlatformException(EXP_MSG);
			}
		} catch (DocumentException e) {
			throw new PriestPlatformException(e);
		}
		return value;
	}

	public static String getNodeValue(String document, String xpath) {
		String value = null;
		try {
			Document doc = DocumentHelper.parseText(document);
			List<?> nodes = doc.selectNodes(xpath);
			if (nodes.size() > 0) {
				for (Iterator<?> iterator = nodes.iterator(); iterator.hasNext();) {
					Object object = iterator.next();
					if (object instanceof Attribute) {
						throw new PriestPlatformException("The xpath is not a attribute");
					} else if (object instanceof Element) {
						Element element = (Element) object;
						value = element.getText();
					}
				}
			} else {
				throw new PriestPlatformException(EXP_MSG);
			}
		} catch (DocumentException e) {
			throw new PriestPlatformException(e);
		}
		return value;
	}

	public static String modifyNodeAttribute(String document, String xpath, String value) {
		Map<String, String> attributeMap = new HashMap<String, String>();
		int i = xpath.lastIndexOf('@');
		String attribute = xpath.substring(i + 1);
		attributeMap.put(attribute, value);
		return modifyNodeAttributes(document, xpath, attributeMap);
	}

	public static String modifyNodeAttributes(String document, String xpath, Map<String, String> attributeMap) {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(document);
		} catch (DocumentException e) {
			throw new PriestPlatformException(e);
		}
		List<?> nodes = doc.selectNodes(xpath);
		if (nodes.size() > 0) {
			for (Iterator<?> iterator = nodes.iterator(); iterator.hasNext();) {
				Object object = iterator.next();
				if (object instanceof Attribute) {
					Attribute attribute = (Attribute) object;
					String name = attribute.getName();
					String value = attributeMap.get(name);
					if (value != null) {
						attribute.setValue(value);
					} else {
						throw new PriestPlatformException("The attribute is not exit");
					}
				} else if (object instanceof Element) {
					Element element = (Element) object;
					for (Entry<String, String> entry : attributeMap.entrySet()) {
						String key = entry.getKey();
						String value = entry.getValue();
						Attribute attribute = element.attribute(key);
						if (attribute != null) {
							attribute.setValue(value);
						} else {
							throw new PriestPlatformException("The attribute is not exit");
						}
					}
				}
			}
		} else {
			throw new PriestPlatformException(EXP_MSG);
		}
		return doc.asXML();
	}

	public static String removeNode(String document, String xpath) {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(document);
			List<?> nodes = doc.selectNodes(xpath);
			if (nodes.size() > 0) {
				for (Iterator<?> iterator = nodes.iterator(); iterator.hasNext();) {
					Object object = iterator.next();
					if (object instanceof Attribute) {
						Attribute attribute = (Attribute) object;
						Element parent = attribute.getParent();
						Element parentElement = (parent == null) ? doc.getRootElement() : parent;
						parentElement.remove(attribute);
					} else if (object instanceof Element) {
						Element element = (Element) object;
						Element parent = element.getParent();
						Element parentElement = (parent == null) ? doc.getRootElement() : parent;
						parentElement.remove(element);
					}
				}
			}
		} catch (DocumentException e) {
			throw new PriestPlatformException(e);
		}
		return doc.asXML();
	}

	public static Set<String> getAttributeValueSet(String document, String xpath) {
		Document doc = null;
		List<String> attributeValueList = new ArrayList<String>();
		try {
			doc = DocumentHelper.parseText(document);
			List<?> nodes = doc.selectNodes(xpath);
			if (nodes.size() > 0) {
				for (Iterator<?> iterator = nodes.iterator(); iterator.hasNext();) {
					Object object = iterator.next();
					if (object instanceof Attribute) {
						Attribute attribute = (Attribute) object;
						attributeValueList.add(attribute.getValue());
					} else if (object instanceof Element) {
						throw new PriestPlatformException("The xpath is not a element");
					} else {
						throw new PriestPlatformException(EXP_MSG);
					}
				}
			}
		} catch (DocumentException e) {
			throw new PriestPlatformException(e);
		}
		return new HashSet<String>(attributeValueList);
	}
}
