package com.fauxbunnies.pokedatabase.Tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by MacAir on 9/5/15.
 */
public class XMLParser {

    private static Document DOCUMENT;

    public static void parseFile(InputStream is) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            DOCUMENT = dBuilder.parse(is);

            DOCUMENT.getDocumentElement().normalize();
            System.out.println("Root: " + DOCUMENT.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Element[] getChildElementsByID(String tag, String id) {
        NodeList nList = DOCUMENT.getElementsByTagName(tag);
        Element set = null;
        ArrayList<Element> elements = new ArrayList<>();

        for(int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                if(element.getAttribute("title") == id) {
                    set = element;
                    break;
                }
            }
        }

        if(set != null) {
            NodeList childList = set.getChildNodes();

            for(int i = 0; i < childList.getLength(); i++) {
                Node child = childList.item(i);

                if(child.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) child;
                    elements.add(childElement);
                }
            }

            Element[] ele = new Element[elements.size()];
            ele = elements.toArray(ele);

            return ele;
        }
        
        return null;
    }

    public static Element[] getChildElementsByPosition(String tag, int position) {
        NodeList nList = DOCUMENT.getElementsByTagName(tag);
        Node node = nList.item(position);

        ArrayList<Element> elements = new ArrayList<>();

        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            NodeList children = element.getChildNodes();

            for(int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);

                if(child.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) child;
                    elements.add(childElement);
                }

            }
        }

        Element[] ele = new Element[elements.size()];
        ele = elements.toArray(ele);

        return ele;
    }

    public static String[] getChildElements(String tag, int position) {
        NodeList nList = DOCUMENT.getElementsByTagName(tag);
        Node node = nList.item(position);

        ArrayList<String> elements = new ArrayList<>();

        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            NodeList children = element.getChildNodes();

            for(int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);

                if(child.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) child;
                    elements.add(childElement.getAttribute("title"));
                }

            }
        }

        String[] ele = new String[elements.size()];
        ele = elements.toArray(ele);

        return ele;
    }

    public static String[] getElementsByTagName(String tag) {

        NodeList nList = DOCUMENT.getElementsByTagName(tag);
        String[] elements = new String[nList.getLength()];

        for(int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                elements[i] = element.getAttribute("title");
            }
        }

        return elements;
    }

}
