package com.example.springTest.domain.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 登録更新テスト
 */
@Entity(listener = TrnUpsertListener.class)
@Table(name = "trn_upsert")
public class TrnUpsert {

    /** 登録更新内部ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upsert_mid")
    Long upsertMid;

    /** 登録更新ルートID */
    @Column(name = "upsert_root_id")
    String upsertRootId;

    /** 登録更新ID */
    @Column(name = "upsert_id")
    String upsertId;

    /** 登録更新名 */
    @Column(name = "upsert_name")
    String upsertName;

    /** 順序 */
    @Column(name = "sort_num")
    Integer sortNum;

    /** 
     * Returns the upsertMid.
     * 
     * @return the upsertMid
     */
    public Long getUpsertMid() {
        return upsertMid;
    }

    /** 
     * Sets the upsertMid.
     * 
     * @param upsertMid the upsertMid
     */
    public void setUpsertMid(Long upsertMid) {
        this.upsertMid = upsertMid;
    }

    /** 
     * Returns the upsertRootId.
     * 
     * @return the upsertRootId
     */
    public String getUpsertRootId() {
        return upsertRootId;
    }

    /** 
     * Sets the upsertRootId.
     * 
     * @param upsertRootId the upsertRootId
     */
    public void setUpsertRootId(String upsertRootId) {
        this.upsertRootId = upsertRootId;
    }

    /** 
     * Returns the upsertId.
     * 
     * @return the upsertId
     */
    public String getUpsertId() {
        return upsertId;
    }

    /** 
     * Sets the upsertId.
     * 
     * @param upsertId the upsertId
     */
    public void setUpsertId(String upsertId) {
        this.upsertId = upsertId;
    }

    /** 
     * Returns the upsertName.
     * 
     * @return the upsertName
     */
    public String getUpsertName() {
        return upsertName;
    }

    /** 
     * Sets the upsertName.
     * 
     * @param upsertName the upsertName
     */
    public void setUpsertName(String upsertName) {
        this.upsertName = upsertName;
    }

    /** 
     * Returns the sortNum.
     * 
     * @return the sortNum
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /** 
     * Sets the sortNum.
     * 
     * @param sortNum the sortNum
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}