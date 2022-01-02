package org.pvhees.katas.arjancodes.depinjectdepinv.start;

import org.pvhees.katas.arjancodes.RandomUtils;

import java.util.Scanner;

public class AuthorizerSms {
    private String code;
    private boolean authorized;

    public AuthorizerSms() {
        this.code = null;
        this.authorized = false;
    }

    public String generateCode() {
        code = RandomUtils.randomDigits(6);
        return code;
    }

    public void authorize() {
        System.out.println("Enter code: ");
        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        authorized = this.code.equalsIgnoreCase(code);
    }

    public boolean isAuthorized() {
        return authorized;
    }
}
