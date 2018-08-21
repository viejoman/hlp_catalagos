package corp.galvan.hlp.catalogos.domain;

public class CryptoHard {

    private static final String PASSWORD = "fenix3009%%h4sk3ll80";
    /* ACCESOS_VUCEM */
    public static final String WRITE_ACCVUCEM = "encrypt(?, '" + PASSWORD + "'::bytea, 'aes')";
    public static final String READ_ACCVUCEM_PWS = "decrypt(contrasenia_ws, '" + PASSWORD + "'::bytea, 'aes')";
    public static final String READ_ACCVUCEM_ARCHKEY = "decrypt(contrasenia_archkey, '" + PASSWORD + "'::bytea, 'aes')";
    /* USUARIOS */
    public static final String WRITE_USERPASS = "HMAC(?,'" + PASSWORD + "','sha256')";

}
