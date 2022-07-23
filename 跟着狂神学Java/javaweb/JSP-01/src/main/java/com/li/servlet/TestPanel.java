package com.li.servlet;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame=new Frame("中秋快乐");//新建一个窗体
        Panel panel=new Panel(null);//面板
        frame.setLayout(null);//设置窗体布局

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255));//设置背景颜色

        frame.setBounds(50,50,300,300);
        frame.setBackground(new Color(0,255,0));

        frame.add(panel);
        frame.setVisible(true);
        //监听关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
    }
}
