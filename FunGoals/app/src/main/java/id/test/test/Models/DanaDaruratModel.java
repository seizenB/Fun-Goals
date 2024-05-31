package id.test.test.Models;

public class DanaDaruratModel extends DanaKeuangan {
    private double pengeluaranWajibTiapBulan;
    private int jumlahTanggungan;
    private double lamaTargetMengumpulkan;
    private double danaDaruratSaatIni;
    private double hasilDanaDarurat;

    // Implementasi metode abstrak
    @Override
    public void hitungInvestasi() {
        double jumlahTabungan = getDanaDaruratSaatIni() + (getTargetInvestasiTiapBulan() * getLamaTargetMengumpulkan());
        this.hasilInvestasi = jumlahTabungan
                * Math.pow((1 + ((getReturnInvestasiPerTahun() / 100) / 100)), getLamaTargetMengumpulkan() / 12);
    }

    // Getter dan Setter

    public double getHasilDanaDarurat() {
        return hasilDanaDarurat;
    }

    public void setHasilDanaDarurat() {
        int pengali = 3 * (getJumlahTanggungan() + 2);
        this.hasilDanaDarurat = getPengeluaranWajibTiapBulan() * pengali;
    }

    public double getPengeluaranWajibTiapBulan() {
        return pengeluaranWajibTiapBulan;
    }

    public void setPengeluaranWajibTiapBulan(double pengeluaranWajibTiapBulan) {
        this.pengeluaranWajibTiapBulan = pengeluaranWajibTiapBulan;
    }

    public int getJumlahTanggungan() {
        return jumlahTanggungan;
    }

    public void setJumlahTanggungan(int jumlahTanggungan) {
        this.jumlahTanggungan = jumlahTanggungan;
    }

    public double getLamaTargetMengumpulkan() {
        return lamaTargetMengumpulkan;
    }

    public void setLamaTargetMengumpulkan(double lamaTargetMengumpulkan) {
        this.lamaTargetMengumpulkan = lamaTargetMengumpulkan;
    }

    public double getDanaDaruratSaatIni() {
        return danaDaruratSaatIni;
    }

    public void setDanaDaruratSaatIni(double danaDaruratSaatIni) {
        this.danaDaruratSaatIni = danaDaruratSaatIni;
    }
}