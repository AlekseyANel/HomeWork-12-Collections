package com.alevel.dao;

import com.alevel.writeRead.ReadWriteFile;

import java.util.HashSet;

public class HashSetDaoImp implements CollectionsDao {
    //создали пустой HashSet для его экземпляров
    public static  HashSet<HashSet<Integer>> hashSets = new HashSet<>();
    public static ReadWriteFile readWriteFile= new ReadWriteFile();

    @Override
    public void createAndAdd(String iter, String count) {
        int SIZE = Integer.parseInt(iter);
        int COUNT = Integer.parseInt(count);
        long start=System.currentTimeMillis();
        long end = 0;

        for (int ex = 0; ex < SIZE; ex++) {
            HashSet elemEx = new HashSet<>();
            hashSets.add(elemEx);
            for (int in = 0; in < COUNT; in++) {
                elemEx.add(in);
            }
            System.out.println("Inner HashSet size= " + elemEx.size());
        }
        System.out.println("Exterior HashSet size= " + hashSets.size());
        end = System.currentTimeMillis() - start;
        System.out.println("Total end-time for HashSet Addition = " + end);
        readWriteFile.write("HashSet. Addition time = " + end+"\n");
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void delete() {//Iterator -объект хранит в себе последовательность
        System.out.println("Check: Exterior HashSet size before deleting = " + hashSets.size());
        long start=System.currentTimeMillis();
        long end = 0;

        for (HashSet ex : hashSets) {
            ex.clear();
            System.out.println("Inner HashSet size after deleting = " + ex.size());
            }
        hashSets.clear();

        end = System.currentTimeMillis()-start;
        System.out.println("Total end-time Delete = " + end);
        readWriteFile.write("HashSet. Delete time = " + end+"\n");
        System.out.println("Check: Exterior HashSet size after deleting = " + hashSets.size());
        System.out.println("-------------------------------------------------");
    }
}
