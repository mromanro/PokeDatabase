package com.fauxbunnies.pokedatabase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.InputStream;

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

    public static String[] getChildElementsByTagName(String tag) {
        return null;
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
