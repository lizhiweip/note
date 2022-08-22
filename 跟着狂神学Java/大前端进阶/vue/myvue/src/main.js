// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import router from './router'//自动扫描里面的路由
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import {formatTime} from "./utils/time";

import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)
Vue.config.productionTip = false
//显式声明使用VueRouter
Vue.use(VueRouter);
Vue.use(ElementUI);
//自定义指令
Vue.directive('title',  function (el, binding) {
  document.title = el.dataset.title
})
// 格式话时间
Vue.filter('format', formatTime)
new Vue({
  el: '#app',
  render: h => h(App)
});
/* eslint-disable no-new */
new Vue({
  el: '#app',
  //配置路由
  router,
  components: { App },
  template: '<App/>'
})
