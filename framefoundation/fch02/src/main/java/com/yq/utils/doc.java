package com.yq.utils;

import org.junit.jupiter.api.Test;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * dom解析xml
 */
public class doc {
    //???xml
    public Document loadXml() {
        try {
            //??dom????????
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //??????dom???
            DocumentBuilder db = factory.newDocumentBuilder();
            //??xml??
            Document d = db.parse("src/main/resources/手机信息.xml");
            return d;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    //????
    public void showElementInfo() {
        try {
            Document d = loadXml();
            //??Brand??
            NodeList nodeList = d.getElementsByTagName("Brand");
            for (int i = 0; i < nodeList.getLength(); i++) {
                //???i?Brand??
                Element element = (Element) nodeList.item(i);
                //??????
                System.out.println(element.getAttribute("name"));
                NodeList nodeList1 = element.getElementsByTagName("type");
                for (int j = 0; j > nodeList1.getLength(); j++) {
                    //???j?type??
                    Element element1 = (Element) nodeList1.item(j);
                    //??????
                    System.out.println(element1.getAttribute("name"));
                    NodeList nodeList2 = element.getElementsByTagName("item");
                    for (int k = 0; k < nodeList2.getLength(); k++) {
                        //???k?item??
                        Element element2 = (Element) nodeList2.item(k);
                        //????
                        System.out.println("??" + element2.getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
                    }
                }
            }
        } catch (DOMException e) {
            e.printStackTrace();
        }
    }

    @Test
    //????
    public void deleteElement() {
        Document d = loadXml();
        NodeList nodeList = d.getElementsByTagName("Brand");
        //??????
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            System.out.println(element.getAttribute("name"));
            if (element.getAttribute("name").equals("三星")) {
                element.getParentNode().removeChild(element);

                if (saveXml(d) == 1) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            }
        }
    }

    @Test
    //新增元素
    public void insertElement() {
        Document d = loadXml();
        //创建元素节点
        Element createBrand = d.createElement("Brand");
        createBrand.setAttribute("name", "三星");
        Element createType = d.createElement("type");
        createType.setAttribute("name", "SLG");
        createBrand.appendChild(createType);
        Element phoneElement = (Element) d.getElementsByTagName("PhoneInfo").item(0);
        phoneElement.appendChild(createBrand);
        saveXml(d);
    }

    @Test
    //修改元素
    public void updateElement() {
        Document d = loadXml();
        NodeList nodeList = d.getElementsByTagName("Brand");//brand元素节点
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node brandNode = nodeList.item(i);
            Element element = (Element) brandNode;
            if (element.getAttribute("name").equals("三星")) {
                element.setAttribute("name", "小辣椒");
                if (saveXml(d) == 1) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }
            }
        }
    }

    //保存xml
    public int saveXml(Document d) {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer();
            DOMSource domSource = new DOMSource(d);
            StreamResult streamResult = new StreamResult(new FileOutputStream("src/main/resources/手机信息.xml"));
            transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
            transformer.transform(domSource, streamResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return 0;
        } catch (TransformerException e) {
            e.printStackTrace();
            return 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
