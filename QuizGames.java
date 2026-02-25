package com.Medium;

import java.util.ArrayList;
import java.util.Scanner;

class Question{
	String questionTest;
	String[] options;
	int correctAnswer;
	
	public Question(String questionTest, String[] options, int correctAnswer) {
		super();
		this.questionTest = questionTest;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}
	public boolean askQuestions(Scanner sc) {
		System.out.println("\n "+ questionTest);
		for(int i=0;i<options.length;i++) {
			System.out.println((i+1)+" . "+ options[i]);
		}
		System.out.println("Enter your ans (1-4): ");
		int userAns=sc.nextInt();
		if(userAns-1==correctAnswer) {
			System.out.println("Correct!!");
			return true;
		}else {
			System.out.println("Wrong !! correct Ans:"+
			options[correctAnswer]);
			return false;
		}
	}	
	
}
class QuizGame{
	private ArrayList<Question> questions;
	private int score;
	public QuizGame() {
		questions =new ArrayList<>();
		score=0;
	}
	public void addQuestion(Question q) {
		questions.add(q);
	}
	public void startQuiz() {
		Scanner sc=new Scanner(System.in);
		for(Question q: questions) {
			if(q.askQuestions(sc)) {
				score++;
			}
		}
		System.out.println("\n Quiz Finished!");
		System.out.println("Your Score: "+ score +" / "+questions.size());
		sc.close();
	}
}

public class QuizGames {
	public static void main(String[] args) {
		QuizGame quizGame=new QuizGame();
		quizGame.addQuestion(new Question("Which language is used for Android Developments?", new String[] {"Java", "Python","C++","HTML"},0));
		quizGame.addQuestion(new Question("Which keyword is used to inherit a class in java?", new String[] {"this", "super","extends","implements"},2));
		quizGame.addQuestion(new Question("Which collection class allows dynamic array ?", new String[] {"Array", "LinkedList","ArrayList","HashMap"},2));
		quizGame.startQuiz();
	}

}
