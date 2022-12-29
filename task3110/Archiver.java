package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

import static com.javarush.task.task31.task3110.Operation.*;

public class Archiver {
    public static void main(String[] args) {
        Operation operation = null;
        while (Operation.EXIT != operation) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        }
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage(String.format("Выберите операцию:\n" +
                "%s - упаковать файлы в архив\n" +
                "%s - добавить файл в архив\n" +
                "%s - удалить файл из архива\n" +
                "%s - распаковать архив\n" +
                "%s - просмотреть содержимое архива\n" +
                "%s - выход",
                CREATE.ordinal(), ADD.ordinal(), REMOVE.ordinal(), EXTRACT.ordinal(), CONTENT.ordinal(), EXIT.ordinal()));
        int i = ConsoleHelper.readInt();
        return Operation.values()[i];
    }
}
