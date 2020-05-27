package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class NoteBookArrayList {
    ArrayList<NoteBook> list = new ArrayList<>();

    public NoteBookArrayList(ArrayList<NoteBook> list ){
        this.list = list;
    }

    public ArrayList<NoteBook> search(String event){
       try{
           return list.stream().filter(var -> var.getEvent().equals(event)).
                   collect(Collectors.toCollection(ArrayList::new));
       }
       catch (Exception e){
           return null;
       }
    }

    public NoteBook filter(String dayOfWeek){
        return list.stream().filter(var -> var.getDayOfWeek().equals(dayOfWeek)).findFirst().get();
    }
    public void sort(Comparator comparator){
        try{
            list.sort(comparator);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static NoteBook min(ArrayList<NoteBook> list){
       return list.stream().min(Comparator.comparing(NoteBook::getCost)).get();
    }

    public static NoteBook max(ArrayList<NoteBook> list){
        return list.stream().max(Comparator.comparing(NoteBook::getCost)).get();
    }

    public static double sum(ArrayList<NoteBook> list,int iMin1, int iMin2){
      return list.stream().skip(iMin1 + 1).limit(iMin2 - iMin1).mapToDouble(NoteBook::getCost).sum();
    }

    public static long count(ArrayList<NoteBook> list,int iMin1, int iMin2){
        return list.stream().skip(iMin1 + 1).limit(iMin2 - iMin1).count();
    }

    public static double average(ArrayList<NoteBook> list,int iMin1, int iMin2){
        try{
            return list.stream().skip(iMin1 + 1).limit(iMin2 - iMin1).
                    mapToDouble(NoteBook::getCost).average().getAsDouble();
        }
        catch (NoSuchElementException e){
            return 0.0;
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        list.forEach(result::append);
        return result.toString();
    }
}
