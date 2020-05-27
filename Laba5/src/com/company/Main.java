package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }


    private static void task1(){
        IntegerArrayList list = new IntegerArrayList(FileProcessing.fileIntegerRead());
        System.out.println("Исходные данные:");
        System.out.println(list);
        System.out.println("Минимальный элемент: " + list.min());
        System.out.println("Максимальный элемент: " + list.max());
        System.out.println("Индекс левого минимального элемента: " + list.iMin1());
        System.out.println("Индекс правого минимального элемента: " + list.iMin2());
        System.out.println("Массив между индексами: ");
        System.out.println(list.arrListBetweenMin());
        System.out.println("Количество элементов между индексами: " + list.count(list.iMin1(),list.iMin2()));
        System.out.println("Сумма элементов между индексами: " + list.sumBetweenIndex(list.iMin1(),list.iMin2()));
        System.out.println("Среднее значение элементов между индексами: " + list.average(list.iMin1(),list.iMin2()));
        ArrayList<Integer> list1 = list.reverseSort();
        System.out.println("Отсортированный массив по убыванию:");
        System.out.println(list1);
        System.out.println("Отсортированный по возрастанию массив: ");
        ArrayList<Integer> list2 = list.naturalSort();
        System.out.println(list2);
        System.out.println("Вторая группа из пяти элементов исходного массива: ");
        System.out.println(list.skipFiveTakeFive());
        System.out.println("5 наибольших элементов исходного массива: ");
        ArrayList<Integer> list3 = list.fiveMax();
        System.out.println(list3);
        System.out.println("Пропускаем первые 5 элементов и находим сумму: " + list.skipFiveAndSum());
        System.out.println("Пропускаем 3 элемента и находим сумму до 1 максимального элемента: "
                + list.skipAndSumToMax());
        System.out.println("Берем 5 элементов меньших максимума на k-значений, при k = 3: ");
        System.out.println(list.takeFive(3));
        System.out.println("Берем первые 5 наименьших элементов");
        ArrayList<Integer> list4 = list.takeFiveMin();
        System.out.println(list4);
        System.out.println("объединяем массивы 3 и 4: ");
        ArrayList<Integer> list5 = list.concat(list3,list4);
        System.out.println(list5);
        System.out.println("Создаем массив из исходного, не содержащий элементы массива 3");
        ArrayList<Integer> list6 = list.except(list3);
        System.out.println(list6);
        System.out.println("Создаем массив содержащий уникальные элементы: ");
        System.out.println(list.distinct());

    }

    private static void task2(){
        StringArrayList list = new StringArrayList(FileProcessing.fileStringRead());
        System.out.println("Исходные данные:");
        System.out.println(list);
        System.out.println("Минимальный элемент: " + list.min());
        System.out.println("Максимальный элемент: " + list.max());
        System.out.println("Индекс левого минимального элемента: " + list.iMin1());
        System.out.println("Индекс правого минимального элемента: " + list.iMin2());
        System.out.println("Массив между индексами: ");
        System.out.println(list.arrListBetweenMin(list.iMin1(),list.iMin2()));
        System.out.println("Количество элементов между индексами: " + list.count(list.iMin1(),list.iMin2()));
        System.out.println("Сумма элементов между индексами: " + list.sumBetweenIndex(list.iMin1(),list.iMin2()));
        System.out.println("Среднее значение элементов между индексами: " + list.average(list.iMin1(),list.iMin2()));
        ArrayList<String> list1 = list.reverseSort();
        System.out.println("Отсортированный массив по убыванию:");
        System.out.println(list1);
        System.out.println("Отсортированный по возрастанию массив: ");
        ArrayList<String> list2 = list.naturalSort();
        System.out.println(list2);
        System.out.println("Вторая группа из пяти элементов исходного массива: ");
        System.out.println(list.skipFiveTakeFive());
        System.out.println("5 наибольших элементов исходного массива: ");
        ArrayList<String> list3 = list.fiveMax();
        System.out.println(list3);
        System.out.println("Пропускаем первые 5 элементов и находим сумму: " + list.skipFiveAndSum());
        System.out.println("Пропускаем 3 элемента и находим сумму до 1 максимального элемента: "
                + list.skipAndSumToMax());
        System.out.println("Берем 5 элементов меньших максимума на k-значений, при k = 3: ");
        System.out.println(list.takeFive(3));
        System.out.println("Берем первые 5 наименьших элементов");
        ArrayList<String> list4 = list.takeFiveMin();
        System.out.println(list4);
        System.out.println("объединяем массивы 3 и 4: ");
        ArrayList<String> list5 = list.concat(list3,list4);
        System.out.println(list5);
        System.out.println("Создаем массив из исходного, не содержащий элементы массива 3");
        ArrayList<String> list6 = list.except(list3);
        System.out.println(list6);
        System.out.println("Создаем массив содержащий уникальные элементы: ");
        System.out.println(list.distinct());
        System.out.println("Элементы, которые начинаются на букву 'B'");
        System.out.println(list.startsWithB());
        System.out.println("Элементы, которые не содержат букву 'B'");
        System.out.println(list.notContainsB());
    }

    private static void task3(){
        NoteBookArrayList list = new NoteBookArrayList(FileProcessing.fileObjectRead());
        Scanner scanner = new Scanner(System.in);
        ArrayList<NoteBook> arrayList;
        System.out.println("Исходные данные: ");
        System.out.println(list);
        System.out.print("Введите название мероприятия: ");
        String dayOfWeek = scanner.nextLine();
        arrayList = list.search(dayOfWeek);
        System.out.println("Новый массив: ");
        System.out.println(arrayList);
        System.out.println("Минимальный элемент: ");
        NoteBook min = NoteBookArrayList.min(arrayList);
        System.out.println(min);
        System.out.println("Максимальный элемент: ");
        NoteBook max = NoteBookArrayList.max(arrayList);
        System.out.println(max);
        int iMin1 = arrayList.indexOf(min);
        int iMin2 = arrayList.lastIndexOf(min);
        System.out.println(iMin1);
        System.out.println(iMin2);
        System.out.println("Сумма элементов по полю 2: ");
        System.out.println(NoteBookArrayList.sum(arrayList,iMin1,iMin2));
        System.out.println("Количество элементов между индексами: ");
        System.out.println(NoteBookArrayList.count(arrayList,iMin1,iMin2));
        System.out.println("Среднее значение элементов между индексами: ");
        System.out.println(NoteBookArrayList.average(arrayList,iMin1,iMin2));
        System.out.println("Отсортированный массив по дням недели: ");
        Comparator<NoteBook> comparator = Comparator.comparing(NoteBook::getDayOfWeek);
        list.sort(comparator);
        System.out.println(list);
        System.out.println("Отсортированный массим по мероприятиям: ");
        comparator = Comparator.comparing(NoteBook::getEvent);
        list.sort(comparator);
        System.out.println(list);
    }


}
