

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class FilmController {
    
    FilmModel filmModel;
    FilmView filmView;
    String dataterpilih;
    int baris, kolom;
    
    public FilmController(FilmView filmView, FilmModel filmModel) {
        this.filmModel = filmModel;
        this.filmView = filmView;
        
        if(filmModel.getBanyakDataFilm()!= 0){
            String datafilm[][]= filmModel.readFilm();
            filmView.tabel.setModel((new JTable(datafilm, filmView.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
        
        filmView.btnSimpan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filmView.getJudul().equals("")||filmView.getTipe().equals("")||filmView.getEpisode().equals("")
                        ||filmView.getGenre().equals("")||filmView.getStatus().equals("")||filmView.getRating().equals("")) 
                {
                    JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
                } 
                else 
                {
                    String judul = filmView.getJudul();
                    String tipe = filmView.getTipe();
                    String episode = filmView.getEpisode();
                    String genre = filmView.getGenre();
                    String status = filmView.getStatus();
                    String rating = filmView.getRating();
                    filmModel.insertFilm(judul, tipe, episode, genre, status, rating);  
                }
            }
        });
        
        filmView.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                int baris = filmView.tabel.getSelectedRow();
                int kolom = filmView.tabel.getSelectedColumn();   
                dataterpilih = filmView.tabel.getValueAt(baris, 1).toString();
                String judulterpilih = filmView.tabel.getValueAt(baris, 2).toString();
                String tipeterpilih = filmView.tabel.getValueAt(baris, 3).toString();
                String episodeterpilih = filmView.tabel.getValueAt(baris, 4).toString();
                String genreterpilih = filmView.tabel.getValueAt(baris, 5).toString();
                String statusterpilih = filmView.tabel.getValueAt(baris, 6).toString();
                String ratingterpilih = filmView.tabel.getValueAt(baris, 7).toString();
                filmView.tfjudul.setText(judulterpilih);
                filmView.tftipe.setText(tipeterpilih);
                filmView.tfepisode.setText(episodeterpilih);
                filmView.tfgenre.setText(genreterpilih);
                filmView.cmbstatus.setSelectedItem(statusterpilih);
                filmView.tfrating.setText(ratingterpilih);

            }
        });
        
        filmView.btnEdit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String id = dataterpilih;
                String judul = filmView.getJudul();
                String tipe = filmView.getTipe();
                String episode = filmView.getEpisode();
                String genre = filmView.getGenre();
                String status = filmView.getStatus();
                String rating = filmView.getRating();
                filmModel.updateFilm(id, judul, tipe, episode, genre, status, rating);
            }
        });
        
        filmView.btnRefresh.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                filmView.tfjudul.setText("");
                filmView.tftipe.setText("");
                filmView.tfepisode.setText("");
                filmView.tfgenre.setText("");
                filmView.cmbstatus.setSelectedItem("");
                filmView.tfrating.setText("");
                filmView.tfcari.setText("");
                
                String datafilm[][] = filmModel.readFilm();
                filmView.tabel.setModel(new JTable(datafilm, filmView.namaKolom).getModel());
                
                
            }
        });
        
        
        filmView.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                baris = filmView.tabel.getSelectedRow();
                kolom = filmView.tabel.getSelectedColumn();   
            }
        });
    
        filmView.btnHapus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String dataterpilih = filmView.tabel.getValueAt(baris, 1).toString();   
                filmModel.deleteFilm(dataterpilih);  
            }
        });
       
        filmView.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String cari = filmView.getsearch();
                filmModel.searchFilm(cari);
                String datafilm[][]= filmModel.searchFilm(cari);
                filmView.tabel.setModel((new JTable(datafilm, filmView.namaKolom)).getModel());
            }
        });
        

       filmView.btnKeluar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
       });
       
}

    
}
