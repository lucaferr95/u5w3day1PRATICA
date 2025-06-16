package it.epicode.u5w3day1PRATICA.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.epicode.u5w3day1PRATICA.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTool {
    //gestita direttamente da Spring per la fgestione dei Token
    @Value("${jwt.duration}")
    private long durata;
    @Value("${jwt.secret}")
    private String chiaveSegreta;


    public String createToken(User user) {
        //per generare il token ho bisogno della data di generazione del token, della durata e dell'id dell'utente per il quale
        // stiamo creando il token. Abbiamo bisogno anche della chiave segreta per crittografare il token

        return  Jwts.builder().issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ durata)).
                subject(String.valueOf(user.getId())).
                signWith(Keys.hmacShaKeyFor(chiaveSegreta.getBytes())).compact();
    }
    //metodo per la verifica e validita token

    public void validateToken(String token) {
        Jwts.parser().verifyWith(Keys.hmacShaKeyFor(chiaveSegreta.getBytes())).
                build().parse(token);
    }


}


