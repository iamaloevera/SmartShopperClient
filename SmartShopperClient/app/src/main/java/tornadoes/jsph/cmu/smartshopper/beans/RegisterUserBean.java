package tornadoes.jsph.cmu.smartshopper.beans;

import tornadoes.jsph.cmu.smartshopper.entities.IUserRegister;
import tornadoes.jsph.cmu.smartshopper.entities.RegisterUser;

public class RegisterUserBean {

    String userName;
    String password;
    String email;

    IUserRegister registerUserEntity;

    public RegisterUserBean(String username,String password,String email){
        this.userName=username;
        this.password=password;
        this.email=email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisterResponse(){

        registerUserEntity=new RegisterUser();

        System.out.println("Register bean called");

            return registerUserEntity.userPersist(this);

    }
}
