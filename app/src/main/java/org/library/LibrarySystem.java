package org.library;

import java.io.IOException;
import java.util.Scanner;

public class LibrarySystem {
  private int userType;
  private String userName;
  public boolean loginStatus;

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
    try {
      LibrarySystem existingUser = getUser(userName);
      if (exsitingUser != null) {
        return existingUser;
      }
    } catch (Exception e) {
      int userType = serveUserType();
      return new LibrarySystem(userType, userName);
    }
  }

  static LibrarySystem getUser(String userName) throws Exception {
    List<LibrarySystem> userList= RegisterFileHandler.getUsers();

    if (userList.size() > 0) {
      for (LibrarySystem user : userList) {
        if (user.userName.toLowerCase().equals(userName.toLowerCase)) {
          return user;
        }
      }

    }
    throw new Exception();
  }

  public boolean login() {
    try {
      if (getUser(this.userName) != null) {
        this.loginStatus = true;
        return true;
      }
    } 
    catch(Exception e) {
      System.out.println("User Not found.");
      return false;
    }
  }

  public void logout() {
    this.loginStatus = false;
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

  public void serveOptions() {
    Scanner localRead = new Scanner(System.in);
    System.out.println("------------------Options------------------------");
    System.out.println("-------------------------------------------------");
    System.out.println("--------------------------------------------------");
    LibraryOptions[] options = LibraryOptions.values();
    for (LibraryOptions opt: options) {
      System.out.println("To " +  opt.desc + "press " + opt.code);
    }
    int choice = Integer.parseInt(localRead.nextLine());
    localRead.close();
    System.out.println("--------------------------------------------------");
    System.out.println("--------------------------------------------------");
    System.out.println("--------------------------------------------------");

    switch(choice) {
      case 1: {
        try {
          Books.listBooks();
        } catch (Exception e) {
          System.out.println('Exception Occured', e);
        }
      }
      break;
    }
  }
}
