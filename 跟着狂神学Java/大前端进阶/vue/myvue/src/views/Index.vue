<template>
<div>
  <el-container class="me-container">
    <el-main class="me-articles">
        <ArticleItem v-for="article in articles" v-bind="article" :key="article.id"></ArticleItem>
    </el-main>
    <el-aside width="250px">
      <CardMe></CardMe>
    </el-aside>
  </el-container>

</div>
</template>

<script>
import ArticleScrollPage from "../components/common/ArticleScrollPage";
import CardMe from "../components/card/CardMe";
import BlogView from "./blog/BlogView";
export default {
  data() {
    return {

      articles:[
        {
          id:"1",
          weight:1,
          title:"标题1",
          commentCounts:10,
          viewCounts:90,
          summary:"概要1",
          author:"作者1",
          tags:[{"tagName":"vue"}],
          createDate:"2022-8-8 14:08:00"
        },
        {
          id:"2",
          weight:1,
          title:"标题2",
          commentCounts:13,
          viewCounts:19,
          summary:"概要2",
          author:"作者2",
          tags:[{"tagName":"java"}],
          createDate:"2022-8-9 14:00:00"
        },{
          id:"3",
          weight:1,
          title:"标题3",
          commentCounts:123,
          viewCounts:1949,
          summary:"概要3",
          author:"作者3",
          tags:[{"tagName":"html"}],
          createDate:"2022-8-8 14:00:00"
        },{
          id:"4",
          weight:1,
          title:"标题4",
          commentCounts:123,
          viewCounts:1667,
          summary:"概要4",
          author:"作者4",
          tags:[{"tagName":"css"}],
          createDate:"2022-8-8 14:06:00"
        },{
          id:"5",
          weight:1,
          title:"标题5",
          commentCounts:155,
          viewCounts:10986,
          summary:"概要5",
          author:"作者5",
          tags:[{"tagName":"javascript"}],
          createDate:"2022-8-8 14:06:00"
        },{
          id:"6",
          weight:1,
          title:"标题6",
          commentCounts:155,
          viewCounts:10986,
          summary:"概要5",
          author:"作者5",
          tags:[{"tagName":"javascript"}],
          createDate:"2022-8-8 14:06:00"
        },{
          id:"7",
          weight:1,
          title:"标题7",
          commentCounts:155,
          viewCounts:10986,
          summary:"概要5",
          author:"作者5",
          tags:[{"tagName":"javascript"}],
          createDate:"2022-8-8 14:06:00"
        },{
          id:"8",
          weight:1,
          title:"标题8",
          commentCounts:155,
          viewCounts:10986,
          summary:"概要5",
          author:"作者5",
          tags:[{"tagName":"javascript"}],
          createDate:"2022-8-8 14:06:00"
        }
      ]
    }
  },
  components: {BlogView, BaseHeader, CardMe, ArticleScrollPage, ArticleItem},
  //name: "index"
  comments:{
    ArticleScrollPage,
    CardMe,BaseHeader,BlogView
  }
}
import ArticleItem from "../components/article/ArticleItem";
import BaseHeader from "../components/common/BaseHeader";
</script>

<style scoped>
.me-container{
  margin: 100px auto 140px;
}
.el-container {
  width: 960px;
  margin-left: 250px;
}

.el-aside {
  margin-left: 20px;
  width: 260px;
}

.el-main {
  padding: 0px;
  line-height: 16px;
}

.el-card {
  border-radius: 0;
}

.el-card:not(:first-child) {
  margin-top: 20px;
}
</style>
