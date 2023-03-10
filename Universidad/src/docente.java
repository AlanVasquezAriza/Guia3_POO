import javax.swing.JOptionPane;

public class docente extends Usuario{

    // Instancias
    private int escalaton;
    
    // Constructor
    public docente() {
        for(int i = 0; i < 2; i++){
            String escalatonS = JOptionPane.showInputDialog("Escalaton: ");
            if(escalatonS.substring(0).matches("[0-9]+")) {
                this.escalaton = Integer.parseInt(escalatonS);
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
        JOptionPane.showMessageDialog(null, "Nombre: " + this.nombres + "\nApellido: " + this.apellidos + "\nID: " + this.ID + "\nEscalaton: " + this.escalaton + "\nDireccion: " + this.direccion);
    }
}