package Job4;

public class Main4 {
    public static void main(String[] args) {
        try {
            ClassTextFile ctf = new ClassTextFile("task4.txt");
            User user1 = new User();
            ctf.fill(user1);
            System.out.println(user1.getName()+" "+user1.getLogin() + " " + user1.getPassword());
            ClassSeriyazableFile csf = new ClassSeriyazableFile("task4_2.txt");
            csf.record(user1);
            user1 = csf.read();
            System.out.println(user1.getName()+" "+user1.getLogin() + " " + user1.getPassword());
            csf.collection();
            csf.readfile();
            System.out.println(csf.gerArray().toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
