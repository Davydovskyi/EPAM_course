package by.jonline.module_5.task5.bean;

public enum CandyType {

	CARAMEL("Карамель"), CHOCOLATE("Шоколадная конфета"), TOFFEE("Ирис"), SOUFFLE("Суфле"), LOLLIPOP("Леденец"),
	TRUFFLE("Трюфельные конфеты");

	private String name;

	private CandyType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}