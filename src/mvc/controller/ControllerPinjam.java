package mvc.controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import mvc.model.ModelPinjam;
import mvc.util.Koneksi;

/**
 *
 * @author 15312629
 */
public class ControllerPinjam {

    Koneksi koneksi = new Koneksi();

    public void simpanPinjam(ModelPinjam mp) {
        koneksi.koneksiDatabase();
        String querySimpanPinjam = "insert into tbl_pinjam(namaTeman,barangDipinjam)"
                + "values('" + mp.getNama() + "','" + mp.getBarang() + "')";
        try {
            koneksi.state.executeUpdate(querySimpanPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
            System.err.println("Error! " + e);
        }
    }

    public void hapusDataPinjam(ModelPinjam mp) {
        try {
            koneksi.koneksiDatabase();
            String queryHapusDataPinjam = "delete from tbl_pinjam where id=('" + mp.getId() + "')";
            koneksi.state.executeUpdate(queryHapusDataPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
        } catch (SQLException e) {
            System.err.println("Error! " + e);
            JOptionPane.showMessageDialog(null, "Data Tidak Terhapus");
        }
    }

    public void ubahDataPinjam(ModelPinjam mp) {
        koneksi.koneksiDatabase();
        try {
            int id = mp.getId();
            String nama = mp.getNama();
            String barang = mp.getBarang();

            String queryUbahDataPinjam = "update tbl_pinjam "
                    + "set barangDipinjam=('" + barang + "') where id=('" + id + "')";
            koneksi.state.executeUpdate(queryUbahDataPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {
            System.err.println("Error! " + e);
            JOptionPane.showMessageDialog(null, "Data Tidak Terubah");
        }
    }
}
