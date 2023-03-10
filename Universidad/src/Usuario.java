import java.util.Hashtable;
import javax.swing.JOptionPane;

class Usuario {
    // instancias
    protected int ID;
    protected String tipoID;
    protected String nombres;
    protected String apellidos;
    protected String direccion;

    // Constructor
    public Usuario() {
        this.nombres = JOptionPane.showInputDialog("Nombre: ");
        this.apellidos = JOptionPane.showInputDialog("Apellidos: ");

        // Valida que se ingrese un numero
        for (int i = 0; i < 2; i++) {
            String IDs = JOptionPane.showInputDialog("Ingresar ID: ");
            if (IDs.substring(0).matches("[0-9]+")) {
                this.ID = Integer.parseInt(IDs);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa un valor válido");
                i--;
                continue;
            }
        }

        this.tipoID = JOptionPane.showInputDialog("Tipo de ID: ");
        this.direccion = JOptionPane.showInputDialog("Direccion: ");
    }

    // Metodos

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getID() {
        return ID;
    }

    public String getTipoID() {
        return tipoID;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void consultarInfoPersonal() {
        JOptionPane.showMessageDialog(null, "Nombre: " + this.nombres + "\nApellido: " + this.apellidos + "\nID: "
                + this.ID + "\nDireccion: " + this.direccion);
    }

    public static int removerUsuario(Hashtable<Integer, Object> tabla, int numU) {

        // Muestra a los usuarios
        System.out.println();
        for (int i = 0; i < numU; i++) {
            Object objeto = tabla.get(i);
            System.out.println(i + " " + ((estudiante) objeto).nombres + " " + ((estudiante) objeto).apellidos);
        }

        // Ingresar usuario
        // Valida que se coloque un numero
        int user = 0;
        for(int i = 0; i < 2; i++){
            String userS = JOptionPane.showInputDialog("Ingrese el usuario: ");
            if(userS.substring(0).matches("[0-9]+")) {
                user = Integer.parseInt(userS);
               break;
           }
           else {
               JOptionPane.showMessageDialog(null, "Ingresa un valor válido");
               i--;
               continue;
           }
        }
        
        // Elimina al usuario si existe
        if (tabla.containsKey(user)) {
            Object objeto = tabla.remove(user);
            System.out.println("Valores actualizados correctamente.");
            numU = numU-1;
            
        } else {
            System.out.println("La clave " + user + " no existe en la tabla.");
        }
        return numU;
    }
}