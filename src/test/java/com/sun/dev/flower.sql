-- 母亲节 '2019-05-12 00:00:00' and '2019-05-12 23:59:59'
-- 520 '2019-05-20 00:00:00' and '2019-05-20 23:59:59'
-- 七夕 '2019-08-07 00:00:00' and '2019-08-07 23:59:59'
-- 母亲节 '2020-05-10 00:00:00' and '2020-05-10 23:59:59'

-- 接单前，拒单
select allOrder.CustomerID,
       count(allOrder.NewOrderID)                                                              as '订单量',
       count(refuse.NewOrderID) - 10                                                           as '拒单量对比值',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2) - 30, '%') as '拒单率对比值'
from (select CustomerID, NewOrderID
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 00:00:00') allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.RelationShopId = 0
        and orders.ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 00:00:00'
        and operation.OperationType = 4) refuse
     on allOrder.NewOrderID = refuse.NewOrderID
Group by allOrder.CustomerID
order by allOrder.CustomerID asc
limit 0, 10000;

-- 接单后，拒单
select allOrder.RelationShopId                                                                 as '点评shopID',
       count(allOrder.NewOrderID)                                                              as '订单量',
       count(refuse.NewOrderID) - 5                                                            as '拒单量对比值',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2) - 30, '%') as '拒单率对比值'
from (select RelationShopId, NewOrderID
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and RelationShopId != 0
        and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 00:00:00') allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.RelationShopId != 0
        and orders.ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 00:00:00'
        and operation.OperationType = 4) refuse
     on allOrder.NewOrderID = refuse.NewOrderID
Group by allOrder.RelationShopId
order by allOrder.RelationShopId asc
limit 0, 10000;

-- 鲜花联盟
select "爱恋鲜花-KA", count(NewOrderID) - 16000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID = 40118608
UNION ALL
select "爱里鲜花-KA", count(NewOrderID) - 5000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID = 41634243
UNION ALL
select "爱花居集团-KA", count(NewOrderID) - 60000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID = 40648510
UNION ALL
select "爱之裳-KA", count(NewOrderID) - 6000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID IN (1567681, 1515912)
UNION ALL
select "爱丽丝花坊-KA", count(NewOrderID) - 1000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID = 1259593
UNION ALL
select "先花店-KA", count(NewOrderID) - 18000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID = 723059
UNION ALL
select "沪花拾者-KA", count(NewOrderID) - 6000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID = 41115818
UNION ALL
select "美尚美鲜花-KA", count(NewOrderID) - 10000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID = 1370172
UNION ALL
select "玫瑰之约-KA", count(NewOrderID) - 15000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID IN (40088145, 41447232, 1254050, 41370270, 41370235)
UNION ALL
select "花冠鲜花-KA", count(NewOrderID) - 9000
from DPF_DeliveryOrder
where Status != 1
  and Status != 9
  and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
  and CustomerID = 676674;


-- 总订单，总拒单
select count(allOrder.NewOrderID)                                                         as '总订单量',
       count(refuse.NewOrderID)                                                           as '拒单量',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2), '%') as '拒单率'
from (select NewOrderID
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and ArrivalTime between '2020-08-25 00:00:00' and '2020-08-25 23:59:59') allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.ArrivalTime between '2020-08-25 00:00:00' and '2020-08-25 23:59:59'
        and operation.OperationType = 4) refuse
     on allOrder.NewOrderID = refuse.NewOrderID;

-- 总订单，总确认收货
select count(allOrder.NewOrderID)                                                         as '总订单量',
       count(refuse.NewOrderID)                                                           as '确认收货订单量',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2), '%') as '占比'
from (select NewOrderID
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and ArrivalTime between '2020-08-25 00:00:00' and '2020-08-25 23:59:59') allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.ArrivalTime between '2020-08-25 00:00:00' and '2020-08-25 23:59:59'
        and operation.OperationType = 5) refuse
     on allOrder.NewOrderID = refuse.NewOrderID;

-- 总订单，总确认收货
select count(allOrder.NewOrderID)                                                         as '总订单量',
       count(refuse.NewOrderID)                                                           as '配送退款订单量',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2), '%') as '占比'
from (select NewOrderID
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and ArrivalTime between '2020-08-25 00:00:00' and '2020-08-25 23:59:59') allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.ArrivalTime between '2020-08-25 00:00:00' and '2020-08-25 23:59:59'
        and operation.OperationType = 6) refuse
     on allOrder.NewOrderID = refuse.NewOrderID;


-- 总订单，总拒单，筛选customerid
select count(allOrder.NewOrderID)                                                         as '总订单量',
       count(refuse.NewOrderID)                                                           as '拒单量',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2), '%') as '拒单率'
from (select NewOrderID
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
        and CustomerID IN (41062815, 40512776, 41521960, 40874484)) allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.ArrivalTime between '2020-05-20 00:00:00' and '2020-05-20 23:59:59'
        and orders.CustomerID IN (41062815, 40512776, 41521960, 40874484)
        and operation.OperationType = 4) refuse
     on allOrder.NewOrderID = refuse.NewOrderID;

-- 拒单，筛选shopid
select allOrder.RelationShopId                                                            as shopId,
       count(allOrder.NewOrderID)                                                         as '总订单量',
       count(refuse.NewOrderID)                                                           as '拒单量',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2), '%') as '拒单率'
from (select NewOrderID, RelationShopId
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and ArrivalTime between '2020-05-10 00:00:00' and '2020-05-10 23:59:59'
        and RelationShopId IN (1674057538, 131453998, 110493438, 21072788, 66955598)) allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.ArrivalTime between '2020-05-10 00:00:00' and '2020-05-10 23:59:59'
        and orders.RelationShopId IN (1674057538, 131453998, 110493438, 21072788, 66955598)
        and operation.OperationType = 4) refuse
     on allOrder.NewOrderID = refuse.NewOrderID
Group by allOrder.RelationShopId;

select allOrder.RelationShopId                                                            as shopId,
       count(allOrder.NewOrderID)                                                         as '总订单量',
       count(refuse.NewOrderID)                                                           as '拒单量',
       concat(ROUND(count(refuse.NewOrderID) / count(allOrder.NewOrderID) * 100, 2), '%') as '拒单率'
from (select NewOrderID, RelationShopId
      from DPF_DeliveryOrder
      where Status != 1
        and Status != 9
        and ArrivalTime between '2020-05-10 00:00:00' and '2020-05-10 23:59:59'
        and RelationShopId IN (1674057538, 131453998, 110493438, 21072788, 66955598)) allOrder
         Left JOIN
     (select orders.NewOrderID
      from DPF_DeliveryOrder orders
               inner join DPF_DeliveryOrderOperation operation
                          ON orders.NewOrderID = operation.NewOrderID
      where orders.Status != 1
        and orders.Status != 9
        and orders.ArrivalTime between '2020-05-10 00:00:00' and '2020-05-10 23:59:59'
        and orders.RelationShopId IN (1674057538, 131453998, 110493438, 21072788, 66955598)
        and operation.OperationType = 4
        and operation.AddTime between '2020-05-10 07:00:00' and '2020-05-10 07:30:00') refuse
     on allOrder.NewOrderID = refuse.NewOrderID
Group by allOrder.RelationShopId;

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