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
 * 主类
 */
public class MainFrame  {
	static JFrame mainframe = new JFrame("白嫖徐浩田");// 创建窗口并设置标题
	static Container cc;// 创建容器应用
	JLabel name = new JLabel("姓名： " + Servant.xu.name);// 设置姓名标签
	JLabel honey = new JLabel("亲密度: " + Servant.xu.honey);// 设置亲密度标签
	JLabel cost = new JLabel("花费: " + Servant.xu.cost);// 设置花费标签
	JLabel money = new JLabel("金钱： " + Customer.chu.money);// 设置金钱标签
	boolean b = true;
	File f4 = null;

	/**
	 * main方法
	 */
	public static void main(String[] args) {
		System.out.println("-------------欢迎使用-------------");
		System.out.println("@作者  Mr.Wang");
		System.out.println("\t\t\t2018-08-12");
		SplashScreen splashScreen = SplashScreen.getSplashScreen();// 创建闪现屏幕对象
		if (!(splashScreen == null)) {// 闪现屏幕对象不为空
			try {
				Thread.sleep(3000);// 线程休眠3秒
			} catch (InterruptedException e) {
			}
		}
		new Otherwin().Sign(); // 弹出免责声明
	}

	/**
	 * 写文件方法
	 */
	private void writeFiles() {
		if (f4.exists()) {// 判断文件是否存在
			try {
				FileOutputStream out = new FileOutputStream(f4);// 创建输出流
				String s;
				s = Servant.xu.honey + "." + Servant.xu.cost + "." + Customer.chu.money + "." + Customer.chu.success;
				// 写入的信息为:亲密度,花费,金钱,是否成功
				byte[] b = s.getBytes();
				try {
					out.write(b);// 写入信息
					out.close();// 关闭流
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {// 若不存在，则创建文件后写入数据
			try {
				f4.createNewFile();
				writeFiles();// 递归一次后终止
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("writeFiles方法正常！");
	}

	/**
	 * 初始化文件对象方法
	 */
	private void inFiles() {
		String jar = MainFrame.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		try {
			jar = URLDecoder.decode(jar, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String path = new File(jar).getParentFile().getAbsolutePath();
		f4 = new File(path + "/config.txt");// 找到jar包所在的文件夹的绝对路径
	}

	/**
	 * 读文件方法
	 */
	private void readFiles() {
		if (!f4.exists()) {// 如果文件不存在，则创建文件，并将数据写入文件
			try {
				f4.createNewFile();
				writeFiles();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {// 若文件存在，则读取文件数据
			try {
				FileInputStream in = new FileInputStream(f4);
				byte[] b = new byte[1024];
				try {
					int len = in.read(b);
					String str = new String(b, 0, len);
					//文件中的信息
					in.close();// 关闭流
					if (str.matches("\\d{1,3}\\.\\d+\\.\\d+\\..+")) {// 使用正则表达式判断文件数据是否被熊孩子篡改
						String[] s = str.split("\\.");// 将文件中的信息分割处理
						for (String x : s) {
							System.out.println(x);
						}
						Servant.xu.honey = Integer.parseInt(s[0]);
						Servant.xu.cost = Integer.parseInt(s[1]);
						Customer.chu.money = Integer.parseInt(s[2]);
						Boolean b2 = new Boolean(s[3]);
						Customer.chu.success = b2.booleanValue();
						// 读取数据
						retext();// 重置标签
					} else {// 如果被熊孩子篡改，则重新写入数据
						writeFiles();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println("readFiles方法正常！");
	}

	/**
	 * 初始化主窗体方法
	 */
	void creatframe() {
		mainframe.setSize(780, 500);// 设置主窗体大小
		mainframe.setResizable(false);// 主窗体不能缩放
		mainframe.setLayout(null);// 主窗体使用绝对布局
		//Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		mainframe.setLocationRelativeTo(null);// 设置窗体弹出位置
		mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置窗体关闭方式
		cc = mainframe.getContentPane();// 获取容器对象
		putlabels();// 初始化标签方法
		putbuttons();// 出事哈按钮方法
		inFiles();// 初始化文件方法
		readFiles();// 读取文件方法
		writeFiles();// 写文件方法
		System.out.println("主窗体正常！");
		thread();// 采用多线程
		mainframe.setVisible(true);// 使主窗体可见
	}

	/**
	 * 初始化按钮方法
	 */
	private void putbuttons() {
		JButton piao = new JButton("嫖他");// 创建按钮对象
		JButton liao = new JButton("撩他");
		JButton forever = new JButton("永  久  白  嫖");
		JButton da = new JButton("打工赚钱");
		JButton tui = new JButton("退出");
		JButton re = new JButton("重来");
		JButton cun = new JButton("保存");
		new Otherwin().reTell();
		piao.setBounds(150, 250, 200, 50);// 设置窗体位置
		liao.setBounds(400, 250, 200, 50);
		forever.setBounds(150, 350, 450, 50);
		da.setBounds(550, 100, 200, 50);
		tui.setBounds(690, 400, 80, 50);
		re.setBounds(5, 400, 80, 50);
		cun.setBounds(5, 300, 80, 50);
		cc.add(piao);// 将按钮添加至容器中
		cc.add(liao);
		cc.add(forever);
		cc.add(da);
		cc.add(tui);
		cc.add(re);
		cc.add(cun);
		Selection.addSelections();
		// 为按钮添加鼠标单击事件
		liao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Customer.chu.success) {
					if (Customer.chu.flirt()) {
						new Otherwin().communicate("调戏成功");// 弹出对话框方法;
					} else {
						new Otherwin().communicate("调戏失败");
					}
					retext();// 重置标签方法
				}

			}
		});

		piao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!Customer.chu.success) {
					if (Customer.chu.money - Servant.xu.cost - Selection.getCost((String) Selection.jc.getSelectedItem())>= 0) {
						//判断钱是否够用
						if (Customer.chu.prostitute()) {
							new Otherwin().communicate("嫖娼成功");
						} else {
							new Otherwin().communicate("嫖娼失败");
						}
						retext();
					} else {
						new Otherwin().communicate("钱不够啊");
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
						retext();// 重置标签方法
						Customer.chu.success = true;
						new Otherwin().communicate("永久白嫖成功");
					} else {
						new Otherwin().communicate("钱不够啊");
					}
				}

			}
		});
		da.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog jd = new JDialog(MainFrame.mainframe, "王氏集团提醒您", true);
				jd.setLayout(null);
				jd.setResizable(false);
				Container cc = jd.getContentPane();
				
				
				jd.setSize(400, 250);
				JLabel jl = new JLabel("欢迎前来搬砖");
				jl.setFont(new Font("", 0, 20));
				int a = jl.getText().length();
				jl.setBounds(195 - (a * 18) / 2, 18, 200, 80);
				cc.add(jl);
				JButton jb = new JButton("确定");
				jd.setLocationRelativeTo(jb);
				jb.setEnabled(false);// 使按钮不可用
				jb.setBounds(140, 160, 100, 30);
				cc.setBackground(new Color(245, 245, 245));
				cc.add(jb);
				jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jd.setVisible(false);
					}
				});
				JProgressBar jp = new JProgressBar();// 创建进度条
				jp.setBackground(Color.GREEN);// 进度条颜色设置为绿色
				jp.setBounds(63, 100, 275, 20);
				cc.add(jp);
				new Thread(new Runnable() {// 控制进度条的进度

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
						jl.setText("  打工完成");
						Customer.chu.money += Customer.chu.work();
						retext();
						jb.setEnabled(true);// 使按钮可用
					}
				}).start();
				System.out.println("对话框弹出正常！");
				jd.setVisible(true);
			}
		});

		tui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("退出正常！");
				new Otherwin().communicate("真的退出吗?", new Button() {
					@Override
					public void doIt() {
						Otherwin.jd.setVisible(false);// 使用Button接口为按钮添加单击事件
						System.exit(0);
					}
				});
			}
		});
		re.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog jd = new JDialog(MainFrame.mainframe, "王氏集团提醒您", true);
				jd.setLayout(null);
				jd.setResizable(false);
				Container cc = jd.getContentPane();
				
				
				jd.setSize(300, 180);
				JLabel jl = new JLabel("真的重来吗?");
				jl.setFont(new Font("", 0, 20));
				int a = jl.getText().length();
				jl.setBounds(135 - (a * 18) / 2, 18, 200, 80);
				cc.add(jl);
				JButton jb = new JButton("确定");
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
				System.out.println("对话框弹出正常！");
				jd.setVisible(true);
			}
		});
		cun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writeFiles();
				new Otherwin().communicate("保存成功");
				System.out.println("保存正常");
			}
		});
	}

	/**
	 * 初始化标签方法
	 */
	private void putlabels() {
		name.setFont(new Font("", 0, 15));// 设置标签字体
		honey.setFont(new Font("", 0, 15));
		cost.setFont(new Font("", 0, 15));
		money.setFont(new Font("", 0, 15));
		name.setBounds(250, 10, 200, 30);// 设置标签位置
		cc.add(name);// 将标签添加至容器中
		honey.setBounds(250, 80, 200, 30);
		cc.add(honey);
		cost.setBounds(250, 150, 200, 30);
		cc.add(cost);
		money.setBounds(590, 50, 180, 30);
		cc.add(money);
	}

	/**
	 * 重置标签方法
	 */
	private void retext() {
		honey.setText("亲密度：" + Servant.xu.honey);
		money.setText("金钱： " + Customer.chu.money);
		cost.setText("花费： " + Servant.xu.cost);
	}

	/**
	 * 多线程
	 */
	private void thread() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {// 重写run方法
				new Drawicon().draw();// 绘制图片线程
				showFish();
				int R, G, B;
				R = 50;
				G = 100;
				B = 100;
				boolean[] b = { true, true, true };
				while (true) {// 颜色渐变
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
						Thread.sleep(20);// 休眠20毫米，以达到每秒50帧
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					Color c = new Color(R, G, B);
					cc.setBackground(c);
					c = null;
				}
			}
		});
		t1.start();// 启动线程
	}

	/**
	 * 点击照片，显示老于的头像
	 */
	private void showFish() {
		URL url = getClass().getResource("/res/fish.png");//获取图片的URl路径
		Drawicon.photo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {//给图片添加鼠标点击事件
				JFrame jf = new JFrame("Old Fish");
				jf.setLocationRelativeTo(Drawicon.photo);
				jf.setSize(320, 325);
				jf.setResizable(false);
				Container co = jf.getContentPane();
				JLabel jl = new JLabel();//用标签的形式保存图片
				Icon ic = new ImageIcon(url);
				jl.setIcon(ic);
				co.add(jl);
				jl.setBounds(0, 10, 317, 310);
				jf.setVisible(true);
				jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			}
		});
		System.out.println("音乐已加载!");
	}
}
