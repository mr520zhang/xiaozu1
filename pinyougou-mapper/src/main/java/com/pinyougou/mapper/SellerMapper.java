package com.pinyougou.mapper;

import com.pinyougou.pojo.Seller;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * SellerMapper 数据访问接口
 * @date 2019-03-28 09:54:28
 * @version 1.0
 */
public interface SellerMapper extends Mapper<Seller>{

    /** 多条件查询商家 */
    List<Seller> findAll(Seller seller);

    /** 修改商家状态 */
    @Update("UPDATE tb_seller SET STATUS = #{status} WHERE seller_id = #{sellerId}")
    void updateStatus(@Param("sellerId") String sellerId,
                      @Param("status")String status);

    //查询密码
    @Select("SELECT password from tb_seller WHERE seller_id = #{sellerId}")
    String findPassword(String sellerId);

    //修改密码
    @Update("UPDATE tb_seller set password=#{encode} WHERE seller_id= #{sellerId}")
    void updatePassword(@Param("sellerId") String sellerId, @Param("encode") String encode );
}