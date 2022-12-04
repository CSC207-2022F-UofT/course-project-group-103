package controllers;

import interactors.SignUpInteractor;

public class SignUpScreenController {

    SignUpInteractor signUpInteractor;
    Presenter presenter;

    public SignUpScreenController(SignUpInteractor i, Presenter p) {
        this.signUpInteractor = i;
        this.presenter = p;
    }

    public void back() {
        this.presenter.displayLogin();
    }

    public void showHome() {
        this.presenter.displayHome();
    }

    public void sendSignUp(String username, String contact, String password,
                           String confirm_password) throws Exception {
        this.signUpInteractor.signUp(username, contact, password, confirm_password);
    }
}
