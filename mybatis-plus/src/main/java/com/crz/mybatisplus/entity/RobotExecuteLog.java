package com.crz.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author rzcai
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RobotExecuteLog implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer robotId;

    private String robotName;

    private Date startTime;

    private Date endTime;

    private String executeResult;

    private Integer userId;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
