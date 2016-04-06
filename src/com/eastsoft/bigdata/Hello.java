package com.eastsoft.bigdata;
import java.lang.Thread;

public class Hello {
	public static void main(String[] args){
		System.out.println("Start..." + "Ñ§ºÃJAVA¡£");

		try{
			System.out.println("sleep(1000)...");
			Thread.sleep(1000);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("end.");
	}

}
