package Job2;

import java.util.LinkedList;
import java.util.Scanner;

class Syllabus {
    private int derection_code;
    private String derection_name;
    private String kind_activity;
    private int profile_code;
    private String profile_name;
    private int year_start_Syllabus;
    LinkedList<Syllabus> syllabus_array = new LinkedList<>();

    Syllabus(int d_code, String d_name, String kind_a, int p_code, String p_name, int y_s_S){
        this.derection_code = d_code;
        this.derection_name = d_name;
        this.kind_activity = kind_a;
        this.profile_code = p_code;
        this.profile_name = p_name;
        this.year_start_Syllabus = y_s_S;
    }
    Syllabus(){}

    void Set_d_code(int d_code){ this.derection_code = d_code;}
    int Get_d_code (){return derection_code;}
    void Set_d_name(String d_name){this.derection_name = d_name;}
    String Get_d_name(){return derection_name;}
    void Set_kind_a(String kind_a){this.kind_activity = kind_a;}
    String Get_kind_a(){return kind_activity;}
    void Set_p_code(int p_code){this.profile_code = p_code;}
    int Get_p_code(){return profile_code;}
    void Set_p_name(String p_name){this.profile_name = p_name;}
    String Get_p_name(){return profile_name;}
    void Set_y_s_S(int y_s_S){this.year_start_Syllabus =y_s_S;}
    int Get_y_s_S(){return year_start_Syllabus;}

    void print(){
        System.out.println("Шифр направления: " + derection_code + " Название направления: " +derection_name + " Вид деятельности: " +kind_activity + " Шифр профиля: " +profile_code + " Название профиля: " +profile_name +" Год начала действияя УП" +year_start_Syllabus);
    }

    @Override
    public String toString(){
      return String.valueOf(derection_code)+" "+derection_name+" "+kind_activity+" "+String.valueOf(profile_code)+" "+profile_name+" "+String.valueOf(year_start_Syllabus);
    }

        void AddSyllabus(){ //Добавление УП
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите шифр направления: ");
            int d_code = in.nextInt();
            Set_d_code(d_code);
            if(d_code < 0) throw new Exception(d_code + " не может быть меньше 0");
            System.out.println("Введите название направления: ");
            String d_name = in.next();
            Set_d_name(d_name);
            System.out.println("Вид деятельности: ");
            String kind_a = in.next();
            Set_kind_a(kind_a);
            System.out.println("Введите шифр профиля: ");
            int p_code = in.nextInt();
            Set_p_code(p_code);
            if(p_code < 0) throw new Exception(p_code +" не может быть меньше 0");
            System.out.println("Введите название профиля: ");
            String p_name = in.next();
            Set_p_name(p_name);
            System.out.println("Введите год начала действия УП: ");
            int y_s_S = in.nextInt();
            Set_y_s_S(y_s_S);
            if(y_s_S < 1950 || y_s_S > 2020) throw new Exception(y_s_S +" не может быть меньше 1950 и больше 2020");
            Syllabus new_syllabus = new Syllabus(Get_d_code(), Get_d_name(), Get_kind_a(), Get_p_code(), Get_p_name(), Get_y_s_S());
            syllabus_array.add(new_syllabus);
        }
         catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    void Return_kind_a (){ //Определить по шифру направления и шифру профиля вернуть вид деятельности.
        Scanner in = new Scanner(System.in);
        if(syllabus_array.size() != 0){
            try{
                System.out.println("Введите шифр направления: ");
                int d_code = in.nextInt();
                if(d_code < 0) throw new Exception(d_code + " не может быть меньше 0");
                System.out.println("Введите шифр профиля: ");
                int p_code = in.nextInt();
                if(p_code < 0) throw new Exception(p_code +" не может быть меньше 0");
                for(Syllabus a : syllabus_array){
                    if(d_code == a.Get_d_code() && p_code == a.Get_p_code()) System.out.println("Вид деятельности" + Get_kind_a());
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    void Two_d_name(){ //Определить относится ли два плана к одному направлению
        Scanner in = new Scanner(System.in);
        if(syllabus_array.size() > 1){
                System.out.println("Введите название направления: ");
                String d_name = in.next();
                Syllabus a = null, b = null;
                    for(Syllabus i : syllabus_array){
                        if(d_name.equals(i.Get_d_name()) && a == null)a = i;
                        assert a != null;
                        if(d_name.equals(i.Get_d_name()) && i.Get_p_code() != a.Get_p_code() && i.Get_d_code() != a.Get_p_code()) b = i;
                        if(b != null) System.out.println("План: " +a.toString() + " и план: " + b.toString() +" относятся к направлению " +d_name);
                    }
        }
    }
}




