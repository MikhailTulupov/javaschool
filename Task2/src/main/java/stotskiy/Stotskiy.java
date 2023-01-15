package stotskiy;

public class Stotskiy {
    public static void main(String[] args) {
        int[] array = new int[10000];
        long start, finish, elapsed;
        int randomNumber = (int) (Math.random() * 1000);
        int id = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        //Сортировка массива
        Arrays.sort(array);

        //Линейный поиск
        System.out.println("_____________Линейный поиск:______________");
        start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            //System.out.println(" " + String.valueOf(array[i]));
            if (array[i] == randomNumber) {
                id = i;
                break;
            } else {
                id = -1;
            }
        }
        finish = System.currentTimeMillis();
        elapsed = start - finish;
        MessageFunction(id, elapsed, randomNumber, array);

        //Поиск прыжками
        System.out.println("_____________Поиск прыжками:______________");
        start = System.currentTimeMillis();
        int jumpStep = (int) Math.sqrt(array.length);
        int previousStep = 0;
        int id2 = 0;

        while (array[Math.min(jumpStep, array.length) - 1] < randomNumber) {
            previousStep = jumpStep;
            jumpStep += (int) Math.sqrt(array.length);
            if (previousStep > array.length) {
                id2 = -1;
            }

            while (array[previousStep] < randomNumber) {
                previousStep++;
                if (previousStep == Math.min(jumpStep, array.length)) {
                    id2 = -1;
                }
            }
            if (array[previousStep] == randomNumber) {
                id2 = previousStep;
            }
        }

        finish = System.currentTimeMillis();
        elapsed = start - finish;
        MessageFunction(id2, elapsed, randomNumber, array);

        //Поиск бинарный
        System.out.println("_____________Бинарный:______________");
        start = System.currentTimeMillis();
        int minIndexArray = 0;
        int maxIndexArray = array.length - 1;
        int id3 = 0;

        for (int k = minIndexArray; k <= maxIndexArray; k++) {
            int midIndexArray = (minIndexArray + maxIndexArray) / 2;

            if (array[midIndexArray] == randomNumber) {
                id3 = midIndexArray;
            } else if (array[midIndexArray] < randomNumber) {
                minIndexArray = midIndexArray + 1;
            } else if (array[midIndexArray] > randomNumber) {
                maxIndexArray = midIndexArray - 1;
            }
        }
        finish = System.currentTimeMillis();
        elapsed = start - finish;
        MessageFunction(id3, elapsed, randomNumber, array);
    }

    //Сделал функцию чтобы не грамоздить еще больше код
    public static void MessageFunction(int id, long elapsed, int rN, int[] arr) {
        if (id == -1 || id == 0) {
            System.out.println("Числа не существует или оно не найдено");
        } else {
            System.out.println("Прошло времени: " + elapsed * (-1) + " мс | id = " + id + " |Число задуманное: " + rN + "| Число в массиве: " + arr[id]);
        }
    }
}