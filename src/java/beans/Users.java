package beans;

import java.util.ArrayList;

/**
 *
 * @author dmitry
 */
public class Users {
    private static ArrayList <User> USERS = new ArrayList<>();
    
    private Users(){}
    
    public ArrayList<User> getUSERS(){
        return USERS;
    }
    
    public User getUserById(int id){
        return null;
    }
    
    public User getUserByEmail(int id){
        return null;
    }
    
    public void addUser(User user){
        USERS.add(user);
    }
    
    public void removeUser(User user){
        for (int i = 0; i < USERS.size(); i++){
            if (USERS.get(i).equals(user)){
                USERS.remove(i);
                break;
            }
        }
    }
}
