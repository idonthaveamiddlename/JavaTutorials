package com.devank.client;

import java.util.Scanner;

import com.devank.presentation.MobileShopUserInterface;
import com.devank.presentation.MobileShopUserInterfaceImpl;

public class MyMain {

	public static void main(String[] args) {
		MobileShopUserInterface ui = new MobileShopUserInterfaceImpl();
		Scanner sc=new Scanner(System.in);
		while(true){
			ui.showMenu();
			System.out.println("Enter choice : ");
			int choice=sc.nextInt();
			ui.perform(choice);

		}

	}

}
