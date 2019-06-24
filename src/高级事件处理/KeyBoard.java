package 高级事件处理;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级事件处理
//@user:彭友聪
//@date:2019/6/24
//@time:19:57
//@project:IDEA_JAVA
//@file:KeyBoard.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * 虚拟键盘(键盘的按下与释放)
 */
public class KeyBoard extends JFrame {
    private Color green = Color.GREEN;//定义Color对象，用来表示按下键的颜色
    private Color white = Color.WHITE;//定义Color对象，用来表示释放键的颜色

    // 定义一个集合用来存储所有的按键ID
    private ArrayList<JButton> btns = new ArrayList<JButton>();

    // 自定义一个方法，用来将容器中的所有 JButton 组件添加到集合中
    private void addButtons() {
        for (Component cmp : getComponents()) {  // 遍历面板中所有的组件
            if (cmp instanceof JButton) {
                btns.add((JButton) cmp);
            }
        }
    }

    private KeyBoard() {
        setTitle("虚拟按键（模拟按键的按下和释放）");
        setResizable(false); // 不可改变窗体的宽高
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 548, 280);
        /*
         * 创建JPanel面板contentPane置于JFrame窗体中，并设置面板的背景色、边距和布局
         */
        //声明窗体中的成员组件
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        /*
         * 创建 26 个字母对应的按键并置于面板contentPane中，设置按钮的背景色、位置、宽高以及按钮中的字体位置、内容、样式
         */
        JButton btnQ = new JButton("Q");
        btnQ.setBackground(white);
        btnQ.setVerticalAlignment(SwingConstants.TOP);
        btnQ.setHorizontalAlignment(SwingConstants.LEADING);
        btnQ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnQ.setBounds(0, 60, 47, 45);
        contentPane.add(btnQ);

        JButton btnW = new JButton("W");
        btnW.setBackground(white);
        btnW.setVerticalAlignment(SwingConstants.TOP);
        btnW.setHorizontalAlignment(SwingConstants.LEADING);
        btnW.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnW.setBounds(55, 60, 49, 45);
        contentPane.add(btnW);

        JButton btnE = new JButton("E");
        btnE.setBackground(white);
        btnE.setVerticalAlignment(SwingConstants.TOP);
        btnE.setHorizontalAlignment(SwingConstants.LEADING);
        btnE.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnE.setBounds(110, 60, 45, 45);
        contentPane.add(btnE);

        JButton btnR = new JButton("R");
        btnR.setBackground(white);
        btnR.setVerticalAlignment(SwingConstants.TOP);
        btnR.setHorizontalAlignment(SwingConstants.LEADING);
        btnR.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnR.setBounds(165, 60, 45, 45);
        contentPane.add(btnR);

        JButton btnF = new JButton("F");
        btnF.setBackground(white);
        btnF.setVerticalAlignment(SwingConstants.TOP);
        btnF.setHorizontalAlignment(SwingConstants.LEADING);
        btnF.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnF.setBounds(195, 125, 45, 45);
        contentPane.add(btnF);

        JButton btnD = new JButton("D");
        btnD.setBackground(white);
        btnD.setVerticalAlignment(SwingConstants.TOP);
        btnD.setHorizontalAlignment(SwingConstants.LEADING);
        btnD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnD.setBounds(137, 125, 45, 45);
        contentPane.add(btnD);

        JButton btnT = new JButton("T");
        btnT.setVerticalAlignment(SwingConstants.TOP);
        btnT.setHorizontalAlignment(SwingConstants.LEADING);
        btnT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnT.setBackground(white);
        btnT.setBounds(220, 60, 45, 45);
        contentPane.add(btnT);

        JButton btnY = new JButton("Y");
        btnY.setVerticalAlignment(SwingConstants.TOP);
        btnY.setHorizontalAlignment(SwingConstants.LEADING);
        btnY.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnY.setBackground(white);
        btnY.setBounds(275, 60, 45, 45);
        contentPane.add(btnY);

        JButton btnU = new JButton("U");
        btnU.setVerticalAlignment(SwingConstants.TOP);
        btnU.setHorizontalAlignment(SwingConstants.LEADING);
        btnU.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnU.setBackground(white);
        btnU.setBounds(330, 60, 45, 45);
        contentPane.add(btnU);

        JButton btnI = new JButton("I");
        btnI.setVerticalAlignment(SwingConstants.TOP);
        btnI.setHorizontalAlignment(SwingConstants.LEADING);
        btnI.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnI.setBackground(white);
        btnI.setBounds(385, 60, 45, 45);
        contentPane.add(btnI);

        JButton btnO = new JButton("O");
        btnO.setVerticalAlignment(SwingConstants.TOP);
        btnO.setHorizontalAlignment(SwingConstants.LEADING);
        btnO.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnO.setBackground(white);
        btnO.setBounds(440, 60, 46, 45);
        contentPane.add(btnO);

        JButton btnP = new JButton("P");
        btnP.setVerticalAlignment(SwingConstants.TOP);
        btnP.setHorizontalAlignment(SwingConstants.LEADING);
        btnP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnP.setBackground(white);
        btnP.setBounds(495, 60, 45, 45);
        contentPane.add(btnP);

        JButton btnA = new JButton("A");
        btnA.setVerticalAlignment(SwingConstants.TOP);
        btnA.setHorizontalAlignment(SwingConstants.LEADING);
        btnA.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnA.setBackground(white);
        btnA.setBounds(23, 125, 45, 45);
        contentPane.add(btnA);

        JButton btnS = new JButton("S");
        btnS.setVerticalAlignment(SwingConstants.TOP);
        btnS.setHorizontalAlignment(SwingConstants.LEADING);
        btnS.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnS.setBackground(white);
        btnS.setBounds(82, 125, 45, 45);
        contentPane.add(btnS);

        JButton btnG = new JButton("G");
        btnG.setVerticalAlignment(SwingConstants.TOP);
        btnG.setHorizontalAlignment(SwingConstants.LEADING);
        btnG.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnG.setBackground(white);
        btnG.setBounds(251, 125, 45, 45);
        contentPane.add(btnG);

        JButton btnH = new JButton("H");
        btnH.setVerticalAlignment(SwingConstants.TOP);
        btnH.setHorizontalAlignment(SwingConstants.LEADING);
        btnH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnH.setBackground(white);
        btnH.setBounds(306, 125, 45, 45);
        contentPane.add(btnH);

        JButton btnJ = new JButton("J");
        btnJ.setVerticalAlignment(SwingConstants.TOP);
        btnJ.setHorizontalAlignment(SwingConstants.LEADING);
        btnJ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnJ.setBackground(white);
        btnJ.setBounds(361, 125, 45, 45);
        contentPane.add(btnJ);

        JButton btnK = new JButton("K");
        btnK.setVerticalAlignment(SwingConstants.TOP);
        btnK.setHorizontalAlignment(SwingConstants.LEADING);
        btnK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnK.setBackground(white);
        btnK.setBounds(416, 125, 47, 45);
        contentPane.add(btnK);

        JButton btnL = new JButton("L");
        btnL.setVerticalAlignment(SwingConstants.TOP);
        btnL.setHorizontalAlignment(SwingConstants.LEADING);
        btnL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnL.setBackground(white);
        btnL.setBounds(471, 125, 45, 45);
        contentPane.add(btnL);

        JButton btnZ = new JButton("Z");
        btnZ.setVerticalAlignment(SwingConstants.TOP);
        btnZ.setHorizontalAlignment(SwingConstants.LEADING);
        btnZ.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnZ.setBackground(white);
        btnZ.setBounds(39, 190, 45, 45);
        contentPane.add(btnZ);

        JButton btnX = new JButton("X");
        btnX.setVerticalAlignment(SwingConstants.TOP);
        btnX.setHorizontalAlignment(SwingConstants.LEADING);
        btnX.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnX.setBackground(white);
        btnX.setBounds(107, 190, 45, 45);
        contentPane.add(btnX);

        JButton btnC = new JButton("C");
        btnC.setVerticalAlignment(SwingConstants.TOP);
        btnC.setHorizontalAlignment(SwingConstants.LEADING);
        btnC.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnC.setBackground(white);
        btnC.setBounds(178, 190, 45, 45);
        contentPane.add(btnC);

        JButton btnV = new JButton("V");
        btnV.setVerticalAlignment(SwingConstants.TOP);
        btnV.setHorizontalAlignment(SwingConstants.LEADING);
        btnV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnV.setBackground(white);
        btnV.setBounds(250, 190, 45, 45);
        contentPane.add(btnV);

        JButton btnB = new JButton("B");
        btnB.setVerticalAlignment(SwingConstants.TOP);
        btnB.setHorizontalAlignment(SwingConstants.LEADING);
        btnB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnB.setBackground(white);
        btnB.setBounds(315, 190, 45, 45);
        contentPane.add(btnB);

        JButton btnN = new JButton("N");
        btnN.setVerticalAlignment(SwingConstants.TOP);
        btnN.setHorizontalAlignment(SwingConstants.LEADING);
        btnN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnN.setBackground(white);
        btnN.setBounds(382, 190, 47, 45);
        contentPane.add(btnN);

        JButton btnM = new JButton("M");
        btnM.setVerticalAlignment(SwingConstants.TOP);
        btnM.setHorizontalAlignment(SwingConstants.LEADING);
        btnM.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnM.setBackground(white);
        btnM.setBounds(449, 190, 48, 45);
        contentPane.add(btnM);
        /*
         * 创建面板panel置于面板contentPane中，设置面板panel的位置、宽高、TitledBorder、背景色以及布局方式（边界布局）
         */
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "文本显示区", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 540, 45);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        /*
         * 创建文本框textField置于面板panel的中间
         */
        JTextField textField ;
        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() { //文本框添加键盘事件的监听
            char word;
            @Override
            public void keyPressed(KeyEvent e) { //按键被按下时被触发
                word=e.getKeyChar();//获取按下键表示的字符
                for(int i=0;i<btns.size();i++){//遍历存储按键ID的ArrayList集合
                    //判断按键是否与遍历到的按键的文本相同
                    if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getText())){
                        btns.get(i).setBackground(green);//将指定按键颜色设置为绿色
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) { //按键被释放时被触发
                word=e.getKeyChar();//获取释放键表示的字符
                for(int i=0;i<btns.size();i++){//遍历存储按键ID的ArrayList集合
                    //判断按键是否与遍历到的按键的文本相同
                    if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getText())){
                        btns.get(i).setBackground(white);//将指定按键颜色设置为白色
                    }
                }
            }
            @Override
            public void keyTyped(KeyEvent e){
                word=e.getKeyChar();//获取按下键表示的字符
                for(int i=0;i<btns.size();i++){//遍历存储按键ID的ArrayList集合
                    //判断按键是否与遍历到的按键的文本相同
                    if(String.valueOf(word).equalsIgnoreCase(btns.get(i).getText())){
                        btns.get(i).setBackground(green);//将指定按键颜色设置为绿色
                    }
                }
            }
        });
        panel.add(textField, BorderLayout.CENTER);
        textField.setColumns(10);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                KeyBoard frame = new KeyBoard();
                frame.addButtons(); // 初始化存储所有按键的集合
                frame.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
