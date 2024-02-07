/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

/**
 *
 * @author ALBERTO BARCALA GUTIÉRREZ
 */
import View.*;
import hibernate.Usuario;

public class controller {
	static inicio in = new inicio();
	static App main;
	public static void main(String[] args) {
		in.main();
	}

	public static void abrirMainFrame() {
		Usuario us=in.getuser();
                in.dispose();
                main.setUser(us);
		main=new App();
	}
        public static void salir(){
            main.dispose();
        }
}