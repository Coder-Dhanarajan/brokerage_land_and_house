package useraccount;
public class UserDataManager {
    public int userId;
    public String userName;
    public String email;
    public String password;
    UserDataManager(String username, String email, String password, int uid){
        userId =uid;
        this.userName =username;
        this.email=email;
        this.password=password;
    }


}