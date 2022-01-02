package org.pvhees.katas.arjancodes.depinjectdepinv.start;

import org.pvhees.katas.arjancodes.RandomUtils;

public class Order {
    private final String id;
    private String status;

    public Order() {
        id = RandomUtils.randomLetters(6);
        status = "open";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
