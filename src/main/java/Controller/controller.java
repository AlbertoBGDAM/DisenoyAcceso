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
import com.formdev.flatlaf.intellijthemes.FlatGradiantoMidnightBlueIJTheme;

public class controller {
	static inicio in = new inicio();
	static Interior main = new Interior();

	public static void main(String[] args) {
		in.main();

	}

	public static void abrirMainFrame() {
		in.dispose();
		main.main();
	}
}