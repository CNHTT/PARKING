package com.extra.dao;

import com.extra.model.RechargeBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TransactionDao {
    ArrayList<RechargeBean> selectRechargeList(String companyUUID);
}
