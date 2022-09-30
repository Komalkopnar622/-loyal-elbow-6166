package com.masai.Main;

import com.masai.Exceptions.BusException;
import com.masai.Exceptions.TicketException;

public class Main {

	public static void main(String[] args) {
		System.out.println("         ********************** Welcome to Bus Registration Application **********************       ");
		try {
			try {
				HRM.selectOption();
			} catch (TicketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (BusException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
