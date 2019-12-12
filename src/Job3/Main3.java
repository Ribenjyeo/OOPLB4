package Job3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main3 {
    //Задание 1
    private static void Task1() throws IOException {
        DataInputStream dataIn = new DataInputStream(new FileInputStream("T1.txt"));
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("T2.txt"));
        int i;
        while ((i = dataIn.read()) != -1) dataOut.write(i);
        dataIn.close();
        dataOut.close();
    }
    //Задание 2
    private static void Task2() throws Exception {
        BufferedReader inb = new BufferedReader(new FileReader("A.txt"), 128);
        BufferedWriter outb = new BufferedWriter(new FileWriter("B.txt"), 128);
        char[] buf = new char[128];

        while ((inb.read(buf)) != -1) outb.write(buf); outb.newLine();
        outb.flush();
        outb.close();
        inb.close();
    }
    //Задание 3
    private static void Task3() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src\\A.txt"), "Cp1251"));
        System.out.println("Чтение в кадировке Cp1251 ");
        String s;
        while ((s = in.readLine()) != null) System.out.println(s);
        BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream("src\\A.txt"), StandardCharsets.UTF_8));
        System.out.print("Чтение в кодировке: ");
        System.out.println(Charset.defaultCharset().name());
        String s1;
        while ((s1 = in1.readLine()) != null) System.out.println(s1);


    }

    public static void main(String[] args) {
        try {
            Task1();
            Task2();
            Task3();
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }
}
