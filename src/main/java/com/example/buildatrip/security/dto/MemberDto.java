package com.example.buildatrip.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
@Getter
@Setter
@ToString
public class MemberDto extends User {
    private String memId;
    private String memName;
    private String memPw;
    private int memAge;
    private String memGender;
    private boolean fromSocial;

    public MemberDto(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

        this.memId = username;
        this.fromSocial = fromSocial;
        this.memPw = password;
    }
}
