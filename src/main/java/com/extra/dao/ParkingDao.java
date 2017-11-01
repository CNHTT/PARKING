package com.extra.dao;

import com.extra.model.ParkingLotBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Extra on 2017/11/1.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Repository
public interface ParkingDao {
    ArrayList<ParkingLotBean> selectParkingLotList(String companyUUID);
}
