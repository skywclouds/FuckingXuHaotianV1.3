package Character;

public class Servant {
	public String name;
	public int honey = 50;
	public int cost = -100 * honey + 10000;

	/**
	 * 构造方法
	 */
	public Servant(String name) {
		this.name = name;
		System.out.println(name + "已准备就绪");
	}

	/**
	 * 重置费用方法
	 */
	public void recost() {
		this.cost = -100 * honey + 10000;
		System.out.println("重置花费成功！");
	}

	public static Servant xu = new Servant("徐浩田");// 创建静态对象并命名
}
