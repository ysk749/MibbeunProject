package com.mibbeun.pattern;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "xuser")
@Getter
@Setter
@NoArgsConstructor
public class XUser {

    @Id
    @Column(name = "user_id", length = 20)
    private String userId;

    @Column(name = "user_nm")
    private String userNm;

    @Column(name = "user_pswd")
    private String userPswd;

    @Column(name = "admin_auth_yn", length = 1)
    private String adminAuthYn = "N";

    @Column(name = "delete_yn", length = 1)
    private String deleteYn = "N";

    @Column(name = "use_yn", length = 1)
    private String useYn = "Y";

    @Column(name = "user_pattern")
    private String userPattern;

    public XUser(String userId, String userNm, String userPswd) {
        this.userId = userId;
        this.userNm = userNm;
        this.userPswd = userPswd;
    }
}