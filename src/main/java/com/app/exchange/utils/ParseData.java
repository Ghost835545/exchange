package com.app.exchange.utils;

import com.app.exchange.domain.Exchange;
import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class ParseData {


    private String url = "http://www.cbr.ru/scripts/XML_daily.asp";
    private List<Exchange> exc = new ArrayList<>();

    public List<Exchange> parsingData() {

        try {

            System.out.println(url);
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.addRequestProperty("Accept", "application/xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            dbFactory.setNamespaceAware(false);
            dbFactory.setValidating(false);

            Document doc = dBuilder.parse(urlConnection.getInputStream());
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Valute");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                System.out.println(
                        "\nCurrent Element :" + nNode.getAttributes().item(0).getTextContent());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("NumCode : "
                            + Integer.parseInt(eElement
                            .getElementsByTagName("NumCode")
                            .item(0)
                            .getTextContent()));
                    System.out.println("CharCode : "
                            + eElement
                            .getElementsByTagName("CharCode")
                            .item(0)
                            .getTextContent().toString());
                    System.out.println("Nominal : "
                            + Integer.parseInt(eElement
                            .getElementsByTagName("Nominal")
                            .item(0)
                            .getTextContent()));
                    System.out.println("Name : "
                            + eElement
                            .getElementsByTagName("Name")
                            .item(0)
                            .getTextContent().toString());

                    System.out.println("Value : "
                            + Float.parseFloat(eElement
                            .getElementsByTagName("Value")
                            .item(0)
                            .getTextContent().replace(",",".")));
                    exc.add(temp,
                            new Exchange(
                                    nNode.getAttributes().item(0).getTextContent(),
                                    Integer.parseInt(eElement.getElementsByTagName("NumCode").item(0).getTextContent()),
                                            eElement.getElementsByTagName("CharCode").item(0).getTextContent(),
                                            Integer.parseInt(eElement.getElementsByTagName("Nominal").item(0).getTextContent()),
                                            eElement.getElementsByTagName("Name").item(0).getTextContent(),
                                            Float.parseFloat(eElement.getElementsByTagName("Value").item(0).getTextContent().replace(",","."))
                                    )
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exc;
    }
}

