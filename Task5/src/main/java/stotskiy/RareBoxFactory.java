package stotskiy;
/**
 * �������� (���������) ������� ��������
 * */
public class RareBoxFactory implements AbstractFabricLootBox{
    @Override
    public AbstractOpenBox createAbstractOpen() {
        System.out.println("____Create Rare box____\n" +
                "� ������� �����������:\n" +
                "1.���� �������� ������������ (Legendary)\n" +
                "2.��������� �������(Rare)\n" +
                "3.����������� ����\n" +
                "4.����� ����� ����\n" +
                "4.50 ������� ������\n" +
                "___________________________"
        );
        return new RareBoxResult(0);
    }
}