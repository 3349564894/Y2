package com.yq.dao.sysuser;

import com.yq.entity.T_Storage_Relcord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface T_Storage_RelcordMapper {
    List<T_Storage_Relcord> getStorageRelcordByParams
            (@Param("goodsName") String goodsName,
             @Param("srCode") String srCode,
             @Param("payStatus") Integer payStatus);
}
