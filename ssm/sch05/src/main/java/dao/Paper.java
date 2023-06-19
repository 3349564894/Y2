package dao;

/**
 * 纸张接口
 */
public interface Paper {
    public static final String newline = "\r\n";

    public void putInChar(char c);

    public String getContent();
}
