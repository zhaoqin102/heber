package com.muchu.heber.dao.model;

public class Account {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.amount
     *
     * @mbggenerated
     */
    private String amount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.id
     *
     * @return the value of account.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.id
     *
     * @param id the value for account.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.user_id
     *
     * @return the value of account.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.user_id
     *
     * @param userId the value for account.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.amount
     *
     * @return the value of account.amount
     *
     * @mbggenerated
     */
    public String getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.amount
     *
     * @param amount the value for account.amount
     *
     * @mbggenerated
     */
    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }
}