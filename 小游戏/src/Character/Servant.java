package Character;

public class Servant {
	public String name;
	public int honey = 50;
	public int cost = -100 * honey + 10000;

	/**
	 * ���췽��
	 */
	public Servant(String name) {
		this.name = name;
		System.out.println(name + "��׼������");
	}

	/**
	 * ���÷��÷���
	 */
	public void recost() {
		this.cost = -100 * honey + 10000;
		System.out.println("���û��ѳɹ���");
	}

	public static Servant xu = new Servant("�����");// ������̬��������
}
