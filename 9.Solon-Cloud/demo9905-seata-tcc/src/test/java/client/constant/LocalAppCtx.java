package client.constant;

public class LocalAppCtx {
    public static Boolean PREPARE = null;
    public static Boolean COMMIT = null;
    public static Boolean ROLLBACK = null;

    public static void init() {
        PREPARE = false;
        COMMIT = false;
        ROLLBACK = false;
    }
}
