import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Отдельно созданный класс Parser,который позволяет нам запарсить данные из xml файлаю Имеет два статистических метода:parse(),
 * buildDocument(). Также статистическое поле List<Worker> peopleList;
 */
public class Parser {
    public static List<Worker> peopleList;
    public static Root parse() {
        Document doc=null;
        Root root=new Root();//создание объекта класса Root

        try {
            doc=buildDocument();//вызов функции builDocument()
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        Node node=doc.getFirstChild();//получения первого элемента
        NodeList nodeList=node.getChildNodes();
        NodeList managerNodeList=node.getChildNodes();
        String mainName=null;
        Node peopleNode=null;
        Node topPeopleNode=null;
        for (int i=0; i<nodeList.getLength(); i++) {

            if(nodeList.item(i).getNodeType()!=Node.ELEMENT_NODE) {//позволяет пропускать не подходящие нам элементы
                continue;
            }

            System.out.println(nodeList.item(i).getNodeName());
            switch (nodeList.item(i).getNodeName()) {//поиск соответствующих тэгов в файле и распределение их в NodeList-ы
                case "nameFile": {
                    mainName=nodeList.item(i).getTextContent();
                    System.out.println("mainName: "+mainName);
                    break;
                }
                case "people": {
                    peopleNode=nodeList.item(i);
                    break;
                }

                case "top-people": {
                    topPeopleNode=managerNodeList.item(i);
                }
            }
        }

        root.setName(mainName);

        if (peopleNode==null) {
            return null;
        }

        if (topPeopleNode==null) {
            return null;
        }


        peopleList=WorkerUtils.parseWorker(peopleNode);//вызов метода parseWorker,который позволяет нам извлекать данные с тэгом  Worker
        List<Manager> managerList=ManagerUtils.parseManager(topPeopleNode,peopleList);//вызов метода parseManager,который позволяет нам извлекать данные с тэгом  Manager

        return root;
    }


    public static List<Worker> getWorkerList() {
        return peopleList;
    }


    /**
     * Метод позволяет нам найти xml файл и начать его парсинг
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static Document buildDocument() throws ParserConfigurationException, IOException, SAXException {
        File file=new File("C:\\Parser\\src\\main\\resources\\Staff.xml");
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder().parse(file);

    }
}
