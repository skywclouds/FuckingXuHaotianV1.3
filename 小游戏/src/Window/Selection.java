package Window;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Selection {
	public static JComboBox<String> jc=null;//����ѡ��ؼ�������
	public static void addSelections() {//��ʼ��ѡ��ؼ�,��������ӵ�������
		String[] str= {"����","���","����","ΰ��","��"};//�������
		jc=new JComboBox<>(str);//ʵ����ѡ��ؼ�����
		MainFrame.cc.add(jc);//������ӵ�������
		JLabel jl=new JLabel("����:");//������ǩ
		MainFrame.cc.add(jl);//������ӵ�������
		jl.setBounds(615,255,40,30);//���ñ�ǩλ��
		jl.setFont(new Font("", 0, 15));//����ǩ��������
		jc.setBounds(658, 258, 90, 25);//����ѡ��ؼ�λ��
	}
	public static int getCost(String name) {//��ȡ���ߵĻ���
		int G=0;
		switch(name) {//ʹ��switch������û���
		case "����":G=10;break;
		case "���":G=15;break;
		case "����":G=20;break;
		case "ΰ��":G=25;break;
		case "��":G=0;break;
		}
		return G;
	}
	public static int getHoney(String name) {//��ȡʹ�õ������ӵĶ������ܶ�
		int H=0;
		switch(name) {//ʹ��switch������û���
		case "����":H=5;break;
		case "���":H=10;break;
		case "����":H=15;break;
		case "ΰ��":H=20;break;
		case "��":H=0;break;
		}
		return H;
	}
}
