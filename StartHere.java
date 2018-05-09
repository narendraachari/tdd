package com.ubs.opsit.interviews;

import java.util.Scanner;

public class StartHere {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		String text = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string");
		text = in.nextLine();
		MyBerlin clk = new MyBerlin();
		System.out.println(clk.convertTime(text));

	}

}
