/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelAnimate implements ActionListener
{
    JPanel PanelToAnimate;
    String AnimationDirection;
    Timer tAnimate;
    boolean booRemovePanel;
    
    public PanelAnimate(int speed, JPanel recievedPanel) 
    {
        tAnimate = new Timer(speed, this);
        tAnimate.addActionListener(this);
        PanelToAnimate = recievedPanel;
    }
    
    public void RemovePanelAfterAnimation(boolean informedRemovePanelAfterAnimation)
    {
        booRemovePanel=informedRemovePanelAfterAnimation;
    }
    public void SlideLeft()
    {
        AnimationDirection = "Left";
        tAnimate.start();
    }
    
    public void SlideRight()
    {
        AnimationDirection = "Right";
        tAnimate.start();
    }
    
    public void SlideCenter()
    {
        AnimationDirection = "Center";
        tAnimate.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        switch (AnimationDirection)
        {
            case "Left":
                if (PanelToAnimate.getX() > -420)
                {
                    PanelToAnimate.setBounds(PanelToAnimate.getX()-12,PanelToAnimate.getY(),PanelToAnimate.getWidth(),PanelToAnimate.getHeight());        
                }
                else
                {
                    tAnimate.stop();
                    //PanelToAnimate.setVisible(false);
                    RemovePanel();
                }
                break;
            case "Right":
                if (PanelToAnimate.getX() < 420)
                {
                    PanelToAnimate.setBounds(PanelToAnimate.getX()+12,PanelToAnimate.getY(),PanelToAnimate.getWidth(),PanelToAnimate.getHeight());        
                }
                else
                {
                    tAnimate.stop();
                    //PanelToAnimate.setVisible(false);
                    RemovePanel();
                }
                break;
            case "Center":
                
                PanelToAnimate.setVisible(true);
                
                if (PanelToAnimate.getX() < 105)
                {
                    PanelToAnimate.setBounds(PanelToAnimate.getX()+12,PanelToAnimate.getY(),PanelToAnimate.getWidth(),PanelToAnimate.getHeight());        
                }
                else if (PanelToAnimate.getX() > 105)
                {
                    PanelToAnimate.setBounds(PanelToAnimate.getX()-12,PanelToAnimate.getY(),PanelToAnimate.getWidth(),PanelToAnimate.getHeight());        
                }
                else
                {                    
                    tAnimate.stop();
                }
                break;
        }
        
    }
    
    private void RemovePanel()
    {
        if (booRemovePanel)
        {
            SetupWindow setup = (SetupWindow)PanelToAnimate.getParent();
            if (setup!=null)
            {
                setup.remove(PanelToAnimate);
                setup.repaint();
            }
        }
    }
}
