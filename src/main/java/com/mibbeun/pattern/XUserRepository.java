package com.mibbeun.pattern;

import org.springframework.data.jpa.repository.JpaRepository;

public interface XUserRepository extends JpaRepository<XUser, String> {
    XUser findByUserIdAndUseYnAndDeleteYn(String userId, String useYn, String deleteYn);

    default XUser findActiveUser(String userId) {
        return findByUserIdAndUseYnAndDeleteYn(userId, "Y", "N");
    }
}