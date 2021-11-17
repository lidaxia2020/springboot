package com.lidaxia.springbootsecurity.vo;

import com.lidaxia.springbootsecurity.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:57（
 */
@Data
public class SysShortcutMenuVo extends PageCondition implements Serializable {
    private String shortcutMenuId;//用户快捷菜单id

    private String shortcutMenuName;//用户快捷菜单名称

    private String shortcutMenuPath;//用户快捷菜单路径

    private String userId;//用户id

    private String shortcutMenuParentId;//上级id

    private List<SysShortcutMenuVo> sysShortcutMenuVos = new ArrayList<>();//如果是父类，这里存孩子节点


}