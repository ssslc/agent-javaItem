package com.example.devicemanagement.device;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeviceMapper {

    @Select("SELECT id, asset_code, name, status FROM devices ORDER BY id")
    List<Device> findAll();

    @Select("SELECT id, asset_code, name, status FROM devices WHERE id = #{id}")
    Optional<Device> findById(@Param("id") long id);
}
