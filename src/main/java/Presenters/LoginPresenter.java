package Presenters;

import Interactors.LoginPresenterOB;

import java.util.Objects;

public class LoginPresenter implements LoginPresenterOB {

    //Changes the UI to the screen corresponding to userType
    @Override
    public void present(String userType) {
        if(userType.equals("User")){
            //open the User home screen
        }else if(userType.equals("Owner")){
            //open the Owner home screen
        }else if(userType.equals("Realtor")){
            //open the Realtor home screen
        }
    }
}
