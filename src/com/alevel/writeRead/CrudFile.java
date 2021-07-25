package com.alevel.writeRead;

import java.io.File;
import java.io.IOException;

public class CrudFile {
    public void createFile(String path){
        File file = new File(path);//в конструктор передаем наш путь
        //Получаем абсолютный путь к файлу
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = "+ absolutePath);
        boolean exists = file.exists();//будет фолс.Будеи все мета информация профайл. Кроме самого создания
        System.out.println("is file exists = "+ exists);//java не умеет делать файлы
        try {
            file.createNewFile();//этот метод создает файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
