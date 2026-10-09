package nguyenanhkiet25748841;

import java.time.LocalDate;

public class KhachHangNN extends KhachHang {
    private String quocTich;

    public KhachHangNN(String hoTen, LocalDate ngayLapHoaDon,
                       double soKW, double donGia,
                       String quocTich) {
        super(hoTen, ngayLapHoaDon, soKW, donGia);

        setQuocTich(quocTich);
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        if (quocTich == null || quocTich.isBlank()) {
            throw new IllegalArgumentException("Quoc tich khong hop le");
        }
        this.quocTich = quocTich;
    }

    @Override
    public double thanhTien() {
        return getSoKW() * getDonGia();
    }

    @Override
    public String toString() {
        return super.toString()
            + String.format(
                " | %-20s| %-10s| %15.2f |",
                quocTich, "----------", thanhTien()
            );
    }
}
