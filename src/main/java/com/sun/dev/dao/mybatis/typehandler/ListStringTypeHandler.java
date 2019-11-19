package com.sun.dev.dao.mybatis.typehandler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunchengfei on 2018/6/29.
 */
@MappedJdbcTypes(value = JdbcType.VARCHAR)
@MappedTypes(java.util.List.class)
public class ListStringTypeHandler extends BaseTypeHandler<List<String>> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        //父类BaseTypeHandler已做入参非空判断做处理
        preparedStatement.setString(i, StringUtils.join(strings, ";"));
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String result = resultSet.getString(s);
        if (StringUtils.isNotEmpty(result)) {
            return Arrays.asList(result.split(";"));
        }
        return null;
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String result = resultSet.getString(i);
        if (StringUtils.isNotEmpty(result)) {
            return Arrays.asList(result.split(";"));
        }
        return null;
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String result = callableStatement.getString(i);
        if (StringUtils.isNotEmpty(result)) {
            return Arrays.asList(result.split(";"));
        }
        return null;
    }
}
