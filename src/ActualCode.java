import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class ActualCode extends JFrame implements ActionListener {
    ButtonGroup bg = new ButtonGroup();
    JButton gButton = new JButton("Generate");
    JTextField PasswordLen = new JTextField();
    JLabel Password = new JLabel("Password:");
    JLabel Question = new JLabel("Enter The Length of  Password");
    JFrame frame = new JFrame();


    ActualCode(){

        frame.setTitle("Password-o Generator-o");
        Question.setBounds(65,25,260,40);
        gButton.setBounds(57,60,100,40);
        PasswordLen.setBounds(215,60,100,35);
        gButton.addActionListener(this);


        bg.add(gButton);
        frame.add(gButton);
        frame.add(PasswordLen);
        frame.add(Password);
        frame.add(Question);

        frame.setSize(500,250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);



        JLabel Clipped = new JLabel("Password copied to your clipboard");
        Clipped.setBounds(69, 90, 260, 40);
        frame.add(Clipped);
        Clipped.setText("Password Will to your clipboard");
    }

    private String ActualLogic(int theSize){
        String NeededCharacters=  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789!@#$%^&*?";

        StringBuilder sb = new StringBuilder(theSize);
        for(int i= 0; i < theSize; i++ ){


            int gen = (int)(NeededCharacters.length() * Math.random());
            sb.append(NeededCharacters.charAt(gen));
        }

        return sb.toString();
    }



    void copyFucntion(String copy){


        StringSelection copyThis = new StringSelection(copy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(copyThis, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String theLength = PasswordLen.getText();
        int PasswordLength = Integer.parseInt(theLength);

        if (PasswordLength < 9 || PasswordLength > 30) {

            System.out.println("");
            JTextField Error = new JTextField();
            Error.setBounds(65, 120, 260, 40);
            Error.setEditable(false);
            frame.add(Error);
            Error.setText("Error: Please keep it between 9 - 30+ characters long");
            Error.revalidate();




        }


        else {

            JTextField finishedProduct = new JTextField();
            finishedProduct.setBounds(65, 120, 260, 40);
            finishedProduct.setEditable(false);

            var PasswordDone = ActualLogic(PasswordLength);
            finishedProduct.setText(PasswordDone);

            frame.add(finishedProduct);
            copyFucntion(PasswordDone);



        }


    }




}

