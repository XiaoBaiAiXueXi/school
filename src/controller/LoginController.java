package controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import commom.util.FileUtil;
import entity.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements Initializable,ControlledStage{
	@FXML
	Button btn_clear;
	@FXML
	Button bun_login;
	@FXML
	TextField tf_userName;
	@FXML
	TextField tf_password;
	StageController sc;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void login() {
		List<User> l = FileUtil.getList(new File(System.getProperty("user.dir")+"/src/resources/data/user.ser"));
		String userName = tf_userName.getText();
		String password = tf_password.getText();
		Alert a = new Alert(Alert.AlertType.WARNING);
		a.initOwner(sc.getStage(Main.LOGIN_STAGE_ID));
		sc.setStage(Main.MAIN_STAGE_ID,Main.LOGIN_STAGE_ID);
		int flag=0;
		for(User u:l) {
			if(userName.equals(u.getName())) {
				if(password.equals(u.getPassword())) {
					flag=1;
					sc.setStage(Main.MAIN_STAGE_ID,Main.LOGIN_STAGE_ID);
				}else {
					a.setTitle("提示");
					a.setContentText("密码错误");
					a.show();
				}
			}
		}
		if(flag != 1 ) {
		a.setTitle("提示");
		a.setContentText("用户名或密码错误");
		a.show();
		}
	}
	
	public void clear() {
		tf_userName.setText("");
		tf_password.setText("");
	}
	@Override
	public void setStageController(StageController stageController) {
		this.sc = stageController;
	}
}
