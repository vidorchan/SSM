package com.vidor.interceptor;

import com.github.pagehelper.util.MSUtils;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Collections;
import java.util.List;

@Intercepts({
    @Signature(type = Executor.class, method= "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})

})
public class MyPageInterceptor implements Interceptor {

    private final String countSuffix = "Count";
//    public Object intercept(Invocation invocation) throws Throwable {
//        System.out.println("简易版的分页插件：逻辑分页改成物理分页");
//        Object[] args = invocation.getArgs();
//        MappedStatement mappedStatement = (MappedStatement) args[0];
//        Object parameterObject=args[1];
//        BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
//        // 分页信息
//        RowBounds rowBounds = (RowBounds) args[2];
//        // 原来的sql
//        String sql = boundSql.getSql();
//        // count sql
//        //String sqlCount = mappedStatement.getId() + countSuffix;
//        // 拼接分页的sql
//        String limitSql = sql + " limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
//        // 将分页sql重新封装一个BoundSql 进行后续执行
//        BoundSql limitBoundSql = new BoundSql(mappedStatement.getConfiguration(), limitSql, boundSql.getParameterMappings(), parameterObject);
////        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), "select count(1) from USER_PRIVILEGES", boundSql.getParameterMappings(), parameterObject);
//
//        // 被代理的对象
//        Executor executor = (Executor) invocation.getTarget();
//
//        //MappedStatement mappedStatement1 = MSUtils.newCountMappedStatement(mappedStatement, sqlCount);
//        // 先执行count
////        List<Object> query = executor.query(mappedStatement1, parameterObject, RowBounds.DEFAULT, (ResultHandler) args[3], executor.createCacheKey(mappedStatement, parameterObject, RowBounds.DEFAULT, countBoundSql), countBoundSql);
////        if (query.size() <= 0) {
////            return "Error";
////        }
////        System.out.println("总计多少：" + query.size());
//
//        CacheKey cacheKey = executor.createCacheKey(mappedStatement, parameterObject, rowBounds, limitBoundSql);
//        // 调用修改过后的sql继续执行查询
//        return executor.query(mappedStatement, parameterObject, rowBounds, (ResultHandler) args[3], cacheKey, limitBoundSql);
//    }

    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("查询分页之前，查询count方法，得到总数");
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameterObject=args[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
        // 分页信息
        RowBounds rowBounds = (RowBounds) args[2];

        // count sql
        String sqlCount = mappedStatement.getId() + countSuffix;

        // 被代理的对象
        Executor executor = (Executor) invocation.getTarget();

        Configuration configuration = mappedStatement.getConfiguration();
        MappedStatement mappedStatement1 = configuration.getMappedStatement(sqlCount);

        // 先执行count
        List<Integer> query = executor.query(mappedStatement1, parameterObject, rowBounds, (ResultHandler) args[3]);
        if (query.get(0) <= 0) {
            System.out.println("没有结果，无需执行接下来的分页查询");
            return Collections.EMPTY_LIST;
        }
        System.out.println("总计多少：" + query.get(0));

        // 调用修改过后的sql继续执行查询
        return executor.query(mappedStatement, parameterObject, rowBounds, (ResultHandler) args[3]);
    }
}
