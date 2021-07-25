package com.alevel.dao;

import com.alevel.writeRead.ReadWriteFile;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDaoImp implements CollectionsDao {
    //создали пустой аррейлист arrLists для его экземпляров
    public static  List<LinkedList<Integer>> linkedLists = new LinkedList<>();
    public static ReadWriteFile readWriteFile= new ReadWriteFile();

    @Override
    public void createAndAdd(String iter, String count) {
        int SIZE = Integer.parseInt(iter);
        int COUNT = Integer.parseInt(count);

        long start=System.currentTimeMillis();
        long end = 0;
        for (int ex = 0; ex <SIZE; ex++){
            linkedLists.add(new LinkedList<>());
            for (int in=0; in<COUNT; in++){
                linkedLists.get(ex).add(in);
            }
            System.out.println("Inner linkedList size= " + linkedLists.get(ex).size());
        }
        System.out.println("Exterior linkedList size= " + linkedLists.size());
        end = System.currentTimeMillis()-start;
        System.out.println("Total end-time for LinkedList Addition = " + end);
        readWriteFile.write("LinkedList. Addition time = " + end+"\n");
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void delete() {//Iterator -объект хранит в себе последовательность
        System.out.println("Check: Exterior linkedList size before deleting = " + linkedLists.size());
        //Iterator<ArrayList<Integer>> arrListsIterator= arrLists.iterator();

        long start=System.currentTimeMillis();
        long end = 0;

        for (int ex = (linkedLists.size()-1); ex>=0; ex--){
             for (int in = (linkedLists.get(ex).size()-1); in>=0; in--){
                linkedLists.get(ex).remove(in);
            }
            System.out.println("Inner linkedLists size after deleting = " + linkedLists.get(ex).size());
            linkedLists.remove(ex);
        }

        /*Iterator<ArrayList<Integer>> arrListsIterator= arrLists.iterator();
        while (arrListsIterator.hasNext()){//пока есть следующий (boolean)
            arrListsIterator.next(); //получаем next
            arrListsIterator.remove();//удаляем его
        }*/
        end = System.currentTimeMillis()-start;
        System.out.println("Total end-time Delete = " + end);
        readWriteFile.write("LinkedList. Delete time = " + end+"\n");
        System.out.println("Check: Exterior linkedList size after deleting = " + linkedLists.size());
        System.out.println("-------------------------------------------------");
    }
}
