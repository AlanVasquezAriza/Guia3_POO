import javax.swing.JOptionPane;

public class administrador extends Usuario{

    // Instancias
    private int salario;
    
    // Constructor
    public administrador() {
        
        // Valida que se ingrese un numero
        for(int i = 0; i < 2; i++){
            String salarioS = JOptionPane.showInputDialog("Salario");
            if(salarioS.substring(0).matches("[0-9]+")) {
                this.salario = Integer.parseInt(salarioS);
                break;
           }
           else {
                JOptionPane.showMessageDialog(null, "Ingresa un valor válido");
               i--;
               continue;
           }
        }    
    }
    
    // Metodos
    @Override
    public void consultarInfoPersonal(){
        JOptionPane.showMessageDialog(null, "Nombre: " + this.nombres + "\nApellido: " + this.apellidos + "\nID: " + this.ID + "\nSalario: " + this.salario + "\nDireccion: " + this.direccion);
    }
}