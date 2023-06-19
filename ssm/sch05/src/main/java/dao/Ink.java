package dao;

/***
 * 墨盒接口
 */
public interface Ink {
    /**
     * @param red   红色
     * @param green 绿色
     * @param blue  蓝色
     * @return 返回颜色
     */
    public String getColor(int red, int green, int blue);
}
