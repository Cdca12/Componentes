package componentes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Contreras
 */
public class JCombosDependientes extends JPanel implements ItemListener {

    private RandomAccessFile archivoEstados, archivoMunicipios, archivoCiudades;
    private final String defaultValueCmbEstados = "Seleccione estado",
            defaultValueCmbMunicipios = "Seleccione municipio",
            defaultValueCmbCiudades = "Selecciona ciudad";
    private final int LONGITUD_ESTADO = 56,
            LONGITUD_MUNICIPIO = 60,
            LONGITUD_CIUDAD = 21;

    private JLabel lbEstados, lbMunicipios, lbCiudades;
    private JComboBox cmbEstados, cmbMunicipios, cmbCiudades;

    public JCombosDependientes() {
        initComponents();
        addListeners();
    }

    public JCombosDependientes(String defaultValueCmbEstados) {
        this(); // Manda a llamar constructor por default
        this.cmbEstados.removeAllItems();
        this.cmbEstados.addItem(defaultValueCmbEstados);
        this.cmbEstados.removeItemListener(this);
    }

    public JCombosDependientes(String defaultValueCmbEstados, String defaultValueCmbMunicipios) {
        this();
        this.cmbEstados.removeAllItems();
        this.cmbEstados.addItem(defaultValueCmbEstados);
        this.cmbEstados.removeItemListener(this);
        
        this.cmbMunicipios.removeAllItems();
        this.cmbMunicipios.addItem(defaultValueCmbMunicipios);
        this.cmbMunicipios.removeItemListener(this);
        
    }

    public JCombosDependientes(String defaultValueCmbEstados, String defaultValueCmbMunicipios, String defaultValueCmbCiudades) {
        this();
        this.cmbEstados.removeAllItems();
        this.cmbEstados.addItem(defaultValueCmbEstados);
        
        this.cmbMunicipios.removeAllItems();
        this.cmbMunicipios.addItem(defaultValueCmbMunicipios);
        this.cmbMunicipios.removeItemListener(this);
        
        this.cmbCiudades.removeAllItems();
        this.cmbCiudades.addItem(defaultValueCmbCiudades);
        this.cmbCiudades.removeItemListener(this);
    }

    public void initComponents() {
        try {
            // Cargar archivos
            archivoEstados = new RandomAccessFile("./src/componentes/Files/estados.dat", "rw");
            archivoMunicipios = new RandomAccessFile("./src/componentes/Files/municipios.dat", "rw");
            archivoCiudades = new RandomAccessFile("./src/componentes/Files/ciudades.dat", "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("Error al cargar los archivos");
        }

        setLayout(new FlowLayout());
        lbEstados = new JLabel("Estados");
        add(lbEstados);

        cmbEstados = new JComboBox<>();
        cmbEstados.setPreferredSize(new Dimension(120, 25));
        cmbEstados.insertItemAt(defaultValueCmbEstados, 0);
        cmbEstados.setSelectedIndex(0);
        add(cmbEstados);

        cargarEstados();

        lbMunicipios = new JLabel("Municipios");
        add(lbMunicipios);

        cmbMunicipios = new JComboBox<>();
        cmbMunicipios.setPreferredSize(new Dimension(120, 25));
//        cmbMunicipios.insertItemAt(defaultValueCmbMunicipios, 0);
        add(cmbMunicipios);

        lbCiudades = new JLabel("Ciudades");
        add(lbCiudades);

        cmbCiudades = new JComboBox<>();
        cmbCiudades.setPreferredSize(new Dimension(120, 25));
//        cmbCiudades.insertItemAt(defaultValueCmbCiudades, 0);
        add(cmbCiudades);

    }

    public void addListeners() {
        cmbEstados.addItemListener(this);
        cmbMunicipios.addItemListener(this);
        cmbCiudades.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        if (evt.getStateChange() != ItemEvent.SELECTED) { // Evita que se disparen otros eventos
            return;
        }
        String id = "", seleccion = (String) evt.getItem();
        if (evt.getSource() == cmbEstados) {
            cmbMunicipios.removeItemListener(this);
            if (seleccion.equals(defaultValueCmbEstados)) {
                cmbMunicipios.removeAllItems();
                cmbCiudades.removeAllItems();
                return;
            }
            int posicion = obtenerPosicion(archivoEstados, seleccion, LONGITUD_ESTADO);
            try {
                archivoEstados.seek((posicion - 1) * LONGITUD_ESTADO);
                id = archivoEstados.readUTF();
            } catch (IOException ex) {
                System.out.println("Error al cargar municipios");
            }
            cmbMunicipios.removeAllItems();
            cmbCiudades.removeAllItems();
            cargarMunicipios(id);
            cmbMunicipios.insertItemAt(defaultValueCmbMunicipios, 0);
            cmbMunicipios.setSelectedIndex(0);
            cmbMunicipios.addItemListener(this);
            return;
        }

        if (evt.getSource() == cmbMunicipios) {
            cmbCiudades.removeItemListener(this);
            if (seleccion.equals(defaultValueCmbMunicipios)) {
                cmbCiudades.removeAllItems();
                return;
            }
            int posicion = obtenerPosicion(archivoMunicipios, seleccion, LONGITUD_MUNICIPIO);
            try {
                archivoMunicipios.seek((posicion - 1) * LONGITUD_MUNICIPIO);
                archivoMunicipios.readUTF();
                id = archivoMunicipios.readUTF();
            } catch (IOException ex) {
                System.out.println("Error al cargar ciudades");
            }
            cmbCiudades.removeAllItems();
            cargarCiudades(id);
            cmbCiudades.insertItemAt(defaultValueCmbCiudades, 0);
            cmbCiudades.setSelectedIndex(0);
            cmbCiudades.addItemListener(this);
            return;
        }
    }

    public void cargarEstados() {
        try {
            int lengthArchivoEstados = (int) (archivoEstados.length() / LONGITUD_ESTADO);
            for (int i = 0; i < lengthArchivoEstados; i++) {
                archivoEstados.seek((i * LONGITUD_ESTADO) + 4); // + 4 saltandome los ID
                cmbEstados.addItem(archivoEstados.readUTF().trim()); // trim quita espacios
            }
        } catch (IOException ex) {
            System.out.println("No se pudieron cargar los estados");
        }
    }

    public void cargarMunicipios(String idEstado) {
        String comparador;
        boolean bandera = false;
        try {
            int lengthArchivoMunicipios = (int) (archivoMunicipios.length() / LONGITUD_MUNICIPIO);
            for (int i = 0; i < lengthArchivoMunicipios; i++) {
                archivoMunicipios.seek(i * LONGITUD_MUNICIPIO);
                comparador = archivoMunicipios.readUTF();
                if (!comparador.equals(idEstado)) {
                    if (bandera) { // Si la bandera es true, terminar la búsqueda
                        return;
                    }
                    continue;
                }
                bandera = true;
                archivoMunicipios.readUTF();
                cmbMunicipios.addItem(archivoMunicipios.readUTF().trim());
            }
        } catch (IOException ex) {
            System.out.println("No se pudieron cargar los municipios");
        }
    }

    public void cargarCiudades(String idMunicipio) {
        String comparador;
        boolean bandera = false;
        try {
            int lengthArchivoCiudades = (int) (archivoCiudades.length() / LONGITUD_CIUDAD);
            for (int i = 0; i < lengthArchivoCiudades; i++) {
                archivoCiudades.seek(i * LONGITUD_CIUDAD);
                archivoCiudades.readUTF(); // Lectura en falso para posicionarse
                comparador = archivoCiudades.readUTF();
                if (!comparador.equals(idMunicipio)) {
                    if (bandera) { // Si la bandera es true, terminar la búsqueda
                        return;
                    }
                    continue;
                }
                bandera = true;
                archivoCiudades.readUTF();
                cmbCiudades.addItem(archivoCiudades.readUTF().trim());
            }
        } catch (IOException ex) {
            System.out.println("No se pudieron cargar las ciudades");
        }
    }

    public int obtenerPosicion(RandomAccessFile archivo, String cadena, int longitud) {
        int posicionador;
        if (archivo == archivoEstados) {
            posicionador = 4;
        } else if (archivo == archivoMunicipios) {
            posicionador = 8;
        } else {
            posicionador = 12;
        }
        try {
            int longitudArchivo = (int) (archivo.length() / longitud);
            for (int i = 0; i < longitudArchivo; i++) {
                archivo.seek((i * longitud) + posicionador);
                if (archivo.readUTF().trim().equals(cadena)) {
                    return i + 1;
                }
            }
            return -1; // No encontró
        } catch (IOException ex) {
            System.out.println("No se pudo obtener la longitud del archivo");
            return -1;
        }
    }
}
