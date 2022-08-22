import Vue from 'vue'
import VueRouter from "vue-router";
import index from "../views";
import ArticleOne from "../components/simulation/ArticleOne";



//安装路由
Vue.use(VueRouter);

//配置导出路由
export default new VueRouter({
  routers:[
    {
      //路由路径
      path:'/index',
      //跳转组件
      component: index
    },{
      path: '/view/one',
      component: ArticleOne
    }
  ]
});
