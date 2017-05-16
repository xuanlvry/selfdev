package com.my.test.lendCtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 订单信息controller
 * Created by Chengfei.Sun on 2015/9/14.
 */
@Controller("orderInfoController")
@RequestMapping("/ordersInfo")
public class OrderInfoController {
    /***
     * 订单列表
     * @param request 请求对象<br>
     *     number(int >= 1): 页码<br>
     *     sortMode: 排序规则 1 => 按下单时间排序，2 => 按还款日期排序<br>
     * @return
     *        resultCode: 返回代码<br>
     *        message: 返回消息<br>
     *        pageSize: 每页个数<br>
     *        pageNumber: 页码<br>
     *        totalCount: 总共数量<br>
     *        pageCount:  本页数量<br>
     *        listData:  订单数组<br>
     *           orderNo[string]: 订单编号<br>
     *           amount[decimal]: 订单金额<br>
     *           fee[decimal]: 手续费<br>
     *           orderStatus[int]: 订单状态<br>
     *           refundDate[yyyy-MM-dd HH:mm:ss]: 还款时间<br>
     *           orderTime[yyyy-MM-dd HH:mm:ss]: 下单时间<br>
     */
    @RequestMapping(value="/getBlestOrderList",method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String getBlestOrders(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    /***
     *  订单详情
     * @param request 请求对象<br>
     *        orderNo:订单编号<br>
     * @return
     *        resultCode: 返回代码<br>
     *        message: 返回消息<br>
     *        properties:
     *           orderNo[string]: 订单编号<br>
     *           amount[decimal]: 订单金额<br>
     *           fee[decimal]: 手续费<br>
     *           orderStatus[int]: 订单状态<br>
     *           realName[String]: 真实姓名<br>
     *           refundDate[yyyy-MM-dd HH:mm:ss]: 还款时间<br>
     *           orderTime[yyyy-MM-dd HH:mm:ss]: 下单时间<br>
     */
    @RequestMapping(value="/getOrderDetail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String getOrder(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
