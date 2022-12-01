/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author hp
 */
public class sudoku2 extends javax.swing.JFrame {

    /**
     * Creates new form sudoku2
     */
    public sudoku2() {
        initComponents();
        startGame();
        
        
    }
    ArrayList[] rows = new ArrayList[9];
    ArrayList[] cols = new ArrayList[9];
    ArrayList[][] boxes = new ArrayList[3][3];
    int[][] solution = new int[9][9];
    int[][] board = new int[9][9];
    JButton[][] boardInputs = new JButton[9][9];
    JButton[] numberInputs = new JButton[9];
    int curNum = 1;
    
    public void startGame() {
        initialiseArrays();
        initialiseInputs();
        createGrid();
        numberInputs[0].setBackground(Color.yellow);
        printInitialGrid();
        generateSolution(0, 0);
        
       
    }
    
    public void initialiseArrays() {
        rows = new ArrayList[9];
        cols = new ArrayList[9];
        boxes = new ArrayList[3][3];
        for(int i=0; i<9; i++) {
            ArrayList temp = new ArrayList();
            rows[i] = temp;
            ArrayList temp1 = new ArrayList();
            cols[i] = temp1;
        }
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                ArrayList temp = new ArrayList();
                boxes[i][j] = temp;
            }
        }
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                board[i][j] = 0;
            }
        }
    }
    
    public void initialiseInputs() {
        boardInputs = new JButton[][] {
            {t1,t2,t3,t4,t5,t6,t7,t8,t9},
            {t10,t11,t12,t13,t14,t15,t16,t17,t18},
            {t19,t20,t21,t22,t23,t24,t25,t26,t27},
            {t28,t29,t30,t31,t32,t33,t34,t35,t36},
            {t37,t38,t39,t40,t41,t42,t43,t44,t45},
            {t46,t47,t48,t49,t50,t51,t52,t53,t54},
            {t55,t56,t57,t58,t59,t60,t61,t62,t63},
            {t64,t65,t66,t67,t68,t69,t70,t71,t72},
            {t73,t74,t75,t76,t77,t78,t79,t80,t81}
        };
        numberInputs = new JButton[] {
            t82,t83,t84,t85,t86,t87,t88,t89,t90
        };
    }
    
    public boolean isValid(int i, int j, int num) {
        if(rows[i].contains(num)) return false;
        if(cols[j].contains(num)) return false;
        else if(boxes[(int)(Math.floor((double)i/3))][(int)(Math.floor((double)j/3))].contains(num)) return false;
       // else if (boxes[i/3][j/3].contains(num)) return false;
        return true;
    }
    
    public void addToGrid(int i, int j, int num) {
        rows[i].add(num);
        cols[j].add(num);
        boxes[(int)(Math.floor((double)i/3))][(int)(Math.floor((double)j/3))].add(num);
    }
    
    public void createGrid() {
        int count = 0;
        while(count != 20) {
            int i = (int)(Math.random()*9);
            int j = (int)(Math.random()*9);
            int num = (int)(Math.random()*9) + 1;
            if(board[i][j]==0 && isValid(i,j,num)) {
                count++;
                addToGrid(i,j,num);
                board[i][j]=num;
                solution[i][j]=num;
            }
        }
    }
    
    public void printInitialGrid() {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                JButton cur_btn = boardInputs[i][j];
                if(board[i][j]==0) {
                    cur_btn.setBackground(Color.white);
                }
                else {
                    int num = board[i][j];
                    cur_btn.setText(Integer.toString(num));
                    cur_btn.setBackground(Color.black);
                    cur_btn.setForeground(Color.white);
                }
            }
        }
    }
    
    public boolean generateSolution(int i, int j) {
        if(i == 9) return true;
        if(solution[i][j] != 0) {
            int x = i, y = j+1;
            if(y == 9) {
                x = x + 1;
                y = 0;
            }
            return generateSolution(x, y);
        }
        boolean b = false;
        for(int num=1; num<=9; num++) {
            if(isValid(i, j, num)) {
                addToGrid(i, j, num);
                solution[i][j] = num;
                int x = i, y = j+1;
                if(y == 9) {
                    x = i+1;
                    y = 0;
                }
                b = b || generateSolution(x, y);
                if(b) break;
                rows[i].remove(Integer.valueOf(num));
                cols[j].remove(Integer.valueOf(num));
                boxes[(int)(Math.floor((double)i/3))][(int)(Math.floor((double)j/3))].remove(Integer.valueOf(num));
                solution[i][j] = 0;
            }
        }
        return b;
    }
    
    public void setValueInInput(int i, int j) {
        if(board[i][j] == 0) boardInputs[i][j].setText(Integer.toString(curNum));
    }
    
    public void selectNumber(int num) {
        int prevNum = curNum;
        JButton prevSelected = numberInputs[prevNum-1];
        prevSelected.setBackground(new Color(255,204,204));
        JButton curSelected = numberInputs[num-1];
        curSelected.setBackground(Color.yellow);
        curNum = num;
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t1 = new javax.swing.JButton();
        t2 = new javax.swing.JButton();
        t3 = new javax.swing.JButton();
        t10 = new javax.swing.JButton();
        t11 = new javax.swing.JButton();
        t12 = new javax.swing.JButton();
        t19 = new javax.swing.JButton();
        t20 = new javax.swing.JButton();
        t21 = new javax.swing.JButton();
        t4 = new javax.swing.JButton();
        t5 = new javax.swing.JButton();
        t6 = new javax.swing.JButton();
        t13 = new javax.swing.JButton();
        t14 = new javax.swing.JButton();
        t15 = new javax.swing.JButton();
        t22 = new javax.swing.JButton();
        t23 = new javax.swing.JButton();
        t24 = new javax.swing.JButton();
        t7 = new javax.swing.JButton();
        t8 = new javax.swing.JButton();
        t9 = new javax.swing.JButton();
        t16 = new javax.swing.JButton();
        t17 = new javax.swing.JButton();
        t18 = new javax.swing.JButton();
        t25 = new javax.swing.JButton();
        t26 = new javax.swing.JButton();
        t27 = new javax.swing.JButton();
        t54 = new javax.swing.JButton();
        t28 = new javax.swing.JButton();
        t29 = new javax.swing.JButton();
        t30 = new javax.swing.JButton();
        t37 = new javax.swing.JButton();
        t38 = new javax.swing.JButton();
        t39 = new javax.swing.JButton();
        t46 = new javax.swing.JButton();
        t47 = new javax.swing.JButton();
        t48 = new javax.swing.JButton();
        t31 = new javax.swing.JButton();
        t32 = new javax.swing.JButton();
        t33 = new javax.swing.JButton();
        t40 = new javax.swing.JButton();
        t41 = new javax.swing.JButton();
        t42 = new javax.swing.JButton();
        t49 = new javax.swing.JButton();
        t50 = new javax.swing.JButton();
        t51 = new javax.swing.JButton();
        t34 = new javax.swing.JButton();
        t35 = new javax.swing.JButton();
        t36 = new javax.swing.JButton();
        t43 = new javax.swing.JButton();
        t44 = new javax.swing.JButton();
        t45 = new javax.swing.JButton();
        t52 = new javax.swing.JButton();
        t53 = new javax.swing.JButton();
        t81 = new javax.swing.JButton();
        t55 = new javax.swing.JButton();
        t56 = new javax.swing.JButton();
        t57 = new javax.swing.JButton();
        t64 = new javax.swing.JButton();
        t65 = new javax.swing.JButton();
        t66 = new javax.swing.JButton();
        t73 = new javax.swing.JButton();
        t74 = new javax.swing.JButton();
        t75 = new javax.swing.JButton();
        t58 = new javax.swing.JButton();
        t59 = new javax.swing.JButton();
        t60 = new javax.swing.JButton();
        t67 = new javax.swing.JButton();
        t68 = new javax.swing.JButton();
        t69 = new javax.swing.JButton();
        t76 = new javax.swing.JButton();
        t77 = new javax.swing.JButton();
        t78 = new javax.swing.JButton();
        t61 = new javax.swing.JButton();
        t62 = new javax.swing.JButton();
        t63 = new javax.swing.JButton();
        t70 = new javax.swing.JButton();
        t71 = new javax.swing.JButton();
        t72 = new javax.swing.JButton();
        t79 = new javax.swing.JButton();
        t80 = new javax.swing.JButton();
        t82 = new javax.swing.JButton();
        t83 = new javax.swing.JButton();
        t84 = new javax.swing.JButton();
        t85 = new javax.swing.JButton();
        t86 = new javax.swing.JButton();
        t87 = new javax.swing.JButton();
        t88 = new javax.swing.JButton();
        t89 = new javax.swing.JButton();
        t90 = new javax.swing.JButton();
        X1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });

        t10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t10ActionPerformed(evt);
            }
        });

        t11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t11ActionPerformed(evt);
            }
        });

        t12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t12ActionPerformed(evt);
            }
        });

        t19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t19ActionPerformed(evt);
            }
        });

        t20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t20ActionPerformed(evt);
            }
        });

        t21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t21ActionPerformed(evt);
            }
        });

        t4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t4ActionPerformed(evt);
            }
        });

        t5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t5ActionPerformed(evt);
            }
        });

        t6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t6ActionPerformed(evt);
            }
        });

        t13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t13ActionPerformed(evt);
            }
        });

        t14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });

        t15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t15ActionPerformed(evt);
            }
        });

        t22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t22ActionPerformed(evt);
            }
        });

        t23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t23ActionPerformed(evt);
            }
        });

        t24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t24ActionPerformed(evt);
            }
        });

        t7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t7ActionPerformed(evt);
            }
        });

        t8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t8ActionPerformed(evt);
            }
        });

        t9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t9ActionPerformed(evt);
            }
        });

        t16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t16ActionPerformed(evt);
            }
        });

        t17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t17ActionPerformed(evt);
            }
        });

        t18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t18ActionPerformed(evt);
            }
        });

        t25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t25ActionPerformed(evt);
            }
        });

        t26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t26ActionPerformed(evt);
            }
        });

        t27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t27ActionPerformed(evt);
            }
        });

        t54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t54ActionPerformed(evt);
            }
        });

        t28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t28ActionPerformed(evt);
            }
        });

        t29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t29ActionPerformed(evt);
            }
        });

        t30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t30ActionPerformed(evt);
            }
        });

        t37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t37ActionPerformed(evt);
            }
        });

        t38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t38ActionPerformed(evt);
            }
        });

        t39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t39ActionPerformed(evt);
            }
        });

        t46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t46ActionPerformed(evt);
            }
        });

        t47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t47ActionPerformed(evt);
            }
        });

        t48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t48ActionPerformed(evt);
            }
        });

        t31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t31ActionPerformed(evt);
            }
        });

        t32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t32ActionPerformed(evt);
            }
        });

        t33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t33ActionPerformed(evt);
            }
        });

        t40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t40ActionPerformed(evt);
            }
        });

        t41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t41ActionPerformed(evt);
            }
        });

        t42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t42ActionPerformed(evt);
            }
        });

        t49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t49ActionPerformed(evt);
            }
        });

        t50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t50ActionPerformed(evt);
            }
        });

        t51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t51ActionPerformed(evt);
            }
        });

        t34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t34ActionPerformed(evt);
            }
        });

        t35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t35ActionPerformed(evt);
            }
        });

        t36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t36ActionPerformed(evt);
            }
        });

        t43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t43ActionPerformed(evt);
            }
        });

        t44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t44ActionPerformed(evt);
            }
        });

        t45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t45ActionPerformed(evt);
            }
        });

        t52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t52ActionPerformed(evt);
            }
        });

        t53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t53ActionPerformed(evt);
            }
        });

        t81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t81ActionPerformed(evt);
            }
        });

        t55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t55ActionPerformed(evt);
            }
        });

        t56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t56ActionPerformed(evt);
            }
        });

        t57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t57ActionPerformed(evt);
            }
        });

        t64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t64ActionPerformed(evt);
            }
        });

        t65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t65ActionPerformed(evt);
            }
        });

        t66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t66ActionPerformed(evt);
            }
        });

        t73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t73ActionPerformed(evt);
            }
        });

        t74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t74ActionPerformed(evt);
            }
        });

        t75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t75ActionPerformed(evt);
            }
        });

        t58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t58ActionPerformed(evt);
            }
        });

        t59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t59ActionPerformed(evt);
            }
        });

        t60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t60ActionPerformed(evt);
            }
        });

        t67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t67ActionPerformed(evt);
            }
        });

        t68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t68ActionPerformed(evt);
            }
        });

        t69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t69ActionPerformed(evt);
            }
        });

        t76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t76ActionPerformed(evt);
            }
        });

        t77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t77ActionPerformed(evt);
            }
        });

        t78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t78ActionPerformed(evt);
            }
        });

        t61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t61ActionPerformed(evt);
            }
        });

        t62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t62ActionPerformed(evt);
            }
        });

        t63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t63ActionPerformed(evt);
            }
        });

        t70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t70ActionPerformed(evt);
            }
        });

        t71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t71ActionPerformed(evt);
            }
        });

        t72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t72ActionPerformed(evt);
            }
        });

        t79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t79ActionPerformed(evt);
            }
        });

        t80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t80ActionPerformed(evt);
            }
        });

        t82.setBackground(new java.awt.Color(255, 204, 204));
        t82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t82.setText("1");
        t82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t82ActionPerformed(evt);
            }
        });

        t83.setBackground(new java.awt.Color(255, 204, 204));
        t83.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t83.setText("2");
        t83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t83ActionPerformed(evt);
            }
        });

        t84.setBackground(new java.awt.Color(255, 204, 204));
        t84.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t84.setText("3");
        t84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t84ActionPerformed(evt);
            }
        });

        t85.setBackground(new java.awt.Color(255, 204, 204));
        t85.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t85.setText("4");
        t85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t85ActionPerformed(evt);
            }
        });

        t86.setBackground(new java.awt.Color(255, 204, 204));
        t86.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t86.setText("5");
        t86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t86ActionPerformed(evt);
            }
        });

        t87.setBackground(new java.awt.Color(255, 204, 204));
        t87.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t87.setText("6");
        t87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t87ActionPerformed(evt);
            }
        });

        t88.setBackground(new java.awt.Color(255, 204, 204));
        t88.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t88.setText("7");
        t88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t88ActionPerformed(evt);
            }
        });

        t89.setBackground(new java.awt.Color(255, 204, 204));
        t89.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t89.setText("8");
        t89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t89ActionPerformed(evt);
            }
        });

        t90.setBackground(new java.awt.Color(255, 204, 204));
        t90.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t90.setText("9");
        t90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t90ActionPerformed(evt);
            }
        });

        X1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        X1.setText("RESET");
        X1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                X1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("CHECK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("EXIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("SOLUTION");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("SUDOKU GAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t73, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t74, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t75, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t64, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t65, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t66, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t55, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t56, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t57, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t76, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t77, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t78, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t67, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t68, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t69, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t58, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t59, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t60, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t79, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t80, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t81, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t70, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t71, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t72, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t61, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t62, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t63, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t46, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t47, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t48, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t37, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t38, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t39, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t28, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t29, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t30, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t49, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t50, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t51, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t40, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t41, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t42, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t31, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t32, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t52, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t53, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t54, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t43, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t44, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t45, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t34, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t35, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t36, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t23, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t24, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t25, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t26, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t27, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(t16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(t18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(306, 306, 306)
                                    .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(t82, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(t83, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t84, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t85, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t86, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(X1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(t87, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t88, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t89, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t90, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t25, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t36, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t35, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t34, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t45, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t44, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t43, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t54, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t53, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t52, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t33, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t32, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t31, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t42, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t41, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t40, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t51, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t50, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t49, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t30, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t39, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t38, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t48, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t47, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t46, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t63, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t62, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t61, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t72, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t71, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t70, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t81, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t80, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t79, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t60, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t59, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t58, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t69, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t68, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t67, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t78, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t77, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t76, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t57, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t56, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t55, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t66, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t65, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t64, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t75, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t74, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t73, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t84, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(t83, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t82, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(t87, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t86, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t85, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t90, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t89, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t88, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(X1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t88ActionPerformed
        // TODO add your handling code here:
        selectNumber(7);
    }//GEN-LAST:event_t88ActionPerformed

    private void t82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t82ActionPerformed
        // TODO add your handling code here:
        selectNumber(1);
    }//GEN-LAST:event_t82ActionPerformed

    private void t83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t83ActionPerformed
        // TODO add your handling code here:
        selectNumber(2);
    }//GEN-LAST:event_t83ActionPerformed

    private void t84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t84ActionPerformed
        // TODO add your handling code here:
        selectNumber(3);
    }//GEN-LAST:event_t84ActionPerformed

    private void t85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t85ActionPerformed
        // TODO add your handling code here:
        selectNumber(4);
    }//GEN-LAST:event_t85ActionPerformed

    private void t86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t86ActionPerformed
        // TODO add your handling code here:
        selectNumber(5);
    }//GEN-LAST:event_t86ActionPerformed

    private void t87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t87ActionPerformed
        // TODO add your handling code here:
        selectNumber(6);
    }//GEN-LAST:event_t87ActionPerformed

    private void t89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t89ActionPerformed
        // TODO add your handling code here:
        selectNumber(8);
    }//GEN-LAST:event_t89ActionPerformed

    private void t90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t90ActionPerformed
        // TODO add your handling code here:
        selectNumber(9);
    }//GEN-LAST:event_t90ActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,0);
    }//GEN-LAST:event_t1ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
         setValueInInput(0,1);
    }//GEN-LAST:event_t2ActionPerformed

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
         setValueInInput(0,2);
    }//GEN-LAST:event_t3ActionPerformed

    private void t4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t4ActionPerformed
        // TODO add your handling code here: 
        setValueInInput(0,3);
        
    }//GEN-LAST:event_t4ActionPerformed

    private void t5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t5ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,4);
    }//GEN-LAST:event_t5ActionPerformed

    private void t6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t6ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,5);
    }//GEN-LAST:event_t6ActionPerformed

    private void t7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t7ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,6);
    }//GEN-LAST:event_t7ActionPerformed

    private void t8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t8ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,7);
    }//GEN-LAST:event_t8ActionPerformed

    private void t9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t9ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,8);
    }//GEN-LAST:event_t9ActionPerformed

    private void t10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t10ActionPerformed
        // TODO add your handling code here:
        setValueInInput(1,0);
    }//GEN-LAST:event_t10ActionPerformed

    private void t11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t11ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,1);
    }//GEN-LAST:event_t11ActionPerformed

    private void t12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t12ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,2);
    }//GEN-LAST:event_t12ActionPerformed

    private void t13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t13ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,3);
    }//GEN-LAST:event_t13ActionPerformed

    private void t14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t14ActionPerformed
 setValueInInput(1,4);        // TODO add your handling code here:
    }//GEN-LAST:event_t14ActionPerformed

    private void t15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t15ActionPerformed
 setValueInInput(1,5);        // TODO add your handling code here:
    }//GEN-LAST:event_t15ActionPerformed

    private void t16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t16ActionPerformed
 setValueInInput(1,6);    }//GEN-LAST:event_t16ActionPerformed

    private void t17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t17ActionPerformed
 setValueInInput(1,7);        // TODO add your handling code here:
    }//GEN-LAST:event_t17ActionPerformed

    private void t18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t18ActionPerformed
 setValueInInput(1,8);        // TODO add your handling code here:
    }//GEN-LAST:event_t18ActionPerformed

    private void t19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t19ActionPerformed
 setValueInInput(2,0);        // TODO add your handling code here:
    }//GEN-LAST:event_t19ActionPerformed

    private void t20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t20ActionPerformed
setValueInInput(2,1);        // TODO add your handling code here:
    }//GEN-LAST:event_t20ActionPerformed

    private void t21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t21ActionPerformed
setValueInInput(2,2);        // TODO add your handling code here:
    }//GEN-LAST:event_t21ActionPerformed

    private void t22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t22ActionPerformed
setValueInInput(2,3);        // TODO add your handling code here:
    }//GEN-LAST:event_t22ActionPerformed

    private void t23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t23ActionPerformed
setValueInInput(2,4);        // TODO add your handling code here:
    }//GEN-LAST:event_t23ActionPerformed

    private void t24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t24ActionPerformed
setValueInInput(2,5);        // TODO add your handling code here:
    }//GEN-LAST:event_t24ActionPerformed

    private void t25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t25ActionPerformed
setValueInInput(2,6);        // TODO add your handling code here:
    }//GEN-LAST:event_t25ActionPerformed

    private void t26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t26ActionPerformed
setValueInInput(2,7);        // TODO add your handling code here:
    }//GEN-LAST:event_t26ActionPerformed

    private void t27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t27ActionPerformed
setValueInInput(2,8);        // TODO add your handling code here:
    }//GEN-LAST:event_t27ActionPerformed

    private void t28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t28ActionPerformed
setValueInInput(3,0);        // TODO add your handling code here:
    }//GEN-LAST:event_t28ActionPerformed

    private void t29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t29ActionPerformed
setValueInInput(3,1);        // TODO add your handling code here:
    }//GEN-LAST:event_t29ActionPerformed

    private void t30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t30ActionPerformed
setValueInInput(3,2);        // TODO add your handling code here:
    }//GEN-LAST:event_t30ActionPerformed

    private void t31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t31ActionPerformed
setValueInInput(3,3);        // TODO add your handling code here:
    }//GEN-LAST:event_t31ActionPerformed

    private void t32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t32ActionPerformed
setValueInInput(3,4);        // TODO add your handling code here:
    }//GEN-LAST:event_t32ActionPerformed

    private void t33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t33ActionPerformed
setValueInInput(3,5);        // TODO add your handling code here:
    }//GEN-LAST:event_t33ActionPerformed

    private void t34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t34ActionPerformed
setValueInInput(3,6);        // TODO add your handling code here:
    }//GEN-LAST:event_t34ActionPerformed

    private void t35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t35ActionPerformed
setValueInInput(3,7);        // TODO add your handling code here:
    }//GEN-LAST:event_t35ActionPerformed

    private void t36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t36ActionPerformed
setValueInInput(3,8);        // TODO add your handling code here:
    }//GEN-LAST:event_t36ActionPerformed

    private void t37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t37ActionPerformed
setValueInInput(4,0);        // TODO add your handling code here:
    }//GEN-LAST:event_t37ActionPerformed

    private void t38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t38ActionPerformed
setValueInInput(4,1);         // TODO add your handling code here:
    }//GEN-LAST:event_t38ActionPerformed

    private void t39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t39ActionPerformed
setValueInInput(4,2);         // TODO add your handling code here:
    }//GEN-LAST:event_t39ActionPerformed

    private void t40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t40ActionPerformed
setValueInInput(4,3);        // TODO add your handling code here:
    }//GEN-LAST:event_t40ActionPerformed

    private void t41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t41ActionPerformed
setValueInInput(4,4);        // TODO add your handling code here:
    }//GEN-LAST:event_t41ActionPerformed

    private void t42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t42ActionPerformed
setValueInInput(4,5);        // TODO add your handling code here:
    }//GEN-LAST:event_t42ActionPerformed

    private void t43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t43ActionPerformed
setValueInInput(4,6);        // TODO add your handling code here:
    }//GEN-LAST:event_t43ActionPerformed

    private void t44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t44ActionPerformed
setValueInInput(4,7);        // TODO add your handling code here:
    }//GEN-LAST:event_t44ActionPerformed

    private void t45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t45ActionPerformed
setValueInInput(4,8);        // TODO add your handling code here:
    }//GEN-LAST:event_t45ActionPerformed

    private void t46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t46ActionPerformed
setValueInInput(5,0);        // TODO add your handling code here:
    }//GEN-LAST:event_t46ActionPerformed

    private void t47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t47ActionPerformed
setValueInInput(5,1);        // TODO add your handling code here:
    }//GEN-LAST:event_t47ActionPerformed

    private void t48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t48ActionPerformed
setValueInInput(5,2);        // TODO add your handling code here:
    }//GEN-LAST:event_t48ActionPerformed

    private void t49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t49ActionPerformed
setValueInInput(5,3);        // TODO add your handling code here:
    }//GEN-LAST:event_t49ActionPerformed

    private void t50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t50ActionPerformed
setValueInInput(5,4);        // TODO add your handling code here:
    }//GEN-LAST:event_t50ActionPerformed

    private void t51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t51ActionPerformed
setValueInInput(5,5);        // TODO add your handling code here:
    }//GEN-LAST:event_t51ActionPerformed

    private void t52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t52ActionPerformed
setValueInInput(5,6);        // TODO add your handling code here:
    }//GEN-LAST:event_t52ActionPerformed

    private void t53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t53ActionPerformed
setValueInInput(5,7);        // TODO add your handling code here:
    }//GEN-LAST:event_t53ActionPerformed

    private void t54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t54ActionPerformed
setValueInInput(5,8);        // TODO add your handling code here:
    }//GEN-LAST:event_t54ActionPerformed

    private void t55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t55ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,0);
    }//GEN-LAST:event_t55ActionPerformed

    private void t56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t56ActionPerformed
setValueInInput(6,1);        // TODO add your handling code here:
    }//GEN-LAST:event_t56ActionPerformed

    private void t57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t57ActionPerformed
setValueInInput(6,2);        // TODO add your handling code here:
    }//GEN-LAST:event_t57ActionPerformed

    private void t58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t58ActionPerformed
setValueInInput(6,3);        // TODO add your handling code here:
    }//GEN-LAST:event_t58ActionPerformed

    private void t59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t59ActionPerformed
setValueInInput(6,4);        // TODO add your handling code here:
    }//GEN-LAST:event_t59ActionPerformed

    private void t60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t60ActionPerformed
setValueInInput(6,5);        // TODO add your handling code here:
    }//GEN-LAST:event_t60ActionPerformed

    private void t61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t61ActionPerformed
setValueInInput(6,6);        // TODO add your handling code here:
    }//GEN-LAST:event_t61ActionPerformed

    private void t62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t62ActionPerformed
setValueInInput(6,7);        // TODO add your handling code here:
    }//GEN-LAST:event_t62ActionPerformed

    private void t63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t63ActionPerformed
setValueInInput(6,8);        // TODO add your handling code here:
    }//GEN-LAST:event_t63ActionPerformed

    private void t64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t64ActionPerformed
setValueInInput(7,0);        // TODO add your handling code here:
    }//GEN-LAST:event_t64ActionPerformed

    private void t65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t65ActionPerformed
setValueInInput(7,1);        // TODO add your handling code here:
    }//GEN-LAST:event_t65ActionPerformed

    private void t66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t66ActionPerformed
setValueInInput(7,2);        // TODO add your handling code here:
    }//GEN-LAST:event_t66ActionPerformed

    private void t67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t67ActionPerformed
setValueInInput(7,3);        // TODO add your handling code here:
    }//GEN-LAST:event_t67ActionPerformed

    private void t68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t68ActionPerformed
setValueInInput(7,4);        // TODO add your handling code here:
    }//GEN-LAST:event_t68ActionPerformed

    private void t69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t69ActionPerformed
setValueInInput(7,5);        // TODO add your handling code here:
    }//GEN-LAST:event_t69ActionPerformed

    private void t70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t70ActionPerformed
setValueInInput(7,6);        // TODO add your handling code here:
    }//GEN-LAST:event_t70ActionPerformed

    private void t71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t71ActionPerformed
setValueInInput(7,7);        // TODO add your handling code here:
    }//GEN-LAST:event_t71ActionPerformed

    private void t72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t72ActionPerformed
setValueInInput(7,8);        // TODO add your handling code here:
    }//GEN-LAST:event_t72ActionPerformed

    private void t73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t73ActionPerformed
setValueInInput(8,0);    }//GEN-LAST:event_t73ActionPerformed

    private void t74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t74ActionPerformed
setValueInInput(8,1);        // TODO add your handling code here:
    }//GEN-LAST:event_t74ActionPerformed

    private void t75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t75ActionPerformed
setValueInInput(8,2);        // TODO add your handling code here:
    }//GEN-LAST:event_t75ActionPerformed

    private void t76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t76ActionPerformed
setValueInInput(8,3);        // TODO add your handling code here:
    }//GEN-LAST:event_t76ActionPerformed

    private void t77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t77ActionPerformed
setValueInInput(8,4);        // TODO add your handling code here:
    }//GEN-LAST:event_t77ActionPerformed

    private void t78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t78ActionPerformed
setValueInInput(8,5);        // TODO add your handling code here:
    }//GEN-LAST:event_t78ActionPerformed

    private void t79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t79ActionPerformed
setValueInInput(8,6);        // TODO add your handling code here:
    }//GEN-LAST:event_t79ActionPerformed

    private void t80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t80ActionPerformed
setValueInInput(8,7);        // TODO add your handling code here:
    }//GEN-LAST:event_t80ActionPerformed

    private void t81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t81ActionPerformed
setValueInInput(8,8);        // TODO add your handling code here:
    }//GEN-LAST:event_t81ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
for(int i=0;i<9;i++){
    for(int j=0;j<9;j++){
        if(board[i][j] == 0){
            boardInputs[i][j].setBackground(Color.white);
            boardInputs[i][j].setText(Integer.toString(solution[i][j]));
        }
    }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void X1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_X1ActionPerformed
for(int i=0;i<9;i++){
    for(int j=0;j<9;j++){
        if(board[i][j]==0){
            boardInputs[i][j].setText("");
            boardInputs[i][j].setBackground(Color.white);
        }
    }
}
        // TODO add your handling code here:
    }//GEN-LAST:event_X1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    JButton cur_btn = boardInputs[i][j];
                    if(!cur_btn.getText().isBlank()){
                        int num = Integer.parseInt(cur_btn.getText());
                        if(num==solution[i][j]) cur_btn.setBackground(Color.green);
                        else cur_btn.setBackground(Color.red);
                    }
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sudoku2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sudoku2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sudoku2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sudoku2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sudoku2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton X1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton t1;
    private javax.swing.JButton t10;
    private javax.swing.JButton t11;
    private javax.swing.JButton t12;
    private javax.swing.JButton t13;
    private javax.swing.JButton t14;
    private javax.swing.JButton t15;
    private javax.swing.JButton t16;
    private javax.swing.JButton t17;
    private javax.swing.JButton t18;
    private javax.swing.JButton t19;
    private javax.swing.JButton t2;
    private javax.swing.JButton t20;
    private javax.swing.JButton t21;
    private javax.swing.JButton t22;
    private javax.swing.JButton t23;
    private javax.swing.JButton t24;
    private javax.swing.JButton t25;
    private javax.swing.JButton t26;
    private javax.swing.JButton t27;
    private javax.swing.JButton t28;
    private javax.swing.JButton t29;
    private javax.swing.JButton t3;
    private javax.swing.JButton t30;
    private javax.swing.JButton t31;
    private javax.swing.JButton t32;
    private javax.swing.JButton t33;
    private javax.swing.JButton t34;
    private javax.swing.JButton t35;
    private javax.swing.JButton t36;
    private javax.swing.JButton t37;
    private javax.swing.JButton t38;
    private javax.swing.JButton t39;
    private javax.swing.JButton t4;
    private javax.swing.JButton t40;
    private javax.swing.JButton t41;
    private javax.swing.JButton t42;
    private javax.swing.JButton t43;
    private javax.swing.JButton t44;
    private javax.swing.JButton t45;
    private javax.swing.JButton t46;
    private javax.swing.JButton t47;
    private javax.swing.JButton t48;
    private javax.swing.JButton t49;
    private javax.swing.JButton t5;
    private javax.swing.JButton t50;
    private javax.swing.JButton t51;
    private javax.swing.JButton t52;
    private javax.swing.JButton t53;
    private javax.swing.JButton t54;
    private javax.swing.JButton t55;
    private javax.swing.JButton t56;
    private javax.swing.JButton t57;
    private javax.swing.JButton t58;
    private javax.swing.JButton t59;
    private javax.swing.JButton t6;
    private javax.swing.JButton t60;
    private javax.swing.JButton t61;
    private javax.swing.JButton t62;
    private javax.swing.JButton t63;
    private javax.swing.JButton t64;
    private javax.swing.JButton t65;
    private javax.swing.JButton t66;
    private javax.swing.JButton t67;
    private javax.swing.JButton t68;
    private javax.swing.JButton t69;
    private javax.swing.JButton t7;
    private javax.swing.JButton t70;
    private javax.swing.JButton t71;
    private javax.swing.JButton t72;
    private javax.swing.JButton t73;
    private javax.swing.JButton t74;
    private javax.swing.JButton t75;
    private javax.swing.JButton t76;
    private javax.swing.JButton t77;
    private javax.swing.JButton t78;
    private javax.swing.JButton t79;
    private javax.swing.JButton t8;
    private javax.swing.JButton t80;
    private javax.swing.JButton t81;
    private javax.swing.JButton t82;
    private javax.swing.JButton t83;
    private javax.swing.JButton t84;
    private javax.swing.JButton t85;
    private javax.swing.JButton t86;
    private javax.swing.JButton t87;
    private javax.swing.JButton t88;
    private javax.swing.JButton t89;
    private javax.swing.JButton t9;
    private javax.swing.JButton t90;
    // End of variables declaration//GEN-END:variables
}
