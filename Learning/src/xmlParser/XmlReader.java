package xmlParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.annotation.ElementType;

/**
 * Created by shubhamsharma on 4/6/2015.
 */
public class XmlReader {

    public static void main(String[] a)
    {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("D:\\Learning\\src\\xmlParser\\records.xml");
            document.getDocumentElement().normalize();
            System.out.println("root:  "+document.getDocumentElement().getNodeName());

            NodeList list = document.getElementsByTagName("staff");

            for (int i=0;i<list.getLength();i++)
            {
                Node node = list.item(i);
                System.out.println("node name :  "+node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element e = (Element)node;
                    System.out.println(e.getAttribute("id"));
                    System.out.println(e.getElementsByTagName("firstname").item(0).getTextContent());
                }

            }
        }
        catch (Exception e)
        {

        }
    }

    public static void Main(String[] a)
    {
        try{
            DocumentBuilderFactory bf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = bf.newDocumentBuilder();
            Document document =db.parse("D:\\Learning\\src\\xmlParser\\records.xml");
            document.getDocumentElement().normalize();

            System.out.println("root element ::: "+document.getDocumentElement().getNodeName());
            NodeList list = document.getElementsByTagName("staff");

            for(int i=0;i<list.getLength();i++)
            {
                    Node node = list.item(i);
                    System.out.println("node name ::: "+node.getNodeName());
                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element eElement =(Element)node;

                        System.out.println("Staff id : " + eElement.getAttribute("id"));
                        System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                        System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                        System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                        System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                    }

            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

}
