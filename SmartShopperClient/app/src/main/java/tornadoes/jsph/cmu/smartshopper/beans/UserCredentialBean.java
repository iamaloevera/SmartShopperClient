package tornadoes.jsph.cmu.smartshopper.beans;

import tornadoes.jsph.cmu.smartshopper.entities.CheckLogin;
import tornadoes.jsph.cmu.smartshopper.entities.IAuthUser;

public class UserCredentialBean {

    String username;
    String password;
    IAuthUser authUser;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserLogin(){
        authUser=new CheckLogin();
        return authUser.verifyLogin(this);
    }


}
