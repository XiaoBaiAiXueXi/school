package application;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import controller.StageController;
import dao.EmployeeMapper;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static String MAIN_STAGE_ID = "mainStage";
	public static String MAIN_STAGE_RES = "mainStage.fxml";
	
	public static String LOGIN_STAGE_ID = "loginStage";
	public static String LOGIN_STAGE_RES = "login.fxml";

	public static String EMPLOYEE_MANAGE_ID = "employeeManageStage";
	public static String EMPLOYEE_MANAGE_RES = "employeeManage.fxml";
	
	StageController sc;

	@Override
	public void start(Stage primaryStage) {
		try {
			sc = new StageController();
			sc.setPrimaryStage("primaryStage", primaryStage);//主界面交给管理器
		
			//加载界面到管理器
			sc.loadStage(LOGIN_STAGE_ID, LOGIN_STAGE_RES);
			sc.loadStage(MAIN_STAGE_ID, MAIN_STAGE_RES);
			sc.loadStage(EMPLOYEE_MANAGE_ID, EMPLOYEE_MANAGE_RES);
			
			
			sc.getStage(LOGIN_STAGE_ID).setResizable(false);
			sc.setStage(LOGIN_STAGE_ID);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
