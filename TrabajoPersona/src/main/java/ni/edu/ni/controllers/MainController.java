/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ni.edu.uni.views.MainFrame;
import ni.edu.uni.views.PersonForm;

/**
 *
 * @author Comtech
 */
public class MainController implements ActionListener{
    MainFrame mainFrame;

    public MainController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch(event.getActionCommand()){
            case "persona":
                showPersonForm();
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }
    private void showPersonForm(){
        PersonForm pf = new PersonForm();
        mainFrame.showChild(pf, false);
    }
    
    
}
