package org.bitsly.bud.user.api;

public interface UserApi {
    /**
     * 根据userid换算成uid
     * @param userId
     * @return
     */
    String getUidFromUserId(Long userId);

    /**
     * 根据uid换算成userid
     * @param uid
     * @return
     */
    Long getUserIdFromUid(String uid);

    /**
     * 获取当前会话的uid
     * @return
     */
    String getUidFromCurrentSession();

    /**
     * 获取当前会话的userid
     * @return
     */
    Long getUserIdFromCurrentSession();
}
