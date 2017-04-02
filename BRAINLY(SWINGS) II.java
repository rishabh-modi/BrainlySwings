//SOURCE CODE FOR BRAINLY - AN  APPLICATION THAT LETS YOU EXERSISE YOUR BRAIN BY  DOING RANDDOM SIMPLE ADDITION SUMS ;) 



import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import sun.audio.*;
import java.io.*;
 
 
class game1 implements ActionListener
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
    ArrayList<Integer>answer = new ArrayList<Integer>();//to store the options for a given question



    JButton b1,b2,b3,b4,playAgain; //on screen play buttons

    int i;



 
  

    game1()
    {
        f=new JFrame("BRAINLY");
        t1=new JLabel("timer");
        t2=new JLabel("question");
        t3=new JLabel("score");
        
        b1=new JButton("1");
        b2=new JButton("2");
        
        b3=new JButton("3");
        b4=new JButton("4");
        playAgain=new JButton("PLAY AGAIN");
        
        b1.setForeground(Color.black);
        
        t1.setBounds(10,40,100,30);//
        t2.setBounds(150,40,60,30);//
        t3.setBounds(250,40,100,30);//
                                    //
                                    //  setting boundary layouts for containers
                                    //
        b1.setBounds(110,170,50,40);//
        b2.setBounds(180,170,50,40);//
                                    //        
        b3.setBounds(110,240,50,40);//
        b4.setBounds(180,240,50,40);//
                                    //
                                    //
        playAgain.setBounds(70,380,200,40);//

 	    f.getContentPane().setBackground(Color.CYAN);//
        b1.setBackground(Color.GREEN);               //
        b2.setBackground(Color.MAGENTA);             //
        b3.setBackground(Color.ORANGE);              //colouring the containers
        b4.setBackground(Color.YELLOW);              //
        playAgain.setBackground(Color.RED);          //


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
        
        b1.addActionListener(this);//
        b2.addActionListener(this);//
        b3.addActionListener(this);//Adding ActionListener to listen  button click
        b4.addActionListener(this);//
        playAgain.addActionListener(this);//
        
        playAgain.setVisible(false);
        generateQuestion();
        again();



     

    }

    public void generateQuestion()
    {
        Random random = new Random();

          num1 = random.nextInt(51);//
          num2 = random.nextInt(51);//creating random numbers for qquestion

          t2.setText(Integer.toString(num1) + " + " + Integer.toString(num2));//display question on the screen

        locationOfAnswer = random.nextInt(4);//storing the location of the answer in a random location in arraylist
        answer.clear();//flush out the arraylist after each iteration

        for(int i = 0; i<4 ; i++)
        {
            if(i == locationOfAnswer)
            {
                answer.add(num1 + num2);//adding correct answer to arrayList
            }
            else
            {
                incorrectAnswer = random.nextInt(100);
                while(incorrectAnswer == num1+num2)
                {
                    incorrectAnswer = random.nextInt(100);//creating incorrect answers

                }

            }
            answer.add(incorrectAnswer);//adding  incorrect answers to the arrayList
        }


        b1.setText(Integer.toString(answer.get(0)));//
        b2.setText(Integer.toString(answer.get(1)));//Display the anweers atored in arrayList on the buttons
        b3.setText(Integer.toString(answer.get(2)));//
        b4.setText(Integer.toString(answer.get(3)));//


    }
 
    public void actionPerformed(ActionEvent e)
    {

    	 if(e.getSource()==b1)
    	 {
    	 	if(b1.getText().equals(Integer.toString(num1+num2)))//if button1 pressed is equal to correct answer
    	 	{
    	 		score++;
    	 		
      	 	}
            
        }

         if(e.getSource()==b2)
    	 {
    	 	if(b2.getText().equals(Integer.toString(num1+num2)))//if button2 pressed is equal to correct answer
    	 	{
    	 		score++;
    	 		
      	 	}
            
        }

         if(e.getSource()==b3)
    	 {
    	 	if(b3.getText().equals(Integer.toString(num1+num2)))//if button3 pressed is equal to correct answer
    	 	{
    	 		score++;
    	 		
      	 	}
            
        }

         if(e.getSource()==b4)
    	 {
    	 	if(b4.getText().equals(Integer.toString(num1+num2)))//if button4 pressed is equal to correct answer
    	 	{
    	 		score++;
    	 		
    	 		
      	 	}
            
        }


             if(e.getSource()==playAgain)//if button playAgain is pressed
    	 {
    	 	again();
            
        }
       
       		totalQuestions++;//incrementing total number of  qquestions left at each iteration

            generateQuestion();//generating a new questtion at each iteration

            t3.setText("score: " + Integer.toString(score) + "/" + Integer.toString(totalQuestions));//updating score on the screen

                //             RISHABH MODI - BRAINLY(SWINGS) - JAVA ASSIGNMENT
		    	
    			t1.setText(Integer.toString(i)+ " Questions");//updating total number of questions leeft on th screen
    			i--;

    		if(i == 0)
    		{
    			 b1.setEnabled(false);//disable buttons when game is over
        		 b2.setEnabled(false);
         		 b3.setEnabled(false);
        		 b4.setEnabled(false);
        		 playAgain.setVisible(true);//show play again button when gaame is over
	
    		}

    }


 public void again()
    {                               //update values at the start of each game
        t3.setText("score: 0/0");
        score = 0;
        totalQuestions = 0;
        t1.setText("20 Questions");
        playAgain.setVisible(false);

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);

    i =20;//total number of questions = 20

}


    public static void main(String...s)
    {	
        new game1();//create object
    }
}