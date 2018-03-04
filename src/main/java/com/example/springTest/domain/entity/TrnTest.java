package com.example.springTest.domain.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * テスト
 */
@Entity(listener = TrnTestListener.class)
@Table(name = "trn_test")
public class TrnTest {

    /** テスト内部ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_mid")
    Long testMid;

    /** ユーザーID */
    @Column(name = "user_id")
    String userId;

    /** ユーザー名 */
    @Column(name = "user_name")
    String userName;

    /** メールアドレス */
    @Column(name = "mail_address")
    String mailAddress;

    /** 
     * Returns the testMid.
     * 
     * @return the testMid
     */
    public Long getTestMid() {
        return testMid;
    }

    /** 
     * Sets the testMid.
     * 
     * @param testMid the testMid
     */
    public void setTestMid(Long testMid) {
        this.testMid = testMid;
    }

    /** 
     * Returns the userId.
     * 
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * Sets the userId.
     * 
     * @param userId the userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** 
     * Returns the userName.
     * 
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /** 
     * Sets the userName.
     * 
     * @param userName the userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 
     * Returns the mailAddress.
     * 
     * @return the mailAddress
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /** 
     * Sets the mailAddress.
     * 
     * @param mailAddress the mailAddress
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}