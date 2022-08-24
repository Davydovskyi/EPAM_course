package by.jonline.module_5.task1.view;

import by.jonline.module_5.task1.entity.File;

public class TextView {

	public void viewContent(File file) {
		System.out.println(file.getContent().toString());
	}
}