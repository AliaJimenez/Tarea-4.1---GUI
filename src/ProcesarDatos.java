/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alian
 */

public class ProcesarDatos {
    private String matricula;
    private String nombres;
    private String apellidos;
    private String cuatrimestre;
    
    public ProcesarDatos(){
        this.matricula = "";
        this.nombres = "";
        this.apellidos = "";
        this.cuatrimestre = "";
    }
    
    public void capturarDatos(String matricula, String nombres, String apellidos, String cuatrimestre) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cuatrimestre = cuatrimestre;
    }
    
    public String presentarDatos() {
        // Si no hay datos guardados, muestra un mensaje
        if (matricula.isEmpty() || nombres.isEmpty()) {
            return "No hay datos guardados.\nPrimero presiona el botón Capturar.";
        }
        
        String texto = "";
        
        texto += "═════════════════════════════════\n";
        texto += "    DATOS DEL PARTICIPANTE\n\n";
        texto += "Matrícula:    " + matricula + "\n";
        texto += "Nombres:      " + nombres + "\n";
        texto += "Apellidos:    " + apellidos + "\n";
        texto += "Cuatrimestre: " + cuatrimestre + "\n";
        texto += "\n═════════════════════════════════";
        
        return texto;
    }
    
    public void limpiarDatos() {
        this.matricula = "";
        this.nombres = "";
        this.apellidos = "";
        this.cuatrimestre = "";
    }
}
