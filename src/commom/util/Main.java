package commom.util;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import entity.User;

public class Main {
	public static void main(String[] args) {
		
		//  PayLevel pl = new PayLevel(1,100); List<PayLevel> list = new
		  
		  User u = new User("ºúÑà²¨","123456");
		  List list = new LinkedList<User>(); 
		  list.add(u); 
		  FileUtil.saveList(list, new File(System.getProperty("user.dir")+"/src/resources/data/user.ser"));
		 

		/*
		 * List<PayLevel> l = FileUtil.getList(new
		 * File(System.getProperty("user.dir")+"/source/data/PayLevel.ser"));
		 * for(PayLevel p:l) System.out.println(p.getLevel()+p.getMoney());
		 */
	}
}
