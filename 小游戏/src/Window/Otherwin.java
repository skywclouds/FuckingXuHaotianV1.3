package Window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Otherwin {
	static JDialog jd = null;
	static Container cc = null;

	/**
	 * �������巽��
	 */
	void Sign() {
		JFrame sign = new JFrame("����");// ������������
		sign.setResizable(false);
		sign.setSize(500, 700);
		sign.setLayout(null);
		sign.setLocationRelativeTo(null);;// ���ô��嵯��λ��
		Container cc = sign.getContentPane();// ��ȡ����
		cc.setBackground(new Color(240, 240, 240));
		JLabel jl = new JLabel("��������");
		jl.setBounds(180, 0, 200, 50);
		jl.setFont(new Font("", 1, 30));
		JButton bi = new JButton("��ʼ��Ϸ");// ���ð�ť
		cc.add(jl);
		String s = "       ����Ϸ����ѧϰ�����֣�����ʹ�á�������κ��ˣ��������غ�24Сʱ֮��ж�أ����������һ�к������е���"
				+ "���ڱ���ˮƽ���ޣ���֮ʱ��ִ٣����ܻ���һЩ���������½⡣�������һЩ����ͽ��飬�뷢���ҵĵ�������\'\'ws_wanghe@163.com\'\'��"
				+ "\n\t\t������\n\t\t2018-08-12";// ����������
		JTextArea jt = new JTextArea(s);// �����ı������
		jt.setFont(new Font("", 0, 20));// �����ı��������
		jt.setEditable(false);// ���ô��岻������
		jt.setLineWrap(true);// �����Զ�����
		jt.setBounds(45, 75, 400, 400);
		cc.add(jt);// ���ı��������������
		sign.setVisible(true);// �Ǵ���ɼ�
		bi.setBounds(190, 550, 100, 50);
		cc.add(bi);// ����ť�����������
		bi.addActionListener(new ActionListener() {
			// Ϊ��ť�����굥���¼�
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame login = new LoginDialog();// ʵ������¼�������
				login.setResizable(false);
				login.setVisible(true);// ʹ��¼����ɼ�
				sign.setVisible(false);// ���������ڲ��ɼ�
			}
		});
		// Ϊ�ı�����Ӽ����¼�
		jt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {// �ж��Ƿ�Ϊ�س���
					JFrame login = new LoginDialog();// ʵ������¼�������
					login.setVisible(true);// ʹ��¼����ɼ�
					sign.setVisible(false);// ���������ڲ��ɼ�
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		sign.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// ���ô��ڹرշ�ʽ
		System.out.println("��������������");
	}

	/**
	 * �����Ի��򷽷�
	 */
	void communicate(String Display) {
		jd = new JDialog(MainFrame.mainframe, "���ϼ���������", true);
		jd.setResizable(false);
		cc = jd.getContentPane();// ��ȡ����
		cc.setLayout(new GridLayout(2, 1));
		jd.setSize(315, 185);// ���öԻ����С
		JLabel jl = new JLabel(Display);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setFont(new Font("", 0, 20));
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.setLayout(new GridLayout(3,1));
		jp2.setLayout(null);
		cc.add(jp1);
		cc.add(jp2);
		JButton jb = new JButton("ȷ��");// ���ð�ť
		jd.setLocationRelativeTo(jb);// ���öԻ��򵯳�λ��
		jp1.add(new JPanel());
		jp1.add(jl);
		jp1.add(new JPanel());
		jb.setBounds(105, 10, 100, 30);
		jp2.add(jb);
		cc.setBackground(new Color(245, 245, 245));
		// Ϊ��ť�����굥���¼�
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jd.setVisible(false);// ���ضԻ���
			}
		});
		System.out.println("�Ի��򵯳�������");
		jd.setVisible(true);// ʹ�Ի���ɼ�
	}

	void communicate(String Display, Button bu) {
		// ���ñ��⣬�����壬����
		jd = new JDialog(MainFrame.mainframe, "���ϼ���������", true);
		
		jd.setResizable(false);
		cc = jd.getContentPane();// ��ȡ����
		cc.setLayout(new GridLayout(2, 1));
		jd.setSize(315, 185);// ���öԻ����С
		JLabel jl = new JLabel(Display);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setFont(new Font("", 0, 20));
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.setLayout(new GridLayout(3,1));
		jp2.setLayout(null);
		cc.add(jp1);
		cc.add(jp2);
		JButton jb = new JButton("ȷ��");// ���ð�ť
		jd.setLocationRelativeTo(jb);// ���öԻ��򵯳�λ��
		jp1.add(new JPanel());
		jp1.add(jl);
		jp1.add(new JPanel());
		jb.setBounds(105, 10, 100, 30);
		jp2.add(jb);
		cc.setBackground(new Color(245, 245, 245));
		
		// Ϊ��ť�����굥���¼�
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bu.doIt();
			}
		});
		System.out.println("�Ի��򵯳�������");
		jd.setVisible(true);// ʹ�Ի���ɼ�
	}
	/**
	 * ʵ�ָ��������ܵķ���
	 * */
	void reTell() {
		JTextField jt = new JTextField("�����븴������(��֧��Ӣ��)");//����һ���ı���
		jt.setBounds(550, 180, 200, 25);
		MainFrame.cc.add(jt);
		jt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {// �ж��Ƿ�Ϊ�س���
					new Otherwin().communicate(jt.getText());
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
}

/**
 * ����ʾ�Ի����е�"ȷ��"��ť�ṩ�����¼��Ľӿ�
 */
interface Button {
	void doIt();
}

