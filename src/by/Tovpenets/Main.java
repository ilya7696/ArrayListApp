package by.Tovpenets;

/*
    Основное задание
    1. Создать коллекцию класса ArrayList наполнить ее элементами
    рандомными элементами типа Integer.
    С помощью Stream'ов:
    - Удалить дубликаты
    - Вывести все четные элементы в диапазоне от 7 до 17
    (включительно)
    - Каждый элемент умножить на 2
    - Отсортировать и вывести на экран первых 4 элемента
    - Вывести количество элементов в стриме
    - Вывести среднее арифметическое всех чисел в стриме

    Дополнительное задание
    2. Создать коллекцию класса ArrayList со значениями имен всех студентов
    в группе
    С помощью Stream'ов:
    - Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
    - Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
    - Отсортировать и вернуть первый элемент коллекции или "Empty@, если коллекция пуста
*/

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        // List of strings
        List<String> list = new ArrayList<>();
        System.out.println("First print");
        list.print();

        System.out.println("Adding elements to array list");
        list.add("lakjsdas");
        list.add("gdfgd");
        list.add("lakjsddfgdfas");
        list.add("dfgdfg");
        list.add("dfgdfg");
        list.print();

        System.out.println("And one more...");
        list.add("lakjsdas");
        list.add("gdfgd");
        list.add("lakjsddfgdfas");
        list.add("dfgdfg");
        list.add("dfgdfg");
        list.add("lakjsdas");
        list.add("gdfgd");
        list.add("lakjsddfgdfas");
        list.add("dfgdfg");
        list.add("dfgdfg");
        list.print();

        System.out.println("The last one");
        list.add("lakjsdas");
        list.add("gdfgd");
        list.add("lakjsddfgdfas");
        list.add("dfgdfg");
        list.add("dfgdfg");
        list.add("lakjsdas");
        list.add("Ilya");
        list.add("lakjsddfgdfas");
        list.add("dfgdfg");
        list.add("dfgdfg");
        list.print();

        System.out.println("GET: " + list.get(2)); //lakjsddfgdfas
        System.out.println("Size is " + list.size());
        list.remove(2);
        System.out.println("GET 2: " + list.get(2)); //dfgdfg
        System.out.println("Size is " + list.size());

        System.out.println("Ilya contains: " + list.contains("Ilya"));
        System.out.println("Alex contains: " + list.contains("Alex"));

        System.out.println("Before deleting duplicates");
        list.print();

        System.out.println("After deleting duplicates");
        list.removeDuplicates();
        list.print();

        // List of integers
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(32);
        nums.add(-12);
        nums.add(8);
        nums.add(12);
        nums.add(17);
        nums.add(20);
        nums.add(1);

        printEvenFrom7To17(nums);
        printMultipleOn2(nums);
        sortAndPrintFirst4Elements(nums);
        elementsCount(nums);
        avgInList(nums);

        /*
         - Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
         - Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
         - Отсортировать и вернуть первый элемент коллекции или "Empty@, если коллекция пуста
        */
        // List of students names
        List<String> studentsNames = new ArrayList<>();
        studentsNames.add("Ilya");
        studentsNames.add("Alex");
        studentsNames.add("Ivan");
        studentsNames.add("Oleg");
        studentsNames.add("Aleksandr");
        studentsNames.add("Ruslan");
        studentsNames.add("ILYA");

        printCountByName(studentsNames, "Ilya");
        printAllNamesStartsWithAIgnoreCase(studentsNames);

        sortFirstElementOrElseSpecWord(studentsNames);

        List<String> emptyList = new ArrayList<>();
        sortFirstElementOrElseSpecWord(emptyList);
    }

    private static void sortFirstElementOrElseSpecWord(List<String> studentsNames) {
        System.out.println("sortFirstElementOrElseSpecWord");
        Arrays.stream(studentsNames.getElements())
                .filter(Objects::nonNull)
                .sorted()
                .findFirst()
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("\"Empty@")
                    );
    }

    private static void printAllNamesStartsWithAIgnoreCase(List<String> studentsNames) {
        System.out.println("printAllNamesStartsWithAIgnoreCase");
        Arrays.stream(studentsNames.getElements())
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .filter(name -> name.startsWith("A") || name.startsWith("a"))
                .forEach(System.out::println);
    }

    private static void printCountByName(List<String> studentsNames, String name) {
        System.out.println("printCountByName");
        long count = Arrays.stream(studentsNames.getElements())
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .filter(studentName -> studentName.equalsIgnoreCase(name))
                .count();
        System.out.println("Count of students with name " + name + " is " + count);
    }

    private static void printEvenFrom7To17(List<Integer> nums) {
        System.out.println("printEvenFrom7To17");
        StringBuilder builder = new StringBuilder();

        Arrays.stream(nums.getElements())
                .filter(Objects::nonNull)
                .map(element -> (Integer)element)
                .filter(element -> element > 7 && element <= 17 && element % 2 == 0)
                .forEach(element -> builder.append(element).append(","));

        System.out.println(builder);
    }

    private static void printMultipleOn2(List<Integer> nums) {
        System.out.println("printMultipleOn2");
        Arrays.stream(nums.getElements())
                .filter(Objects::nonNull)
                .map(element -> (Integer)element * 2)
                .forEach(System.out::println);
    }

    private static void sortAndPrintFirst4Elements(List<Integer> nums) {
        System.out.println("sortAndPrintFirst4Elements");
        Arrays.stream(nums.getElements())
                .filter(Objects::nonNull)
                .sorted()
                .limit(4)
                .forEach(System.out::println);
    }

    private static void elementsCount(List<Integer> nums) {
        System.out.println("elementsCount");
        System.out.println(
                Arrays.stream(nums.getElements()).filter(Objects::nonNull).count());
    }

    private static void avgInList(List<Integer> nums) {
        System.out.println("avgInList");

        int count = (int) Arrays.stream(nums.getElements()).filter(Objects::nonNull).count();

        Integer sum = Arrays.stream(nums.getElements())
                .filter(Objects::nonNull)
                .map(element -> (Integer)element)
                .reduce(0, Integer::sum);

        System.out.println("Result: " + sum / count);

    }

}

interface List<E> {
    void add(E element);
    void remove(int index);
    E get(int index);
    boolean contains(E element);
    void print();
    int size();
    void removeDuplicates();
    Object[] getElements();
}

class ArrayList<E> implements List<E> {

    private int initSize = 12;
    private int elementCount = 0;
    private Object[] elements;

    public ArrayList() {
        elements = new Object[initSize];
    }

    public ArrayList(int initSize) {
        this.initSize = initSize;

        elements = new Object[initSize];
    }

    @Override
    public void add(E element) {
        if (elementCount+1 > elements.length)
            elements = Arrays.copyOf(elements, (int)(elements.length * 1.5 + 1));

        elements[elementCount++] = element;
    }

    @Override
    public void remove(int index) {
        Object[] firstPart = Arrays.copyOfRange(elements, 0, index-1);
        Object[] secondPart = Arrays.copyOfRange(elements, index, elements.length-1);

        elementCount--;
        elements = new Object[firstPart.length + secondPart.length];

        AtomicInteger i = new AtomicInteger(0);
        Arrays.stream(firstPart).forEach(node -> elements[i.getAndIncrement()] = node);
        Arrays.stream(secondPart).forEach(node -> elements[i.getAndIncrement()] = node);
    }

    @Override
    public E get(int index) {
        if (elements[index] == null) {
            System.out.println("Element on index " + index + " is null!");
            return null;
        } else return (E)elements[index];
    }

    @Override
    public boolean contains(E element) {
        return Arrays.asList(elements).contains(element);
    }

    @Override
    public void print() {
        Arrays.stream(elements).forEach(System.out::println);
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public void removeDuplicates() {
        elements = Arrays.stream(elements).distinct().toArray();
        elementCount = (int)Arrays.stream(elements).filter(Objects::nonNull).count();
    }

    @Override
    public Object[] getElements() {
        return elements;
    }
}