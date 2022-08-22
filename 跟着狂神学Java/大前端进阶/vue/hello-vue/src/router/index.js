

import Main from '../views/Main'
import Login from '../views/Login'
//引入插件

import { createRouter, createWebHistory } from "vue-router";

//引入路由组件


const routes = [
  {
    path: "/main",
    component: Main
  },
  {
    path: "/login",
    component: Login
  },

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
