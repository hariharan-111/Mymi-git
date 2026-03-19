package org.library;

public enum UserType {
    ADMIN( "admin", 1),
    LIBRARIAN("librarian", 2),
    STAFF("staff", 3),
    STUDENT("student", 4);

    int code;
    String displayName;

    UserType(String displayName, int code) {
        this.code = code;
        this.displayName = displayName;
    }

    static int getCode(String val) throws Exception{
        UserType[] typeArr = values();
        for (UserType userType: typeArr) {
            if (userType.displayName.equals(val)) {
                return userType.code;
            }
        }
        throw new Exception();
    }

}
