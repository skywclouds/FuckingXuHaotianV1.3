package Character;

import Window.Selection;

public class Customer {
	public int money;// �����Ǯ����
	public boolean success = false;

	public Customer(int money) {// ���췽������money��ֵ
		this.money = money;
		System.out.println("������׼��������");// ������
	}

	/**
	 * "�ж�"����
	 */
	public boolean prostitute() {
		double p = Math.random();// 90%�ĸ���ʧ��
		boolean b = false;
		if (p < 0.91) {// ���ɹ����򡭡�
			b = true;
			money -= (Servant.xu.cost + Selection.getCost((String) Selection.jc.getSelectedItem()));
			if (Servant.xu.honey < 90 - Selection.getHoney((String) Selection.jc.getSelectedItem())) {// ��ֹ���ܶȳ���100
				Servant.xu.honey += (10 + Selection.getHoney((String) Selection.jc.getSelectedItem()));
			} else {
				Servant.xu.honey = 100;
			}
			Servant.xu.recost();

		} else {// ��ʧ�ܣ��򡭡�
			money = 0;
			if (Servant.xu.honey > 20) {// ��ֹ���ܶȱ�Ϊ����
				Servant.xu.honey -= 20;
			} else {
				Servant.xu.honey = 0;
			}
			Servant.xu.recost();

		}
		System.out.println("�ж�������");
		return b;// ���سɹ���ʧ��
	}

	/**
	 * ��Ϸ����
	 */
	public boolean flirt() {
		double p = Math.random();
		boolean b = false;
		if (p < 0.51) {// 50%����ʧ��
			b = true;
			if (Servant.xu.honey > 95) {// ���ɹ����򡭡�
				Servant.xu.honey = 100;
			} else {
				Servant.xu.honey += 5;
			}
			Servant.xu.recost();
		} else {

			if (Servant.xu.honey > 10) {// ��ʧ�ܣ��򡭡�
				Servant.xu.honey -= 10;
			} else {
				Servant.xu.honey = 0;
			}
			Servant.xu.recost();
		}
		System.out.println("��Ϸ������");
		return b;// ���سɹ���ʧ��

	}

	/**
	 * �򹤷���
	 */
	public int work() {
		int cost = (int) (201 * Math.random() + 100); // �������нˮ
		System.out.println("��������");
		return cost;

	}

	public static Customer chu = new Customer(1000);// ������̬����
}
