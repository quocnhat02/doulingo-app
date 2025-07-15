//package com.duolingo.clone.common.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.JWTVerifier;
//
//import java.security.KeyFactory;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.Base64;
//
//public class ClerkJwtVerifier {
//
//    private final JWTVerifier verifier;
//
//    public ClerkJwtVerifier(String publicKeyPem) {
//        RSAPublicKey publicKey = parsePublicKey(publicKeyPem);
//        Algorithm algorithm = Algorithm.RSA256(publicKey, null);
//        this.verifier = JWT.require(algorithm).build();
//    }
//
//    public DecodedJWT verify(String token) {
//        return verifier.verify(token);
//    }
//
//    private RSAPublicKey parsePublicKey(String pem) {
//        try {
//            String cleaned = pem
//                    .replace("-----BEGIN PUBLIC KEY-----", "")
//                    .replace("-----END PUBLIC KEY-----", "")
//                    .replaceAll("\\s", "");
//            byte[] decoded = Base64.getDecoder().decode(cleaned);
//            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
//            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(keySpec);
//        } catch (Exception e) {
//            throw new RuntimeException("Invalid public key format", e);
//        }
//    }
//}