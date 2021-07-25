package com.alevel.writeRead;

public enum FileType {

    FILE_PATH("file.txt");

    private final String path;

    FileType(String path) {//конструктор
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}