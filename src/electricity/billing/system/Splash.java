package electricity.billing.system;

import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    
    Splash() {
        
        int x=1;
        for(int i=2; i<600; i+=4, x+=1){
            setSize(i+x, i);
            setLocation(700-((i+x)/2), 400-(i/2));
            try{
                Thread.sleep(50);
            }catch (Exception e){
                e.printStackTrace();
            }
                
        }
        
        run();
        
        setVisible(true);
        
    }
    
    public void run(){
        try {
            Thread.sleep(1000);
            setVisible(false);
            //login frame
            
            new Login();
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Splash();
    }
}
