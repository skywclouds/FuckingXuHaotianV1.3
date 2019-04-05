package Window;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Selection {
	public static JComboBox<String> jc=null;//创建选项控件的引用
	public static void addSelections() {//初始化选项控件,并将其添加到容器中
		String[] str= {"套套","震棒","神油","伟哥","无"};//五个道具
		jc=new JComboBox<>(str);//实例化选项控件对象
		MainFrame.cc.add(jc);//将其添加到容器中
		JLabel jl=new JLabel("道具:");//创建标签
		MainFrame.cc.add(jl);//将其添加到容器中
		jl.setBounds(615,255,40,30);//设置标签位置
		jl.setFont(new Font("", 0, 15));//给标签设置字体
		jc.setBounds(658, 258, 90, 25);//设置选项控件位置
	}
	public static int getCost(String name) {//获取道具的花费
		int G=0;
		switch(name) {//使用switch语句设置花费
		case "套套":G=10;break;
		case "震棒":G=15;break;
		case "神油":G=20;break;
		case "伟哥":G=25;break;
		case "无":G=0;break;
		}
		return G;
	}
	public static int getHoney(String name) {//获取使用道具增加的额外亲密度
		int H=0;
		switch(name) {//使用switch语句设置花费
		case "套套":H=5;break;
		case "震棒":H=10;break;
		case "神油":H=15;break;
		case "伟哥":H=20;break;
		case "无":H=0;break;
		}
		return H;
	}
}
