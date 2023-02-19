package configuration;

public class Configuration {

    private static final String USER_LOGIN_PERSISTENCE = "./user_login.dat";

    private static final String PROTOCOL = "http";
    private static final String HOST = "localhost";
    private static final String PORT = "8080";
    private static final String CONTEXT_PATH = "QRCodeApplication";

    private static final String DIVIDER = "@";
    private static final String QRCODEPATH = "qrcode";
    private static final String AUTHENTICATION_PATH = "authenticate";

    /**
     * @return the USER_LOGIN_PERSISTENCE
     */
    public static String getUSER_LOGIN_PERSISTENCE() {
        return USER_LOGIN_PERSISTENCE;
    }

    /**
     * @return the PROTOCOL
     */
    public static String getPROTOCOL() {
        return PROTOCOL;
    }

    /**
     * @return the HOST
     */
    public static String getHOST() {
        return HOST;
    }

    /**
     * @return the PORT
     */
    public static String getPORT() {
        return PORT;
    }

    /**
     * @return the CONTEXT_PATH
     */
    public static String getCONTEXT_PATH() {
        return CONTEXT_PATH;
    }

    /**
     * @return the QRCODEPATH
     */
    public static String getQRCODEPATH() {
        return QRCODEPATH;
    }

    /**
     * @return the AUTHENTICATION_PATH
     */
    public static String getAUTHENTICATION_PATH() {
        return AUTHENTICATION_PATH;
    }

    /**
     * @return the DIVIDER
     */
    public static String getDIVIDER() {
        return DIVIDER;
    }
}
