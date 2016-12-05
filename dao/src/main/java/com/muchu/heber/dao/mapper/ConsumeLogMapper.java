package com.muchu.heber.dao.mapper;

import com.muchu.heber.dao.model.ConsumeLog;
import java.util.List;

public interface ConsumeLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consume_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consume_log
     *
     * @mbggenerated
     */
    int insert(ConsumeLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consume_log
     *
     * @mbggenerated
     */
    ConsumeLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consume_log
     *
     * @mbggenerated
     */
    List<ConsumeLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table consume_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ConsumeLog record);
}