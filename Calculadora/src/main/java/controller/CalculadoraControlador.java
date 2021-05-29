package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import views.CalculadoraForm;
/**
 *
 * @author Ervin
 */
public class CalculadoraControlador implements ActionListener{
    private final CalculadoraForm calc;
    public CalculadoraControlador(CalculadoraForm f){
        calc = f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "0":  case "1": case "2": case "3":
            case "4":  case "5": case "6": case "7":
                printNumber(e);
                break;
            case "+": case"-": case"*": case"/":
                break;
        }
    }
    
    private void printNumber(ActionEvent evet){
        JButton b = (JButton)evet.getSource();
        if(calc.isFreeToStart()){
            
        }
    }
}
