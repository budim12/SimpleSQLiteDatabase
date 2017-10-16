package id.co.dev.rabbaanii.sqlitedatabase;

/**
 * Created by moeslim on 16/10/17.
 */

public class modalMahasiswa {
    private String id, nama, kelas;

    public modalMahasiswa(String id, String nama, String kelas){
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
    }

    public modalMahasiswa(){

    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return this.nama;
    }

    public void setKelas(String kelas){
        this.kelas = kelas;
    }

    public String getKelas(){
        return this.kelas;
    }
}
