package org.library;

public enum LibraryOptions {
  GET_LIST_OF_BOOKS(1, "List Of Books"),
  BORROW_BOOK(2, "Borrow Books"),
  RETURN_BOOK(3, "Return Borrowed Books");

  private final int code;
  private final String desc;

  LibraryOptions(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public LibraryOptions getInstance(int code) throws Exception {
    LibraryOptions[] opt = values();
    for (LibraryOptions option : opt) {
      if (option.code == code) {
        return option;
      }
    }

    throw new Exception();
  }
}
 
