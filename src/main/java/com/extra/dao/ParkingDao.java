package com.extra.dao;

import com.extra.model.ParkingLotBean;
import com.extra.model.ParkingRecordBean;
import org.apache.ibatis.annotations.Param;
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

    int selectParkingLotCount(String companyUuid);

    int insertParkingLot(ParkingLotBean lotBean);

    ArrayList<ParkingRecordBean> selectParkingRecordAllList(String companyUUID);

    ArrayList<ParkingRecordBean> selectParkingRecordByLpmAllList(@Param("companyUUID") String companyUUID,@Param("lpm") String lpm);

    ArrayList<ParkingRecordBean> selectParkingUndoneAllList(String companyUUID);

    ArrayList<ParkingRecordBean> selectParkingUndoneByLpmList(@Param("companyUUID") String companyUUID,@Param("lpm") String lpm);

    ArrayList<ParkingRecordBean> selectParkingCompletedByLpmList(@Param("companyUUID") String companyUUID,@Param("lpm") String lpm);

    ArrayList<ParkingRecordBean> selectParkingCompletedAllList(String companyUUID);

    ParkingLotBean selectParkingLotByUUID(String parkingUuid);
}
