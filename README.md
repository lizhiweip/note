# 我的springmvc+mybatis学习笔记

笔记分为两大部分：mybatis和springmvc

- [mybatis](/mybatis)
- [springmvc](/springmvc)


笔记内容主要是mybatis和springmvc的一些基本概念和使用方法，涉及概念介绍、环境搭建、编程细节、运行调试等方面。

这套笔记整体偏入门和应用，适合快速上手，对底层实现和机理并未做过多分析。我后续会研读spring源码，并把学习的收获写成博客分享出来，根据情况再开一个仓库或者贴博客链接。

**如果觉得不错，请先在这个仓库上点个star吧**，这也是对我的肯定和鼓励，谢谢了。不定时进行调整和补充，需要关注更新的请 Watch、Star、Fork

如果你只是单纯要阅读的话，建议移步CSDN或者oschina上观看，访问速度快很多：

>* CSDN:[springmvc+mybatis学习笔记(汇总)](http://blog.csdn.net/h3243212/article/details/51016271)
>* oschina:[springmvc+mybatis学习笔记(汇总)](http://my.oschina.net/brianway/blog/649946)


-----

# 目录

  - [mybatis](/mybatis)
    - [mybatis学习笔记(1)-对原生jdbc程序中的问题总结.md](/mybatis/mybatis学习笔记(1)-对原生jdbc程序中的问题总结.md)
    - [mybatis学习笔记(2)-mybatis概述.md](/mybatis/mybatis学习笔记(2)-mybatis概述.md)
    - [mybatis学习笔记(3)-入门程序一.md](/mybatis/mybatis学习笔记(3)-入门程序一.md)
    - [mybatis学习笔记(3)-入门程序二.md](/mybatis/mybatis学习笔记(3)-入门程序二.md)
    - [mybatis学习笔记(4)-开发dao方法.md](/mybatis/mybatis学习笔记(4)-开发dao方法.md)
    - [mybatis学习笔记(5)-配置文件.md](/mybatis/mybatis学习笔记(5)-配置文件.md)
    - [mybatis学习笔记(6)-输入映射.md](/mybatis/mybatis学习笔记(6)-输入映射.md)
    - [mybatis学习笔记(7)-输出映射.md](/mybatis/mybatis学习笔记(7)-输出映射.md)
    - [mybatis学习笔记(8)-动态sql.md](/mybatis/mybatis学习笔记(8)-动态sql.md)
    - [mybatis学习笔记(9)-订单商品数据模型分析.md](/mybatis/mybatis学习笔记(9)-订单商品数据模型分析.md)
    - [mybatis学习笔记(10)-一对一查询.md](/mybatis/mybatis学习笔记(10)-一对一查询.md)
    - [mybatis学习笔记(11)-一对多查询.md](/mybatis/mybatis学习笔记(11)-一对多查询.md)
    - [mybatis学习笔记(12)-多对多查询.md](/mybatis/mybatis学习笔记(12)-多对多查询.md)
    - [mybatis学习笔记(13)-延迟加载.md](/mybatis/mybatis学习笔记(13)-延迟加载.md)
    - [mybatis学习笔记(14)-查询缓存之一级缓存.md](/mybatis/mybatis学习笔记(14)-查询缓存之一级缓存.md)
    - [mybatis学习笔记(15)-查询缓存之二级缓存.md](/mybatis/mybatis学习笔记(15)-查询缓存之二级缓存.md)
    - [mybatis学习笔记(16)-mybatis整合ehcache.md](/mybatis/mybatis学习笔记(16)-mybatis整合ehcache.md)
    - [mybatis学习笔记(17)-spring和mybatis整合.md](/mybatis/mybatis学习笔记(17)-spring和mybatis整合.md)
    - [mybatis学习笔记(18)-mybatis逆向工程.md](/mybatis/mybatis学习笔记(18)-mybatis逆向工程.md)
  - [springmvc](/springmvc)
    - [springmvc学习笔记(1)-框架原理和入门配置.md](/springmvc/springmvc学习笔记(1)-框架原理和入门配置.md)
    - [springmvc学习笔记(2)-非注解的处理器映射器和适配器.md](/springmvc/springmvc学习笔记(2)-非注解的处理器映射器和适配器.md)   
    - [springmvc学习笔记(3)-注解的处理器映射器和适配器.md](/springmvc/springmvc学习笔记(3)-注解的处理器映射器和适配器.md)
    - [springmvc学习笔记(4)-前端控制器.md](/springmvc/springmvc学习笔记(4)-前端控制器.md)
    - [springmvc学习笔记(5)-入门程序小结.md](/springmvc/springmvc学习笔记(5)-入门程序小结.md)
    - [springmvc学习笔记(6)-springmvc整合mybatis(IDEA中通过maven构建).md](/springmvc/springmvc学习笔记(6)-springmvc整合mybatis(IDEA中通过maven构建).md)
    - [springmvc学习笔记(7)-springmvc整合mybatis之mapper.md](/springmvc/springmvc学习笔记(7)-springmvc整合mybatis之mapper.md)
    - [springmvc学习笔记(8)-springmvc整合mybatis之service.md](/springmvc/springmvc学习笔记(8)-springmvc整合mybatis之service.md)
    - [springmvc学习笔记(9)-springmvc整合mybatis之controller.md](/springmvc/springmvc学习笔记(9)-springmvc整合mybatis之controller.md)
    - [springmvc学习笔记(10)-springmvc注解开发之商品修改功能.md](/springmvc/springmvc学习笔记(10)-springmvc注解开发之商品修改功能.md)
    - [springmvc学习笔记(11)-springmvc注解开发之简单参数绑定.md](/springmvc/springmvc学习笔记(11)-springmvc注解开发之简单参数绑定.md)
    - [springmvc学习笔记(12)-springmvc注解开发之包装类型参数绑定.md](/springmvc/springmvc学习笔记(12)-springmvc注解开发之包装类型参数绑定.md)
    - [springmvc学习笔记(13)-springmvc注解开发之集合类型参数绑定.md](/springmvc/springmvc学习笔记(13)-springmvc注解开发之集合类型参数绑定.md)
    - [springmvc学习笔记(14)-springmvc校验.md](/springmvc/springmvc学习笔记(14)-springmvc校验.md)
    - [springmvc学习笔记(15)-数据回显.md](/springmvc/springmvc学习笔记(15)-数据回显.md)
    - [springmvc学习笔记(16)-异常处理器.md](/springmvc/springmvc学习笔记(16)-异常处理器.md)
    - [springmvc学习笔记(17)-上传图片.md](/springmvc/springmvc学习笔记(17)-上传图片.md)
    - [springmvc学习笔记(18)-json数据交互.md](/springmvc/springmvc学习笔记(18)-json数据交互.md)
    - [springmvc学习笔记(19)-RESTful支持.md](/springmvc/springmvc学习笔记(19)-RESTful支持.md)
    - [springmvc学习笔记(20)-拦截器.md](/springmvc/springmvc学习笔记(20)-拦截器.md)
    - [springmvc学习笔记(21)-springmvc整合mybatis遇到的问题及解决小结.md](/springmvc/springmvc学习笔记(21)-springmvc整合mybatis遇到的问题及解决小结.md)
    - [springmvc学习笔记(22)-springmvc开发小结.md](/springmvc/springmvc学习笔记(22)-springmvc开发小结.md)
-----

# 联系作者

- [Brian's Personal Website](http://brianway.github.io/)
- [oschina](http://my.oschina.net/brianway)
- [CSDN](http://blog.csdn.net/h3243212/)


-----

**All Copyright Reserved**