package com.alpaca.admin.controller;


import com.alpaca.admin.annotation.OperationLog;
import com.alpaca.admin.domain.SysToken;
import com.alpaca.admin.domain.SysUser;
import com.alpaca.admin.service.ISysTokenService;
import com.alpaca.admin.service.ISysUserService;
import com.alpaca.admin.shiro.ShiroUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.grace.commons.system.ResponseMessage;
import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author song
 * @since 2018-11-23
 */
@RestController
public class SysLoginController {

    @Autowired
    private Producer producer;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysTokenService sysTokenService;

    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response)throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public Map<String, Object> login(String username, String password, String captcha)throws IOException {
      /*  String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if(!captcha.equalsIgnoreCase(kaptcha)){
            return ResponseMessage.error("验证码不正确");
        }*/

        //用户信息
        SysUser user = sysUserService.querySysUserByLoginName(username);

        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(ShiroUtils.md5(password,user.getSalt()))) {
            return ResponseMessage.error("账号或密码不正确");
        }

        //账号锁定
        if(user.getStatus() == 0){
            return ResponseMessage.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        SysToken sysToken = sysTokenService.createToken(user.getId());
         return  ResponseMessage.ok().put("token", sysToken.getToken()).put("expire", sysToken.getExpireTime());
    }
}
