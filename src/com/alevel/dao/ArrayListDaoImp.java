package com.alevel.dao;

import com.alevel.writeRead.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDaoImp implements CollectionsDao {
    //создали пустой аррейлист arrLists для его экземпляров
    public static  List<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public static ReadWriteFile readWriteFile= new ReadWriteFile();

    @Override
    public void createAndAdd(String iter, String count) {
        int SIZE = Integer.parseInt(iter);
        int COUNT = Integer.parseInt(count);

        long start=System.currentTimeMillis();
        long end = 0;
        for (int ex = 0; ex <SIZE; ex++){
            arrayLists.add(new ArrayList<>());
            for (int in=0; in<COUNT; in++){
                arrayLists.get(ex).add(in);
            }
            System.out.println("Inner ArrayList size= " + arrayLists.get(ex).size());
        }
        System.out.println("Exterior ArrayList size= " + arrayLists.size());
        end = System.currentTimeMillis()-start;
        System.out.println("Total end-time for ArrayList Addition = " + end);
        readWriteFile.write("ArrayList. Addition time = " + end+"\n");
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void delete() {//Iterator -объект хранит в себе последовательность
        System.out.println("Check: Exterior ArrayList size before deleting = " + arrayLists.size());
        //Iterator<ArrayList<Integer>> arrListsIterator= arrLists.iterator();

        long start=System.currentTimeMillis();
        long end = 0;

        for (int ex = (arrayLists.size()-1); ex>=0; ex--){
             for (int in = (arrayLists.get(ex).size()-1); in>=0; in--){
                arrayLists.get(ex).remove(in);
            }
            System.out.println("Inner ArrayList size after deleting = " + arrayLists.get(ex).size());
            arrayLists.remove(ex);
        }

        /*Iterator<ArrayList<Integer>> arrListsIterator= arrLists.iterator();
        while (arrListsIterator.hasNext()){//пока есть следующий (boolean)
            arrListsIterator.next(); //получаем next
            arrListsIterator.remove();//удаляем его
        }*/
        end = System.currentTimeMillis()-start;
        System.out.println("Total end-time Delete = " + end);
        readWriteFile.write("ArrayList. Delete time = " + end+"\n");
        System.out.println("Check: Exterior ArrayList size after deleting = " + arrayLists.size());
        System.out.println("-------------------------------------------------");
    }
}
