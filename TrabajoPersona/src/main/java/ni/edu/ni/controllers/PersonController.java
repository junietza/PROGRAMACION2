/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ni.edu.ni.models.Person;
import ni.edu.uni.views.PersonForm;

/**
 *
 * @author Comtech
 */
public class PersonController implements ActionListener, FocusListener {

    PersonForm personFrame;
    JComboBox dComboBox;
    JComboBox mComboBox;
    JFileChooser d;
    Person person;
    String[] departments = new String[]{
        "Boaco", "Carazo", "Chinandega", "Chontales",
        "Costa Caribe Norte", "Costa Caribe Sur",
        "Estelí", "Granada", "Jinotega", "León",
        "Madriz", "Managua", "Masaya", "Matagalpa",
        "Nueva Segovia", "Río San Juan", "Rivas"};
    String[] masayaMunicipalities = new String[]{
        "Masaya", "Nindirí", "Catarina", "Masatepe",
        "La concepción", "Tisma", "Nandasmo",
        "San Juan de Oriente","Niquinohomo"};
    String[] managuaMunicipalities = new String[]{
        "Managua", "Ciudad Sandino", "El crucero",
        "Mateare", "San Francisco Libre",
        "San Rafael del Sur", "Ticuantepe", "Tipitapa", "Villa el Carmen"};
    String[] granadaMunicipalities = new String[]{
        "Granada", "Diriomo", "Diriá", "Nandaime"};
    String[] leonMunicipalities = new String[]{
        "León", "Achuapa", "El Jicaral", "El Sauce",
        "La Paz Centro", "Larreynaga", "Telica",
        "Nagarote", "Quezalguaque", "Santa Rosa del Peñón"};
    String[] rivasMunicipalities = new String[]{
        "Rivas", "Altagracia", "Belén", "Buenos Aires",
        "Cárdenas", "Moyogalpa", "Potosí", "San Jorge",
        "San Juan del Sur", "Tola"};
    String[] boacoMunicipalities = new String[]{
        "Boaco", "Camoapa" , "San Josè de los remates", "San Lorenzo",
        "Santa Lucía", "Teustepe"};
    String[] carazoMunicipalities = new String[]{
        "Diriamba", "Dolores", "El Rosario", "Jinotepe", "La Conquista",
        "La paz de oriente", "San Marcos", "Santa Teresa"};
    String[] chinandegaMunicipalities = new String[]{
        "Chichigalpa", "Chinandega", "Cinco Pinos", "Corinto",
        "El Realejo", "El Viejo", "Posoltega", "Puerto MOrazán",
        "San Francisco del Norte", "San Pedro del NOrte",
        "Santo Tomás del Norte", "Somotillo", "Villanueva"};
    String[] chontalesMunicipalities = new String[]{
        "Acoyapa", "Comalapa", "Cuapa","El Coral", "Juigalpa",
        "La Libertad", "San Pedro del Lóvago", "Santo Domingo",
        "Santo Tomás", "Villa Sandino"};
    String[] costaCaribeNorteMunicipalities = new String[]{
        "Bonanza", "Mulukukú", "Prinzapolka", "Puerto Cabezas",
        "Rosita", "Siuna", "Waslala", "Waspán"};
    String[] costaCaribeSurMunicipalities = new String[]{
        "Bluefields", "Desembocadura de Río Grande", "El Ayote",
        "El Rama", "El Tortuguero", "Islas del Maíz", "Kukra Hill",
        "La Cruz del Río Grande", "Laguna de Perlas",
        "Muelle de los Bueyes", "Nueva Guinea", "Paiwas"};
    String[] esteliMunicipalities = new String[]{
        "Condega", "Estelí", "La Trinidad", "Pueblo Nuevo",
        "San Juan de Limay", "San Nicolás"};
    String[] jinotegaMunicipalities = new String[]{
        "El Cúa", "Jinotega", "La Concordia", "San josé de Bocay",
        "San Rafael del Norte", "San Sebastián de Yalí",
        "Santa María ed Pantasma", "Wiwilí de Jinotega"};
    String[] madrizMunicipalities = new String[]{
        "Las Sabanas", "Palacagüina", "San josé de Cusmapa", "San Juan del Río Coco",
        "San Lucas", "Somoto", "Telpaneca", "Totogalpa", "Yalagüina"};
    String[] matagalpaMunicipalities = new String[]{
        "Ciudad Darío", "El Tuma - La Dalia", "Esquipulas", "Matagalpa", "Matiguás",
        "Muy Muy", "Rancho Grande", "Río Blanco", "San Dionisio",
        "San Isidro", "San Ramón", "Sébaco", "Terrabona"};
    String[] nuevaSegoviaMunicipalities = new String[]{
        "Ciudad Antigua", "Dipilto", "El Jícaro", "Jalapa", "Macuelizo",
        "Mozonte", "Murra", "Ocotal", "Quilalí", "San Fernando",
        "Santa María", "Wiwilí"};
    String[] rioSanJuanMunicipalities = new String[]{
        "El Almendro", "El Castillo", "Morrito", "San Carlos",
        "San Juan del Norte", "San Miguelito"};
    DefaultComboBoxModel departmentComboBoxModel = new DefaultComboBoxModel<>(departments);

    public PersonController(PersonForm f) {
        super();
        personFrame = f;
        d = new JFileChooser();
        person = new Person();
    }

    public void setPerson(Person b) {
        person = b;
    }

    public void setPerson(String filePath) {
        File f = new File(filePath);
        readPerson(f);
    }

    public Person getPerson() {
        return person;
    }

    public void setDepartmentComboBox(JComboBox jcombo) {
        dComboBox = jcombo;
        dComboBox.setModel(departmentComboBoxModel);
    }

    public void setMunicipalityComboBox(JComboBox jcombo) {
        mComboBox = jcombo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass().getName().equals(JComboBox.class.getName()))
        {
            JComboBox cbo = (JComboBox)e.getSource();
            switch(cbo.getName()){
                case "department":
                    switch(cbo.getSelectedItem().toString()) {
                        case "Boaco":
                            mComboBox.setModel(new DefaultComboBoxModel(boacoMunicipalities));
                            break;
                        case "Carazo":
                            mComboBox.setModel(new DefaultComboBoxModel(carazoMunicipalities));
                            break;
                        case "Chinandega":
                            mComboBox.setModel(new DefaultComboBoxModel(chinandegaMunicipalities));
                            break;
                        case "Chontales":
                            mComboBox.setModel(new DefaultComboBoxModel(chontalesMunicipalities));
                            break;
                        case "Costa Caribe Norte":
                            mComboBox.setModel(new DefaultComboBoxModel(costaCaribeNorteMunicipalities));
                            break;
                        case "Costa Caribe Sur":
                            mComboBox.setModel(new DefaultComboBoxModel(costaCaribeSurMunicipalities));
                            break;
                        case "Estelí":
                            mComboBox.setModel(new DefaultComboBoxModel(esteliMunicipalities));
                            break;
                        case "Granada":
                            mComboBox.setModel(new DefaultComboBoxModel(granadaMunicipalities));
                            break;
                        case "Jinotega":
                            mComboBox.setModel(new DefaultComboBoxModel(jinotegaMunicipalities));
                            break;
                        case "León":
                            mComboBox.setModel(new DefaultComboBoxModel(leonMunicipalities));
                            break;
                        case "Madriz":
                            mComboBox.setModel(new DefaultComboBoxModel(madrizMunicipalities));
                            break;
                        case "Managua":
                            mComboBox.setModel(new DefaultComboBoxModel(managuaMunicipalities));
                            break;
                        case "Masaya":
                            mComboBox.setModel(new DefaultComboBoxModel(masayaMunicipalities));
                            break;
                        case "Matagalpa":
                            mComboBox.setModel(new DefaultComboBoxModel(matagalpaMunicipalities));
                            break;
                        case "Nueva Segovia":
                            mComboBox.setModel(new DefaultComboBoxModel(nuevaSegoviaMunicipalities));
                            break;
                        case "Río San Juan":
                            mComboBox.setModel(new DefaultComboBoxModel(rioSanJuanMunicipalities));
                            break;
                        case "Rivas":
                            mComboBox.setModel(new DefaultComboBoxModel(rivasMunicipalities));
                            break;
                        default:
                            mComboBox.setModel(new DefaultComboBoxModel(new String[]{}));
                            break;
                    }
                    break;
            }
        } else {
            switch (e.getActionCommand()) {
                case "save":
                    d.showSaveDialog(personFrame);
                    person = personFrame.getPersonData();
                    writePerson(d.getSelectedFile());
                    break;
                case "select":
                    d.showOpenDialog(personFrame);
                    person = readPerson(d.getSelectedFile());
                    personFrame.setPersonData(person);
                    break;
                case "clear":
                    personFrame.clear();
                    break;

            }
        }
    }

    @Override
    public void focusGained(FocusEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void writePerson(File file) {
        try {
            ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream(file));
            w.writeObject(getPerson());
            w.flush();
        } catch (IOException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Person readPerson(File file) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            return (Person) ois.readObject();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(personFrame, e.getMessage(), personFrame.getTitle(), JOptionPane.WARNING_MESSAGE);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Person[] readPersonList(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        Person[] persons;
        try (FileInputStream in = new FileInputStream(file);
                ObjectInputStream s = new ObjectInputStream(in)) {
            persons = (Person[]) s.readObject();
        }
        return persons;
    }

}
