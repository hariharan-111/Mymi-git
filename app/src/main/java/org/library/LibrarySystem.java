package org.library;

import java.io.IOException;
import java.util.Scanner;

public class LibrarySystem {
  private int userType;
  private String userName;

  LibrarySystem(int userType, String userName) {
    this.userType = userType;
    this.userName = userName;
  }

  public int getUserType() {
    return this.userType;
  }

  public void setUserType(int type) {
    this.userType = type;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String name) {
    this.userName = name;
  }

  LibrarySystem() {
  }

  public static int serveUserType(){
    UserType[] userTypes = UserType.values();
    Scanner localRead = new Scanner(System.in);
    System.out.println("-------------------------------------------------------------");
    System.out.println("-------------------------------------------------------------");
    System.out.println("-------------------------------------------------------------");
    for(UserType value: userTypes) {
      System.out.println("To register as " + value.displayName.toUpperCase() + "press " + value.code);
    }
    int choice = localRead.nextInt();
    localRead.close();
    System.out.println("-------------------------------------------------------------");
    System.out.println("-------------------------------------------------------------");
    System.out.println("-------------------------------------------------------------");
    return choice;
  }

  static LibrarySystem getLibraryInstance(String userName) {
    int userType = LibrarySystem.serveUserType();
    return new LibrarySystem(userType, userName);
  }

  static boolean checkUser(int userId) {
    List<LibrarySystem> userList= RegisterFileHandler.getUsers();

    if (userList.size() > 0) {
      for (LibrarySystem user : userList) {
        if (user.userName.equals(userName)) {
          return true;
        }
      }

    }

    return false;
  }

  public boolean login() {
    return true;
  }

  public boolean logout() {
    return true;
  }

  public void Register() throws IOException {
    RegisterFileHandler register = new RegisterFileHandler();
    try {
      register.writeUser(this);
    } catch (IOException e) {
      System.out.println(e);
      throw e;
    }
  }
}
