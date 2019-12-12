package Job4;

import java.io.File;
import java.util.Scanner;
import java.io.Serializable;

class ClassTextFile implements Serializable{
    private String file = "";

    ClassTextFile(String f){
        if (new File(f).exists()){
            file = f;
        }else{
            System.out.println("Файла не существует");
        }
    }

    void fill(User s) throws Exception{
        Scanner i = new Scanner(new File(file));
        while (i.hasNextLine()){
            s.setName(i.next());
            s.setLogin(i.next());
            s.setPassword(i.next());
        }
        i.close();
    }

}
