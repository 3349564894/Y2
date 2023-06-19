package com.yq.utils;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
 * @Description 使用DOM解XMl
 * @Author hyl
 * @Date 2023/4/17 11:02
 **/
public class DomUtil {

    private String url = "src/main/resources/手机信息.xml";

    //加载
    public Document loadXml() {
        try {
            // 1、得到DOM解析器的工厂实例
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // 2、从DOM工厂获得DOM解析器
            DocumentBuilder db = dbf.newDocumentBuilder();
            // 3、解析XML文档，得到一个Document，即DOM树
            Document doc = db.parse(url);
            return doc;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    //显示
    @Test
    public void showXML() {
        try {
            Document doc = loadXml();
            //品牌
            NodeList brandlist = doc.getElementsByTagName("Brand"); //获取节点
            for (int i = 0; i < brandlist.getLength(); i++) {
                Element brandElement = (Element) brandlist.item(i);
                String brandName = brandElement.getAttribute("name");
                System.out.println(brandName); //品牌

                //型号
                NodeList typeList = brandElement.getElementsByTagName("type");
                for (int j = 0; j < typeList.getLength(); j++) {
                    Element typeElement = (Element) typeList.item(j);
                    String typeName = typeElement.getAttribute("name");
                    System.out.println("\t" + typeName); //型号

                    //详情
                    NodeList list = doc.getElementsByTagName("item"); //获取节点
                    for (int z = 0; z < list.getLength(); z++) {
                        Element itemElement = (Element) list.item(i);
                        String title = itemElement.getElementsByTagName("title").item(0).getFirstChild().getNodeValue();
                        String description = itemElement.getElementsByTagName("description").item(0).getFirstChild()
                                .getNodeValue();
                        String link = itemElement.getElementsByTagName("link").item(0).getFirstChild().getNodeValue();
                        String pubDate = itemElement.getElementsByTagName("pubDate").item(0).getFirstChild().getNodeValue();

                        System.out.println(title);

                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //修改
    @Test
    public void updateXMl() {
        Document doc = loadXml();
        //获取所有brand节点
        NodeList brands = doc.getElementsByTagName("Brand");
        for (int i = 0; i < brands.getLength(); i++) {
            Node brand = brands.item(i);
            Element brandEle = (Element) brand;
            //如果name属性值为三星，则进行修改
            if (brandEle.getAttribute("name").equals("小米")) {
                brandEle.setAttribute("name", "min");
            }
        }
        //保存
        saveInfo(doc);
    }

    //新增
    @Test
    public void insertXMl() {
        Document doc = loadXml();
        //1.创建新节点，并设置name属性
        Element newEle = doc.createElement("Brand");
        newEle.setAttribute("name", "三星");
        //创建Type节点
        Element newType = doc.createElement("Type");
        newType.setAttribute("name", "NoteX");
        //添加子节点
        newEle.appendChild(newType);
        Element phoneElement = (Element) doc.getElementsByTagName("PhoneInfo").item(0);
        //2.把节点加到其父节点上
        phoneElement.appendChild(newEle);

        //保存
        saveInfo(doc);
    }

    @Test
    //删除
    public void delXMl() {
        Document doc = loadXml();
        NodeList brands = doc.getElementsByTagName("Brand");
        //获取所有brand节点
        for (int i = 0; i < brands.getLength(); i++) {
            Node brand = brands.item(i);
            Element brandEle = (Element) brand;
            //找到name属性值为SAMSUNG的节点，删除
            if (brandEle.getAttribute("name").equals("三星")) {
                //调用父节点的removeChild（）方法删除
                brandEle.getParentNode().removeChild(brandEle);
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }
        //保存
        saveInfo(doc);
    }


    //保存XML
    public void saveInfo(Document doc) {
        //1.创建转换工厂
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            //2.创建转换器
            Transformer former = factory.newTransformer();
            DOMSource xmlSource = new DOMSource(doc);
            StreamResult outputTarget = new StreamResult(new FileOutputStream(url));
            //3.设置编码类型
            former.setOutputProperty(OutputKeys.ENCODING, "gb2312");
            //4.把DOM树转换为XML文件
            former.transform(xmlSource, outputTarget);
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
