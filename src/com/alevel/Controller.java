package com.alevel;

import com.alevel.dao.*;
import com.alevel.writeRead.ReadWriteFile;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private final CollectionsDao collectionsDao = new ArrayListDaoImp();
    private final CollectionsDao collectionsDaoLink = new LinkedListDaoImp();
    private final CollectionsDao collectionsDaoHash = new HashSetDaoImp();
    private final CollectionsDao collectionsDaoLinkedHash = new LinkedHashSetDaoImp();
    private final CollectionsDao collectionsDaoTree = new TreeSetDaoImp();
    public static ReadWriteFile readWriteFile= new ReadWriteFile();
    //private final BookDao bookDao = new BookDaoImpJson();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {System.out.println("Create collections, add elements, please enter");

            if ((reader.readLine()) != null)  {
                createAndAdd(reader);
               }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
        readWriteFile.write("-----------------------------------------------\n");
        System.out.println("-----------------------------------------------");
        try {System.out.println("Delete elements from collections, please enter");
            if ((reader.readLine()) != null) {
                delete();
            } else System.exit(0);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
        readWriteFile.write("-----------------------------------------------\n");
        System.out.println("Check File.txt");
    }

    private void createAndAdd(BufferedReader reader) {
        System.out.println("Controller.create");
        try {
            System.out.println("Please, enter collection instances - ITEM:");
            String iter = reader.readLine();
            readWriteFile.write("iter:"+iter+"\n");
            System.out.println("Please, enter collection size - COUNT:");
            String count = reader.readLine();
            readWriteFile.write("count:"+count+"\n");
            readWriteFile.write("-----------------------------------------------\n");
            collectionsDao.createAndAdd(iter, count);
            collectionsDaoLink.createAndAdd(iter, count);
            collectionsDaoHash.createAndAdd(iter, count);
            collectionsDaoLinkedHash.createAndAdd(iter, count);
            collectionsDaoTree.createAndAdd(iter, count);

        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }
    private void delete() {
        System.out.println("Controller.delete");
        collectionsDao.delete();
        collectionsDaoLink.delete();
        collectionsDaoHash.delete();
        collectionsDaoLinkedHash.delete();
        collectionsDaoTree.delete();
    }





}
