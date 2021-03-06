package ru.dyudin.homework.fruits;

public class BoxUtil {

    public static <T> void copyFromBoxToBox(Box<T> src, Box<? super T> dest) {
        if (src.get() != null) {
            dest.put(src.get());
        }
    }

    public static <T extends Fruit> void copyFreshFruitFromBoxToBox(Box<T> src, Box<? super T> dest) {
        if (src.get() != null) {
            if (src.get().getFresh()) {
                dest.put(src.get());
            }
        }
    }

    public static <T> void printElementFromTwoBoxes(Box<Box<T>> box) {
        if (box != null) {
            System.out.println(box.get().get().toString());
        }
    }

    public static <T> void printElementFromBoxes(Box<T> box) {
        if (box != null) {
            Object content = box;
            while (content instanceof Box) {
                content = ((Box) content).get();
            }
            System.out.println(content.toString());
        }
    }
}
