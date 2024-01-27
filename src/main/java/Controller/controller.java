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

public class controller {
    private static inicio instancia = new inicio();

    public static void main(String[] args) {
        instancia.setVisible(true);
    }

    public static void abrirMainFrame() {
        // Cerrar el JFrame actual
        if (instancia != null) {
            instancia.dispose();
        }

        // Crear e mostrar el nuevo JFrame (Main)
        main mainFrame = new main();
        mainFrame.setVisible(true);
    }
}


