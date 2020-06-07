package commom.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
/**
 * 
 * @author hyb
 *   ����java��׼���ļ���׺Ӧ��Ϊ.ser
 */
public class FileUtil {
	/**
	 * 
	 * @author hyb
	 * @Description ����File�������������List 
	 * @date 2020��6��4�� ����11:40:16
	 *       @param <T>
	 *       @param f
	 *       @returnList<T>
	 */
		public static <T> List<T> getList(File f) {
			ObjectInputStream ois = null ;
			try {
				ois = new ObjectInputStream(new FileInputStream(f));
				return (List)ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		
		public static <T> boolean saveList(List<T> list,File f) {
			ObjectOutputStream oos = null ;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(list);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
		}
		
}
