import javax.swing.JOptionPane;

public class estudiante extends Usuario{

    // Instancias
    private int codigo;
    public boolean matricula;

    // Constructor
    public estudiante() {
        this.matricula = false;

        // Valida que se ingrese un numero
        for(int i = 0; i < 2; i++){
            String codigoS = JOptionPane.showInputDialog("Codigo: ");
            if(codigoS.substring(0).matches("[0-9]+")) {
                this.codigo = Integer.parseInt(codigoS);
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
        JOptionPane.showMessageDialog(null, "Nombre: " + this.nombres + "\nApellido: " + this.apellidos + "\nID: " + this.ID + "\nCodigo: " + this.codigo + "\nDireccion: " + this.direccion + "\nMatricula paga: " + (matricula?"si":"no"));
    }

    public void pagarMatricula(){
        this.matricula = !this.matricula;
    }
}