import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Parser.parse();//основной метод parse,в котором мы храним логику парсинга
        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выйти\n" +
                            "1. добавить работника\n" +
                            "2. вывод работников в алфавитном порядке\n" +
                            "3. вывод работников по дате получения работы\n" +
                            "4. поиск максимальной заработной платы\n"+
                            "5. удаление работника\n"+
                            "_ "
            );

            int choice = scanner.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 6) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {

                case 1:
                    System.out.print("FullName: Фамилия.И.О");
                    String fullName =scanner.next();
                    System.out.print("Date of born:");
                    String dateOfBorn = scanner.next();
                    System.out.print("Date of offer. DD-mm-YYYY:");
                    String dateString1 = scanner.next();
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    Date date1 = format.parse(dateString1);
                    System.out.print("Identificated number for worker begin with 12..:");
                    Integer identifcated = scanner.nextInt();
                    System.out.print("Salary");
                    Integer salary = scanner.nextInt();
                    WorkerUtils.addWorker(Parser.getWorkerList(), new Worker(fullName, dateOfBorn, date1, identifcated, salary));
                    break;
                case 2:
                    WorkerUtils.sortByName(Parser.getWorkerList());
                    for (Worker worker : Parser.getWorkerList()) {
                        System.out.println(worker.toString());
                    }
                    break;
                case 3:
                    WorkerUtils.sortDateOffer(Parser.getWorkerList());
                    for (Worker worker : Parser.getWorkerList()) {
                        System.out.println(worker.toString());
                    }
                    break;
                case 4:
                    WorkerUtils.findMaxSalary(Parser.getWorkerList());
                    for (Worker worker : Parser.getWorkerList()) {
                        System.out.println(worker.toString());
                    }
                    break;

                case 5:
                    WorkerUtils.removeWorker(Parser.getWorkerList());
                    for (Worker worker : Parser.getWorkerList()) {
                        System.out.println(worker.toString());
                    }
                    break;
            }
        }
    }


}
