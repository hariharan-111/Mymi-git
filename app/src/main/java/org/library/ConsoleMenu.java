package org.library;

public enum ConsoleMenu {
    TO_REGISTER(1, "To Register Press 1"),
    TO_LOGIN(2, "To Login Press 2");

    final int code;
    final String desc;

    ConsoleMenu(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ConsoleMenu getValue(int code) throws Exception {
        ConsoleMenu[] menuList = values();
        for (ConsoleMenu value : menuList) {
            if (value.code == code) {
                return value;
            }
        }
        throw new Exception();
    }
}
