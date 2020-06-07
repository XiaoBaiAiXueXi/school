package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import application.Main;
import dao.EmployeeMapper;
import entity.EmployeeProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable,ControlledStage{

	StageController sc;
	ObservableList<EmployeeProperty> list;//列表数据
	ObservableList<String> comboboxList;//删除控件列表
	SqlSession ss = null;
	
	@FXML
	Menu menu_employeeManage;
	@FXML
	MenuBar menubar;
	
	@FXML
	TableColumn<EmployeeProperty,SimpleStringProperty> tabCol_employeeId;
	@FXML
	TableColumn<EmployeeProperty,SimpleStringProperty> tabCol_employeeName;
	@FXML
	TableColumn<EmployeeProperty,SimpleStringProperty> tabCol_employeeGender;
	@FXML
	TableColumn<EmployeeProperty,SimpleStringProperty> tabCol_employeeSection;
	@FXML
	TableColumn<EmployeeProperty,SimpleStringProperty> tabCol_employeePosi;
	@FXML
	TableColumn<EmployeeProperty,IntegerProperty> tabCol_employeeLevel;
	@FXML
	TableView<EmployeeProperty>  tabView_employeeTab;
	@FXML
	ComboBox<String> comboBox_EmId;
	@FXML
	ChoiceBox<String> choicebox_gender;
	@FXML
	Button btn_del;
	@FXML
	Button btn_clearA;
	@FXML
	Button btn_clearQ;
	
	@Override
	public void setStageController(StageController stageController) {
		// TODO Auto-generated method stub
		this.sc = stageController;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//显示员工列表
		
		try {
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("config/mybatis/mybatis-config.xml"));
			ss = ssf.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabCol_employeeId.setCellValueFactory(new PropertyValueFactory<EmployeeProperty,SimpleStringProperty>("id"));
		tabCol_employeeName.setCellValueFactory(new PropertyValueFactory<EmployeeProperty,SimpleStringProperty>("name"));
		tabCol_employeeGender.setCellValueFactory(new PropertyValueFactory<EmployeeProperty,SimpleStringProperty>("gender"));
		tabCol_employeeSection.setCellValueFactory(new PropertyValueFactory<EmployeeProperty,SimpleStringProperty>("section"));
		tabCol_employeePosi.setCellValueFactory(new PropertyValueFactory<EmployeeProperty,SimpleStringProperty>("post"));
		tabCol_employeeLevel.setCellValueFactory(new PropertyValueFactory<EmployeeProperty,IntegerProperty>("level"));
		
		EmployeeMapper em = ss.getMapper(EmployeeMapper.class);
		
		list = FXCollections.observableArrayList(em.getEmployeeList());
		
		tabView_employeeTab.setItems(list);
		
		
		//初始化控件值
		comboboxList =FXCollections.observableArrayList();
		for(EmployeeProperty e:em.getEmployeeList()) {
			comboboxList.add(e.getId());
		}
		comboBox_EmId.setItems(comboboxList);
	
		
		choicebox_gender.getItems().addAll("男士","女士");
	
	}
	
	
	public void delEmByid() {
		String selectId = comboBox_EmId.getSelectionModel().getSelectedItem();
		EmployeeMapper em = ss.getMapper(EmployeeMapper.class);
		em.delById(selectId);
		Iterator<EmployeeProperty> itr = list.iterator();
		while(itr.hasNext()) {
			if(itr.next().getId().equals(selectId))
				itr.remove();
		}
		
		
		
		Iterator<String> itr0 = comboboxList.iterator();
		while(itr0.hasNext()) {
			if(itr0.next().equals(selectId))
				itr0.remove();
		}
		
		comboBox_EmId.getSelectionModel().clearSelection();
		ss.commit();
	}
	
	public void clearQ() {
		
	}
	
}
