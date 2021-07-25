package com.alevel.dao;

import com.alevel.writeRead.ReadWriteFile;

import java.util.Comparator;

import java.util.TreeSet;

public class TreeSetDaoImp implements CollectionsDao {
    TreeSet<TreeSet<Integer>> treeSets = new TreeSet<>(new Comparator<TreeSet<Integer>>() {
        @Override
        public int compare(TreeSet<Integer> o1, TreeSet<Integer> o2) {
            return 0;
        }
    });
    public static ReadWriteFile readWriteFile= new ReadWriteFile();

    @Override
    public void createAndAdd(String iter, String count) {
        int SIZE = Integer.parseInt(iter);
        int COUNT = Integer.parseInt(count);
        long start=System.currentTimeMillis();
        long end = 0;

        for (int ex = 0; ex < SIZE; ex++) {
            TreeSet elemEx = new TreeSet<>();
            treeSets.add(elemEx);
            for (int in = 0; in < COUNT; in++) {
                elemEx.add(in);
            }
            System.out.println("Inner TreeSet size= " + elemEx.size());
        }
        System.out.println("Exterior TreeSet size= " + treeSets.size());//Будет только один уникальный элемент в ТриСете
        //потомучто все экземпляры ТриСета созданы одинаковыми по одному и тому же циклу.
        end = System.currentTimeMillis() - start;
        System.out.println("Total end-time for TreeSet Addition = " + end);
        readWriteFile.write("TreeSet. Addition time = " + end+"\n");
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void delete() {//Iterator -объект хранит в себе последовательность
        System.out.println("Check: Exterior TreeSet size before deleting = " + treeSets.size());
        long start=System.currentTimeMillis();
        long end = 0;

        for (TreeSet ex : treeSets) {
            ex.clear();
            System.out.println("Inner TreeSet size after deleting = " + ex.size());
            }
        treeSets.clear();

        end = System.currentTimeMillis()-start;
        System.out.println("Total end-time Delete = " + end);
        readWriteFile.write("TreeSet. Delete time = " + end+"\n");
        System.out.println("Check: Exterior TreeSet size after deleting = " + treeSets.size());
        System.out.println("-------------------------------------------------");
    }
}
