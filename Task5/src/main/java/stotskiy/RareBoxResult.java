package stotskiy;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * ����� ������������ ������� ������������ �� ��������
 * ������� (rare) �����
 * */
public class RareBoxResult implements AbstractOpenBox {
    private final String rt;
    public int backspin;

    /**
     * @param backspin - �������� ������������� ���� ��������� ������� �����
     * */
    public RareBoxResult(int backspin){
        this.backspin = backspin;
        this.rt = getLoot(generate());
    }


    /**
     * ����� ��������� ����������� �����
     * @return ���������� ����� ��� ����������� ������ ����
     * */
    private int generate(){
        Random random = new Random();
        int[] number = new int[] {1,2,3,4,5};
        int[] chance = new int[] {100,100 - backspin/2,100 - backspin /3,100 - backspin/4,100- backspin/5};
        int count = IntStream.of(chance).sum();

        int index = random.nextInt(count);

        for (int i = 0; i < chance.length; i++) {
            index -=chance[i];
            if(index < 0){
                return number[i];
            }
        }
        return 5;
    }

    /**
     * ���������� �������� ���� �� �������
     * @param val - �������� ��������� ���������� �����
     * @return - ���� (���)
     * */
    private String getLoot(int val){
       return "��� ������:" + switch (val){
            case 1 -> "���� �������� ������������";
            case 2 -> "��������� �������";
            case 3 -> "����������� ����";
            case 4 -> "����� ����� ����";
            default -> "50 ������� ������";
        };
    }

    @Override
    public String result() {
        return this.rt;
    }
}
