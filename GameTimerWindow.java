/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class GameTimerWindow extends JPanel implements ActionListener {

    JTextField timeTextField;
    int timeLeft;
    Timer timer;
    Integer minutes,seconds;
    GameTimerFrame parentFrame;
    
    public GameTimerWindow(GameTimerFrame frame)
    {
        super();
        parentFrame = frame;
        setBackground(Color.DARK_GRAY);
        setVisible(true);        
        timeTextField = new JTextField();
        resetTimer();
              
        add(timeTextField);
        timer = new Timer(1000,this);
	Font font = new Font("SansSerif", Font.BOLD, 32);
	timeTextField.setFont(font);
        timeTextField.setBackground(Color.darkGray);
        timeTextField.setForeground(Color.green);
        timeTextField.setBorder(null);
        timeTextField.setEditable(false);
        timeTextField.addActionListener(this);
	timeTextField.setHorizontalAlignment(JTextField.CENTER);
    }

    public void displayWindow()
    {
        timeTextField.setForeground(Color.GREEN);
        timer.start();
    }
    
    public void hideWindow()
    {
        timer.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (timer == e.getSource())
        {
            updateTime();
        }
        if (e.getSource().equals(timeTextField))
        {
            timeTextField.setSelectionEnd(0);
            timeTextField.setSelectionStart(0);
        }
    }
    
    public void updateTime()
    {
        if (seconds == 0)
        {
            seconds = 59;
            minutes--;
            if (minutes >= 0)
            {
                timeTextField.setText(minutes.toString()+":"+seconds.toString());
                if (minutes == 0)
                {
                    timeTextField.setForeground(Color.red);
                }
            }
            else
            {
                parentFrame.parentFrame.gameWindow.QuestionButtonsDisabled = true;
                timeTextField.setText("GAME OVER");
                timer.stop();
                parentFrame.parentFrame.SoundPlayer.play("endround.wav");
                timeTextField.setBounds(20, 5,200,50);
            }
        }
        else
        {
            seconds--;
            if (seconds < 10)
            {
                timeTextField.setText(minutes.toString()+":"+"0"+seconds.toString());
            }
            else
            {
                timeTextField.setText(minutes.toString()+":"+seconds.toString());
            }
        }  
        parentFrame.parentFrame.SoundPlayer.play("tick.wav");
    }
    
    public final void resetTimer()
    {
        timeLeft = 180;
        minutes = 5;
        seconds = 0;
        timeTextField.setText("5:00");
    }
}
