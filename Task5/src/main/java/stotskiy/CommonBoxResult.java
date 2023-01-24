package stotskiy;

/**
 * ����� ������������ ������� ������������ �� ��������
 * �������� (common) �����
 * */
public class CommonBoxResult implements AbstractOpenBox {
    private final String st;

    public CommonBoxResult() {
        int max = 450;
        int min = -100;
        this.st = getLoot((int) (Math.random() * ((max - min) + 1)) + min);
    }

    /**
     * ���������� �������� ���� �� �������
     * @param value - �������� ���������
     * @return - ���� (���)
     */
    private String getLoot(int value) {
        return "��� ������:" + switch (value / 150) {
            case 0 -> "���� ����";
            case 1 -> "����� ���";
            case 2 -> "������ ����� ����";
            default -> "10 ������� ������";
        };
    }

    @Override
    public String result() {
        return this.st;
    }
}
