package Window;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Drawicon extends JFrame {

	private static final long serialVersionUID = 1L;
	static JButton photo = new JButton();

	/**
	 * ����ͼƬ�ƶ�����
	 */
	void draw() {

		URL url = getClass().getResource("/res/xu.png");
		Icon i = new ImageIcon(url);// ����ͼ�����
		photo.setIcon(i);// ��ͼƬ�����ǩ��
		photo.setOpaque(true);// ����ǩ��Ϊ��͸��
		/*
		 * ����ͼƬλ���ƶ����߳�
		 */
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				int x = 100, y = 100;
				double alpha = 0.0;
				while (true) {
					x = (int) (50 * Math.cos(alpha) + 73);// Բ�Ĳ�������
					y = (int) (50 * Math.sin(alpha) + 75);
					alpha += 0.08;
					photo.setBounds(x, y, 54, 50);
					try {
						Thread.sleep(20);// ����20���룬�Դﵽÿ��50֡
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					if (alpha > 7200) {
						JDialog jd = new JDialog(MainFrame.mainframe, "������ϵͳ", true);
						Dimension size = getToolkit().getScreenSize();
						jd.setLocation((size.width - 300) / 2, (size.height - 180) / 2);// ���öԻ��򵯳�λ��
						JLabel jl = new JLabel("��Ϸ����10���Ӻ�ر�");
						jl.setFont(new Font("", 0, 18));
						Container cc = jd.getContentPane();// ��ȡ����
						jl.setHorizontalAlignment(SwingConstants.CENTER);
						cc.add(jl);
						jd.setSize(300, 180);// ���öԻ����С
						jd.setVisible(true);
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
						System.exit(0);// ������ϵͳ����Сʱ�Զ��ر�
					}
				}

			}
		});
		t1.start();// �����߳�
		MainFrame.cc.add(photo);// ����ǩ���������
	}

}
