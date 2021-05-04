package application;

import model.*;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		//Instanciación de los controladores
		
		AdminManager adminManager = new AdminManagerMySQLImplementation();
		WorkerManager workerManager = new WorkerManagerMySQLImplementation();
		BuyerManager buyerManager = new BuyerManagerMySQLImplementation();
		
		//Pantalla principal
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);

	}

}
