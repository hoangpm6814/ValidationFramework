/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestString;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import validationframework.customPattern.ContainsNumberValidationPattern;
import validationframework.customPattern.EmailValidationPattern;
import validationframework.messageType.label.MessageLabelFactory;
import validationframework.rules.ValidationRuleSet;
import validationframework.rules.comparison.ValidationRuleMaximum;
import validationframework.rules.notNull.ValidationRuleNotNull;
import validationframework.rules.pattern.ValidationRulePattern;
import validationframework.validator.Validator;

public class RegisterForm111 extends JFrame {

    public JPanel contentPane;

    private JTextField txtUsername;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JTextField txtPhone;
    private JDateChooser txtDate;

    public JLabel lblValidateUsername;
    public JLabel lblValidatePhone;
    private JLabel lblValidatePassword;
    private JLabel lblValidateEmail;
    private JLabel lblValidateDate;
    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RegisterForm111 frame = new RegisterForm111();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void validateInput(){
        SimpleDateFormat dcn = new SimpleDateFormat("dd/MM/yyyy");
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String phone  = txtPhone.getText();

        String birthDateAsbirtString = ((JTextField)txtDate.getDateEditor().getUiComponent()).getText();
        Date birthDate = (!"".equals(birthDateAsbirtString)) ? txtDate.getDate() : (new Date());
        String email = txtEmail.getText();
        //Validate username
        MessageLabelFactory messageUsernameFactory = new MessageLabelFactory(lblValidateUsername);
        ValidationRuleNotNull notNullRule = messageUsernameFactory.createNotNullRule(username, "Username cannot be null");
        Validator usernameValidator = new Validator (notNullRule);
        usernameValidator.showMessage();

        //Validate password
        MessageLabelFactory messagePasswordFactory = new MessageLabelFactory(lblValidatePassword);
        ValidationRulePattern passwordLengthRule = messagePasswordFactory.createPatternRule(password,"\\b\\w{5,10}\\b", "Password must be longer than 4 characters and less than 10 characters");
        Validator passwordValidator = new Validator (passwordLengthRule);
        passwordValidator.showMessage();

        // Validate email
        MessageLabelFactory messageEmailFactory = new MessageLabelFactory(lblValidateEmail);
        ValidationRulePattern emailRule = messageEmailFactory.createPatternRule(email, EmailValidationPattern.simple.getPattern(), "Please type valid email");
        Validator emailValidator = new Validator (emailRule);
        emailValidator.showMessage();

        // Validate phone
        MessageLabelFactory messagePhoneFactory = new MessageLabelFactory(lblValidatePhone);
        ValidationRulePattern phoneLengthRule = messagePhoneFactory.createPatternRule(phone, "\\b\\w{10,11}\\b", "Phone numbers length must be from 10 to 11 digits");
        ValidationRulePattern containNumberRule = messagePhoneFactory.createPatternRule(phone, ContainsNumberValidationPattern.shared.getPattern(), "Phone number just contains numeric values");
        ValidationRuleSet phoneRuleSet = new ValidationRuleSet();
        phoneRuleSet.addRule(phoneLengthRule);
        phoneRuleSet.addRule(containNumberRule);
        Validator phoneValidator = new Validator (phoneRuleSet);
        phoneValidator.showMessage();

        //Validate Birth date
        Date now = new Date();
        MessageLabelFactory messageBirthDateFactory = new MessageLabelFactory(lblValidateDate);
        ValidationRuleNotNull dateNotNullRule = messageBirthDateFactory.createNotNullRule(birthDateAsbirtString, "Date cannot be null");
        ValidationRuleMaximum dateMaxRule = messageBirthDateFactory.createMaximumRule(birthDate,now, "Date must be earlier than today");
        ValidationRuleSet dateRuleSet = new ValidationRuleSet();
        dateRuleSet.addRule(dateNotNullRule);
        dateRuleSet.addRule(dateMaxRule);
        Validator dateValidator = new Validator(dateRuleSet);
        dateValidator.showMessage();


    }


    /**
     * Create the frame.
     */
    public RegisterForm111() {
        setResizable(false);
        setBackground(Color.WHITE);
        setTitle("Register Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 481, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel Username = new JLabel("Username:");
        Username.setFont(new Font("Tahoma", Font.PLAIN, 13));

        txtUsername = new JTextField();
        txtUsername.setColumns(10);

        lblValidateUsername = new JLabel("");
        lblValidateUsername.setForeground(Color.RED);
        lblValidateUsername.setFont(new Font("Tahoma", Font.PLAIN, 10));

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));

        txtEmail = new JTextField();
        txtEmail.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));

        txtPassword = new JPasswordField();

        JLabel lblPhoneNumber = new JLabel("Phone number:");
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));

        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setHorizontalAlignment(JTextField.CENTER);

        JLabel lblDateOfBirth = new JLabel("Date of birth:");
        lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblSignUp = new JLabel("Sign Up");
        lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblSignUp.setHorizontalAlignment(JLabel.CENTER);
        lblSignUp.setVerticalAlignment(JLabel.CENTER);

        txtDate = new JDateChooser();
        try {
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990");
            txtDate.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterForm111.class.getName()).log(Level.SEVERE, null, ex);
        }
        JTextFieldDateEditor editor = (JTextFieldDateEditor) txtDate.getDateEditor();
        editor.setEnabled(false);

        JButton btnRegister = new JButton("Register");
        btnRegister.setVerticalAlignment(JLabel.CENTER);
        btnRegister.setHorizontalAlignment(JLabel.CENTER);
//        btnRegister.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                validateInput();
//            }
//        });
        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
                validateInput();
            }
        });

        lblValidatePhone = new JLabel("");
        lblValidatePhone.setForeground(Color.RED);
        lblValidatePhone.setFont(new Font("Tahoma", Font.PLAIN, 10));

        lblValidatePassword = new JLabel("");
        lblValidatePassword.setForeground(Color.RED);
        lblValidatePassword.setFont(new Font("Tahoma", Font.PLAIN, 10));

        lblValidateEmail = new JLabel("");
        lblValidateEmail.setForeground(Color.RED);
        lblValidateEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));

        lblValidateDate = new JLabel("");
        lblValidateDate.setForeground(Color.RED);
        lblValidateDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(160)
                                .addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                .addGap(191))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(185)
                                .addComponent(lblSignUp, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                .addGap(184))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(42)
                                .addComponent(lblValidatePhone)
                                .addContainerGap(394, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(43)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblValidateDate)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addComponent(lblValidateEmail)
                                                        .addContainerGap())
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblValidatePassword)
                                                                .addContainerGap())
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                                                        .addComponent(txtDate, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                                                        .addComponent(lblDateOfBirth, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblValidateUsername)
                                                                        .addComponent(Username)
                                                                        .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                                                        .addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                                                        .addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                                                                .addGap(61))))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(23)
                                .addComponent(lblSignUp, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addGap(18)
                                .addComponent(Username)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblValidateUsername)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblValidatePassword)
                                .addGap(5)
                                .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblValidateEmail)
                                .addGap(5)
                                .addComponent(lblDateOfBirth, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtDate, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addGap(5)
                                .addComponent(lblValidateDate)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblValidatePhone)
                                .addGap(17)
                                .addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addGap(19))
        );
        contentPane.setLayout(gl_contentPane);
    }
}