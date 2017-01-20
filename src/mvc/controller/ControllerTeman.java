package mvc.controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import mvc.model.ModelTeman;
import mvc.util.Koneksi;

/**
 *
 * @author 15312629
 */
public class ControllerTeman {

    Koneksi koneksi = new Koneksi();

    public void simpanTeman(ModelTeman mt) {
        koneksi.koneksiDatabase();
        String querySimpanTeman = "insert into tbl_teman(nama,nope,email)"
                + "values('" + mt.getNama() + "','" + mt.getNope() + "','" + mt.getEmail() + "')";
        try {
            koneksi.state.executeUpdate(querySimpanTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
            System.err.println("Error! " + e);
        }
    }

    public void hapusDataTeman(ModelTeman mt) {
        try {
            koneksi.koneksiDatabase();
            String queryHapusDataTeman = "delete from tbl_teman where id=('" + mt.getId() + "')";
            koneksi.state.executeUpdate(queryHapusDataTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error! " + e);
            JOptionPane.showMessageDialog(null, "Data Tidak Terhapus");
        }
    }

    public void ubahDataTeman(ModelTeman mt) {
        koneksi.koneksiDatabase();
        try {
            int id = mt.getId();
            String nama = mt.getNama();
            String nope = mt.getNope();
            String email = mt.getEmail();

            String queryUbahDataTeman = "update tbl_teman "
                    + "set nama = ('" + nama + "'),"
                    + "nope = ('" + nope + "'),"
                    + "email = ('" + email + "')"
                    + "where id = ('" + id + "')";
            koneksi.state.executeUpdate(queryUbahDataTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {
            System.err.println("Error! " + e);
            JOptionPane.showMessageDialog(null, "Data Tidak Terubah");
        }
    }
}
