import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.09.2022
 * @author Ben Altmann
 */

public class BinaryTreeVisual extends JFrame {
  // Anfang Attribute
  private JNumberField InputNumberField = new JNumberField();
  private JLabel lInputNumber = new JLabel();
  private JLabel lOutput = new JLabel();
  private JNumberField checkNumberField = new JNumberField();
  private JLabel lNumbertocheck = new JLabel();
  private JButton bSave = new JButton();
  private JButton bCheck = new JButton();
  private JTextArea OutputArea = new JTextArea("");
  private JScrollPane OutputAreaScrollPane = new JScrollPane(OutputArea);
  private BinTree NumberTree = new BinTree();
  // Ende Attribute
  
  public BinaryTreeVisual() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 465; 
    int frameHeight = 485;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("BinaryTreeVisual");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    InputNumberField.setBounds(63, 48, 75, 20);
    InputNumberField.setText("");
    cp.add(InputNumberField);
    lInputNumber.setBounds(45, 20, 110, 20);
    lInputNumber.setText("Input Number");
    lInputNumber.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lInputNumber);
    lOutput.setBounds(63, 140, 144, 20);
    lOutput.setText("Output");
    lOutput.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lOutput);
    checkNumberField.setBounds(214, 42, 75, 20);
    checkNumberField.setText("");
    cp.add(checkNumberField);
    lNumbertocheck.setBounds(201, 17, 110, 20);
    lNumbertocheck.setText("Number to check");
    lNumbertocheck.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lNumbertocheck);
    bSave.setBounds(63, 74, 75, 25);
    bSave.setText("Save");
    bSave.setMargin(new Insets(2, 2, 2, 2));
    bSave.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSave_ActionPerformed(evt);
      }
    });
    cp.add(bSave);
    bCheck.setBounds(215, 73, 75, 25);
    bCheck.setText("Check");
    bCheck.setMargin(new Insets(2, 2, 2, 2));
    bCheck.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bCheck_ActionPerformed(evt);
      }
    });
    cp.add(bCheck);
    OutputAreaScrollPane.setBounds(54, 165, 200, 100);
    cp.add(OutputAreaScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public BinaryTreeVisual
  private int count = 0;
  // Anfang Methoden
  
  public static void main(String[] args) {
    new BinaryTreeVisual();
  } // end of main
  
  public void bSave_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    if (InputNumberField.isNumeric()){
      NumberTree.add(InputNumberField.getInt());
    }
  } // end of bSave_ActionPerformed

  public void bCheck_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    if (checkNumberField.isNumeric()){
          count++;
          int number = checkNumberField.getInt();
          OutputArea.append(String.format("---------------\n%s: \nstatus: %s \nnumber tried: %s \n---------------\n",count,NumberTree.search(number),number));
      }
  } // end of bCheck_ActionPerformed

  // Ende Methoden
} // end of class BinaryTreeVisual
