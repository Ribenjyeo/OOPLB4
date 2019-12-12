package Job2;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {

    public static void  main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    LinkedList<Syllabus> plusjob = new LinkedList<>();
    int n;
    Syllabus new_Syllabus = new Syllabus();
    FileJob file = new FileJob();
    while(true){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Меню программы:");
        System.out.println("1. Создать Учебный план");
        System.out.println("2. Вернуть по шифру направления и шифру профиля вид деятельности");
        System.out.println("3. Определить относится ли два плана к одному направлению");
        System.out.println("4. Запись данных в файл");
        System.out.println("5. Чтение данных из файла (дополнительное задание)");
        System.out.println("6. Завершить работу");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        int y = in.nextInt();
        switch (y){
            case 1:
                new_Syllabus.AddSyllabus();
                new_Syllabus.print();
                break;
            case 2:
                new_Syllabus.Return_kind_a();
                break;
            case 3:
                new_Syllabus.Two_d_name();
                break;
            case 4:
                try {
                    file.write(new_Syllabus.syllabus_array);
                }
                catch (Exception e){
                    System.out.println("Error");
                }
                break;
            case 5:
                System.out.println("Введите год ");
                try {
                    n = in.nextInt();
                    plusjob = file.read(n);
                    if (plusjob.size() > 0) {
                        System.out.println("УП: ");
                        for (Syllabus i : plusjob) {
                            i.print();
                        }
                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }

                try{
                    file.randommm(new_Syllabus.syllabus_array);
                }
                catch (Exception e){
                    System.out.println("Error");
                }

                break;
            case 6: System.exit(0);
                break;
        }

    }
    }
}
