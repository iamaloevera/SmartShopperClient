package tornadoes.jsph.cmu.smartshopper.entities;

import tornadoes.jsph.cmu.smartshopper.beans.UserCredentialBean;

public interface IAuthUser {

    public String verifyLogin(UserCredentialBean ucb);

}
