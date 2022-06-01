import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
  
    
     int RWTN = Start.RequiredWinningTiles;
        int FSVN = Start.FieldSizeVertical;
         int FSHN = Start.FieldSizeHorizontal;
    
    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[][] bton = new JButton[FSVN] [FSHN];
    int chance_flag = 0;
    Random random = new Random();
    boolean pl1_chance;
    
    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(100, 100, 100));
        frame.setTitle("Tic Tac Toe");
        frame.setSize(1000,1000);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textfield.setBackground(new Color(120, 20, 124));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);
        
        
        
        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 1000, 100);
        
        bt_panel.setLayout(new GridLayout(FSVN, FSHN));
        bt_panel.setBackground(new Color(150, 150, 150));
        
        
        
        for (int i = 0; i < FSVN ; i++) {
            for (int j = 0; j < FSHN;j++){
            bton[i][j] = new JButton();
            bt_panel.add(bton[i][j]);
            bton[i][j].setFont(new Font("Ink Free", Font.BOLD, 120));
            bton[i][j].setFocusable(false);
            bton[i][j].addActionListener(this);
            }
        }
        
        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(bt_panel);
        startGame();
    }
    public void startGame() {
        try {
            textfield.setText("Continue....");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int chance=random.nextInt(100);
        if (chance%2 == 0) {
            pl1_chance = true;
            textfield.setText("X je na ťahu");
        } else {
            pl1_chance = false;
            textfield.setText("O je na ťahu");
        }
    }
    public void gameOver(String s){
        chance_flag = 0;
        Object[] option={"Reštart","Koniec"};
        int n=JOptionPane.showOptionDialog(frame, "Koniec hry\n"+s,"Koniec",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            new TicTacToe();
        }
        else{
            frame.dispose();
        }
    
    }
    public void matchCheck() {
         for(int i = 0; i<=FSHN;i++){                    
        for(int j = 0; j<=FSVN;j++){
        switch (RWTN){
            case 3:
                //stlpce  X
               
                if ((bton[j][i+0].getText() == "X") && (bton[j][i+1].getText() == "X") && (bton[j][i+2].getText() == "X")) {
            xWins();
        }
                //stlpce  O
                else if ((bton[j][i+0].getText() == "O") && (bton[j][i+1].getText() == "O") && (bton[j][i+2].getText() == "O")) {
            oWins();
        }
                //riadky  X
               else if ((bton[i][j+0].getText() == "X") && (bton[i][j+1].getText() == "X") && (bton[i][j+2].getText() == "X")) {
            xWins();
        }
                //riadky  O
                else if ((bton[i][j+0].getText() == "O") && (bton[i][j+1].getText() == "O") && (bton[i][j+2].getText() == "O")) {
            oWins();
        }
                //sikmo  X
                else if ((bton[j+0][i+0].getText() == "X") && (bton[j+1][i+1].getText() == "X") && (bton[j+2][i+2].getText() == "X")) {
            xWins();
        }
                //sikmo  O
                else if ((bton[j+0][i+0].getText() == "O") && (bton[j+1][i+1].getText() == "O") && (bton[j+2][i+2].getText() == "O")) {
            oWins();
        }
                 //NEGAsikmo  X
                else if ((bton[j+0][i-2].getText() == "X") && (bton[j+1][i-1].getText() == "X") && (bton[j+2][i-0].getText() == "X")) {
            xWins();
        }
                //NEGAsikmo  O
                else if ((bton[j+0][i-2].getText() == "O") && (bton[j+1][i-1].getText() == "O") && (bton[j+2][i-0].getText() == "O")) {
            oWins();
        }
            case 4://444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
                //stlpce  X
                if ((bton[j][i+0].getText() == "X") && (bton[j][i+1].getText() == "X") && (bton[j][i+2].getText() == "X") && (bton[j][i+3].getText() == "X")) {
            xWins();
        }
                //stlpce  O
                else if ((bton[j][i+0].getText() == "O") && (bton[j][i+1].getText() == "O") && (bton[j][i+2].getText() == "O") && (bton[j][i+3].getText() == "O")) {
            oWins();
        }
                //riadky  X
               else if ((bton[i][j+0].getText() == "X") && (bton[i][j+1].getText() == "X") && (bton[i][j+2].getText() == "X") && (bton[i][j+3].getText() == "X")) {
            xWins();
        }
                //riadky  O
                else if ((bton[i][j+0].getText() == "O") && (bton[i][j+1].getText() == "O") && (bton[i][j+2].getText() == "O") && (bton[i][j+3].getText() == "O")) {
            oWins();
        }
                //sikmo  X
                else if ((bton[j+0][i+0].getText() == "X") && (bton[j+1][i+1].getText() == "X") && (bton[j+2][i+2].getText() == "X") && (bton[j+3][i+3].getText() == "X")) {
            xWins();
        }
                //sikmo  O
                else if ((bton[j+0][i+0].getText() == "O") && (bton[j+1][i+1].getText() == "O") && (bton[j+2][i+2].getText() == "O") && (bton[j+3][i+3].getText() == "O")) {
            oWins();
        }
                 //NEGAsikmo  X
                else if ((bton[j+0][i-3].getText() == "X") && (bton[j+1][i-2].getText() == "X") && (bton[j+2][i-1].getText() == "X") && (bton[j+3][i-0].getText() == "X")) {
            xWins();
        }
                //NEGAsikmo  O
                else if ((bton[j+0][i-3].getText() == "O") && (bton[j+1][i-2].getText() == "O") && (bton[j+2][i-1].getText() == "O") && (bton[j+3][i-0].getText() == "O")) {
            oWins();
        }
            case 5: //555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555
                //stlpce  X
                if ((bton[j][i+0].getText() == "X") && (bton[j][i+1].getText() == "X") && (bton[j][i+2].getText() == "X") && (bton[j][i+3].getText() == "X") && (bton[j][i+4].getText() == "X")) {
            xWins();
        }
                //stlpce  O
                else if ((bton[j][i+0].getText() == "O") && (bton[j][i+1].getText() == "O") && (bton[j][i+2].getText() == "O") && (bton[j][i+3].getText() == "O") && (bton[j][i+4].getText() == "O")) {
            oWins();
        }
                //riadky  X
               else if ((bton[i][j+0].getText() == "X") && (bton[i][j+1].getText() == "X") && (bton[i][j+2].getText() == "X") && (bton[i][j+3].getText() == "X") && (bton[i][j+4].getText() == "X")) {
            xWins();
        }
                //riadky  O
                else if ((bton[i][j+0].getText() == "O") && (bton[i][j+1].getText() == "O") && (bton[i][j+2].getText() == "O") && (bton[i][j+3].getText() == "O") && (bton[i][j+4].getText() == "O")) {
            oWins();
        }
                //sikmo  X
                else if ((bton[j+0][i+0].getText() == "X") && (bton[j+1][i+1].getText() == "X") && (bton[j+2][i+2].getText() == "X") && (bton[j+3][i+3].getText() == "X") && (bton[j+4][i+4].getText() == "X")) {
            xWins();
        }
                //sikmo  O
                else if ((bton[j+0][i+0].getText() == "O") && (bton[j+1][i+1].getText() == "O") && (bton[j+2][i+2].getText() == "O") && (bton[j+3][i+3].getText() == "O") && (bton[j+4][i+4].getText() == "O")) { 
            oWins();
        }
                 //NEGAsikmo  X
                else if ((bton[j+0][i-4].getText() == "X") && (bton[j+1][i-3].getText() == "X") && (bton[j+2][i-2].getText() == "X") && (bton[j+3][i-1].getText() == "X") && (bton[j+4][i-0].getText() == "X")) {
            xWins();
        }
                //NEGAsikmo  O
                else if ((bton[j+0][i-4].getText() == "O") && (bton[j+1][i-3].getText() == "O") && (bton[j+2][i-2].getText() == "O") && (bton[j+3][i-1].getText() == "O") && (bton[j+4][i-0].getText() == "O")) {
            oWins();
                }
            case 6:  //666666666666666666666666666666666666666666666666666666666666666
                //stlpce  X
                if ((bton[j][i+0].getText() == "X") && (bton[j][i+1].getText() == "X") && (bton[j][i+2].getText() == "X") && (bton[j][i+3].getText() == "X") && (bton[j][i+4].getText() == "X") && (bton[j][i+5].getText() == "X")) {
            xWins();
        }
                //stlpce  O
                else if ((bton[j][i+0].getText() == "O") && (bton[j][i+1].getText() == "O") && (bton[j][i+2].getText() == "O") && (bton[j][i+3].getText() == "O") && (bton[j][i+4].getText() == "O") && (bton[j][i+5].getText() == "O")) {
            oWins();
        }
                //riadky  X
               else if ((bton[i][j+0].getText() == "X") && (bton[i][j+1].getText() == "X") && (bton[i][j+2].getText() == "X") && (bton[i][j+3].getText() == "X") && (bton[i][j+4].getText() == "X") && (bton[i][j+5].getText() == "X")) {
            xWins();
        }
                //riadky  O
                else if ((bton[i][j+0].getText() == "O") && (bton[i][j+1].getText() == "O") && (bton[i][j+2].getText() == "O") && (bton[i][j+3].getText() == "O") && (bton[i][j+4].getText() == "O") && (bton[i][j+5].getText() == "O")) {
            oWins();
        }
                //sikmo  X
                else if ((bton[j+0][i+0].getText() == "X") && (bton[j+1][i+1].getText() == "X") && (bton[j+2][i+2].getText() == "X") && (bton[j+3][i+3].getText() == "X") && (bton[j+4][i+4].getText() == "X") && (bton[j+5][i+5].getText() == "X")) {
            xWins();
        }
                //sikmo  O
                else if ((bton[j+0][i+0].getText() == "O") && (bton[j+1][i+1].getText() == "O") && (bton[j+2][i+2].getText() == "O") && (bton[j+3][i+3].getText() == "O") && (bton[j+4][i+4].getText() == "O") && (bton[j+5][i+5].getText() == "O")) { 
            oWins();
        }
                 //NEGAsikmo  X
                else if ((bton[j+0][i-5].getText() == "X") && (bton[j+1][i-4].getText() == "X") && (bton[j+2][i-3].getText() == "X") && (bton[j+3][i-2].getText() == "X") && (bton[j+4][i-1].getText() == "X") && (bton[j+5][i-0].getText() == "X")) {
            xWins();
        }
                //NEGAsikmo  O
                else if ((bton[j+0][i-5].getText() == "O") && (bton[j+1][i-4].getText() == "O") && (bton[j+2][i-3].getText() == "O") && (bton[j+3][i-2].getText() == "O") && (bton[j+4][i-1].getText() == "O") && (bton[j+5][i-0].getText() == "O")) {
            oWins();
                }
            case 7://77777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
                //stlpce  X
                if ((bton[j][i+0].getText() == "X") && (bton[j][i+1].getText() == "X") && (bton[j][i+2].getText() == "X") && (bton[j][i+3].getText() == "X") && (bton[j][i+4].getText() == "X") && (bton[j][i+5].getText() == "X") && (bton[j][i+6].getText() == "X")) {
            xWins();
        }
                //stlpce  O
                else if ((bton[j][i+0].getText() == "O") && (bton[j][i+1].getText() == "O") && (bton[j][i+2].getText() == "O") && (bton[j][i+3].getText() == "O") && (bton[j][i+4].getText() == "O") && (bton[j][i+5].getText() == "O") && (bton[j][i+6].getText() == "O")) {
            oWins();
        }
                //riadky  X
               else if ((bton[i][j+0].getText() == "X") && (bton[i][j+1].getText() == "X") && (bton[i][j+2].getText() == "X") && (bton[i][j+3].getText() == "X") && (bton[i][j+4].getText() == "X") && (bton[i][j+5].getText() == "X") && (bton[i][j+6].getText() == "X")) {
            xWins();
        }
                //riadky  O
                else if ((bton[i][j+0].getText() == "O") && (bton[i][j+1].getText() == "O") && (bton[i][j+2].getText() == "O") && (bton[i][j+3].getText() == "O") && (bton[i][j+4].getText() == "O") && (bton[i][j+5].getText() == "O") && (bton[i][j+6].getText() == "O")) {
            oWins();
        }
                //sikmo  X
                else if ((bton[j+0][i+0].getText() == "X") && (bton[j+1][i+1].getText() == "X") && (bton[j+2][i+2].getText() == "X") && (bton[j+3][i+3].getText() == "X") && (bton[j+4][i+4].getText() == "X") && (bton[j+5][i+5].getText() == "X") && (bton[j+6][i+6].getText() == "X")) {
            xWins();
        }
                //sikmo  O
                else if ((bton[j+0][i+0].getText() == "O") && (bton[j+1][i+1].getText() == "O") && (bton[j+2][i+2].getText() == "O") && (bton[j+3][i+3].getText() == "O") && (bton[j+4][i+4].getText() == "O") && (bton[j+5][i+5].getText() == "O") && (bton[j+6][i+6].getText() == "O")) { 
            oWins();
        }
                 //NEGAsikmo  X
                else if ((bton[j+0][i-6].getText() == "X") && (bton[j+1][i-5].getText() == "X") && (bton[j+2][i-4].getText() == "X") && (bton[j+3][i-3].getText() == "X") && (bton[j+4][i-2].getText() == "X") && (bton[j+5][i-1].getText() == "X") && (bton[j+6][i-0].getText() == "X")) {
            xWins();
        }
                //NEGAsikmo  O
                else if ((bton[j+0][i-6].getText() == "O") && (bton[j+1][i-5].getText() == "O") && (bton[j+2][i-4].getText() == "O") && (bton[j+3][i-3].getText() == "O") && (bton[j+4][i-2].getText() == "O") && (bton[j+5][i-1].getText() == "O") && (bton[j+6][i-0].getText() == "O")) {
            oWins();
                }
            case 8://88888888888888888888888888888888888888888888888888888888888888888888888888888888
                //stlpce  X
                if ((bton[j][i+0].getText() == "X") && (bton[j][i+1].getText() == "X") && (bton[j][i+2].getText() == "X") && (bton[j][i+3].getText() == "X") && (bton[j][i+4].getText() == "X") && (bton[j][i+5].getText() == "X") && (bton[j][i+6].getText() == "X") && (bton[j][i+7].getText() == "X")) {
            xWins();
        }
                //stlpce  O
                else if ((bton[j][i+0].getText() == "O") && (bton[j][i+1].getText() == "O") && (bton[j][i+2].getText() == "O") && (bton[j][i+3].getText() == "O") && (bton[j][i+4].getText() == "O") && (bton[j][i+5].getText() == "O") && (bton[j][i+6].getText() == "O") && (bton[j][i+7].getText() == "O")) {
            oWins();
        }
                //riadky  X
               else if ((bton[i][j+0].getText() == "X") && (bton[i][j+1].getText() == "X") && (bton[i][j+2].getText() == "X") && (bton[i][j+3].getText() == "X") && (bton[i][j+4].getText() == "X") && (bton[i][j+5].getText() == "X") && (bton[i][j+6].getText() == "X") && (bton[i][j+7].getText() == "X")) {
            xWins();
        }
                //riadky  O
                else if ((bton[i][j+0].getText() == "O") && (bton[i][j+1].getText() == "O") && (bton[i][j+2].getText() == "O") && (bton[i][j+3].getText() == "O") && (bton[i][j+4].getText() == "O") && (bton[i][j+5].getText() == "O") && (bton[i][j+6].getText() == "O") && (bton[i][j+7].getText() == "O")) {
            oWins();
        }
                //sikmo  X
                else if ((bton[j+0][i+0].getText() == "X") && (bton[j+1][i+1].getText() == "X") && (bton[j+2][i+2].getText() == "X") && (bton[j+3][i+3].getText() == "X") && (bton[j+4][i+4].getText() == "X") && (bton[j+5][i+5].getText() == "X") && (bton[j+6][i+6].getText() == "X") && (bton[j+7][i+7].getText() == "X")) {
            xWins();
        }
                //sikmo  O
                else if ((bton[j+0][i+0].getText() == "O") && (bton[j+1][i+1].getText() == "O") && (bton[j+2][i+2].getText() == "O") && (bton[j+3][i+3].getText() == "O") && (bton[j+4][i+4].getText() == "O") && (bton[j+5][i+5].getText() == "O") && (bton[j+6][i+6].getText() == "O") && (bton[j+7][i+7].getText() == "O")) { 
            oWins();
        }
                 //NEGAsikmo  X
                else if ((bton[j+0][i-7].getText() == "X") && (bton[j+1][i-6].getText() == "X") && (bton[j+2][i-5].getText() == "X") && (bton[j+3][i-4].getText() == "X") && (bton[j+4][i-3].getText() == "X") && (bton[j+5][i-2].getText() == "X") && (bton[j+6][i-1].getText() == "X") && (bton[j+7][i-0].getText() == "X")) {
            xWins();
        }
                //NEGAsikmo  O
                else if ((bton[j+0][i-7].getText() == "O") && (bton[j+1][i-6].getText() == "O") && (bton[j+2][i-5].getText() == "O") && (bton[j+3][i-4].getText() == "O") && (bton[j+4][i-3].getText() == "O") && (bton[j+5][i-2].getText() == "O") && (bton[j+6][i-1].getText() == "O") && (bton[j+7][i-0].getText() == "O")) {
            oWins();
                }
            case 9://99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
                //stlpce  X
                if ((bton[j][i+0].getText() == "X") && (bton[j][i+1].getText() == "X") && (bton[j][i+2].getText() == "X") && (bton[j][i+3].getText() == "X") && (bton[j][i+4].getText() == "X") && (bton[j][i+5].getText() == "X") && (bton[j][i+6].getText() == "X") && (bton[j][i+7].getText() == "X") && (bton[j][i+8].getText() == "X")) {
            xWins();
        }
                //stlpce  O
                else if ((bton[j][i+0].getText() == "O") && (bton[j][i+1].getText() == "O") && (bton[j][i+2].getText() == "O") && (bton[j][i+3].getText() == "O") && (bton[j][i+4].getText() == "O") && (bton[j][i+5].getText() == "O") && (bton[j][i+6].getText() == "O") && (bton[j][i+7].getText() == "O") && (bton[j][i+8].getText() == "O")) {
            oWins();
        }
                //riadky  X
               else if ((bton[i][j+0].getText() == "X") && (bton[i][j+1].getText() == "X") && (bton[i][j+2].getText() == "X") && (bton[i][j+3].getText() == "X") && (bton[i][j+4].getText() == "X") && (bton[i][j+5].getText() == "X") && (bton[i][j+6].getText() == "X") && (bton[i][j+7].getText() == "X") && (bton[i][j+8].getText() == "X")) {
            xWins();
        }
                //riadky  O
                else if ((bton[i][j+0].getText() == "O") && (bton[i][j+1].getText() == "O") && (bton[i][j+2].getText() == "O") && (bton[i][j+3].getText() == "O") && (bton[i][j+4].getText() == "O") && (bton[i][j+5].getText() == "O") && (bton[i][j+6].getText() == "O") && (bton[i][j+7].getText() == "O") && (bton[i][j+8].getText() == "O")) {
            oWins();
        }
                //sikmo  X
                else if ((bton[j+0][i+0].getText() == "X") && (bton[j+1][i+1].getText() == "X") && (bton[j+2][i+2].getText() == "X") && (bton[j+3][i+3].getText() == "X") && (bton[j+4][i+4].getText() == "X") && (bton[j+5][i+5].getText() == "X") && (bton[j+6][i+6].getText() == "X") && (bton[j+7][i+7].getText() == "X") && (bton[j+8][i+8].getText() == "X")) {
            xWins();
        }
                //sikmo  O
                else if ((bton[j+0][i+0].getText() == "O") && (bton[j+1][i+1].getText() == "O") && (bton[j+2][i+2].getText() == "O") && (bton[j+3][i+3].getText() == "O") && (bton[j+4][i+4].getText() == "O") && (bton[j+5][i+5].getText() == "O") && (bton[j+6][i+6].getText() == "O") && (bton[j+7][i+7].getText() == "O") && (bton[j+8][i+8].getText() == "O")) { 
            oWins();
        }
                 //NEGAsikmo  X
                else if ((bton[j+0][i-8].getText() == "X") && (bton[j+1][i-7].getText() == "X") && (bton[j+2][i-6].getText() == "X") && (bton[j+3][i-5].getText() == "X") && (bton[j+4][i-4].getText() == "X") && (bton[j+5][i-3].getText() == "X") && (bton[j+6][i-2].getText() == "X") && (bton[j+7][i-1].getText() == "X") && (bton[j+8][i-0].getText() == "X")) {
            xWins();
        }
                //NEGAsikmo  O
                else if ((bton[j+0][i-8].getText() == "O") && (bton[j+1][i-7].getText() == "O") && (bton[j+2][i-6].getText() == "O") && (bton[j+3][i-5].getText() == "O") && (bton[j+4][i-4].getText() == "O") && (bton[j+5][i-3].getText() == "O") && (bton[j+6][i-2].getText() == "O") && (bton[j+7][i-1].getText() == "O") && (bton[j+8][i-0].getText() == "O")) {
            oWins();
                }
            case 10://1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
                //stlpce  X
                if ((bton[j][i+0].getText() == "X") && (bton[j][i+1].getText() == "X") && (bton[j][i+2].getText() == "X") && (bton[j][i+3].getText() == "X") && (bton[j][i+4].getText() == "X") && (bton[j][i+5].getText() == "X") && (bton[j][i+6].getText() == "X") && (bton[j][i+7].getText() == "X") && (bton[j][i+8].getText() == "X") && (bton[j][i+9].getText() == "X")) {
            xWins();
        }
                //stlpce  O
                else if ((bton[j][i+0].getText() == "O") && (bton[j][i+1].getText() == "O") && (bton[j][i+2].getText() == "O") && (bton[j][i+3].getText() == "O") && (bton[j][i+4].getText() == "O") && (bton[j][i+5].getText() == "O") && (bton[j][i+6].getText() == "O") && (bton[j][i+7].getText() == "O") && (bton[j][i+8].getText() == "O") && (bton[j][i+9].getText() == "O")) {
            oWins();
        }
                //riadky  X
               else if ((bton[i][j+0].getText() == "X") && (bton[i][j+1].getText() == "X") && (bton[i][j+2].getText() == "X") && (bton[i][j+3].getText() == "X") && (bton[i][j+4].getText() == "X") && (bton[i][j+5].getText() == "X") && (bton[i][j+6].getText() == "X") && (bton[i][j+7].getText() == "X") && (bton[i][j+8].getText() == "X") && (bton[i][j+9].getText() == "X")) {
            xWins();
        }
                //riadky  O
                else if ((bton[i][j+0].getText() == "O") && (bton[i][j+1].getText() == "O") && (bton[i][j+2].getText() == "O") && (bton[i][j+3].getText() == "O") && (bton[i][j+4].getText() == "O") && (bton[i][j+5].getText() == "O") && (bton[i][j+6].getText() == "O") && (bton[i][j+7].getText() == "O") && (bton[i][j+8].getText() == "O") && (bton[i][j+9].getText() == "O")) {
            oWins();
        }
                //sikmo  X
                else if ((bton[j+0][i+0].getText() == "X") && (bton[j+1][i+1].getText() == "X") && (bton[j+2][i+2].getText() == "X") && (bton[j+3][i+3].getText() == "X") && (bton[j+4][i+4].getText() == "X") && (bton[j+5][i+5].getText() == "X") && (bton[j+6][i+6].getText() == "X") && (bton[j+7][i+7].getText() == "X") && (bton[j+8][i+8].getText() == "X") && (bton[j+9][i+9].getText() == "X")) {
            xWins();
        }
                //sikmo  O
                else if ((bton[j+0][i+0].getText() == "O") && (bton[j+1][i+1].getText() == "O") && (bton[j+2][i+2].getText() == "O") && (bton[j+3][i+3].getText() == "O") && (bton[j+4][i+4].getText() == "O") && (bton[j+5][i+5].getText() == "O") && (bton[j+6][i+6].getText() == "O") && (bton[j+7][i+7].getText() == "O") && (bton[j+8][i+8].getText() == "O") && (bton[j+9][i+9].getText() == "O")) { 
            oWins();
        }
                 //NEGAsikmo  X
                else if ((bton[j+0][i-9].getText() == "X") && (bton[j+1][i-8].getText() == "X") && (bton[j+2][i-7].getText() == "X") && (bton[j+3][i-6].getText() == "X") && (bton[j+4][i-5].getText() == "X") && (bton[j+5][i-4].getText() == "X") && (bton[j+6][i-3].getText() == "X") && (bton[j+7][i-2].getText() == "X") && (bton[j+8][i-1].getText() == "X") && (bton[j+9][i-0].getText() == "X")) {
            xWins();
        }
                //NEGAsikmo  O
                else if ((bton[j+0][i-9].getText() == "O") && (bton[j+1][i-8].getText() == "O") && (bton[j+2][i-7].getText() == "O") && (bton[j+3][i-6].getText() == "O") && (bton[j+4][i-5].getText() == "O") && (bton[j+5][i-4].getText() == "O") && (bton[j+6][i-3].getText() == "O") && (bton[j+7][i-2].getText() == "O") && (bton[j+8][i-1].getText() == "O") && (bton[j+9][i-0].getText() == "O")) {
            oWins();
                }
        }
        
       
         if(chance_flag==(FSVN * FSHN)) {
            textfield.setText("Match Tie");
             gameOver("Match Tie");
        }
         //}
      //    j = 0;
        }
     //  i=0;
        }
    }
    public void xWins() {
        
          for (int i = 0; i < FSVN; i++) {
            for (int j = 0; j < FSHN; j++) {
            bton[i][j].setEnabled(false);
        }
    }
          
        Connection DB = Database.connect();
          String user_nick = Database.getMeno(DB, Login.user_mail);

        textfield.setText(user_nick + " vyhral");
        gameOver(user_nick +" vyhral");
        System.out.println(Login.user_mail);
        
        int user_money = Database.getMoney(DB,Login.user_mail);
        int user_vyhry = Database.getVyhry(DB,Login.user_mail);
        int user_prehry = Database.getPrehry(DB,Login.user_mail);
        int user_remizy = Database.getRemizy(DB, Login.user_mail);
        Database.updateUser(DB, user_money, 5, user_prehry, user_remizy, Login.user_mail);
        
    }
    public void oWins() {
     
        for (int i = 0; i < FSVN; i++) {
            for (int j = 0; j < FSHN; j++) {
            bton[i][j].setEnabled(false);
        }
    }
        textfield.setText("O vyhral");
        gameOver("O vyhral");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < FSVN ; i++) {
            for (int j = 0; j < FSHN; j++) {
            if (e.getSource() == bton[i][j]) {
                if (pl1_chance) {
                    if (bton[i][j].getText() == "") {
                        bton[i][j].setForeground(new Color(255, 0, 0));
                        bton[i][j].setText("X");
                        pl1_chance = false;
                        textfield.setText("O je na ťahu");
                        chance_flag++;
                        matchCheck();
                    }
                } else {
                    if (bton[i][j].getText() == "") {
                        bton[i][j].setForeground(new Color(0, 0, 255));
                        bton[i][j].setText("O");
                        pl1_chance = true;
                        textfield.setText("X je na ťahu");
                        chance_flag++;
                        matchCheck();
                    }
                }
            }
        }
    }
    }
}