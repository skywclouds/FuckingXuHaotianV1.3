package Character;

import Window.Selection;

public class Customer {
	public int money;// 定义金钱变量
	public boolean success = false;

	public Customer(int money) {// 构造方法，给money赋值
		this.money = money;
		System.out.println("客人已准备就绪！");// 测试用
	}

	/**
	 * "行动"方法
	 */
	public boolean prostitute() {
		double p = Math.random();// 90%的概率失败
		boolean b = false;
		if (p < 0.91) {// 若成功，则……
			b = true;
			money -= (Servant.xu.cost + Selection.getCost((String) Selection.jc.getSelectedItem()));
			if (Servant.xu.honey < 90 - Selection.getHoney((String) Selection.jc.getSelectedItem())) {// 防止亲密度超过100
				Servant.xu.honey += (10 + Selection.getHoney((String) Selection.jc.getSelectedItem()));
			} else {
				Servant.xu.honey = 100;
			}
			Servant.xu.recost();

		} else {// 若失败，则……
			money = 0;
			if (Servant.xu.honey > 20) {// 防止亲密度变为负数
				Servant.xu.honey -= 20;
			} else {
				Servant.xu.honey = 0;
			}
			Servant.xu.recost();

		}
		System.out.println("行动正常！");
		return b;// 返回成功或失败
	}

	/**
	 * 调戏方法
	 */
	public boolean flirt() {
		double p = Math.random();
		boolean b = false;
		if (p < 0.51) {// 50%概率失败
			b = true;
			if (Servant.xu.honey > 95) {// 若成功，则……
				Servant.xu.honey = 100;
			} else {
				Servant.xu.honey += 5;
			}
			Servant.xu.recost();
		} else {

			if (Servant.xu.honey > 10) {// 若失败，则……
				Servant.xu.honey -= 10;
			} else {
				Servant.xu.honey = 0;
			}
			Servant.xu.recost();
		}
		System.out.println("调戏正常！");
		return b;// 返回成功或失败

	}

	/**
	 * 打工方法
	 */
	public int work() {
		int cost = (int) (201 * Math.random() + 100); // 随机生成薪水
		System.out.println("打工正常！");
		return cost;

	}

	public static Customer chu = new Customer(1000);// 创建静态对象
}
