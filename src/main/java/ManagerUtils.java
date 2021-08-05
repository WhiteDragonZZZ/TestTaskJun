import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerUtils {

    /**
     * Возвращаемый статистический метод типа List<Manager>
     * Позволяет нам каждый элемент Manager класть в коллекцию List<Manager>
     * @param managerNode
     * @return
     */
    public static List<Manager> parseManager(Node managerNode, List<Worker> workerList) {
        List<Manager> managerList=new ArrayList<>();
        NodeList childs=managerNode.getChildNodes();
        for (int i=0; i<childs.getLength(); i++) {

            if (childs.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (!childs.item(i).getNodeName().equals("Manager")) {
                continue;
            }


            Manager manager= null;
            try {
                manager = parseManagerElement(childs.item(i),workerList);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            managerList.add(manager);

        }

        return managerList;
    }

    /**
     * Возвращаемый метод позволяет нам извлекать информацию о менеджере с соответствующими тэгами
     * @param element
     * @return
     * @throws ParseException
     */
    public static Manager parseManagerElement(Node element,List<Worker> workerList) throws ParseException {

        String fullName ="";
        String dateOfBorn="";
        Date dateOffer = null;
        int identificatedCode=0;
        int salary=0;

        NodeList elements=element.getChildNodes();
        for(int j=0; j<elements.getLength(); j++) {
            if (elements.item(j).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            switch (elements.item(j).getNodeName()) {
                case "fullName": {
                    fullName=elements.item(j).getTextContent();
                    break;
                }
                case "dateOfBorn": {
                    dateOfBorn=elements.item(j).getTextContent();
                    break;
                }

                case "dateOffer": {
                    SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
                    dateOffer=format.parse(elements.item(j).getTextContent());
                    break;
                }

                case "identificatedCode": {
                    identificatedCode=Integer.valueOf(elements.item(j).getTextContent());
                    break;
                }

                case "salary": {
                    salary=Integer.valueOf(elements.item(j).getTextContent());
                    break;
                }
            }

        }
        Manager manager=new Manager(fullName,dateOfBorn,dateOffer,identificatedCode,workerList,salary);
        return manager;
    }


    public static void sortByName(List<Manager> managers) {
        managers.sort((o1, o2) -> o1.getFullName().compareToIgnoreCase(o2.getFullName()));
    }


    public static void sortDateOffer(List<Manager> managers) {
        managers.sort(((o1, o2) -> o1.getDateOffer().compareTo(o2.getDateOffer())));
    }


    public static void findMaxSalary(List<Manager> managers) {
        int max=0;
        String name = "";
        for (Manager manager:managers) {
            if(max<manager.getSalary()) {
                max=manager.getSalary();
                name=manager.getFullName();
            }
        }

        System.out.println(name+" работник с самой высокой зарплатой "+max);
    }
}
