import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
public class tic_tac extends JFrame implements ActionListener{
    JTextField display,jtf[]; JButton retry;
    tic_tac()
    {
        setSize(300,300);
        retry=new JButton("retry");
        retry.addActionListener(this);
        setLayout(new BorderLayout(5,10));
        jtf=new JTextField[9];
        JPanel jp=new JPanel();
         display=new JTextField("first's turn");
         display.setFont(new Font("sansSerif",Font.BOLD,30));
        display.setEditable(false);
        add(display,BorderLayout.NORTH);
        jp.setLayout(new GridLayout(3,3,4,4));
        for(int i=0;i<9;i++)
        {
            jtf[i]=new JTextField(4);
        }
        for(JTextField jt:jtf)
        {
            jp.add(jt);
            jt.setFont(new Font("sansSerif",Font.BOLD,20));
        }
        add(jp,BorderLayout.CENTER);
        JButton next=new JButton("next");
        next.addActionListener(this);
        JPanel buts=new JPanel();
        buts.add(next);
        buts.add(retry);
        add(buts,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource()==retry)
        {
            for(JTextField jt:jtf)
            {
                jt.setText("");
                jt.setBackground(Color.white);
            }
            display.setText("first's turn");
        }
        else{
        if((display.getText()).equals("first's turn"))
            display.setText("seconds's turn");
        else
        display.setText("first's turn");
        String vals[]=new String[9];
        for(int i=0;i<9;i++)
        {
            vals[i]=jtf[i].getText();
        }
       if((vals[0].equals(vals[1]))&&(vals[1].equals(vals[2]))&&((vals[0].equals("1"))||(vals[0].equals("2"))))
            display.setText((vals[0].equals("1") ? "first wins":"second wins"));
        else if((vals[0].equals(vals[3]))&&(vals[3].equals(vals[6]))&&((vals[0].equals("1"))||(vals[0].equals("2"))))
            display.setText((vals[0].equals("1") ? "first wins":"second wins"));
        else if((vals[0].equals(vals[4]))&&(vals[4].equals(vals[8]))&&((vals[0].equals("1"))||(vals[0].equals("2"))))
            display.setText((vals[0].equals("1") ? "first wins":"second wins"));
        else if((vals[1].equals(vals[4]))&&(vals[4].equals(vals[7]))&&((vals[1].equals("1"))||(vals[1].equals("2"))))
            display.setText((vals[1].equals("1") ? "first wins":"second wins"));
        else if((vals[2].equals(vals[5]))&&(vals[5].equals(vals[8]))&&((vals[2].equals("1"))||(vals[2].equals("2"))))
            display.setText((vals[2].equals("1") ? "first wins":"second wins"));
        else if((vals[2].equals(vals[4]))&&(vals[4].equals(vals[6]))&&((vals[2].equals("1"))||(vals[2].equals("2"))))
            display.setText((vals[2].equals("1") ? "first wins":"second wins"));
        else if((vals[3].equals(vals[4]))&&(vals[4].equals(vals[5]))&&((vals[3].equals("1"))||(vals[3].equals("2"))))
            display.setText((vals[3].equals("1") ? "first wins":"second wins"));
        else if((vals[6].equals(vals[7]))&&(vals[7].equals(vals[8]))&&((vals[6].equals("1"))||(vals[6].equals("2"))))
            display.setText((vals[6].equals("1") ? "first wins":"second wins"));
        int x=0;
            for(JTextField jt:jtf)
        {
            if(jt.getText().equals(""))
            {
                x++;break;
            }
        }
        if(x==0&&!display.getText().endsWith("wins"))
        {
            display.setText("Draw");
            for(int i=0;i<9;i++)
            {
                jtf[i].setBackground(Color.GREEN);
            }
        }
        if(display.getText().endsWith("wins"))
        {
            if(display.getText().startsWith("first"))
            for(int i=0;i<9;i++)
            {
                jtf[i].setBackground(Color.RED);
            }
            else
            for(int i=0;i<9;i++)
            {
                jtf[i].setBackground(Color.blue);
            }
        }
        }
        }
    public static void main(String[] args) {
        new tic_tac();
    }
}
