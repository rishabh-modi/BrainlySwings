
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;
 
 
class Calc implements ActionListener
{
    JFrame f;
    JLabel t1;
    JLabel t2;
    JLabel t3;
    int locationOfAnswer;
    int incorrectAnswer;
    int score = 0;
    int totalQuestions = 0;
    int num1,num2;
    ArrayList<Integer>answer = new ArrayList<Integer>();


    JButton b1,b2,b3,b4,playAgain;

    int i;
 
    static double a=0,b=0,result=0;
    static int operator=0;
 
    Calc()
    {
        f=new JFrame("Calculator");
        t1=new JLabel("timer");
        t2=new JLabel("question");
        t3=new JLabel("score");
        
        b1=new JButton("1");
        b2=new JButton("2");
        
        b3=new JButton("3");
        b4=new JButton("4");
        playAgain=new JButton("PLAY AGAIN");
        
        
        t1.setBounds(10,40,60,30);
        t2.setBounds(150,40,60,30);
        t3.setBounds(300,40,60,30);

        
       
        b1.setBounds(110,170,50,40);
        b2.setBounds(180,170,50,40);
        
        b3.setBounds(110,240,50,40);
        b4.setBounds(180,240,50,40);
        
        
        playAgain.setBounds(70,380,200,40);
        
        f.add(t1);
        f.add(t2);
        f.add(t3);
       
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
       
        f.add(playAgain);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        playAgain.addActionListener(this);
        playAgain.setVisible(false);
        generateQuestion();
        again();
    }

    public void generateQuestion()
    {
        Random random = new Random();

          num1 = random.nextInt(51);
          num2 = random.nextInt(51);

          t2.setText(Integer.toString(num1) + " + " + Integer.toString(num2));

        locationOfAnswer = random.nextInt(4);
        answer.clear();

        for(int i = 0; i<4 ; i++)
        {
            if(i == locationOfAnswer)
            {
                answer.add(num1 + num2);
            }
            else
            {
                incorrectAnswer = random.nextInt(100);
                while(incorrectAnswer == num1+num2)
                {
                    incorrectAnswer = random.nextInt(100);

                }

            }
            answer.add(incorrectAnswer);
        }


        b1.setText(Integer.toString(answer.get(0)));
        b2.setText(Integer.toString(answer.get(1)));
        b3.setText(Integer.toString(answer.get(2)));
        b4.setText(Integer.toString(answer.get(3)));


    }
 
    public void actionPerformed(ActionEvent e)
    {

    	 if(e.getSource()==b1)
    	 {
    	 	if(b1.getText().equals(Integer.toString(num1+num2)))
    	 	{
    	 		score++;
    	 		
      	 	}
            
        }

         if(e.getSource()==b2)
    	 {
    	 	if(b2.getText().equals(Integer.toString(num1+num2)))
    	 	{
    	 		score++;
    	 		
      	 	}
            
        }

         if(e.getSource()==b3)
    	 {
    	 	if(b3.getText().equals(Integer.toString(num1+num2)))
    	 	{
    	 		score++;
    	 		
      	 	}
            
        }

         if(e.getSource()==b4)
    	 {
    	 	if(b4.getText().equals(Integer.toString(num1+num2)))
    	 	{
    	 		score++;
    	 		
    	 		
      	 	}
            
        }


             if(e.getSource()==playAgain)
    	 {
    	 	again();
            
        }
       
       		totalQuestions++;
            generateQuestion();
            t3.setText(Integer.toString(score) + "/" + Integer.toString(totalQuestions));

           
		    	
    			t1.setText(Integer.toString(i));
    			i--;

    		if(i == 0)
    		{
    			 b1.setEnabled(false);
        		 b2.setEnabled(false);
         		 b3.setEnabled(false);
        		 b4.setEnabled(false);
        		         playAgain.setVisible(true);
	
    		}

    }


 public void again()
    {
        t3.setText("0/0");
        score = 0;
        totalQuestions = 0;
        t1.setText("20");
        playAgain.setVisible(false);

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);

    i =20;

   



    }



    public static void main(String...s)
    {	
        new Calc();
    }
}