//package com.my.test.mongo;
//
//import com.my.test.UserInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * @author Chengfei.Sun on 2016/10/31.
// */
//@Repository
//public class UserInfoMongdbDAO {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    /**
//     * 保存
//     * @param userInfo
//     */
//    public void insert(UserInfo userInfo) {
//        this.mongoTemplate.insert(userInfo);
//    }
//
//    /**
//     * 根据id查询
//     * @param id
//     * @return
//     */
//    public UserInfo getById(int id) {
//        return mongoTemplate.findById(id, UserInfo.class);
//    }
//
//    public long count() {
//        return mongoTemplate.count(new Query(), UserInfo.class);
//    }
//
//    /**
//     * 条件查询
//     * @param name
//     * @return
//     */
//    public List<UserInfo> queryByName(String name) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").is(name));
//
//        return mongoTemplate.find(query, UserInfo.class);
//    }
//
//    /**
//     * 根据id更新
//     * @param userInfo
//     * @return
//     */
//    public UserInfo updateById(UserInfo userInfo) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("_id").is(userInfo.getId()));
//
//        Update update = new Update();
//
////        Map<String, Object> map = new ObjectMapper().convertValue(userInfo, Map.class);
////        for (Map.Entry<String, Object> entry : map.entrySet()) {
////            if(entry.getValue() != null){
////                update.set(entry.getKey(), entry.getValue());
////            }
////        }
//
//        UserInfo updateUser = mongoTemplate.findAndModify(query, update, UserInfo.class);
//        return updateUser;
//    }
//
//}
