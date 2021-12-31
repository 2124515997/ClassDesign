package count30;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Count  implements ActionListener {

    private static Integer num;
    private static Integer num1;
    private static JButton btn;
    private static JButton btn1;
    private static JButton jButton;
    private static JButton jButton1;
    private static JButton jButton2;
    private static JTextField textField;
    private static JTextField textField1;
    private static JTextField textField2;

    /**
     * 监听代码
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn){ button1();}
        if (e.getSource() == btn1){ button2();}

    }

    /**
     * 主要的框架类
     */
    public static void frameMain(){
        //1.创建一个JFrame
        JFrame jf = new JFrame();
        //2.主要框架
        jf.setTitle("数火柴游戏");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(200, 200);
        jf.setVisible(true);
        jf.setLocation(0, 0);
        JPanel panel = new JPanel();//创建一个JPanel容器
        jf.setContentPane(panel);
        btn = new JButton("随机生成一个在20到50的数字");
        panel.add(btn);
        textField = new JTextField(5);
        panel.add(textField);

        btn1 = new JButton("计算机取数字");
        panel.add(btn1);
        textField1 = new JTextField(5);
        panel.add(textField1);
        textField1.setText(String.valueOf(num1));

        JLabel jLabel = new JLabel("剩下的火柴数");
        panel.add(jLabel);
        textField2 = new JTextField(5);
        panel.add(textField2);

        textField2.setText(String.valueOf(num));

        JLabel jLabel1 = new JLabel("玩家取火柴");
        panel.add(jLabel1);
        jButton = new JButton("一根");
        jButton1 = new JButton("二根");
        jButton2 = new JButton("三根");
        panel.add(jButton);
        panel.add(jButton1);
        panel.add(jButton2);
    }
    /**
     * 生成随机数
     * @return
     */
    public static void  button1() {
        Random random = new Random();
        num = random.nextInt(31) + 20;
        //3.将btn加入监听器
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(""+num);
            }
        });
    }

    /**
     * 计算总数
     */
    public static void button2() {
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                num1 = random.nextInt(3) + 1;
                //System.out.println(i);
                textField1.setText(String.valueOf(num1));


                if (e.getSource() == btn1) {
                    num = num - num1;

                    textField2.setText(String.valueOf(num));
                    if (num <= 0) {
                        JOptionPane.showMessageDialog(null, "Computer is the winner"); //弹出消息框
                    }
                }
            }
        });
    }
    public static void playertake1()
    {jButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==jButton)num=num-1;{
            if (num<=0)JOptionPane.showMessageDialog(null, "you are the winner"); //弹出消息框
            textField2.setText(String.valueOf(num));}
        }
    });

    }
    public static void playertake2()
    {jButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==jButton1)num=num-2;{
            if (num<=0)JOptionPane.showMessageDialog(null, "you are the winner"); //弹出消息框
            textField2.setText(String.valueOf(num));}
        }
    });

    }
    public static void playertake3()
    {jButton2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==jButton2)num=num-3;{
            if (num<=0)JOptionPane.showMessageDialog(null, "you are the winner"); //弹出消息框
            textField2.setText(String.valueOf(num));}
        }
    });
    }

    public static void main(String[] args) {
        frameMain();
        button1();
        button2();
        playertake1();
        playertake2();
        playertake3();
    }


}