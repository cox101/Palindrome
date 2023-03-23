import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeNumberChecker extends JFrame implements ActionListener {

    private JTextField inputField;
    private JTextArea resultArea;
    private JButton checkButton;

    public  PalindromeNumberChecker() {
        // Set up the GUI
        super("Palindrome Checker");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel inputLabel = new JLabel("Enter a number:");
        inputField = new JTextField(10);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        checkButton = new JButton("Check");
        checkButton.addActionListener(this);
        buttonPanel.add(checkButton);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel resultLabel = new JLabel("Result:");
        resultArea = new JTextArea(1, 10);
        resultArea.setEditable(false);
        resultPanel.add(resultLabel);
        resultPanel.add(resultArea);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        contentPane.add(inputPanel);
        contentPane.add(buttonPanel);
        contentPane.add(resultPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButton) {
            // Get the input number from the user
            String inputText = inputField.getText();
            int inputNumber = Integer.parseInt(inputText);

            // Check if the number is a palindrome
            boolean isPalindrome = checkPalindrome(inputNumber);

            // Display the result
            if (isPalindrome) {
                resultArea.setText("Palindrome!");
            } else {
                resultArea.setText("Not a palindrome.");
            }
        }
    }

    public boolean checkPalindrome(int originalNumber) {
        // Convert the originalNumber to a string o we can reverse it
        String numberString = Integer.toString(originalNumber);

        // Reverse the string
        String reverseString = new StringBuilder(numberString).reverse().toString();

        // Convert the reversed string back to an integer
        int reverseNumber = Integer.parseInt(reverseString);

        // Check if the  original Number and the reversed Number are the same
        if (originalNumber == reverseNumber) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PalindromeNumberChecker checker = new PalindromeNumberChecker();
    }
}
