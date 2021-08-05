import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WorkerUtils {


    /**
     * Возвращаемый статистический метод типа List<Worker>
     * Позволяет нам каждый элемент Worker класть в коллекцию List<Worker>
     * @param workerNode
     * @return
     */

    public static List<Worker> parseWorker(Node workerNode) {
        List<Worker> workerList=new ArrayList<>();
        NodeList childs=workerNode.getChildNodes();
        for (int i=0; i<childs.getLength(); i++) {

            if (childs.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (!childs.item(i).getNodeName().equals("Worker")) {
                continue;
            }


            Worker worker= null;
            try {
                worker = parseWorkerElement(childs.item(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            workerList.add(worker);

        }

        return workerList;
    }

    /**
     * Возвращаемый метод позволяет нам извлекать информацию о работнике с соответствующими тэгами
     * @param element
     * @return
     * @throws ParseException
     */
    public static Worker parseWorkerElement(Node element) throws ParseException {

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
        Worker worker=new Worker(fullName,dateOfBorn,dateOffer,identificatedCode,salary);
        return worker;
    }


    /**
     * Метод addWorker принимает текущую коллекцию типа Worker и добавляет в него работника написанного от пользователя
     * @param workerList
     * @param workersForAdd
     * @return
     */
    public static boolean addWorker(List<Worker> workerList, Worker... workersForAdd) {
        if (workersForAdd == null && workersForAdd.length == 0) return false;
        return workerList.addAll(Arrays.asList(workersForAdd));
    }


    /**
     * Метод removeWorker() позволяет удалять элементы коллекций по идентификационному номеру
     * @param workers
     */
    public static void removeWorker(List<Worker> workers){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Удалять работников стоит,начав с цифр 12..");
        int identificated=scanner.nextInt();
        for (int i=0; i< workers.size(); i++) {
            if(workers.get(i).getIdentificatedCode()==identificated) {
                workers.remove(i);
            }
        }

    }

    //Сортировка по имени
    public static void sortByName(List<Worker> workers) {
        workers.sort((o1, o2) -> o1.getFullName().compareToIgnoreCase(o2.getFullName()));
    }

    //Сортировка по дате принятия на работу
    public static void sortDateOffer(List<Worker> workers) {
        workers.sort(((o1, o2) -> o1.getDateOffer().compareTo(o2.getDateOffer())));
    }


    //поиск самого высокооплачиваемого работника
    public static void findMaxSalary(List<Worker> workers) {
        int max=0;
        String name = "";
        for (Worker worker:workers) {
            if(max<worker.getSalary()) {
                max=worker.getSalary();
                name=worker.getFullName();
            }
        }

        System.out.println(name+" работник с самой высокой зарплатой "+max);
    }


}