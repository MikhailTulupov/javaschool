package stotskiy;
/**
 * �������� (���������) �������� ��������
 * */
public class CommonBoxFactory implements AbstractFabricLootBox{
    @Override
    public AbstractOpenBox createAbstractOpen() {
        System.out.println("____Create Common box____\n" +
                "� ������� �����������:\n" +
                "1.���� ����\n" +
                "2.����� ���\n" +
                "3.������ ����� ���� (Epic)\n" +
                "4. 10 ������\n" +
                "___________________________"
        );
        return new CommonBoxResult();
    }
}
