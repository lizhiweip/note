package com.li.dao;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询语句if
    List<Blog> queryBlogIF(Map map);

    //查询语句choose
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询第1，2，3号博客
    List<Blog> queryBlogForeach(Map map);
}
