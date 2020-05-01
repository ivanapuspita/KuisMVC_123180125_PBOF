
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class FilmView extends JFrame{
    String status;
    JLabel judul = new JLabel ("DATA FILM");
    JLabel lid = new JLabel("ID");
    JTextField tfid = new JTextField();
    JLabel ljudul = new JLabel("Judul");
    JTextField tfjudul = new JTextField();
    JLabel ltipe = new JLabel("Tipe");
    JTextField tftipe = new JTextField();
    JLabel lepisode = new JLabel("Episode");
    JTextField tfepisode = new JTextField();
    JLabel lgenre = new JLabel("Genre");
    JTextField tfgenre = new JTextField();
    JLabel lstatus = new JLabel("Status");
    String[] daftarStatus = 
                {"Selesai", "Belum Selesai"};
    JComboBox cmbstatus = new JComboBox(daftarStatus);
    JLabel lrating = new JLabel("Rating");
    JTextField tfrating = new JTextField();
    JTextField tfcari = new JTextField();
    JButton btnCari = new JButton("Cari");
    JButton btnRefresh = new JButton("Refresh");
    JButton btnSimpan = new JButton("Create");
    JButton btnEdit = new JButton("Update");
    JButton btnHapus = new JButton("Delete");
    JButton btnKeluar = new JButton("Exit");
    
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"#","ID","Judul","Tipe","Episode","Genre","Status","Rating"};
    
    public FilmView()
    {
        setTitle("Data Film");
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(850, 600);
        setLocation(200, 50);
        add(judul);
        add(ljudul);
        add(ltipe);
        add(lepisode);
        add(lgenre);
        add(lstatus);
        add(lrating);
        add(tfjudul);
        add(tftipe);
        add(tfepisode);
        add(tfgenre);
        add(tfrating);
        add(cmbstatus);
        add(btnRefresh);
        add(btnSimpan);
        add(btnEdit);
        add(btnHapus);
        add(btnKeluar);
        add(tfcari);
        add(btnCari);
        
        add(scrollPane);
        scrollPane.setBounds(50, 50, 750, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        judul.setBounds(400, 30, 120, 20);
        ljudul.setBounds(50, 320, 120, 20);
        tfjudul.setBounds(100, 320, 120, 20);
        ltipe.setBounds(50, 350, 120, 20);
        tftipe.setBounds(100, 350, 120, 20);
        lepisode.setBounds(50, 380, 120, 20);
        tfepisode.setBounds(100, 380, 120, 20);
        lgenre.setBounds(250, 320, 120, 20);
        tfgenre.setBounds(300, 320, 120, 20);
        lstatus.setBounds(250, 350, 120, 20);
        cmbstatus.setBounds(300, 350, 120, 20);
        lrating.setBounds(250, 380, 120, 20);
        tfrating.setBounds(300, 380, 120, 20);
        tfcari.setBounds(450, 350, 120, 20);
        btnCari.setBounds(568, 350, 70, 20);
        btnRefresh.setBounds(100, 470, 100, 40);
        btnSimpan.setBounds(220, 470, 100, 40);
        btnEdit.setBounds(340, 470, 100, 40);
        btnHapus.setBounds(460, 470, 100, 40);
        btnKeluar.setBounds(580, 470, 100, 40);
        
    }
    public String getId()
    {
        return tfid.getText();
    }
    public String getJudul()
    {
        return tfjudul.getText();
    }
    public String getTipe()
    {
        return tftipe.getText();
    }
    public String getEpisode()
    {
        return tfepisode.getText();
    }
    public String getGenre()
    {
        return tfgenre.getText();
    }
    public String getStatus()
    {
        status = (String)cmbstatus.getSelectedItem();
        return status;
    }
    public String getRating()
    {
        return tfrating.getText();
    }
    public String getsearch(){
        return tfcari.getText();
    }
    
    
}
