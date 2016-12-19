package com.verizon.util;

import com.verizon.models.Sender;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtils {

    private static final String SECRET_KEY = "EA44A771237E0A1C4C2F9BB234C3A7BB70AE7CCF28542A50F75403D8EB1C096D";

    public static String getPushReceiverFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public static String generateToken(Sender sender) {
        Claims claims = Jwts.claims().setSubject(sender.getChannel());
        claims.put("company", sender.getCompany());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static Sender getSenderFromToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            Sender sender = new Sender();
            sender.setChannel(body.getSubject());
            sender.setCompany((String)body.get("company"));

            return sender;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

}
