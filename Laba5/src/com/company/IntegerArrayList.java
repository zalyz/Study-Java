package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerArrayList {
    private ArrayList<Integer> list = new ArrayList<>();

    public IntegerArrayList(ArrayList<Integer> list){
        this.list = list;
    }

    public void add(int e){
        list.add(e);
    }

    public void add(Integer e){
        list.add(e);
    }

    public int min(){
        return list.stream().min(Comparator.naturalOrder()).get();
    }

    public int max(){
        return list.stream().max(Comparator.naturalOrder()).get();
    }

    public int iMin1(){
        return list.indexOf(min());
    }

    public int iMin2(){
        return list.lastIndexOf(min());
    }

    public ArrayList<Integer> arrListBetweenMin(){
        int min1 = iMin1(),min2 = iMin2();
        return list.stream().skip(min1 + 1).limit(min2 - min1 - 1).collect(Collectors.toCollection(ArrayList::new));
    }

    public int sumBetweenIndex(int min1, int min2){
        return list.stream().skip(min1 + 1).limit(min2 - min1 - 1).mapToInt(var -> var).sum();
    }

    public long count(int min1,int min2){
       return list.stream().skip(min1 + 1).limit(min2 - min1 - 1).count();
    }

    public double average(int min1, int min2){
      return   list.stream().skip(min1 + 1).limit(min2 - min1 - 1).mapToInt(var -> var).average().getAsDouble();
    }

    public ArrayList<Integer> reverseSort(){
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> naturalSort(){
        return list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toCollection(ArrayList::new));
    }


    public ArrayList<Integer> skipFiveTakeFive(){
        return list.stream().skip(5).limit(5).collect(Collectors.toCollection(ArrayList::new));
    }

    public int skipAndSumToMax(){
        int max = list.stream().filter(s -> s == max()).findFirst().get();
       return list.stream().skip(3).filter(s -> s != max).mapToInt(Integer::intValue).sum();
    }

    public ArrayList<Integer> fiveMax(){
      return list.stream().sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toCollection(ArrayList::new));
    }

    public long skipFiveAndSum(){
        return list.stream().skip(5).mapToInt(var -> var).sum();
    }

    public ArrayList<Integer> takeFive(int k){
        int max = max();
        return list.stream().filter(var -> var != max - k).limit(5).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> takeFiveMin(){
        return list.stream().sorted(Comparator.naturalOrder()).
                limit(5).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> concat(ArrayList<Integer> arrayList3,ArrayList<Integer> arrayList4){
        Stream<Integer> concat = Stream.concat(arrayList3.stream(),arrayList4.stream());
        return concat.collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> except(ArrayList<Integer> arrayList3){
        return list.stream().filter(var -> !arrayList3.contains(var)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> distinct(){
        return list.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
