package id.test.test.Models;

public abstract class DanaKeuangan {
    protected double targetInvestasiTiapBulan;
    protected double returnInvestasiPerTahun;
    protected double hasilInvestasi;

    // Metode abstrak
    public abstract void hitungInvestasi();

    public double getHasilInvestasi() {
        return hasilInvestasi;
    }

    public void setHasilInvestasi(double hasilInvestasi) {
        this.hasilInvestasi = hasilInvestasi;
    }

    // Getter dan Setter
    public double getTargetInvestasiTiapBulan() {
        return targetInvestasiTiapBulan;
    }

    public void setTargetInvestasiTiapBulan(double targetInvestasiTiapBulan) {
        this.targetInvestasiTiapBulan = targetInvestasiTiapBulan;
    }

    public double getReturnInvestasiPerTahun() {
        return returnInvestasiPerTahun;
    }

    public void setReturnInvestasiPerTahun(double returnInvestasiPerTahun) {
        this.returnInvestasiPerTahun = returnInvestasiPerTahun;
    }
}