<template>
  <el-card>
    <h2 class="me-author-name">下午好</h2>
    <div class="me-author-description">
      <span><i class="el-icon-date"></i> &nbsp;您已连续签到</span>
      <span><i class="me-icon-job"></i>&nbsp;1&nbsp;天</span>
    </div>
    <div class="me-author-tool">
      <img src="https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/0d87368c4dcc407081574cdd086968cf~tplv-k3u1fbpfcp-no-mark:480:400:0:0.awebp?"
           style="height: 200px;width: 200px;margin-bottom: 20px" herf="https://baidu.com">
      <img src="https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/1342bb1e90e54a4aadceefae35fe5164~tplv-k3u1fbpfcp-no-mark:480:400:0:0.awebp?"
           style="height: 200px;width: 200px;margin-bottom: 20px" herf="https://baidu.com">
    </div>
  </el-card>

</template>

<script>
export default {
  name: 'CardMe',
  data() {
    return {
        message: '<a target="_blank" href="https://space.bilibili.com/473844125">https://space.bilibili.com/473844125</a>'
      }
  },
  methods: {
    showTool(tool) {
      this.$message({
        duration: 0,
        showClose: true,
        dangerouslyUseHTMLString: true,
        message: '<strong>' + tool.message + '</strong>'
      });
    }
  }
}
</script>

<style scoped>
.me-author-name {
  text-align: center;
  font-size: 30px;
  border-bottom: 1px solid #5FB878;
}

.me-author-description {
  padding: 8px 0;
}

.me-icon-job {
  padding-left: 16px;
}

.me-author-tool {
  text-align: center;
  padding-top: 10px;
}

.me-author-tool i {
  cursor: pointer;
  padding: 4px 10px;
  font-size: 30px;
}
</style>

