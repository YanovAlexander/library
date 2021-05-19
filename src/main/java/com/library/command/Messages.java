package com.library.command;

public enum  Messages {
    PUBLICATION_YEAR("Enter the publication's year: ", "Wrong data, enter the number"),
    PAGE_NUMBER("Enter number of pages: ", "Wrong format, enter integer.");

    private String message;
    private String errorMessage;

    Messages(String message, String errorMessage) {
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
