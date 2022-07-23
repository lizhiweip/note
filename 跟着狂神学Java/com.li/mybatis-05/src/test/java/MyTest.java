import com.li.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
        public  void test(){
            System.out.println(IDutils.getId());

    }
    @Test
    public void addBlog(){
        SqlSession session= mybatisUtils.getSqlSession();
        BlogMapper mapper=session.getMapper(BlogMapper.class);

        Blog blog=new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("荔枝味");
        blog.setCreateTime(new Date());
        blog.setViews(900);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.commit();
        session.close();
    }
    @Test
    public void queryBlogIF(){
        SqlSession session= mybatisUtils.getSqlSession();
        BlogMapper mapper=session.getMapper(BlogMapper.class);

        HashMap map=new HashMap();
        map.put("title","java如此简单");

       List<Blog> blogList= mapper.queryBlogIF(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession session= mybatisUtils.getSqlSession();
        BlogMapper mapper=session.getMapper(BlogMapper.class);

        HashMap map=new HashMap();
        map.put("title","java如此简单");

        List<Blog> blogList= mapper.queryBlogChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        session.close();
    }
    @Test
    public void updateBlog() {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        map.put("title","注意SQL语句细节");
        map.put("author", "荔枝味");

        map.put("id", "19b3c8c4fa804a69b05158bf887c14f2");
        mapper.updateBlog(map);
        session.commit();
        session.close();
    }
    @Test
    public void queryBlogForeach(){
        SqlSession session = mybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map=new HashMap<>();

        ArrayList<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);
        List<Blog> blogList=mapper.queryBlogForeach(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        session.close();
    }
}
