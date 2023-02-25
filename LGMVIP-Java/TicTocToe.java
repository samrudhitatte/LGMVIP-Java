import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TicTocToe extends Frame implements ActionListener
{
    String lbl="X",lbl1="Reset";
    Button btn[],btn2;
    Panel pnl1,pnl2;
    int count=0;
    String s;
    public TicTocToe(String t)
    {   
        super(t);
        pnl1=new Panel(new GridLayout(3,3,20,20));
        btn=new Button[9];
        for(int i=0;i<=8;i++)
        {
            btn[i]=new Button();
            pnl1.add(btn[i]);
            btn[i].addActionListener(this);
            btn[i].setFont(new Font("Arial",Font.BOLD,50));
        }
        add(pnl1,"Center");
        pnl2=new Panel(new GridLayout(1,3,10,10));
        btn2=new Button("Reset");
        btn2.setFont(new Font("Arial",Font.BOLD,20));
        pnl2.add(btn2);
        btn2.addActionListener(this);
        add(pnl2,"South");
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Button b=(Button)e.getSource();
        if(lbl.equals("X"))
        {
            lbl="O";
            b.setForeground(Color.red);
        }
        else
        {
            lbl="X";
            b.setForeground(Color.blue);
        }
        b.setLabel(lbl);
        if(b==btn2)
        {
            for(int i=0;i<=8;i++)
            { 
                btn[i].setLabel("");
                btn[i].setEnabled(true);
            }
            count=0;
            b.setLabel("Reset");
            b.setForeground(Color.black);
        }
        count++;
        matches();
    }

//Winning Decision Function
    public void matches()
    {
        if(count!=10)
        {
            for(int i=0;i<=8;i+=3)
            {
                if(btn[i].getLabel()!="")
                {
                    if((btn[i].getLabel()==btn[i+1].getLabel())&&(btn[i+1].getLabel()==btn[i+2].getLabel()))
                    {
                        btn[i].setForeground(Color.green);
                        btn[i+1].setForeground(Color.green);
                        btn[i+2].setForeground(Color.green);
                        try
                        {Thread.sleep(800);}
                        catch(Exception e)
                        {}
                        JOptionPane.showMessageDialog(this,btn[i].getLabel()+" is Winner");
                        for(int j=0;j<=8;j++)
                            btn[j].setEnabled(false);
                    } 
                }
            }
            for(int i=0;i<=2;i++)
            {
                if(btn[i].getLabel()!="")
                {
                    if((btn[i].getLabel()==btn[i+3].getLabel())&&(btn[i+3].getLabel()==btn[i+6].getLabel()))
                    {
                        btn[i].setForeground(Color.green);
                        btn[i+3].setForeground(Color.green);
                        btn[i+6].setForeground(Color.green);
                        try
                        {Thread.sleep(800);}
                        catch(Exception e)
                        {}
                        JOptionPane.showMessageDialog(this,btn[i].getLabel()+" is Winner");
                        for(int j=0;j<=8;j++)
                            btn[j].setEnabled(false);
                    } 
                }   
            }
            for(int i=0,j=2;i<=2;i+=4,j+=2)
            {
                if(btn[i].getLabel()!="")
                {
                    if((btn[i].getLabel()==btn[i+4].getLabel())&&(btn[i+4].getLabel()==btn[i+8].getLabel()))
                    {
                        btn[i].setForeground(Color.green);
                        btn[i+4].setForeground(Color.green);
                        btn[i+8].setForeground(Color.green);
                        try
                        {Thread.sleep(800);}
                        catch(Exception e)
                        {}
                        JOptionPane.showMessageDialog(this,btn[i].getLabel()+" is Winner");
                        for(int k=0;k<=8;k++)
                            btn[k].setEnabled(false);
                    }   
                }
                if(btn[j].getLabel()!="")
                {
                    if((btn[j].getLabel()==btn[j+2].getLabel())&&(btn[j+2].getLabel()==btn[j+4].getLabel()))
                    {
                        btn[j].setForeground(Color.green);
                        btn[j+2].setForeground(Color.green);
                        btn[j+4].setForeground(Color.green);
                        try
                        {Thread.sleep(800);}
                        catch(Exception e)
                        {}
                        JOptionPane.showMessageDialog(this,btn[i].getLabel()+" is Winner");
                        for(int m=0;m<=8;m++)
                            btn[m].setEnabled(false);
                    } 
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Matches are not found  \nReset it");
            for(int m=0;m<=8;m++)
                btn[m].setEnabled(false);
        }
        
    }
    public static void main(String args[])
    {
        TicTocToe f=new TicTocToe("Tic Tac Toe");
        f.setSize(400,400);
        f.setVisible(true);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {System.exit(0);}
        });
    }
}
