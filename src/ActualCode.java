import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class ActualCode extends JFrame implements ActionListener {

    JButton gButton = new JButton("Generate");
    JTextField PasswordLen = new JTextField();
    JLabel Password = new JLabel("Password:");
    JLabel Question = new JLabel("Enter The Length of  Password");
    JFrame frame = new JFrame();


    ActualCode(){

        frame.setTitle("Password-o Generator-o");
        Question.setBounds(65,120,260,40);
        gButton.setBounds(57,60,100,40);
        PasswordLen.setBounds(215,60,100,35);
        gButton.addActionListener(this);

        ButtonGroup bg = new ButtonGroup();
        bg.add(gButton);
        frame.add(gButton);
        frame.add(PasswordLen);
        frame.add(Password);
        frame.add(Question);

        frame.setSize(500,250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
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

    @Override
    public void actionPerformed(ActionEvent e) {

        String theLength = PasswordLen.getText();
        int PasswordLength = Integer.parseInt(theLength);

    if (PasswordLength < 9 || PasswordLength >= 18) {

        System.out.println("Error: Password needs to stay at least within the 9- 18 range of characters please try again");
        JTextField finishedProduct = new JTextField("Error: Please keep it between 9 - 18 characters long");
        finishedProduct.setBounds(65, 120, 260, 40);
        finishedProduct.setEditable(false);
        frame.add(finishedProduct);
    }
    if (gButton.isEnabled()) {

        JTextField finishedProduct = new JTextField(ActualLogic(PasswordLength));
        finishedProduct.setBounds(65, 120, 260, 40);
        finishedProduct.setEditable(false);

        frame.add(finishedProduct);

    }
    }

}
