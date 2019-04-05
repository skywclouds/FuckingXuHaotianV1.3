package Window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;
import Character.Customer;
import Character.Servant;

/**
 * ����
 */
public class MainFrame  {
	static JFrame mainframe = new JFrame("���������");// �������ڲ����ñ���
	static Container cc;// ��������Ӧ��
	JLabel name = new JLabel("������ " + Servant.xu.name);// ����������ǩ
	JLabel honey = new JLabel("���ܶ�: " + Servant.xu.honey);// �������ܶȱ�ǩ
	JLabel cost = new JLabel("����: " + Servant.xu.cost);// ���û��ѱ�ǩ
	JLabel money = new JLabel("��Ǯ�� " + Customer.chu.money);// ���ý�Ǯ��ǩ
	boolean b = true;
	File f4 = null;

	/**
	 * main����
	 */
	public static void main(String[] args) {
		System.out.println("-------------��ӭʹ��-------------");
		System.out.println("@����  Mr.Wang");
		System.out.println("\t\t\t2018-08-12");
		SplashScreen splashScreen = SplashScreen.getSplashScreen();// ����������Ļ����
		if (!(splashScreen == null)) {// ������Ļ����Ϊ��
			try {
				Thread.sleep(3000);// �߳�����3��
			} catch (InterruptedException e) {
			}
		}
		new Otherwin().Sign(); // ������������
	}

	/**
	 * д�ļ�����
	 */
	private void writeFiles() {
		if (f4.exists()) {// �ж��ļ��Ƿ����
			try {
				FileOutputStream out = new FileOutputStream(f4);// ���������
				String s;
				s = Servant.xu.honey + "." + Servant.xu.cost + "." + Customer.chu.money + "." + Customer.chu.success;
				// д�����ϢΪ:���ܶ�,����,��Ǯ,�Ƿ�ɹ�
				byte[] b = s.getBytes();
				try {
					out.write(b);// д����Ϣ
					out.close();// �ر���
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {// �������ڣ��򴴽��ļ���д������
			try {
				f4.createNewFile();
				writeFiles();// �ݹ�һ�κ���ֹ
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("writeFiles����������");
	}

	/**
	 * ��ʼ���ļ����󷽷�
	 */
	private void inFiles() {
		String jar = MainFrame.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		try {
			jar = URLDecoder.decode(jar, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String path = new File(jar).getParentFile().getAbsolutePath();
		f4 = new File(path + "/config.txt");// �ҵ�jar�����ڵ��ļ��еľ���·��
	}

	/**
	 * ���ļ�����
	 */
	private void readFiles() {
		if (!f4.exists()) {// ����ļ������ڣ��򴴽��ļ�����������д���ļ�
			try {
				f4.createNewFile();
				writeFiles();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {// ���ļ����ڣ����ȡ�ļ�����
			try {
				FileInputStream in = new FileInputStream(f4);
				byte[] b = new byte[1024];
				try {
					int len = in.read(b);
					String str = new String(b, 0, len);
					//�ļ��е���Ϣ
					in.close();// �ر���
					if (str.matches("\\d{1,3}\\.\\d+\\.\\d+\\..+")) {// ʹ��������ʽ�ж��ļ������Ƿ��ܺ��Ӵ۸�
						String[] s = str.split("\\.");// ���ļ��е���Ϣ�ָ��
						for (String x : s) {
							System.out.println(x);
						}
						Servant.xu.honey = Integer.parseInt(s[0]);
						Servant.xu.cost = Integer.parseInt(s[1]);
						Customer.chu.money = Integer.parseInt(s[2]);
						Boolean b2 = new Boolean(s[3]);
						Customer.chu.success = b2.booleanValue();
						// ��ȡ����
						retext();// ���ñ�ǩ
					} else {// ������ܺ��Ӵ۸ģ�������д������
						writeFiles();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println("readFiles����������");
	}

	/**
	 * ��ʼ�������巽��
	 */
	void creatframe() {
		mainframe.setSize(780, 500);// �����������С
		mainframe.setResizable(false);// �����岻������
		mainframe.setLayout(null);// ������ʹ�þ��Բ���
		//Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		mainframe.setLocationRelativeTo(null);// ���ô��嵯��λ��
		mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// ���ô���رշ�ʽ
		cc = mainframe.getContentPane();// ��ȡ��������
		putlabels();// ��ʼ����ǩ����
		putbuttons();// ���¹���ť����
		inFiles();// ��ʼ���ļ�����
		readFiles();// ��ȡ�ļ�����
		writeFiles();// д�ļ�����
		System.out.println("������������");
		thread();// ���ö��߳�
		mainframe.setVisible(true);// ʹ������ɼ�
	}

	/**
	 * ��ʼ����ť����
	 */
	private void putbuttons() {
		JButton piao = new JButton("����");// ������ť����
		JButton liao = new JButton("����");
		JButton forever = new JButton("��  ��  ��  ��");
		JButton da = new JButton("��׬Ǯ");
		JButton tui = new JButton("�˳�");
		JButton re = new JButton("����");
		JButton cun = new JButton("����");
		new Otherwin().reTell();
		piao.setBounds(150, 250, 200, 50);// ���ô���λ��
		liao.setBounds(400, 250, 200, 50);
		forever.setBounds(150, 350, 450, 50);
		da.setBounds(550, 100, 200, 50);
		tui.setBounds(690, 400, 80, 50);
		re.setBounds(5, 400, 80, 50);
		cun.setBounds(5, 300, 80, 50);
		cc.add(piao);// ����ť�����������
		cc.add(liao);
		cc.add(forever);
		cc.add(da);
		cc.add(tui);
		cc.add(re);
		cc.add(cun);
		Selection.addSelections();
		// Ϊ��ť�����굥���¼�
		liao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Customer.chu.success) {
					if (Customer.chu.flirt()) {
						new Otherwin().communicate("��Ϸ�ɹ�");// �����Ի��򷽷�;
					} else {
						new Otherwin().communicate("��Ϸʧ��");
					}
					retext();// ���ñ�ǩ����
				}

			}
		});

		piao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Customer.chu.success) {
					if (Customer.chu.money - Servant.xu.cost - Selection.getCost((String) Selection.jc.getSelectedItem())>= 0) {
						//�ж�Ǯ�Ƿ���
						if (Customer.chu.prostitute()) {
							new Otherwin().communicate("��潳ɹ�");
						} else {
							new Otherwin().communicate("���ʧ��");
						}
						retext();
					} else {
						new Otherwin().communicate("Ǯ������");
					}
				}
			}
		});

		forever.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Customer.chu.success) {
					if (Customer.chu.money >= 20000) {
						Customer.chu.money -= 20000;
						Servant.xu.honey = 100;
						Servant.xu.recost();
						retext();// ���ñ�ǩ����
						Customer.chu.success = true;
						new Otherwin().communicate("���ð��γɹ�");
					} else {
						new Otherwin().communicate("Ǯ������");
					}
				}

			}
		});
		da.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog jd = new JDialog(MainFrame.mainframe, "���ϼ���������", true);
				jd.setLayout(null);
				jd.setResizable(false);
				Container cc = jd.getContentPane();
				
				
				jd.setSize(400, 250);
				JLabel jl = new JLabel("��ӭǰ����ש");
				jl.setFont(new Font("", 0, 20));
				int a = jl.getText().length();
				jl.setBounds(195 - (a * 18) / 2, 18, 200, 80);
				cc.add(jl);
				JButton jb = new JButton("ȷ��");
				jd.setLocationRelativeTo(jb);
				jb.setEnabled(false);// ʹ��ť������
				jb.setBounds(140, 160, 100, 30);
				cc.setBackground(new Color(245, 245, 245));
				cc.add(jb);
				jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jd.setVisible(false);
					}
				});
				JProgressBar jp = new JProgressBar();// ����������
				jp.setBackground(Color.GREEN);// ��������ɫ����Ϊ��ɫ
				jp.setBounds(63, 100, 275, 20);
				cc.add(jp);
				new Thread(new Runnable() {// ���ƽ������Ľ���

					@Override
					public void run() {
						for (int i = 1; i < 101; i++) {
							jp.setValue(i);
							try {
								Thread.sleep(20);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						jl.setText("  �����");
						Customer.chu.money += Customer.chu.work();
						retext();
						jb.setEnabled(true);// ʹ��ť����
					}
				}).start();
				System.out.println("�Ի��򵯳�������");
				jd.setVisible(true);
			}
		});

		tui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�˳�������");
				new Otherwin().communicate("����˳���?", new Button() {
					@Override
					public void doIt() {
						Otherwin.jd.setVisible(false);// ʹ��Button�ӿ�Ϊ��ť��ӵ����¼�
						System.exit(0);
					}
				});
			}
		});
		re.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog jd = new JDialog(MainFrame.mainframe, "���ϼ���������", true);
				jd.setLayout(null);
				jd.setResizable(false);
				Container cc = jd.getContentPane();
				
				
				jd.setSize(300, 180);
				JLabel jl = new JLabel("���������?");
				jl.setFont(new Font("", 0, 20));
				int a = jl.getText().length();
				jl.setBounds(135 - (a * 18) / 2, 18, 200, 80);
				cc.add(jl);
				JButton jb = new JButton("ȷ��");
				jd.setLocationRelativeTo(jb);
				jb.setBounds(90, 95, 100, 30);
				cc.setBackground(new Color(245, 245, 245));
				cc.add(jb);
				jb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Customer.chu.money = 1000;
						Customer.chu.success = false;
						Servant.xu.honey = 50;
						Servant.xu.cost = 5000;
						retext();
						jd.setVisible(false);
					}
				});
				System.out.println("�Ի��򵯳�������");
				jd.setVisible(true);
			}
		});
		cun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writeFiles();
				new Otherwin().communicate("����ɹ�");
				System.out.println("��������");
			}
		});
	}

	/**
	 * ��ʼ����ǩ����
	 */
	private void putlabels() {
		name.setFont(new Font("", 0, 15));// ���ñ�ǩ����
		honey.setFont(new Font("", 0, 15));
		cost.setFont(new Font("", 0, 15));
		money.setFont(new Font("", 0, 15));
		name.setBounds(250, 10, 200, 30);// ���ñ�ǩλ��
		cc.add(name);// ����ǩ�����������
		honey.setBounds(250, 80, 200, 30);
		cc.add(honey);
		cost.setBounds(250, 150, 200, 30);
		cc.add(cost);
		money.setBounds(590, 50, 180, 30);
		cc.add(money);
	}

	/**
	 * ���ñ�ǩ����
	 */
	private void retext() {
		honey.setText("���ܶȣ�" + Servant.xu.honey);
		money.setText("��Ǯ�� " + Customer.chu.money);
		cost.setText("���ѣ� " + Servant.xu.cost);
	}

	/**
	 * ���߳�
	 */
	private void thread() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {// ��дrun����
				new Drawicon().draw();// ����ͼƬ�߳�
				showFish();
				int R, G, B;
				R = 50;
				G = 100;
				B = 100;
				boolean[] b = { true, true, true };
				while (true) {// ��ɫ����
					if (b[0]) {
						R += 2;
					} else {
						R -= 2;
					}
					if (R > 253) {
						b[0] = false;
					} else if (R < 150) {
						b[0] = true;
					}
					if (b[1]) {
						G++;
					} else {
						G--;
					}
					if (G > 254) {
						b[1] = false;
					} else if (G < 100) {
						b[1] = true;
					}
					if (b[2]) {
						B++;
					} else {
						B--;
					}
					if (B > 254) {
						b[2] = false;
					} else if (B < 100) {
						b[2] = true;
					}
					try {
						Thread.sleep(20);// ����20���ף��Դﵽÿ��50֡
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					Color c = new Color(R, G, B);
					cc.setBackground(c);
					c = null;
				}
			}
		});
		t1.start();// �����߳�
	}

	/**
	 * �����Ƭ����ʾ���ڵ�ͷ��
	 */
	private void showFish() {
		URL url = getClass().getResource("/res/fish.png");//��ȡͼƬ��URl·��
		Drawicon.photo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {//��ͼƬ���������¼�
				JFrame jf = new JFrame("Old Fish");
				jf.setLocationRelativeTo(Drawicon.photo);
				jf.setSize(320, 325);
				jf.setResizable(false);
				Container co = jf.getContentPane();
				JLabel jl = new JLabel();//�ñ�ǩ����ʽ����ͼƬ
				Icon ic = new ImageIcon(url);
				jl.setIcon(ic);
				co.add(jl);
				jl.setBounds(0, 10, 317, 310);
				jf.setVisible(true);
				jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			}
		});
		System.out.println("�����Ѽ���!");
	}
}
