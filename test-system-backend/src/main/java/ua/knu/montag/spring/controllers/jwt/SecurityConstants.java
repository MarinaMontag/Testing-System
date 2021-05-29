package ua.knu.montag.spring.controllers.jwt;

public class SecurityConstants {
    public static final String SECRET = "secret_key";
    public static final long EXPIRATION = 86400000; // 1 day
    public static final String HEADER = "Authorization token";
}
