-- 母亲节 '2019-05-12 00:00:00' and '2019-05-12 23:59:59'
-- 520 '2019-05-20 00:00:00' and '2019-05-20 23:59:59'
-- 七夕 '2019-08-07 00:00:00' and '2019-08-07 23:59:59'
-- 母亲节 '2020-05-10 00:00:00' and '2020-05-10 23:59:59'
select allOrder.CustomerID,
       count(allOrder.NewOrderID)                                                         as '总订单量',
       count(refuse.NewOrderID)                                                           as '拒单量',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2), '%') as '拒单率'
from (select CustomerID, NewOrderID
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and ArrivalTime between '2020-05-10 00:00:00' and '2020-05-10 23:59:59') allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.RelationShopId = 0
        and orders.ArrivalTime between '2020-05-10 00:00:00' and '2020-05-10 23:59:59'
        and operation.OperationType = 4) refuse
     on allOrder.NewOrderID = refuse.NewOrderID
Group by allOrder.CustomerID
order by allOrder.CustomerID asc
limit 0, 10000;

select allOrder.RelationShopId                                                            as 'shopId',
       count(allOrder.NewOrderID)                                                         as '总订单量',
       count(refuse.NewOrderID)                                                           as '拒单量',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2), '%') as '拒单率'
from (select RelationShopId, NewOrderID
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and RelationShopId != 0
        and ArrivalTime between '2020-05-10 00:00:00' and '2020-05-10 23:59:59') allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.RelationShopId != 0
        and orders.ArrivalTime between '2020-05-10 00:00:00' and '2020-05-10 23:59:59'
        and operation.OperationType = 4) refuse
     on allOrder.NewOrderID = refuse.NewOrderID
Group by allOrder.RelationShopId
order by allOrder.RelationShopId asc
limit 0, 10000;


-- 总订单
select *
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2019-05-12 00:00:00' and '2019-05-12 23:59:59'
  and CustomerID = 40316280;

-- 拒单
select *
from DPF_DeliveryOrder
         left join DPF_DeliveryOrderOperation
                   on DPF_DeliveryOrder.NewOrderID = DPF_DeliveryOrderOperation.NewOrderID
where DPF_DeliveryOrder.Status != 1
  and DPF_DeliveryOrder.Status != 9
  and DPF_DeliveryOrder.ArrivalTime between '2019-05-12 00:00:00' and '2019-05-12 23:59:59'
  and DPF_DeliveryOrder.CustomerID = 40316280
  and DPF_DeliveryOrderOperation.OperationType = 4