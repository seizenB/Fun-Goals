package id.test.test.Models;

public class DanaPensiunModel extends DanaKeuangan {
    private double pengeluaranPerBulan;
    private double pengeluaranPerTahun;
    private int usiaSekarang;
    private int usiaPensiun;
    private double asumsiInflasiPerTahun;
    private double pengeluaranTahunanSaatPensiun;
    private double uangYangDibutuhkan;
    private double danaPensiunSaatIni;
    private int lamaWaktuPensiun;
    private double hasilInvestasi;

    // Implementasi metode abstrak
    @Override
    public void hitungInvestasi() {
        double initialAmount = getDanaPensiunSaatIni(); // uang saat ini
        double monthlyContribution = getTargetInvestasiTiapBulan(); // tabungan per bulan
        double annualReturnRate = getReturnInvestasiPerTahun() / 100; // return investasi tahunan
        int totalMonths = getLamaWaktuPensiun() * 12; // jumlah bulan menabung

        // Tingkat pengembalian per bulan
        double monthlyReturnRate = annualReturnRate / 12;

        // Menghitung nilai masa depan dari setoran awal
        double futureValueLumpSum = initialAmount * Math.pow(1 + monthlyReturnRate, totalMonths);

        // Menghitung nilai masa depan dari setoran rutin (annuity)
        double futureValueAnnuity = monthlyContribution * (Math.pow(1 + monthlyReturnRate, totalMonths) - 1)
                / monthlyReturnRate;

        // Total nilai masa depan
        double totalFutureValue = futureValueLumpSum + futureValueAnnuity;
        this.hasilInvestasi = totalFutureValue;
    }

    public double getHasilInvestasi() {
        return hasilInvestasi;
    }

    // Getter dan Setter
    public double getPengeluaranPerBulan() {
        return pengeluaranPerBulan;
    }

    public void setPengeluaranPerBulan(double pengeluaranPerBulan) {
        this.pengeluaranPerBulan = pengeluaranPerBulan;
        this.pengeluaranPerTahun = pengeluaranPerBulan * 12;
    }

    public double getPengeluaranPerTahun() {
        return pengeluaranPerTahun;
    }

    public int getUsiaSekarang() {
        return usiaSekarang;
    }

    public void setUsiaSekarang(int usiaSekarang) {
        this.usiaSekarang = usiaSekarang;
    }

    public int getUsiaPensiun() {
        return usiaPensiun;
    }

    public void setUsiaPensiun(int usiaPensiun) {
        this.usiaPensiun = usiaPensiun;
    }

    public double getAsumsiInflasiPerTahun() {
        return asumsiInflasiPerTahun;
    }

    public void setAsumsiInflasiPerTahun(double asumsiInflasiPerTahun) {
        this.asumsiInflasiPerTahun = asumsiInflasiPerTahun;
    }

    public double getPengeluaranTahunanSaatPensiun() {
        return pengeluaranTahunanSaatPensiun;
    }

    public void setPengeluaranTahunanSaatPensiun(double pengeluaranTahunanSaatPensiun) {
        this.pengeluaranTahunanSaatPensiun = pengeluaranTahunanSaatPensiun;
    }

    public double getUangYangDibutuhkan() {
        return uangYangDibutuhkan;
    }

    public void setUangYangDibutuhkan() {
        this.uangYangDibutuhkan = getPengeluaranTahunanSaatPensiun() * 25;
    }

    public double getDanaPensiunSaatIni() {
        return danaPensiunSaatIni;
    }

    public void setDanaPensiunSaatIni(double danaPensiunSaatIni) {
        this.danaPensiunSaatIni = danaPensiunSaatIni;
    }

    public int getLamaWaktuPensiun() {
        return lamaWaktuPensiun;
    }

    public void setLamaWaktuPensiun() {
        this.lamaWaktuPensiun = getUsiaPensiun() - getUsiaSekarang();
    }
}