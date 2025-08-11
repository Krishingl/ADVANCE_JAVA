package com.krush.vehical_model.elc;

import java.util.Scanner;

import com.krush.vehic_meodel.blc.Driver;
import com.krush.vehic_meodel.blc.Vehicle;

public class BusDepoWithReflectionAPI {

	public static void main(String[] args) {
		
		
		Driver ki = new Driver();
		
		Scanner sc = new Scanner(System.in);
		
		  System.out.print("Enter Vehicle name : ");

		  String vName = sc.next();
		  
		  
		  try(sc) {
	      Class cls = Class.forName(vName);//Class is loaded into JVM
			
			      try {
					Object obj = cls.newInstance();//Instanting Loaded class
					
					if(obj instanceof Vehicle)
					{
						Vehicle vehicle =(Vehicle)obj;
						ki.drive(vehicle);
						
					}else {
						System.out.println("Vehicle name is not found..");
					}
					
					
					
					
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		 
	}

}
