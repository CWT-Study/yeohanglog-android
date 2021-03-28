package team.triplog.domain.repository

import com.kakao.usermgmt.response.model.User

interface UserRepository {

    /**
     * 유저 정보 업데이트
     */
    fun updateUser(user: User)
}