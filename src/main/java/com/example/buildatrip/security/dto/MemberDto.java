package com.example.buildatrip.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class MemberDto extends User implements OAuth2User {
    private String memId;
    private String memName;
    private String memPw;
    private int memAge;
    private String memGender;
    private boolean fromSocial;
    private Map<String, Object> attr;

    public MemberDto(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

        this.memId = username;
        this.fromSocial = fromSocial;
        this.memPw = password;
    }

    public MemberDto(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities, Map<String,Object> attr) {
        this(username,password, fromSocial, authorities);
        this.attr = attr;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attr;
    }

    @Override
    public String getName() {
        return null;
    }
}
