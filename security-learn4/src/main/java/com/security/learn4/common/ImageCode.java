package com.security.learn4.common;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/20 15:02
 */
@Data
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;

}
