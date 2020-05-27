package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringArrayList {
    ArrayList<String> list = new ArrayList<>();

    public StringArrayList(ArrayList<String> list){
        this.list = list;
    }

    public void add(String e){
        list.add(e);
    }

    public String min(){
        return list.stream().min(Comparator.naturalOrder()).get();
    }

    public String max(){
        return list.stream().max(Comparator.naturalOrder()).get();
    }

    public int iMin1(){
        return list.indexOf(min());
    }

    public int iMin2(){
        return list.lastIndexOf(min());
    }

    public int sumBetweenIndex(int min1, int min2){
        return list.stream().skip(min1 + 1).limit(min2 - min1).mapToInt(String::length).sum();
    }

    public long count(int min1,int min2){
        return list.stream().skip(min1 + 1).limit(min2 - min1).count();
    }

    public double average(int min1, int min2){
        try{
            return   list.stream().skip(min1 + 1).limit(min2 - min1).mapToInt(String::length).average().getAsDouble();
        }
        catch (NoSuchElementException e){
            return 0;
        }
    }

    public ArrayList<String> reverseSort(){
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> naturalSort(){
        return list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<String> skipFiveTakeFive(){
        return list.stream().skip(5).limit(5).collect(Collectors.toCollection(ArrayList::new));
    }

    public int skipAndSumToMax(){
        String max = list.stream().filter(s -> s.equals(max())).findFirst().get();
        return list.stream().skip(3).filter(s -> !s.equals(max())).mapToInt(String::length).sum();
    }

    public ArrayList<String> fiveMax(){
        return list.stream().sorted(Comparator.reverseOrder()).limit(5).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public long skipFiveAndSum(){
        return list.stream().skip(5).mapToInt(String::length).sum();
    }

    public ArrayList<String> takeFive(int k){
        String max = max();
        return list.stream().filter(var -> var.length() != max.length() - k).limit(5).
                collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> takeFiveMin(){
        return list.stream().sorted(Comparator.naturalOrder()).
                limit(5).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> concat(ArrayList<String> arrayList3,ArrayList<String> arrayList4){
        Stream<String> concat = Stream.concat(arrayList3.stream(),arrayList4.stream());
        return concat.collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> except(ArrayList<String> arrayList3){
        return list.stream().filter(var -> !arrayList3.contains(var)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> distinct(){
        return list.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> startsWithB(){
       return list.stream().filter(var -> var.startsWith("B") || var.startsWith("b"))
               .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String>  notContainsB(){
        return list.stream().filter(var -> !var.contains("B")).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public ArrayList<String> arrListBetweenMin(int iMin1, int iMin2) {
        return list.stream().skip(iMin1 + 1).limit(iMin2 - iMin1).collect(Collectors.toCollection(ArrayList::new));
    }
}
