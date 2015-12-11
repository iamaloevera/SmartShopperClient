package tornadoes.jsph.cmu.smartshopper.entities;

import tornadoes.jsph.cmu.smartshopper.beans.UserCredentialBean;
import tornadoes.jsph.cmu.smartshopper.ws.AuthenticateUser;
import tornadoes.jsph.cmu.smartshopper.ws.IUserAuthWebService;

public class CheckLogin implements IAuthUser{

IUserAuthWebService authWS;
    public CheckLogin(){
        authWS=new AuthenticateUser();
    }
    public String verifyLogin(UserCredentialBean ucb){

        String username=ucb.getUsername();
        String password=ucb.getPassword();




      return authWS.checkUserCredentials(username,password);

    }
}
