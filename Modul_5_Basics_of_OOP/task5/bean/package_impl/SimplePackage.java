package by.jonline.module_5.task5.bean.package_impl;

import by.jonline.module_5.task5.bean.Package;

public class SimplePackage extends Package {

	private static final long serialVersionUID = -923637453683857326L;

	public SimplePackage() {
		super("Simple Package", 30);
	}

	public SimplePackage(String name, int price) {
		super(name, price);
	}
}