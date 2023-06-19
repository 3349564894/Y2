package dao;

public class dialogue {
    private String lf;
    private String zgl;

    public String getLf() {
        return lf;
    }

    public void setLf(String lf) {
        this.lf = lf;
    }

    public String getZgl() {
        return zgl;
    }

    public void setZgl(String zgl) {
        this.zgl = zgl;
    }

    public void lfPrint() {
        System.out.println("我是要成为" + this.getLf() + "的男人");
    }

    public void zglPrint() {
        System.out.println("从未见过有如此" + this.getZgl() + "之人");
    }
}
