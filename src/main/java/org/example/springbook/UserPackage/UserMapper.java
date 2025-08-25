package org.example.springbook.UserPackage;

public class UserMapper {
    public static UserDTO mapUserToDTO(User user){
        return new UserDTO(user.getUsername());
    }
}
