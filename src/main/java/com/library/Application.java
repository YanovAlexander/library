package com.library;

import java.util.Arrays;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {

        System.out.println("Добро пожаловать в библиотеку.  Введите команду help  для получения списка доступных команд.");

        Scanner scanner = new Scanner(System.in);
        while (true) {

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("help")) {
                System.out.println("Введите  help, чтобы увидеть список всех доступных команд.");
                System.out.println("Введите exit для выхода из программы.");
            } else if (input.equalsIgnoreCase("exit")) {
                break;
            }else{
                System.out.println("Такой команды нет в списке, пожалуйста, повторите ввод.");
            }
        }
        scanner.close();
    }
}
