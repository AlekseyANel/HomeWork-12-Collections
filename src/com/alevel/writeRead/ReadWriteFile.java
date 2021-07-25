package com.alevel.writeRead;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
    public void write(String s){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(FileType.FILE_PATH.getPath(), true));

            bufferedWriter.write(s);
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
