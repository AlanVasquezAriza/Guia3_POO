import java.util.Hashtable;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        Hashtable<Integer, Object> Estudiantes = new Hashtable<>();
        Hashtable<Integer, Object> Docentes = new Hashtable<>();
        Hashtable<Integer, Object> Administrativo = new Hashtable<>();
        
        // Para configurar las posiciones
        int numE = 0;
        int numD = 0;
        int numA = 0;
        
        while(true){

            int caso = 0;

            // Valida que se coloque un numero
            for(int i = 0; i < 2; i++){
                String casoS = JOptionPane.showInputDialog("1. Registrar Estudiante \n2. Registrar Docente \n3. Registrar Administrador \n4. Mostrar Estudiantes \n5. Mostrar Docente \n6. Mostrar Administrador \n7. Pago matricula \n8. Remover usuario \n9. Salir");
                if(casoS.substring(0).matches("[0-9]+")) {
                   caso = Integer.parseInt(casoS);
                   break;
               }
               else {
                   JOptionPane.showMessageDialog(null, "Ingresa un valor válido");
                   i--;
                   continue;
               }
            }
            
            
            // Salida
            if(caso == 9){
                JOptionPane.showMessageDialog(null,"Adios");
                break;
            }
            
            switch(caso){
                case 1:  
                    // Coloca un elemento en el hashtable de los usuarios
                    Estudiantes.put(numE, new estudiante());
                    // Ubicacion del objeto
                    numE++;
                    break;
                case 2:
                    // Coloca un elemento en el hashtable de la libreria
                    Docentes.put(numD, new docente());
                    // Ubicacion del objeto
                    numD++;
                    break;
                case 3:
                    // Coloca un elemento en el hashtable de la libreria
                    Administrativo.put(numA, new administrador());
                    // Ubicacion del objeto
                    numA++;
                    break;
                case 4:
                    // Interar en la hashtable con un objeto
                    for (int i = 0; i < numE; i++){
                        Object objeto = Estudiantes.get(i);
                        ((estudiante)objeto).consultarInfoPersonal();
                    }    
                    break;

                case 5:
                    // Interar en la hashtable con un objeto
                    for (int i = 0; i < numD; i++){
                        Object objeto = Docentes.get(i);
                        ((docente)objeto).consultarInfoPersonal();;
                    }   
                    break;
                case 6:
                    // Interar en la hashtable con un objeto
                    for (int i = 0; i < numA; i++){
                        Object objeto = Administrativo.get(i);
                        ((administrador)objeto).consultarInfoPersonal();
                    }    
                    break;

                case 7:
                    // Interar en la hashtable con un objeto
                    System.out.println();
                    for (int i = 0; i < numE; i++){
                        Object objeto = Estudiantes.get(i);
                        // Muestra solo los estudiantes que no tienen matricula
                        if(((estudiante)objeto).matricula == false){
                            System.out.println(i + " " + ((estudiante)objeto).nombres + " " + ((estudiante)objeto).apellidos); 
                        }else{
                            continue;
                        }    
                    }
                    // Ingresar usuario
                        String estudianteS = JOptionPane.showInputDialog("Ingrese un estudiante: ");
                        int estudiante = Integer.parseInt(estudianteS);
                        // Matricula paga
                        Object objeto2 = Estudiantes.get(estudiante);
                        ((estudiante)objeto2).pagarMatricula();   
                    break;
                
                case 8:
                    for(int i = 0; i < 2; i++){
                        String casoS = JOptionPane.showInputDialog("1. Eliminar Estudiante \n2. Eliminar Docente \n3. Eliminar Administrador");
                        if(casoS.substring(0).matches("[0-9]+")) {
                            caso = Integer.parseInt(casoS);
                            break;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Ingresa un valor válido");
                            i--;
                            continue;
                        }
                    }
                    // Estudiante
                    if(caso == 1){
                        Usuario.removerUsuario(Estudiantes, numE);
                        numE--;
                    }

                    // Docente
                    else if(caso == 2){
                        Usuario.removerUsuario(Docentes, numD);
                        numD--;
                    }

                    // Administrador
                    else if(caso == 3){
                        Usuario.removerUsuario(Administrativo, numA);
                        numA--;
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "No se pudo realizar el proceso");
                    }
                    break;
                    

                default:
                    JOptionPane.showMessageDialog(null,"Opcion incorrecta");
            }
        }
    }
}
