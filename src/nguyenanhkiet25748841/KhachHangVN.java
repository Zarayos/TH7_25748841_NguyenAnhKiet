package nguyenanhkiet25748841;

import java.time.LocalDate;

public class KhachHangVN extends KhachHang {
    private String doiTuong;
    private double dinhMuc;

    public KhachHangVN(String hoTen, LocalDate ngayLapHoaDon,
                       double soKW, double donGia,
                       String doiTuong, double dinhMuc) {
        super(hoTen, ngayLapHoaDon, soKW, donGia);

        setDoiTuong(doiTuong);
        setDinhMuc(dinhMuc);
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public double getDinhMuc() {
        return dinhMuc;
    }

    public void setDoiTuong(String doiTuong) {
        if (doiTuong == null || doiTuong.isBlank()) {
            throw new IllegalArgumentException("Doi tuong khong hop le");
        }
        this.doiTuong = doiTuong;
    }

    public void setDinhMuc(double dinhMuc) {
        if (dinhMuc < 0) {
            throw new IllegalArgumentException("Dinh muc phai >= 0");
        }
        this.dinhMuc = dinhMuc;
    }

    @Override
    public double thanhTien() {
        if (getSoKW() <= getDinhMuc()) {
            return getSoKW() * getDonGia();
        }

        return getDinhMuc() * getDonGia()
                + (getSoKW() - getDinhMuc()) * getDonGia() * 2.5;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" | %-20s| %10.2f| %15.2f |",
                    doiTuong, dinhMuc, thanhTien());
    }
}
