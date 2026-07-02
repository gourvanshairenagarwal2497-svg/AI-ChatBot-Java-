import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chatbotgui extends JFrame implements ActionListener {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JButton clearButton;

    private Engine engine;

    public chatbotgui() {

        engine = new Engine();

        setTitle("AI ChatBot");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("AI CHATBOT", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setOpaque(true);
        heading.setBackground(new Color(52, 73, 94));
        heading.setForeground(Color.WHITE);
        heading.setPreferredSize(new Dimension(600, 50));
        add(heading, BorderLayout.NORTH);

       
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 15));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

       
        JPanel bottomPanel = new JPanel(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 15));

        JPanel buttonPanel = new JPanel();

        sendButton = new JButton("Send");
        clearButton = new JButton("Clear");

        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(this);
        inputField.addActionListener(this);

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chatArea.setText("");
                showWelcomeMessage();
            }
        });

        showWelcomeMessage();

        setVisible(true);
    }

   
    private void showWelcomeMessage() {

        chatArea.append("=====================================\n");
        chatArea.append("          JAVA AI CHATBOT\n");
        chatArea.append("=====================================\n\n");
        chatArea.append("Bot : Hello! Welcome.\n");
        
    }

   
    private void sendMessage() {

        String message = inputField.getText().trim();

        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a message.");
            return;
        }

        chatArea.append("You : " + message + "\n");

        String response = engine.getResponse(message);

        chatArea.append("Bot : " + response + "\n\n");

        inputField.setText("");

        // Auto Scroll
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendMessage();
    }
}