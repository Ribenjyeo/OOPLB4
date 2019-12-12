package Job4;

import java.io.*;

public class User implements Serializable {
    private String name;
    private String login;
    private String password;

    User(){
        name = "";
        login = "";
        password = "";
    }

    User(String n, String l, String p){
        name = n;
        login = l;
        password = p;
    }

    void setLogin(String login) { this.login = login; }

    void setName(String name) {
        this.name = name;
    }

    void setPassword(String password) {
        this.password = password;
    }

    String getLogin() {
        return login;
    }

    String getName() {
        return name;
    }

    String getPassword() { return password; }

    @Override
    public String toString() {
        return name + " " + login +" " + password;
    }
}

