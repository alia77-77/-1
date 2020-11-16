
public class Result {
    public final int size;
    public final long addTime;
    public final long removeTime;
    public final long setTime;
    public final long getTime;
    public Result(int size, long addTime, long removeTime, long setTime, long getTime) {
        this.size = size;
        this.addTime = addTime;
        this.removeTime = removeTime;
        this.setTime = setTime;
        this.getTime = getTime;
    }
}
