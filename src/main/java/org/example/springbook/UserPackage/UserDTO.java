package org.example.springbook.UserPackage;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private String username;

    public UserDTO(String username){
        this.username = username;
    }

}
