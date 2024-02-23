package pl.wszib.lms.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
    private int id;
    private String login;
    private String password;
    private String role;

    public User(String login, int id, String password, String role){
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User(int id, String login, String password, String role){
        this.login = login;
        this.password = password;
        this.role = role;
    }

}