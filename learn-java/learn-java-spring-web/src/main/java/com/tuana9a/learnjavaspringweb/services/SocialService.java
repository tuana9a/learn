package com.tuana9a.learnjavaspringweb.services;

import com.tuana9a.learnjavaspringweb.entities.User;

public interface SocialService {
    String createAuthorizationURL();
            
    String createAccessToken(String code) throws Exception;
            
    User getUserInfoByToken(String token) throws Exception;
}
