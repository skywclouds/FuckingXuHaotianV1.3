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
	 * 控制图片移动方法
	 */
	void draw() {

		URL url = getClass().getResource("/res/xu.png");
		Icon i = new ImageIcon(url);// 创建图标对象
		photo.setIcon(i);// 将图片放入标签中
		photo.setOpaque(true);// 将标签设为不透明
		/*
		 * 控制图片位置移动的线程
		 */
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				int x = 100, y = 100;
				double alpha = 0.0;
				while (true) {
					x = (int) (50 * Math.cos(alpha) + 73);// 圆的参数方程
					y = (int) (50 * Math.sin(alpha) + 75);
					alpha += 0.08;
					photo.setBounds(x, y, 54, 50);
					try {
						Thread.sleep(20);// 休眠20毫秒，以达到每秒50帧
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					if (alpha > 7200) {
						JDialog jd = new JDialog(MainFrame.mainframe, "防沉迷系统", true);
						Dimension size = getToolkit().getScreenSize();
						jd.setLocation((size.width - 300) / 2, (size.height - 180) / 2);// 设置对话框弹出位置
						JLabel jl = new JLabel("游戏将于10秒钟后关闭");
						jl.setFont(new Font("", 0, 18));
						Container cc = jd.getContentPane();// 获取容器
						jl.setHorizontalAlignment(SwingConstants.CENTER);
						cc.add(jl);
						jd.setSize(300, 180);// 设置对话框大小
						jd.setVisible(true);
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
						System.exit(0);// 防沉迷系统，半小时自动关闭
					}
				}

			}
		});
		t1.start();// 启动线程
		MainFrame.cc.add(photo);// 将标签添加至容器
	}

}
