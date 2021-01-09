package TestString;

import validationframework.customPattern.ContainsNumberValidationPattern;
import validationframework.customPattern.EmailValidationPattern;
import validationframework.messageType.label.MessageLabelFactory;
import validationframework.rules.ValidationRuleSet;
import validationframework.rules.notNull.ValidationRuleNotNull;
import validationframework.rules.pattern.ValidationRulePattern;
import validationframework.validator.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FormGeek
    extends JFrame
    implements ActionListener {

  private Container container;
  private JLabel title;
  private JButton submit;
  private JButton reset;
  private JLabel result;

  private JLabel[] labelName = new JLabel[4];
  private JTextField[] input = new JTextField[4];
  private JLabel[] validationResult  = new JLabel[4];

  private String[] name = {"Username", "Password", "Email", "Phone number"};

  public FormGeek() {
    setTitle("Registration Form");
    setBounds(300, 90, 900, 800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    container = getContentPane();
    container.setLayout(null);

    title = new JLabel("Test Validation Form");
    title.setFont(new Font("Arial", Font.PLAIN, 30));
    title.setSize(400, 30);
    title.setLocation(300, 30);
    container.add(title);

    for (int i = 0; i < name.length; i++) {
      int offset = i * 100;
      labelName[i] = new JLabel(name[i]);
      labelName[i].setFont(new Font("Arial", Font.PLAIN, 20));
      labelName[i].setSize(200, 20);
      labelName[i].setLocation(100, 100 + offset);
      container.add(labelName[i]);

      input[i] = new JTextField();
      input[i].setFont(new Font("Arial", Font.PLAIN, 20));
      input[i].setSize(400, 30);
      input[i].setLocation(270, 100 + offset);
      container.add(input[i]);

      validationResult[i] = new JLabel("");
      validationResult[i].setFont(new Font("Arial", Font.PLAIN, 15));
      validationResult[i].setSize(600, 30);
      validationResult[i].setLocation(270, 150 + offset);
      validationResult[i].setForeground(Color.red);
      container.add(validationResult[i]);
    }

    submit = new JButton("Submit");
    submit.setFont(new Font("Arial", Font.PLAIN, 20));
    submit.setSize(200, 30);
    submit.setLocation(250, 600);
    submit.addActionListener(this);
    container.add(submit);

    reset = new JButton("Reset");
    reset.setFont(new Font("Arial", Font.PLAIN, 20));
    reset.setSize(200, 30);
    reset.setLocation(500, 600);
    reset.addActionListener(this);
    container.add(reset);

    result = new JLabel("");
    result.setFont(new Font("Arial", Font.PLAIN, 20));
    result.setSize(500, 30);
    result.setLocation(300, 650);
    container.add(result);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit) {
      validateInput();
    } else if (e.getSource() == reset) {
      for(int i=0;i< name.length;i++) {
        input[i].setText("");
        validationResult[i].setText("");
      }
    }
  }

  public void validateInput(){
    String username = input[0].getText();
    String password = input[1].getText();
    String email = input[2].getText();
    String phone  = input[3].getText();

    //Validate username
    MessageLabelFactory messageUsernameFactory = new MessageLabelFactory(validationResult[0]);
    ValidationRuleNotNull notNullRule = messageUsernameFactory.createNotNullRule(username, "Username cannot be null");
    Validator usernameValidator = new Validator (notNullRule);
    usernameValidator.showMessage();

    //Validate password
    MessageLabelFactory messagePasswordFactory = new MessageLabelFactory(validationResult[1]);
    ValidationRulePattern passwordLengthRule = messagePasswordFactory.createPatternRule(password,"\\b\\w{5,10}\\b", "Password must be longer than 4 characters and less than 10 characters");
    Validator passwordValidator = new Validator (passwordLengthRule);
    passwordValidator.showMessage();

    // Validate email
    MessageLabelFactory messageEmailFactory = new MessageLabelFactory(validationResult[2]);
    ValidationRulePattern emailRule = messageEmailFactory.createPatternRule(email, EmailValidationPattern.simple.getPattern(), "Please type valid email");
    Validator emailValidator = new Validator (emailRule);
    emailValidator.showMessage();

    // Validate phone
    MessageLabelFactory messagePhoneFactory = new MessageLabelFactory(validationResult[3]);
    ValidationRulePattern phoneLengthRule = messagePhoneFactory.createPatternRule(phone, "\\b\\w{10,11}\\b", "Phone numbers length must be from 10 to 11 digits");
    ValidationRulePattern containNumberRule = messagePhoneFactory.createPatternRule(phone, ContainsNumberValidationPattern.shared.getPattern(), "Phone number just contains numeric values");
    ValidationRuleSet phoneRuleSet = new ValidationRuleSet();
    phoneRuleSet.addRule(phoneLengthRule);
    phoneRuleSet.addRule(containNumberRule);
    Validator phoneValidator = new Validator (phoneRuleSet);
    phoneValidator.showMessage();

  }

  public static void main(String[] args) throws Exception {
    FormGeek f = new FormGeek();
  }
}
