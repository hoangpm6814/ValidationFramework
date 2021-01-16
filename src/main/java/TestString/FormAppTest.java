package TestString;

import annatations.NotNull;
import validationframework.app.FormMessage;
import validationframework.customPattern.ContainsNumberValidationPattern;
import validationframework.rules.AbstractValidationRule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Wrapper;

import lombok.Setter;
import validationframework.rules.ValidationRule;
import validationframework.rules.ValidationRuleSet;
import validationframework.rules.string.pattern.ValidationRulePattern;

class FormAppTest
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

  @Setter  private String username;
  @Setter  private String password;
  @Setter  private String email;
  @Setter  private String phone;

  @NotNull(message = "username cannot be null")
  public String getUsername() {
    return this.username;
  }


  public String getPassword() {
    return this.password;
  }

  public String getEmail() {
    return this.email;
  }
  public String getPhone() {
    return this.phone;
  }

  public FormAppTest() {
    setTitle("Validation Form");
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
    setUsername(input[0].getText());
    setPhone(input[3].getText());



//    ValidationRuleSet ruleSet = new ValidationRuleSet();
//    showMessage(validationResult[1], ruleSet);


//    ValidationRulePattern passwordLengthRule = new ValidationRulePattern(password, "\\b\\w{5,10}\\b","Password must be longer than 4 characters and less than 10 characters");
//    passwordLengthRule.setAbstractMessage(new FormMessage(validationResult[1]));
//    passwordLengthRule.showMessage();
//
//
//    ValidationRulePattern emailRule = new ValidationRulePattern(email, EmailValidationPattern.simple.getPattern(),"Please type valid email");
//    showMessage(validationResult[2], emailRule);
//
    ValidationRulePattern phoneLengthRule = new ValidationRulePattern(phone, "\\b\\w{10,11}\\b","Phone numbers length must be from 10 to 11 digits");
    ValidationRulePattern containNumberRule = new ValidationRulePattern(phone, ContainsNumberValidationPattern.createInstance().getPattern(),"Phone number just contains numeric values");
    ValidationRuleSet phoneRuleSet = new ValidationRuleSet();
    
    phoneRuleSet.addRule(phoneLengthRule);
    phoneRuleSet.addRule(containNumberRule);
    phoneRuleSet.setAbstractMessage(new FormMessage(validationResult[3]));
    phoneRuleSet.showMessage();

  }

  public static void main(String[] args) throws Exception {
    FormAppTest f = new FormAppTest();

//    Wrapper wrapper = new Wrapper(f);
//    List<ValidationRuleSet> = Wrapper.validate();

  }

  public void showMessage(JLabel label, AbstractValidationRule rule) {
    if (rule.validate().isValid()){
      label.setText("");
    } else {
      label.setText(rule.getMessage());
    }
  }
}
