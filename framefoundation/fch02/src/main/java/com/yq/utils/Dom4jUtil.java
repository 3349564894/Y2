package com.yq.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * @Description 使用DOM4j解析XMl
 * @Author hyl
 * @Date 2023/4/17 11:02
 **/
public class Dom4jUtil {

    private String path = "src/main/resources/手机信息.xml";

    //加载
    public Document loadXml() {
        Document doc = null;
        SAXReader saxReader = new SAXReader();
        try {
            doc = saxReader.read(path);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return doc;
    }

    //显示
    @Test
    public void showXML() {
        Document doc = loadXml();
        Element root = doc.getRootElement();//根节点
        Iterator itBrand = root.elementIterator();//子节点
        while (itBrand.hasNext()) {
            Element brandEle = (Element) itBrand.next();
            String brandStr = brandEle.attributeValue("name");//属性
            System.out.println("手机品牌：" + brandStr);

            Iterator itType = brandEle.elementIterator(); //子节点
            while (itType.hasNext()) {
                Element typeEle = (Element) itType.next();
                String typeStr = typeEle.attributeValue("name");//属性
                System.out.println("\t型号：" + typeStr);
            }
        }
    }

    //新增
    @Test
    public void insertXMl() {
        Document doc = loadXml();
        Element root = doc.getRootElement();
        //创建一个brand节点
        Element brandEle = root.addElement("Brand");
        //给Brand节点设置属性
        brandEle.addAttribute("name", "三星");
        //创建Type节点
        Element typeEle = brandEle.addElement("Type");
        typeEle.addAttribute("name", "NoteX");
        this.saveXML(doc);
    }

    //修改
    public void updateXMl() {
        Document doc = loadXml();
        Element root = doc.getRootElement();
        int id = 0;
        Iterator itBrand = root.elementIterator();
        //遍历后获取每个brand节点
        while (itBrand.hasNext()) {
            id++;
            Element brandEle = (Element) itBrand.next();
            brandEle.addAttribute("id", id + "");
        }
        this.saveXML(doc);
    }

    //删除
    public void delXMl() {
        Document doc = loadXml();
        Element root = doc.getRootElement();
        Iterator itBrand = root.elementIterator();
        while (itBrand.hasNext()) {
            Element brandEle = (Element) itBrand.next();
            if (brandEle.attributeValue("name").equals("三星")) {
                brandEle.getParent().remove(brandEle);
            }
        }
        this.saveXML(doc);
    }

    /**
     * 保存XML
     */
    public void saveXML(Document doc) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("gb2312");
        try {
            XMLWriter writer = new XMLWriter(new FileWriter(path), format);
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
