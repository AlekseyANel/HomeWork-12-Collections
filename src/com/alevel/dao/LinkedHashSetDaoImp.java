package com.alevel.dao;

import com.alevel.writeRead.ReadWriteFile;

import java.util.LinkedHashSet;

public class LinkedHashSetDaoImp implements CollectionsDao {
    //создали пустой HashSet для его экземпляров
    public static LinkedHashSet<LinkedHashSet<Integer>> linkedHashSets = new LinkedHashSet<>();
    public static ReadWriteFile readWriteFile= new ReadWriteFile();

    @Override
    public void createAndAdd(String iter, String count) {
        int SIZE = Integer.parseInt(iter);
        int COUNT = Integer.parseInt(count);
        long start=System.currentTimeMillis();
        long end = 0;

        for (int ex = 0; ex < SIZE; ex++) {
            LinkedHashSet elemEx = new LinkedHashSet<>();
            linkedHashSets.add(elemEx);
            for (int in = 0; in < COUNT; in++) {
                elemEx.add(in);
            }
            System.out.println("Inner LinkedHashSet size= " + elemEx.size());
        }
        System.out.println("Exterior LinkedHashSet size= " + linkedHashSets.size());
        end = System.currentTimeMillis() - start;
        System.out.println("Total end-time for LinkedHashSet Addition = " + end);
        readWriteFile.write("LinkedHashSet. Addition time = " + end+"\n");
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void delete() {//Iterator -объект хранит в себе последовательность
        System.out.println("Check: Exterior LinkedHashSet size before deleting = " + linkedHashSets.size());
        long start=System.currentTimeMillis();
        long end = 0;

        for (LinkedHashSet ex : linkedHashSets) {
            ex.clear();
            System.out.println("Inner LinkedHashSet size after deleting = " + ex.size());
            }
        linkedHashSets.clear();

        end = System.currentTimeMillis()-start;
        System.out.println("Total end-time Delete = " + end);
        readWriteFile.write("LinkedHashSet. Delete time = " + end+"\n");
        System.out.println("Check: Exterior LinkedHashSet size after deleting = " + linkedHashSets.size());
        System.out.println("-------------------------------------------------");
    }
}
