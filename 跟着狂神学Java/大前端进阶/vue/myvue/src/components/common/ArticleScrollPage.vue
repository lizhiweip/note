<template>
  <scroll-page :loading="loading" :offset="offset" :no-data="noData"@load="load">
    <ArticleItem v-for="article in articles" v-bind="article" :key="article.id"></ArticleItem>
  </scroll-page>
</template>

<script>
import Scrollpage from "../scrollpage";
import ArticleItem from "../article/ArticleItem";


export default {
  name: "ArticleScrollPage",
  props:{
    query:{
      tagId:Number,
      categoryId:Number,
      type:Object,
      default(){
        return {}
      }
    }
  },
  data(){
    return{
      loading: false,
      noData: true,
      offset: 0,
      innerPage: {
        pageSize: 5,
        pageNumber: 1,
        name: 'a.createDate',
        sort: 'desc',
        tagId: null,
        categoryId: null
      },
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
        }
      ]
    }
  },
  methods:{
    load(){
         //如果触发分页，需要调用接口 加载文章列表
      alert("触发分页");
      this.getArticles();
    },
    getArticles(){
      this.loading = true;
      this.innerPage.tagId  = this.query.tagId;
      this.innerPage.categoryId = this.query.categoryId;
      this.axios.post("url","params").then((res)=>{
        //res.data是后台数据
        if(res.data.success){
          if(res.data.data.length<=0){
            this.nodata=true;
          }
          this.articles = this.articles.concat(res.data.data);
        }else{
          this.$message.error(res.data.msg)
        }
      }).catch(err=>{
        this.$message.error("系统错误");
      }).finally(()=>{
        this.loading=false;
      })
      this.noData = false;
      this.loading = false;
    }
  },
  comments:{
    "scroller-page":Scrollpage,
    ArticleItem
  }
}
</script>

<style scoped>
.el-card {
  border-radius: 0;
}

.el-card:not(:first-child) {
  margin-top: 10px;

}
</style>
