package com.jjh.example.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jjh.example.demo.vo.Member;

@Mapper
public interface MemberRepository {
	@Insert("""
			INSERT INTO `member`
			SET regDate = NOW(),
			updateDate = NOW(),
			loginId = #{loginId},
			loginPw = #{loginPw},
			`name` = #{name},
			nickname = #{nickname},
			cellphoneNo =#{cellphoneNo},
			email = #{email};
			""")
	void join(@Param("loginId") String loginId, @Param("loginPw") String loginPw, @Param("name") String name,
			@Param("nickname") String nickname, @Param("cellphoneNo") String cellphoneNo, @Param("email") String email);

	@Select("SELECT LAST_INSERT_ID()")
	int getLasteInsertId();

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.id = #{id}
			""")
	Member getMemberById(@Param("id") int id);

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.loginId = #{loginId}
			""")
	Member getMemberByLoginId(@Param("loginId") String loginId);

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.name = #{name}
			""")
	Member getMemberByName(@Param("name") String name);

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.nickname = #{nickname}
			""")
	Member getMemberByNickname(@Param("nickname") String nickname);

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.cellphoneNo = #{cellphoneNo}
			""")
	Member getMemberByCellphoneNo(@Param("cellphoneNo") String cellphoneNo);

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.email = #{email}
			""")
	Member getMemberByEmail(@Param("email") String email);

}
