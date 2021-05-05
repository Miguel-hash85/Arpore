package application;

import model.*;
import view.MainWindow;
import view.WorkerWindow;

public class Main {

	public static void main(String[] args) {
		//Instanciación de los controladores
		
		AdminManager adminManager = new AdminManagerMySQLImplementation();
		WorkerManager workerManager = new WorkerManagerMySQLImplementation();
		BuyerManager buyerManager = new BuyerManagerMySQLImplementation();
		
		//Pantalla principal
		/*
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		*/
		
		WorkerWindow workerWindow = new WorkerWindow();
		workerWindow.setVisible(true);

	}

}
