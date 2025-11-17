import javax.swing.*;
import java.awt.*;

public class InterfazParticipante extends JFrame {
    
    // Componentes de la ventana
    private JTextField txtMatricula;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtCuatrimestre;
    private JButton btnCapturar;
    private JButton btnPresentar;
    private JButton btnLimpiar;
    private JLabel lblTitulo;
    private JLabel lblMatricula;
    private JLabel lblNombres;
    private JLabel lblApellidos;
    private JLabel lblCuatrimestre;
    
    // Objeto que procesa los datos
    private ProcesarDatos procesador;
    
    // Constructor
    public InterfazParticipante() {
        procesador = new ProcesarDatos();
        inicializarComponentes();
        configurarVentana();
    }
    
    private void inicializarComponentes() {
        setLayout(null);
        
        // TÍTULO
        lblTitulo = new JLabel("REGISTRO DE PARTICIPANTE");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(0, 102, 204));
        lblTitulo.setBounds(100, 20, 300, 30);
        add(lblTitulo);
        
        // MATRÍCULA
        lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
        lblMatricula.setBounds(50, 70, 100, 25);
        add(lblMatricula);
        
        txtMatricula = new JTextField();
        txtMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
        txtMatricula.setBounds(160, 70, 250, 30);
        add(txtMatricula);
        
        // NOMBRES
        lblNombres = new JLabel("Nombres:");
        lblNombres.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNombres.setBounds(50, 110, 100, 25);
        add(lblNombres);
        
        txtNombres = new JTextField();
        txtNombres.setFont(new Font("Arial", Font.PLAIN, 14));
        txtNombres.setBounds(160, 110, 250, 30);
        add(txtNombres);
        
        // APELLIDOS
        lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
        lblApellidos.setBounds(50, 150, 100, 25);
        add(lblApellidos);
        
        txtApellidos = new JTextField();
        txtApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
        txtApellidos.setBounds(160, 150, 250, 30);
        add(txtApellidos);
        
        // CUATRIMESTRE
        lblCuatrimestre = new JLabel("Cuatrimestre:");
        lblCuatrimestre.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCuatrimestre.setBounds(50, 190, 100, 25);
        add(lblCuatrimestre);
        
        txtCuatrimestre = new JTextField();
        txtCuatrimestre.setFont(new Font("Arial", Font.PLAIN, 14));
        txtCuatrimestre.setBounds(160, 190, 250, 30);
        add(txtCuatrimestre);
        
        // BOTÓN CAPTURAR
        btnCapturar = new JButton("CAPTURAR");
        btnCapturar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCapturar.setBounds(50, 250, 120, 40);
        btnCapturar.setBackground(new Color(0, 153, 51));
        btnCapturar.setForeground(Color.WHITE);
        btnCapturar.addActionListener(e -> capturarDatos());
        add(btnCapturar);
        
        // BOTÓN PRESENTAR
        btnPresentar = new JButton("PRESENTAR");
        btnPresentar.setFont(new Font("Arial", Font.BOLD, 14));
        btnPresentar.setBounds(180, 250, 120, 40);
        btnPresentar.setBackground(new Color(0, 102, 204));
        btnPresentar.setForeground(Color.WHITE);
        btnPresentar.addActionListener(e -> presentarDatos());
        add(btnPresentar);
        
        // BOTÓN LIMPIAR
        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 14));
        btnLimpiar.setBounds(310, 250, 120, 40);
        btnLimpiar.setBackground(new Color(204, 0, 0));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.addActionListener(e -> limpiarCampos());
        add(btnLimpiar);
    }
    
    private void configurarVentana() {
        setTitle("Sistema de Registro");
        setSize(480, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(240, 240, 240));
    }
    
    private void capturarDatos() {
        String matricula = txtMatricula.getText().trim();
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String cuatrimestre = txtCuatrimestre.getText().trim();
        
        if (matricula.isEmpty() || nombres.isEmpty() || 
            apellidos.isEmpty() || cuatrimestre.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, llena todos los campos.",
                "Campos vacíos",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        procesador.capturarDatos(matricula, nombres, apellidos, cuatrimestre);
        
        JOptionPane.showMessageDialog(
            this,
            "✓ Datos capturados correctamente.\nAhora puedes presionar PRESENTAR.",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    private void presentarDatos() {
        String datos = procesador.presentarDatos();
        
        JOptionPane.showMessageDialog(
            this,
            datos,
            "Datos del Participante",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    private void limpiarCampos() {
        txtMatricula.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtCuatrimestre.setText("");
        procesador.limpiarDatos();
        txtMatricula.requestFocus();
        
        JOptionPane.showMessageDialog(
            this,
            "Campos limpiados.",
            "Limpieza",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazParticipante ventana = new InterfazParticipante();
            ventana.setVisible(true);
        });
    }
}