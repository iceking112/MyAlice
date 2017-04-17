package org.myalice.mapping.websocket;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.myalice.domain.websocket.TalkRecord;

public interface TalkRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talk_record
     *
     * @mbg.generated
     */
    @Delete({
        "delete from talk_record",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talk_record
     *
     * @mbg.generated
     */
    @Insert({
        "insert into talk_record (id, content, ",
        "from_user_id, from_user_name, ",
        "to_user_id, to_user_name, ",
        "type, create_time, ",
        "connection_id, from_ip, ",
        "to_ip)",
        "values (#{id,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{fromUserId,jdbcType=VARCHAR}, #{fromUserName,jdbcType=VARCHAR}, ",
        "#{toUserId,jdbcType=VARCHAR}, #{toUserName,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{connectionId,jdbcType=VARCHAR}, #{fromIp,jdbcType=VARCHAR}, ",
        "#{toIp,jdbcType=VARCHAR})"
    })
    int insert(TalkRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talk_record
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, content, from_user_id, from_user_name, to_user_id, to_user_name, type, create_time, ",
        "connection_id, from_ip, to_ip",
        "from talk_record",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_user_id", property="fromUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_user_name", property="fromUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_name", property="toUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="connection_id", property="connectionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_ip", property="fromIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_ip", property="toIp", jdbcType=JdbcType.VARCHAR)
    })
    TalkRecord selectByPrimaryKey(String id);
    
    /**
     * 查找最近n次会话记录
     * @param userId
     * @param limit
     * @return
     */
    @Select({
        "select",
        "content, from_user_name, type, create_time ",
        "from talk_record",
        "where (from_user_id = #{userId,jdbcType=VARCHAR} or to_user_id = #{userId,jdbcType=VARCHAR}) ",
        "order by create_time desc limit #{limit}"
    })
    @Results({
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_user_name", property="fromUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TalkRecord> selectLastTalkByUserId(@Param("userId") String userId, @Param("limit") int limit);
    
    /**
     * 查询最近n次会话记录
     * @param ip
     * @param limit
     * @return
     */
    @Select({
        "select",
        "content, from_user_name, type, create_time ",
        "from talk_record",
        "where (from_ip = #{ip,jdbcType=VARCHAR} or to_ip = #{ip,jdbcType=VARCHAR}) ",
        "order by create_time desc limit #{limit}"
    })
    @Results({
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_user_name", property="fromUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TalkRecord> selectLastTalkByIp(@Param("ip") String ip, @Param("limit") int limit);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talk_record
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, content, from_user_id, from_user_name, to_user_id, to_user_name, type, create_time, ",
        "connection_id, from_ip, to_ip",
        "from talk_record"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_user_id", property="fromUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_user_name", property="fromUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_name", property="toUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="connection_id", property="connectionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="from_ip", property="fromIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_ip", property="toIp", jdbcType=JdbcType.VARCHAR)
    })
    List<TalkRecord> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table talk_record
     *
     * @mbg.generated
     */
    @Update({
        "update talk_record",
        "set content = #{content,jdbcType=VARCHAR},",
          "from_user_id = #{fromUserId,jdbcType=VARCHAR},",
          "from_user_name = #{fromUserName,jdbcType=VARCHAR},",
          "to_user_id = #{toUserId,jdbcType=VARCHAR},",
          "to_user_name = #{toUserName,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=CHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "connection_id = #{connectionId,jdbcType=VARCHAR},",
          "from_ip = #{fromIp,jdbcType=VARCHAR},",
          "to_ip = #{toIp,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TalkRecord record);
}