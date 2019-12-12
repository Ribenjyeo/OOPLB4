package Job1;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Задание 1
        try {
            //упражнение 1
            File MyFile1 = new File("MyFile1.txt"); //Создать файл в папке приложения с именем MyFile1.txt.
            MyFile1.createNewFile(); //Проверка
            File MyFile2 = new File("D:\\MyFile2.txt"); //Создать файл с именем MyFile2.txt в корне определенного диска.
            MyFile2.createNewFile();//Проверка
            File MyFile3 = new File("C:\\Users\\xxxxs\\Desktop\\WHYFile1.txt");//Создать файл с именем MyFile3.txt в папке Имя диска\\Имя папки\\Имя файла.
            MyFile3.createNewFile();//Проверка
            File folders = new File("One\\Two\\Three");//Создать папку третьего уровня, например, Первая\\Вторая\\Третья.
            folders.mkdirs();//Проверка

            //Упражнение 2
            System.out.println("Задание №2:");
            System.out.println("Введите путь к файлу:");
            Scanner in = new Scanner(System.in);
            String way = in.next();
            File task2 = new File(way);
            System.out.println(task2.getName());
            System.out.println(task2.getParent());

            if (!way.contains(".")){
                System.out.println("Введена папка а не файл");
            }

            File check = new File("MyFile1.txt");
            if(check.exists()){
                System.out.println("MyFile1.txt существует");
            }
            else{
                System.out.println("MyFile1.txt не существует");
            }

            System.out.println(task2.getAbsolutePath()); //Абсолютный путь

            System.out.println(task2.length() + " байт");
            if (task2.isDirectory()){
                System.out.println("Объект - папка");
            }
            else{
                System.out.println("Объект - файл");
            }

            //Упражнение 3
            System.out.println("___________________________________________");
            System.out.println("Задание №3");
            File addpackage = new File("newDirectory");
            addpackage.mkdir();
            File folder = new File("C:\\Users\\xxxxs\\IdeaProjects\\KumanekLB4");
            String[] listOfFiles_str = folder.list();
            File[] listOfFiles = folder.listFiles();

            System.out.println("Содержимое папки приложения list():");
            assert listOfFiles_str != null;
            for(String y: listOfFiles_str){
                System.out.println(y);
            }
            System.out.println("+++++++++++");

            System.out.println("Содержимое папки приложения listFiles():");
            int fi = 0, dir = 0;
            assert listOfFiles != null;
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    System.out.println(listOfFile.getName());
                    fi++;
                } else if (listOfFile.isDirectory()) {
                    System.out.println(listOfFile.getName());
                    dir++;
                }
            }
            System.out.println("Количество файлов: " + fi);
            System.out.println("Количество папок: " + dir);

            MyFile1.delete();
            MyFile2.delete();
            MyFile3.delete();
            folders.delete();
            folders = new File ("Bum\\Kadabra");
            folders.delete();
            folders = new File ("Bum");
            folders.delete();
            addpackage.delete();

        }catch (Exception e){
            System.out.println("error");
        }
    }
}

