package Presenters;

import Interactors.LoginPresenterOB;

import java.util.Objects;

public class LoginPresenter implements LoginPresenterOB {

    //Changes the UI to the screen corresponding to userType
    @Override
    public void present(String userType) {
        if(userType.equals("User")){

        }else if(userType.equals("Owner")){

        }else if(userType.equals("Realtor")){

        }
    }
}