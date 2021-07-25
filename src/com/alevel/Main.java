package com.alevel;

import com.alevel.writeRead.CrudFile;
import com.alevel.writeRead.FileType;

public class Main {

    public static void main(String[] args) {
        new CrudFile().createFile(FileType.FILE_PATH.getPath());
        new Controller().run();

        //прилетит строка "file.txt"

    }
}
