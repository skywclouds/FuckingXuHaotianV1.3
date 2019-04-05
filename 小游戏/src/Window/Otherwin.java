package Window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Otherwin {
	static JDialog jd = null;
	static Container cc = null;

	/**
	 * 声明窗体方法
	 */
	void Sign() {
		JFrame sign = new JFrame("声明");// 创建声明窗口
		sign.setResizable(false);
		sign.setSize(500, 700);
		sign.setLayout(null);
		sign.setLocationRelativeTo(null);;// 设置窗体弹出位置
		Container cc = sign.getContentPane();// 获取容器
		cc.setBackground(new Color(240, 240, 240));
		JLabel jl = new JLabel("免责声明");
		jl.setBounds(180, 0, 200, 50);
		jl.setFont(new Font("", 1, 30));
		JButton bi = new JButton("开始游戏");// 设置按钮
		cc.add(jl);
		String s = "       本游戏仅供学习，娱乐，交流使用。不针对任何人，请于下载后24小时之内卸载，否则产生的一切后果由你承担。"
				+ "由于本人水平有限，加之时间仓促，可能会有一些错误，请您谅解。如果您有一些意见和建议，请发到我的电子邮箱\'\'ws_wanghe@163.com\'\'。"
				+ "\n\t\t王先生\n\t\t2018-08-12";// 声明的内容
		JTextArea jt = new JTextArea(s);// 创建文本域对象
		jt.setFont(new Font("", 0, 20));// 设置文本域的字体
		jt.setEditable(false);// 设置窗体不能缩放
		jt.setLineWrap(true);// 设置自动换行
		jt.setBounds(45, 75, 400, 400);
		cc.add(jt);// 将文本域添加至容器中
		sign.setVisible(true);// 是窗体可见
		bi.setBounds(190, 550, 100, 50);
		cc.add(bi);// 将按钮添加至容器中
		bi.addActionListener(new ActionListener() {
			// 为按钮添加鼠标单击事件
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame login = new LoginDialog();// 实例化登录窗体对象
				login.setResizable(false);
				login.setVisible(true);// 使登录窗体可见
				sign.setVisible(false);// 是声明窗口不可见
			}
		});
		// 为文本域添加键盘事件
		jt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {// 判断是否为回车键
					JFrame login = new LoginDialog();// 实例化登录窗体对象
					login.setVisible(true);// 使登录窗体可见
					sign.setVisible(false);// 是声明窗口不可见
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		sign.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置窗口关闭方式
		System.out.println("免责声明正常！");
	}

	/**
	 * 创建对话框方法
	 */
	void communicate(String Display) {
		jd = new JDialog(MainFrame.mainframe, "王氏集团提醒您", true);
		jd.setResizable(false);
		cc = jd.getContentPane();// 获取容器
		cc.setLayout(new GridLayout(2, 1));
		jd.setSize(315, 185);// 设置对话框大小
		JLabel jl = new JLabel(Display);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setFont(new Font("", 0, 20));
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.setLayout(new GridLayout(3,1));
		jp2.setLayout(null);
		cc.add(jp1);
		cc.add(jp2);
		JButton jb = new JButton("确定");// 设置按钮
		jd.setLocationRelativeTo(jb);// 设置对话框弹出位置
		jp1.add(new JPanel());
		jp1.add(jl);
		jp1.add(new JPanel());
		jb.setBounds(105, 10, 100, 30);
		jp2.add(jb);
		cc.setBackground(new Color(245, 245, 245));
		// 为按钮添加鼠标单击事件
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jd.setVisible(false);// 隐藏对话框
			}
		});
		System.out.println("对话框弹出正常！");
		jd.setVisible(true);// 使对话框可见
	}

	void communicate(String Display, Button bu) {
		// 设置标题，父窗体，类型
		jd = new JDialog(MainFrame.mainframe, "王氏集团提醒您", true);
		
		jd.setResizable(false);
		cc = jd.getContentPane();// 获取容器
		cc.setLayout(new GridLayout(2, 1));
		jd.setSize(315, 185);// 设置对话框大小
		JLabel jl = new JLabel(Display);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setFont(new Font("", 0, 20));
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.setLayout(new GridLayout(3,1));
		jp2.setLayout(null);
		cc.add(jp1);
		cc.add(jp2);
		JButton jb = new JButton("确定");// 设置按钮
		jd.setLocationRelativeTo(jb);// 设置对话框弹出位置
		jp1.add(new JPanel());
		jp1.add(jl);
		jp1.add(new JPanel());
		jb.setBounds(105, 10, 100, 30);
		jp2.add(jb);
		cc.setBackground(new Color(245, 245, 245));
		
		// 为按钮添加鼠标单击事件
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bu.doIt();
			}
		});
		System.out.println("对话框弹出正常！");
		jd.setVisible(true);// 使对话框可见
	}
	/**
	 * 实现复读机功能的方法
	 * */
	void reTell() {
		JTextField jt = new JTextField("请输入复读内容(仅支持英文)");//创建一个文本框
		jt.setBounds(550, 180, 200, 25);
		MainFrame.cc.add(jt);
		jt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {// 判断是否为回车键
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
 * 给提示对话框中的"确定"按钮提供单击事件的接口
 */
interface Button {
	void doIt();
}

