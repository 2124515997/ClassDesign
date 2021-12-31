package test;


import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
public class Test extends JFrame implements ActionListener {
    /*************北面的控件***************/
    private JPanel jp_north=new JPanel();//声明的面板
    private JTextField input_text=new JTextField();//输入框
    private JButton c_Btn=new JButton("C");//清除按钮
    /*************中间的控件***************/
    private JPanel jp_center=new JPanel();

    public Test() throws HeadlessException{
        this.init();
        this.addCenterButton();
        this.addNorth();
    }
    //初始化的方法
    public void init(){
        this.setTitle("计算器");
        this.setSize(300,300);
        this.setLayout(new BorderLayout());
        // this.setResizable(false);//窗体不可拉伸
        this.setLocationRelativeTo(null);//窗口居中
    }
    //添加北面的控件
    public void addNorth(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.input_text.setPreferredSize(new Dimension(230,30));

        jp_north.add(input_text);
        jp_north.add(c_Btn);

        c_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input_text.setText("");
            }
        });//清空功能
        this.add(jp_north,BorderLayout.NORTH);
    }
    //添加中间的按钮
    public void addCenterButton(){
        String btn_text="123+456-789*0.=%";
        this.jp_center.setLayout(new GridLayout(4,4));
        for(int i=0;i<16;i++){
            String temp=btn_text.substring(i,i+1);
            JButton btn=new JButton();
            btn.setText(temp);
            btn.addActionListener(this);
            jp_center.add(btn);
        }
        this.add(jp_center,BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        Test carculator=new Test();
        carculator.setVisible(true);
    }
    private String firstInput=null;
    private String operator=null;
    @Override
    public void actionPerformed(ActionEvent e) {
        String clickStr = e.getActionCommand();//获取点击按钮的值
        if (".123456789".indexOf(clickStr) != -1) {
            this.input_text.setText(input_text.getText()+clickStr);//把按钮上的值赋给文本框里
            this.input_text.setHorizontalAlignment(JTextField.RIGHT);
            // JOptionPane.showMessageDialog(this, clickStr);//获取的值.123456789显现出来，+—*/为运算符不用获得值
        }else if(clickStr.matches("[\\+\\-*%]{1}")){
            operator =clickStr;//根据运算符进行对应操作运算
            firstInput=this.input_text.getText();//把第一次输入的值进行记录
            this.input_text.setText("");//把文本框清空
        }else if(clickStr.equals("=")){
            Double a=Double.valueOf(firstInput);//第一次输入文本框的值
            Double b=Double.valueOf(this.input_text.getText());//点击运算符后输入文本框里的值
            Double result=null;
            switch(operator){
                case"+":
                    result=a+b;
                    break;
                case"-":
                    result=a-b;
                    break;
                case"*":
                    result=a*b;
                    break;
                case"%":
                    if(b!=0) {
                        result = a / b;
                    }
                    break;
            }
            this.input_text.setText(result.toString());

        }
    }

}
