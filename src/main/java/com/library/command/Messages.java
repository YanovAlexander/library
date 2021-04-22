package com.library.command;

public enum  Messages {
    PUBLICATION_YEAR("Введите год публикации: ", "Вы ввели не число, введите год публикации."),
    PAGE_NUMBER("Введите количество страниц: ", "Вы ввели не целое число страниц, введите верное количество страниц.");

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
