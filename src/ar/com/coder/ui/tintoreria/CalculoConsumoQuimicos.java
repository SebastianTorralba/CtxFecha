/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.tintoreria;

import ar.com.coder.Principal;
import ar.com.coder.dominio.ArticuloControlador;
import ar.com.coder.dominio.BarcadaControlador;
import ar.com.coder.dominio.ColorControlador;
import ar.com.coder.dominio.MaquinaControlador;
import ar.com.coder.dominio.RecetaControlador;
import ar.com.coder.dominio.RutaControlador;
import ar.com.coder.dominio.excel.ExcelSimuladorConsumo;
import ar.com.coder.objetos.Articulo;
import ar.com.coder.objetos.ArticuloProduccion;
import ar.com.coder.objetos.TipoArticulo;
import ar.com.coder.objetos.tintoreria.Color;
import ar.com.coder.objetos.tintoreria.Maquina;
import ar.com.coder.objetos.tintoreria.NodoRuta;
import ar.com.coder.objetos.tintoreria.NodoRutaColor;
import ar.com.coder.objetos.tintoreria.NodoRutaDetalle;
import ar.com.coder.objetos.tintoreria.Receta;
import ar.com.coder.objetos.tintoreria.Ruta;
import ar.com.coder.ui.IActualizable;
import ar.com.coder.ui.grillas.CalculoConsumoQuimicoGrilla;
import ar.com.coder.ui.grillas.RecetaGrilla;
import ar.com.coder.ui.grillas.RutaColorGrilla;
import ar.com.coder.ui.grillas.RutaGrilla;
import ar.com.coder.ui.grillas.editors.EtapaProductivaCellEditor;
import ar.com.coder.ui.grillas.editors.MaquinaColorCellEditor;
import ar.com.coder.ui.grillas.editors.MaquinaCellEditor;
import ar.com.coder.ui.grillas.renders.RutaRenderer;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sysadmin
 */
public class CalculoConsumoQuimicos extends javax.swing.JInternalFrame implements IActualizable {

    //private NodoRutaDetalleControlador psc;
    private ArticuloControlador articuloControlador;
    private RecetaControlador recetaControlador;
    private MaquinaControlador maquinaControlador;
    private RutaControlador rutaControlador;
    private ArrayList<NodoRuta> nodos = new ArrayList<>();
    private ArrayList<NodoRutaColor> nodosColor = new ArrayList<>();
    private ArrayList<Color> colores;
    private ArrayList<NodoRutaDetalle> datos = new ArrayList<>();
    private ArrayList<Receta> recetas;
    private ArrayList<Articulo> articulos;
    private ArrayList<Maquina> maquinas;
    private int[] filaSeleccionadas;
    private final CalculoConsumoQuimicoGrilla consumosQuimicos;
    private TableRowSorter trsGrillaConsumosQuimicos, trsRecetasDisponibles, trsNodosRuta;
    private BarcadaControlador barcadaControlador;
    private DefaultComboBoxModel dcbmArticulos;
//private ExcelNodoRutaDetalle excelNodoRutaDetalle=new ExcelNodoRutaDetalle();
    private ArticuloProduccion ap;
    private final MaquinaCellEditor maquinaNodoCellEditor;
    private final EtapaProductivaCellEditor etapaProductivaCellEditor;
    private final MaquinaColorCellEditor maquinaColorCellEditor;
    private int metros;
    private float kilos;
    private DataFlavor dfReceta = new DataFlavor(Receta.class, "Receta");
    private ExcelSimuladorConsumo excelSimuladorConsumo;
    private ColorControlador colorControlador;

    /**
     * Creates new form GrillaNodoRutaDetalle
     */
    public CalculoConsumoQuimicos() {

        initComponents();
        this.trsGrillaConsumosQuimicos = new TableRowSorter<CalculoConsumoQuimicoGrilla>();
        this.trsRecetasDisponibles = new TableRowSorter();
        this.trsNodosRuta = new TableRowSorter();
        barcadaControlador = new BarcadaControlador(Principal.conexionInfotint);
        maquinaControlador = new MaquinaControlador(Principal.conexionInfotint);
        colorControlador = new ColorControlador(Principal.conexionInfotint);
        rutaControlador = new RutaControlador(Principal.connection);
        maquinas = maquinaControlador.extrerTodo();
        colores = colorControlador.extrerTodo();
        articuloControlador = new ArticuloControlador(Principal.conexionInfotint);
        articulos = articuloControlador.extrerTodo(TipoArticulo.PRODUCCION);
        dcbmArticulos = new DefaultComboBoxModel(articulos.toArray());
        jcbArticulo.setModel(dcbmArticulos);
        recetaControlador = new RecetaControlador(Principal.conexionInfotint);
        recetaGrilla = new RecetaGrilla();
        trsRecetasDisponibles.setModel(recetaGrilla);
        excelSimuladorConsumo = new ExcelSimuladorConsumo();
        excelSimuladorConsumo.setDatos(datos);
        consumosQuimicos = new CalculoConsumoQuimicoGrilla();

        trsGrillaConsumosQuimicos.setModel(consumosQuimicos);
        jtRutaConsumo.setModel(consumosQuimicos);
        jtRutaConsumo.setRowSorter(trsGrillaConsumosQuimicos);
        jtRuta.setDefaultRenderer(Maquina.class, new RutaRenderer());
        jtRutaColor.setDefaultRenderer(Object.class, new RutaRenderer());

        maquinaNodoCellEditor = new MaquinaCellEditor(maquinas);
        maquinaNodoCellEditor.setNodos(nodos);
        maquinaNodoCellEditor.setiActualizable(this);
        jtRuta.setDefaultEditor(Maquina.class, maquinaNodoCellEditor);

        etapaProductivaCellEditor = new EtapaProductivaCellEditor(null);
        etapaProductivaCellEditor.setNodos(nodos);
        etapaProductivaCellEditor.setiActualizable(this);
        jtRuta.setDefaultEditor(Maquina.class, maquinaNodoCellEditor);

        maquinaColorCellEditor = new MaquinaColorCellEditor(maquinas, colores);
        maquinaColorCellEditor.setNodos(nodosColor);
        maquinaColorCellEditor.setiActualizable(this);
        jtRutaColor.setDefaultEditor(Object.class, maquinaColorCellEditor);
        rutaGrilla = new RutaGrilla();
        rutaColorGrilla=new RutaColorGrilla();
        actualizar();
    }
    private static final Logger LOG = Logger.getLogger(CalculoConsumoQuimicos.class.getName());

    private void actualizar() {
        //  datos = psc.extrerTodo();
        //excelNodoRutaDetalle.setDatos(datos);
        recetas = recetaControlador.extrerTodoCabecera();
        recetaGrilla.setData(recetas);
        jtRecetasDisponibles.setModel(recetaGrilla);
        recetaGrilla.fireTableDataChanged();
        consumosQuimicos.setData(datos);
        jtRuta.setRowHeight(25);
        consumosQuimicos.fireTableDataChanged();
    }

    public void actualizarRuta() {

        rutaGrilla.setData(nodos);
        actualizarFactor();
        jtRuta.setModel(rutaGrilla);
        if (nodos.size() > 0) {
            trsNodosRuta.setModel(rutaGrilla);
        }
        rutaGrilla.fireTableDataChanged();
        rutaColorGrilla.setData(nodosColor);
        actualizarFactor();
        jtRutaColor.setModel(rutaColorGrilla);
        rutaColorGrilla.fireTableDataChanged();
    }

    private void actualizarFactor() {

        for (NodoRuta nodo : nodos) {
            float litros = kilos * nodo.getMaquina().getFactor();
            if (nodo.getMaquina().getCodigo().equals("R01") || nodo.getMaquina().getCodigo().equals("R02")
                    || nodo.getMaquina().getCodigo().equals("R03") || nodo.getMaquina().getCodigo().equals("I01")
                    || nodo.getMaquina().getCodigo().equals("I02") || nodo.getMaquina().getCodigo().equals("P01")) {
                litros += Maquina.LITROS_FONDO;
            }
            nodo.setLitrosAgua(litros);
        }
        
        for (NodoRutaColor nodo : nodosColor) {
            float litros = kilos * nodo.getMaquina().getFactor();
            if (nodo.getMaquina().getCodigo().equals("R01") || nodo.getMaquina().getCodigo().equals("R02")
                    || nodo.getMaquina().getCodigo().equals("R03") || nodo.getMaquina().getCodigo().equals("I01")
                    || nodo.getMaquina().getCodigo().equals("I02") || nodo.getMaquina().getCodigo().equals("P01")) {
                litros += Maquina.LITROS_FONDO;
            }
            nodo.setLitrosAgua(litros);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recetaGrilla = new ar.com.coder.ui.grillas.RecetaGrilla();
        rutaGrilla = new ar.com.coder.ui.grillas.RutaGrilla();
        calculoConsumoQuimicoGrilla = new ar.com.coder.ui.grillas.CalculoConsumoQuimicoGrilla();
        rutaColorGrilla = new ar.com.coder.ui.grillas.RutaColorGrilla();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbArticulo = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtRecetasDisponibles = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jbQuitar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfAncho = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfGrml = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfMetros = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfKilos = new javax.swing.JTextField();
        jbSimularConsumo = new javax.swing.JButton();
        jlArticulo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfBuscar = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jtpRuta = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtRuta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtRutaColor = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRutaConsumo = new javax.swing.JTable();
        jbExcel = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Reporte de Deposito");

        jLabel1.setText("Articulo:");

        jcbArticulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbArticuloActionPerformed(evt);
            }
        });

        jtRecetasDisponibles.setModel(recetaGrilla);
        jtRecetasDisponibles.setDragEnabled(true);
        jScrollPane4.setViewportView(jtRecetasDisponibles);

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbQuitar.setText("Quitar");
        jbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ancho:");

        jtfAncho.setText("0");
        jtfAncho.setEnabled(false);

        jLabel3.setText("Gr/Ml:");

        jtfGrml.setText("0");
        jtfGrml.setEnabled(false);
        jtfGrml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGrmlActionPerformed(evt);
            }
        });

        jLabel4.setText("Metros:");

        jtfMetros.setText("0");
        jtfMetros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfMetrosFocusLost(evt);
            }
        });
        jtfMetros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMetrosActionPerformed(evt);
            }
        });

        jLabel5.setText("Kilos:");

        jtfKilos.setText("0");
        jtfKilos.setEnabled(false);

        jbSimularConsumo.setText("Simular Consumo");
        jbSimularConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSimularConsumoActionPerformed(evt);
            }
        });

        jLabel6.setText("Buscar");

        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jtRuta.setModel(rutaGrilla);
        jtRuta.setDragEnabled(true);
        jtRuta.setDropMode(javax.swing.DropMode.INSERT_ROWS);
        jtRuta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtRutaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtRuta);
        if (jtRuta.getColumnModel().getColumnCount() > 0) {
            jtRuta.getColumnModel().getColumn(0).setHeaderValue("Orden");
            jtRuta.getColumnModel().getColumn(1).setHeaderValue("Receta");
            jtRuta.getColumnModel().getColumn(2).setHeaderValue("Maquina");
            jtRuta.getColumnModel().getColumn(3).setHeaderValue("Rel. Baño");
            jtRuta.getColumnModel().getColumn(4).setHeaderValue("Litros Agua");
            jtRuta.getColumnModel().getColumn(5).setHeaderValue("Costo $");
        }

        jtpRuta.addTab("Ruta Base", jScrollPane3);

        jtRutaColor.setModel(rutaColorGrilla);
        jScrollPane2.setViewportView(jtRutaColor);

        jtpRuta.addTab("Ruta Color", jScrollPane2);

        jtRutaConsumo.setModel(calculoConsumoQuimicoGrilla);
        jScrollPane1.setViewportView(jtRutaConsumo);

        jbExcel.setText("Exportar a Excel");
        jbExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcelActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtpRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbSimularConsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfGrml, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfMetros, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfKilos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfGrml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfMetros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfKilos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlArticulo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jbAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbQuitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSimularConsumo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtpRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcel)
                    .addComponent(jbCancelar))
                .addGap(84, 84, 84))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtfAncho, jtfGrml, jtfKilos, jtfMetros});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            excelSimuladorConsumo.generarArchivo(file);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbExcelActionPerformed

    private void jtfGrmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGrmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfGrmlActionPerformed

    private void jcbArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbArticuloActionPerformed
        ap = (ArticuloProduccion) jcbArticulo.getSelectedItem();
        jtfAncho.setText(String.valueOf(ap.getAncho()));
        jtfGrml.setText(String.valueOf(ap.getGrml()));
        jlArticulo.setText(ap.getNombre());
        calcularKilos();
        actualizarDatos();
        Ruta ruta = rutaControlador.extraer(ap.getCodigo());
        if (ruta.getArticulo() != null) {
            limpiar();
            cargarNodos(ruta);
            actualizarFactor();
            actualizarRuta();
        }
        simularConsumo();
    }//GEN-LAST:event_jcbArticuloActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        int[] filasSeleccionadas = jtRecetasDisponibles.getSelectedRows();
        if (jtpRuta.getSelectedIndex() == 0) {
            for (int fila : filasSeleccionadas) {
                Receta receta = recetaGrilla.getData().get(fila);
                NodoRuta nodoRuta = new NodoRuta();
                nodoRuta.setReceta(receta);
                nodos.add(nodoRuta);
            }
        }else{
             for (int fila : filasSeleccionadas) {
                Receta receta = recetaGrilla.getData().get(fila);
                NodoRutaColor nodoRutaColor = new NodoRutaColor();
                nodoRutaColor.setReceta(receta);
                nodoRutaColor.setColor(receta.getColor());
                nodosColor.add(nodoRutaColor);
            }
        }

        actualizarRuta();
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitarActionPerformed
        int[] filasSeleccionadas = jtRuta.getSelectedRows();
        for (int fila : filasSeleccionadas) {
            rutaGrilla.getData().remove(fila);
        }
        actualizarRuta();
    }//GEN-LAST:event_jbQuitarActionPerformed

    private void jtfMetrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMetrosActionPerformed
        calcularKilos();
        actualizarDatos();
        actualizarFactor();
    }//GEN-LAST:event_jtfMetrosActionPerformed

    private void calcularKilos() throws NumberFormatException {
        metros = Integer.parseInt(jtfMetros.getText());
        kilos = metros * ap.getGrml() / 1000;
        jtfKilos.setText(String.valueOf(kilos));
    }

    private void jtRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRutaMouseClicked

    }//GEN-LAST:event_jtRutaMouseClicked

    private void jtfMetrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfMetrosFocusLost
        calcularKilos();
        actualizarDatos();

        actualizarFactor();
    }//GEN-LAST:event_jtfMetrosFocusLost

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void limpiar() {
        nodos.clear();
        rutaGrilla.fireTableDataChanged();
    }

    private void jbSimularConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSimularConsumoActionPerformed
        simularConsumo();
    }//GEN-LAST:event_jbSimularConsumoActionPerformed

    private void simularConsumo() {
        datos = new ArrayList<NodoRutaDetalle>();
        for (NodoRuta nr : nodos) {
            barcadaControlador.convertirEnBarcada(nr, kilos, (float) metros);
            barcadaControlador.calcularConsumo();
            barcadaControlador.retornaNodo();
            datos.addAll(nr.getDetalle());
        }
        int fila = jtRutaColor.getSelectedRow();
        if(fila>=0){
            NodoRutaColor nrc = nodosColor.get(fila);
            barcadaControlador.convertirEnBarcada(nrc, kilos, (float) metros);
            barcadaControlador.calcularConsumo();
            barcadaControlador.retornaNodo();
            datos.addAll(nrc.getDetalle());
        }
        excelSimuladorConsumo.setDatos(datos);
        actualizar();
    }

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        String buscar = jtfBuscar.getText();
        List<Receta> recetaFiltrada = recetas.stream()
                .filter(r -> r.getCodigo().contains(buscar))
                .collect(Collectors.toList());
        recetaGrilla.setData((ArrayList<Receta>) recetaFiltrada);
        recetaGrilla.fireTableDataChanged();


    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Desea Grabar la Ruta?", "Atencion!", JOptionPane.OK_CANCEL_OPTION) == 0) {
            Ruta r = new Ruta();
            r.setArticulo(ap);
            for (int i = 0; i < nodos.size(); i++) {
                NodoRuta nodo = nodos.get(i);
                r.agregarNodo(i, nodo);
            }
            rutaControlador.eliminar(r);
            rutaControlador.crear(r);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ar.com.coder.ui.grillas.CalculoConsumoQuimicoGrilla calculoConsumoQuimicoGrilla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcel;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbQuitar;
    private javax.swing.JButton jbSimularConsumo;
    private javax.swing.JComboBox<String> jcbArticulo;
    private javax.swing.JLabel jlArticulo;
    private javax.swing.JTable jtRecetasDisponibles;
    private javax.swing.JTable jtRuta;
    private javax.swing.JTable jtRutaColor;
    private javax.swing.JTable jtRutaConsumo;
    private javax.swing.JTextField jtfAncho;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfGrml;
    private javax.swing.JTextField jtfKilos;
    private javax.swing.JTextField jtfMetros;
    private javax.swing.JTabbedPane jtpRuta;
    private ar.com.coder.ui.grillas.RecetaGrilla recetaGrilla;
    private ar.com.coder.ui.grillas.RutaColorGrilla rutaColorGrilla;
    private ar.com.coder.ui.grillas.RutaGrilla rutaGrilla;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizarDatos() {
        actualizarFactor();
        actualizarRuta();
    }

    private void cargarNodos(Ruta ruta) {
        for (int i = 0; i < ruta.sizeNodos(); i++) {
            Receta receta = ruta.getNodo(i).getReceta();
            NodoRuta nodoRuta = new NodoRuta();
            nodoRuta.setReceta(receta);
            nodoRuta.setMaquina(ruta.getNodo(i).getMaquina());

            nodos.add(nodoRuta);
        }

    }
}
