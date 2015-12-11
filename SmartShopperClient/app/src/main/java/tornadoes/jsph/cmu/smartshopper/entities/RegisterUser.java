package tornadoes.jsph.cmu.smartshopper.entities;

import tornadoes.jsph.cmu.smartshopper.beans.RegisterUserBean;
import tornadoes.jsph.cmu.smartshopper.ws.IUserRegisterWebService;
import tornadoes.jsph.cmu.smartshopper.ws.RegisterUserWS;

public class RegisterUser implements IUserRegister{

    IUserRegisterWebService reg;
    @Override
    public String userPersist(RegisterUserBean rub) {


        reg=new RegisterUserWS();

        String username=rub.getUserName();
        String password=rub.getPassword();
        String email=rub.getEmail();

        return reg.userPersistToServer(username,password,email);

    }
}
