import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class Pantalla{
    private int turno;
     private VetoableChangeSupport controladora;
    
    public Pantalla(){
        turno=0;
        this.controladora= new VetoableChangeSupport(this);
    }

    public void nuevoObservador(VetoableChangeListener listener){
        this.controladora.addVetoableChangeListener(listener);
    }
    public void eliminarObservador(VetoableChangeListener listener){
        this.controladora.removeVetoableChangeListener(listener);
    }
    public void setTurno(int turno) throws PropertyVetoException{
        //firePropertyChange: para emitir un cambio en una de sus propiedades, en este caso en turno
        controladora.fireVetoableChange("turno", this.turno, turno);
        this.turno=turno;
    }
    public int getTurno(){
        return turno;
    }
}