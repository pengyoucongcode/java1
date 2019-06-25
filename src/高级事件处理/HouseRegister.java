package 高级事件处理;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级事件处理
//@user:彭友聪
//@date:2019/6/25
//@time:15:37
//@project:IDEA_JAVA
//@file:HouseRegister.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class HouseRegister extends JFrame {

    private JComboBox<String> cboxNCity;
    private JComboBox<String> cboxCity;
    //存储黑龙江省的所有地级市
    private String[] strHLJ={ "哈尔滨", "齐齐哈尔", "牡丹江", "大庆", "伊春", "双鸭山","鹤岗", "鸡西", "佳木斯", "七台河", "黑河", "绥化", "大兴安岭" };
    //存储吉林省的所有地级市
    private String[] strJL={ "长春", "延边", "吉林", "白山", "白城", "四平", "松原", "辽源", "大安", "通化" };
    //存储辽宁省的所有地级市
    private String[] strLN={ "沈阳", "大连", "葫芦岛", "旅顺", "本溪", "抚顺","铁岭", "辽阳", "营口", "阜新", "朝阳", "锦州", "丹东", "鞍山" };
    /*
     * 根据选择的省显示其所有地级市
     * @param item ItemEvent类型，表示下拉列表中的选择项
     * @param cbox JComboBox类型，表示JComboBox组件
     */
    private void getCity(ItemEvent item, JComboBox<String> cbox){
        String strProvince=String.valueOf(item.getItem());//获取选中项
        switch (strProvince) {
            case "黑龙江省":
                cbox.setModel(new DefaultComboBoxModel<>(strHLJ));
                break;
            case "吉林省":
                cbox.setModel(new DefaultComboBoxModel<>(strJL));
                break;
            case "辽宁省":
                cbox.setModel(new DefaultComboBoxModel<>(strLN));
                break;
        }
    }
    /**
     * 主方法
     */
    public static void main(String[] args) {
        try{
            new HouseRegister().setVisible(true); // 创建HouseRegister对象frame
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 创建JFrame窗体
     */
    private HouseRegister() { // HouseRegister的构造方法
        setTitle("户口本（局部）"); // 设置窗体题目
        NPanel contentPanel = new NPanel();// 创建一个面板对象
        contentPanel.setLayout(null);// 设置面板为绝对布局
        getContentPane().add(contentPanel);// 将面板添加到窗体上
        setResizable(false); // 不可改变窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭的方式
        setBounds(100, 100, 592, 190);

        /*
         * 创建下拉列表cboxProvince置于面板contentPane中，设置复选框里的Model值、复选框的大小
         */
        // 声明“户口本”类中的成员组件
        JComboBox<String> cboxProvince = new JComboBox<>();
        //存储省份
        String[] strProvinces = {"黑龙江省", "吉林省", "辽宁省"};
        cboxProvince.setModel(new DefaultComboBoxModel<>(strProvinces));
        //添加选项事件监听器
        cboxProvince.addItemListener(arg0 -> {//重写选项发生变化时的方法
            getCity(arg0,cboxCity);//调用自定义方法实现省市联动
        });
        cboxProvince.setBounds(69, 97, 85, 21);
        contentPanel.add(cboxProvince);
        /*
         * 创建下拉列表“市”，设置该下拉列表中的选项值，横坐标、纵坐标、宽高，把下拉列表“市”放到面板contentPane中
         */

        cboxCity = new JComboBox<>(); // 创建下拉列表cboxCity
        cboxCity.setModel(new DefaultComboBoxModel<>(strHLJ));
        cboxCity.setBounds(158, 97, 85, 21); // 设置下拉列表的大小
        contentPanel.add(cboxCity); // 将下拉列表cboxCity置于面板panel中

        /*
         * 创建下拉列表cboxNProvince置于面板contentPane中，设置复选框里的Model值、复选框的大小
         */
        JComboBox<String> cboxNProvince = new JComboBox<>();
        cboxNProvince.setModel(new DefaultComboBoxModel<>(strProvinces));
        //添加选项事件监听器
        cboxNProvince.addItemListener(arg0 -> {//重写选项发生变化时的方法
            getCity(arg0,cboxNCity);//调用自定义方法实现省市联动
        });
        cboxNProvince.setBounds(69, 131, 85, 21);
        contentPanel.add(cboxNProvince);
        /*
         * 创建下拉列表“市”，设置该下拉列表中的选项值，横坐标、纵坐标、宽高，把下拉列表“市”放到面板contentPane中
         */

        cboxNCity = new JComboBox<>(); // 创建下拉列表cboxNProvince
        cboxNCity.setModel(new DefaultComboBoxModel<>(strHLJ));
        cboxNCity.setBounds(158, 131, 85, 21); // 设置下拉列表的大小
        contentPanel.add(cboxNCity); // 将下拉列表cboxNProvince置于面板panel中
    }

    class NPanel extends JPanel {// 重绘面板
        @Override
        protected void paintComponent(Graphics arg0) {// 重写事件，用来重绘面板背景
            int x = 0;// 定义重绘的起始点坐标
            int y = 0;
            // 使用指定图片创建ImageIcon对象
            ImageIcon imgBack;
            imgBack = new ImageIcon(HouseRegister.class.getResource("back.png"));
            // 按面板大小重绘图片
            arg0.drawImage(imgBack.getImage(), x, y, getSize().width, getSize().height, this);
            while (true) {
                arg0.drawImage(imgBack.getImage(), x, y, this);// 按原始大小重绘图片
                if (x > getSize().width && y > getSize().height)
                    break;
                // 保证窗口大于图片时，图片仍能够覆盖整个窗口
                if (x > getSize().width) {
                    x = 0;
                    y += imgBack.getIconHeight();
                } else
                    x += imgBack.getIconWidth();
            }
        }
    }
}
