package Job2;

import java.io.*;
import java.util.*;

public class FileJob {
    private String fname = "";
    private Scanner in = new Scanner(System.in);

    public void write(LinkedList<Syllabus> syllabus_array) throws Exception {
        System.out.println("Введите имя файла: ");
        fname = in.next();
        fname += ".txt";
        DataOutputStream write = new DataOutputStream(new FileOutputStream(fname));
        for (Syllabus i : syllabus_array) {
            write.writeInt(i.Get_d_code());
            write.writeUTF(i.Get_d_name());
            write.writeUTF(i.Get_kind_a());
            write.writeInt(i.Get_p_code());
            write.writeUTF(i.Get_p_name());
            write.writeInt(i.Get_y_s_S());
        }
        File f = new File(fname);
        if (f.exists())
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");
        write.close();
    }

    public LinkedList<Syllabus> read(int numP) throws Exception {
        LinkedList<Syllabus> syllabus_array = new LinkedList<>();
        String  d_n, k_a, p_n;
        int d_c, p_c, y_s_S;
        DataInputStream read = new DataInputStream(new FileInputStream(fname));
        while (read.available() > 0) {
            d_c =read.readInt();
            d_n =read.readUTF();
            k_a =read.readUTF();
            p_c =read.readInt();
            p_n = read.readUTF();
            y_s_S = read.readInt();
            if (y_s_S == numP) {
                Syllabus new2_syllabus = new Syllabus(d_c, d_n, k_a, p_c, p_n, y_s_S);
                syllabus_array.add(new2_syllabus);
            }
        }
        read.close();
        return syllabus_array;
    }

    public void randommm(LinkedList<Syllabus> syllabus_array) throws Exception {
        fname.replaceAll(".txt","R" + Math.random());
        fname += ".txt";
        DataOutputStream write = new DataOutputStream(new FileOutputStream(fname));
        for (Syllabus i : syllabus_array) {
            byte[] text = i.toString().getBytes("UTF-8");
            write.write(text);
            write.write("\r\n".getBytes("UTF-8"));
        }
        File f = new File(fname);
        if (f.exists())
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");
        write.close();

        RandomAccessFile rand = new RandomAccessFile(fname, "rw");
        rand.seek(0);

        System.out.println("Введите номер");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        LinkedList<Syllabus> temp = new LinkedList<>();
        String[] tmp;
        for(Syllabus i : syllabus_array){
            if(number == i.Get_p_code()){
                System.out.println("На что заменить?");
                String d = in.next();
                tmp = rand.readLine().split(" ");
                i = new Syllabus(Integer.parseInt(tmp[0]), tmp[1], tmp[2], Integer.parseInt(tmp[3]), d, Integer.parseInt(tmp[5]));
                temp.add(i);
            }
        }


        rand.seek(0);
        for (Syllabus i : temp) {
            byte[] text = i.toString().getBytes("UTF-8");
            rand.write(text);
            rand.write("\r\n".getBytes("UTF-8"));
        }
        rand.close();
    }
}

