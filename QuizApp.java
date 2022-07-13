package work;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.jaunt.component.Label;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class QuizApp extends JFrame implements ActionListener {
	static JRadioButton b1 = new JRadioButton() ;
	static JRadioButton b2 = new JRadioButton() ;
	static JRadioButton b3 = new JRadioButton() ;
	static JRadioButton b4 = new JRadioButton() ;
	JButton nxtQuestion;
	JButton submit;
	static Random r = new Random();
	static int scorecount = 0;
	static String scores = String.valueOf(scorecount);
	static JLabel score = new JLabel(scores);
	static JLabel L = new JLabel();
	static int[] used = new int[10];
	static int[] store = new int[10];

	static int current = 0;
	
	boolean empty = true;
	//buttons checked function

	private JTextField textField;
	
	public QuizApp() { //constructor of QuizApp class
		//creation of radio buttons


		nxtQuestion = new JButton("Next");
		submit = new JButton("Submit");

		this.setLayout(new FlowLayout());
		L.setBounds(30,40,450,20);
		score.setBounds(100, 200, 300, 200);


		ButtonGroup group = new ButtonGroup();
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		nxtQuestion.addActionListener(this);
		submit.addActionListener(this);

		group.add(b1);
		group.add(b2);
		group.add(b3);
		group.add(b4);

		this.add(score);
		this.add(L);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);

		this.add(nxtQuestion);
		this.add(submit); 
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		for(int i = 1; i < used.length; i++) {
			used[i] = i;
		}

		QuizApp q = new QuizApp();

		q.setBounds(200, 500, 300, 300);
		q.setTitle("QuestionApp");  
		q.setVisible(true);
		System.out.println(answer());

	}
	void setData() { //questions

		b1.setSelected(true);
		if(current == 0) { //randomized question
			L.setText("What type of animal is a seahorse?");
			b1.setText("A. Crustacean");
			b2.setText("B. Arachnid");
			b3.setText("C. Fish");
			b4.setText("D. Shell");
		}

		if(current == 1) { //randomized question
			L.setText("Which of the following dog breeds is the smallest?");
			b1.setText("A. Dachshund");
			b2.setText("B. Poodle");
			b3.setText("C. Pomeranian");
			b4.setText("D. Chihuahua");
		}if(current == 2) { //randomized question
			L.setText("What color are zebras?");
			b1.setText("A.  White with black stripes");
			b2.setText("B. Black with white stripes");
			b3.setText("C. Both of the above");
			b4.setText("D. None of the above");
		}if(current == 3) { //randomized question
			L.setText("What existing bird has the largest wingspan?");
			b1.setText("A. Stork");
			b2.setText("B. Swan");
			b3.setText("C. Condor");
			b4.setText("D. Albatross");
		}if(current == 4) { //randomized question
			L.setText("What is the biggest animal that has ever lived?");
			b1.setText("A. Blue whale");
			b2.setText("B. African elephant");
			b3.setText("C. Apatosaurus (aka Brontosaurus)");
			b4.setText("D. Spinosaurus");
		}if(current == 5) { //randomized question
			L.setText("Fill in the blank: Out of these pets, there are the most pet _____ in the U.S.");
			b1.setText("A. Birds");
			b2.setText("B. Cats");
			b3.setText("C. Dogs");
			b4.setText("D. Horses");
		}if(current == 6) { //randomized question
			L.setText("Which of these animals lives the longest?");
			b1.setText("A. Ocean quahog (clam)");
			b2.setText("B. Red sea urchin");
			b3.setText("C. Galapagos tortoise");
			b4.setText("D. Rougheye rockfish");
		}if(current == 7) { //randomized question
			L.setText("What are female elephants called?");
			b1.setText("A. Mares");
			b2.setText("B. Sows");
			b3.setText("C. Cows");
			b4.setText("D. Dams");
		}if(current == 8) { //randomized question
			L.setText("Which of the following animals sleeps standing up?");
			b1.setText("A. Gorillas");
			b2.setText("B. Flamingos");
			b3.setText("C. Hedgehogs");
			b4.setText("D. Ravens");
		}if(current == 9) { //randomized question
			L.setText("What is the fastest water animal?");
			b1.setText("A. Porpoise");
			b2.setText("B. Sailfish");
			b3.setText("C. Flying fish");
			b4.setText("D. Tuna");
		}

	}
	
	public static int[] removeElement(int[] arr, int item) {
		return Arrays.stream(arr)
				.filter(i -> i != item)
				.toArray();
	}
	public static boolean answer() {
		
		if(current == 1 && b3.isSelected() == true) {
			
			return true;
		}
		else if(current == 2 && b4.isSelected() == true) {
			return true;
		}
		else if(current == 3 && b2.isSelected() == true) {
			return true;
		}
		else if(current == 4 && b4.isSelected() == true) {
			return true;
		}
		else if(current == 5 && b1.isSelected() == true) {
			return true;
		}
		else if(current == 6 && b2.isSelected() == true) {
			return true;
		}
		else if(current == 7 && b1.isSelected() == true) {
			return true;
		}
		else if(current == 8 && b3.isSelected() == true) {
			return true;
		}
		else if(current == 9 && b2.isSelected() == true) {
			return true;
		}
		else if(current == 10 && b2.isSelected() == true) {
			return true;
		}
		else {
			return false;
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(used.length != 0) {
			if(e.getSource() == nxtQuestion) {
				this.dispose(); //close previous window after button is pressed
				QuizApp q = new QuizApp();
				q.setBounds(200, 500, 300, 300); //new bounds
				q.setTitle("QuestionApp");  //creation basically 
				q.setData();
				current++;
				System.out.println(current);
			
			}
		}
		int randomIndex = new Random().nextInt(used.length);
		for (Object ob : used) {
			if (ob != null) {
				empty = false;
				break;
			}
		}
		
		if(e.getSource() == submit) { //submit answer~`	
			if(answer() == true) {		
				System.out.println("that is correct");		
				scorecount++;
				this.dispose();
				scores = String.valueOf(scorecount);
				score.setText(scores);
				QuizApp q = new QuizApp();
				q.setBounds(200, 500, 300, 300); //new bounds
				q.setTitle("QuestionApp");  //creation basically 
				
				
			}
			else {
				System.out.println("that is incorrect");
			}
		}
		

	}

}
