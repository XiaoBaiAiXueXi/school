package controller;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageController {
	 //����һ��ר�Ŵ洢Stage��Map��ȫ�����ڴ��Stage����
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();


    /**
     * �����غõ�Stage�ŵ�Map�н��й���
     *
     * @param name  �趨Stage������
     * @param stage Stage�Ķ���
     */
    public void addStage(String name, Stage stage) {
        stages.put(name, stage);
    }


    /**
     * ͨ��Stage���ƻ�ȡStage����
     *
     * @param name Stage������
     * @return ��Ӧ��Stage����
     */
    public Stage getStage(String name) {
        return stages.get(name);
    }


    /**
     * ������̨�Ķ��󱣴�����������ֻ��Ϊ���Ժ������Ҫ�ã�Ŀǰ����֪���ò��õ���
     *
     * @param primaryStageName ��������̨������
     * @param primaryStage     ����̨������Start()��������JavaFx��API����
     */
    public void setPrimaryStage(String primaryStageName, Stage primaryStage) {
        this.addStage(primaryStageName, primaryStage);
    }


    /**
     * ���ش��ڵ�ַ����Ҫfxml��Դ�ļ����ڶ����Ĵ��ڲ���Pane������������̳�
     *
     * @param name      ע��õ�fxml���ڵ��ļ�
     * @param resources fxml��Դ��ַ
     * @param styles    �ɱ������initʹ�õĳ�ʼ����ʽ��Դ����
     * @return �Ƿ���سɹ�
     */
    public boolean loadStage(String name, String resources, StageStyle... styles) {
        try {
            //����FXML��Դ�ļ�
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resources));
            Parent tempPane = (Parent) loader.load();

            //ͨ��Loader��ȡFXML��Ӧ��ViewCtr��������StageControllerע�뵽ViewCtr��
            ControlledStage controlledStage = (ControlledStage) loader.getController();
            controlledStage.setStageController(this);

            //�����Ӧ��Stage
            Scene tempScene = new Scene(tempPane);
            Stage tempStage = new Stage();
            tempStage.setScene(tempScene);

            //����initStyle
            for (StageStyle style : styles) {
                tempStage.initStyle(style);
            }

            //�����úõ�Stage�ŵ�HashMap��
            this.addStage(name, tempStage);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ��ʾStage���������κ�Stage
     *
     * @param name ��Ҫ��ʾ�Ĵ��ڵ�����
     * @return �Ƿ���ʾ�ɹ�
     */
    public boolean setStage(String name) {
    	this.getStage(name).getIcons().add(new Image("/img/icon.png"));
        this.getStage(name).show();
        return true;
    }


    /**
     * ��ʾStage�����ض�Ӧ�Ĵ���
     *
     * @param show  ��Ҫ��ʾ�Ĵ���
     * @param close ��Ҫɾ���Ĵ���
     * @return
     */
    public boolean setStage(String show, String close) {
        getStage(close).close();
        setStage(show);
        return true;
    }


    /**
     * ��Map��ɾ��Stage���ض���
     *
     * @param name ��Ҫɾ����fxml�����ļ���
     * @return �Ƿ�ɾ���ɹ�
     */
    public boolean unloadStage(String name) {
        if (stages.remove(name) == null) {
            System.out.println("���ڲ����ڣ���������");
            return false;
        } else {
            System.out.println("�����Ƴ��ɹ�");
            return true;
        }
    }
}
