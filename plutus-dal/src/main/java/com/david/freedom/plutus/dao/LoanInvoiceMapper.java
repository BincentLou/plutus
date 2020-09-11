/**
 * hsjry.com Inc.
 * Copyright (c) 2015-2020 All Rights Reserved.
 */
package com.david.freedom.plutus.dao;

import com.david.freedom.plutus.entity.LoanInvoice;
import com.david.freedom.plutus.entity.LoanInvoiceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hsjry
 * @version $Id: LoanInvoiceMapper.java, v1.0 2020年09月03日 22:07:01 hsjry Exp $
 * @since 1.0
 */
public interface LoanInvoiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    long countByExample(LoanInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    int deleteByExample(LoanInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long loanInvoiceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    int insert(LoanInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    int insertSelective(LoanInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    List<LoanInvoice> selectByExample(LoanInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    LoanInvoice selectByPrimaryKey(Long loanInvoiceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LoanInvoice record, @Param("example") LoanInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LoanInvoice record, @Param("example") LoanInvoiceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LoanInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scm_loan_invoice
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LoanInvoice record);
}