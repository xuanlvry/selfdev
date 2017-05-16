package com.my.test.lendCtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 协议controller
 * Created by Chengfei.Sun on 2015/9/22.
 */
@Controller("agreementController")
@RequestMapping("/agreement")
public class AgreementController {
    /***
     * 获取协议列表
     * @param request 请求对象 无<br>
     * @return
     *       agreementTitle[string]: 协议标题<br>
     *       agreementId[int]: 协议Id<br>
     */
    @RequestMapping(value="/list", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String agreementList(HttpServletRequest request,HttpServletResponse response) {
        return null;
    }

    /***
     * 获取协议详情
     * @param request 请求对象
     *                agreementId[int]: 协议Id<br>
     * @return
     *       agreementTitle[string]: 协议标题<br>
     *       agreementContent[string]: 协议内容<br>
     */
    @RequestMapping(value="/detail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String agreementDetail(HttpServletRequest request,HttpServletResponse response) {
        return null;
    }
}
