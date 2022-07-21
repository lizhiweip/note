window.addEventListener('load',function(){
    //1,获取元素
    var arrow_l=document.querySelector('.arrow-l');
    var arrow_r= this.document.querySelector('.arrow-r');
    var focus = document.querySelector('.focus');
    var focusWidth = focus.offsetWidth;
    //2,鼠标经过就显示
    focus.addEventListener('mouseenter',function(){
        arrow_l.style.display='block';
        arrow_r.style.display = 'block';
        clearInterval(timer);
        timer=null;//清除定时器变量
    })
    focus.addEventListener('mouseleave',function(){
        arrow_l.style.display='none';
        arrow_r.style.display = 'none';
    })
    //3,动态生成小圈圈
    var ul=focus.querySelector('ul');
    var ol=focus.querySelector('.circle');
    for(var i=0;i<ul.children.length;i++){
        //创建一个小li
        var li =this.document.createElement('li');
        //记录当前小圆圈的索引号，通过自定义属性来做
        li.setAttribute('index',i); 
        //把小li插入到ol中
        ol.appendChild(li);
        //4,小圆圈的排他思想，我们可以直接在生成小圆圈的同时直接绑定点击事件
        li.addEventListener('click',function(){  
            //干掉所有人 把所有的li清除 current 类名
            for(var i=0;i<ol.children.length;i++){
                ol.children[i].className='';
            }
            //留下我自己 当前的小li 设置current类名
            this.className='current';
            //5,点击小圆圈，移动图片，移动的是ul
            // ul的移动距离 小圆圈的索引号 乘以图片的宽度，注意是负值
            //当我们点击了某个小li 就拿到当前小li的索引号
            var index = this.getAttribute('index');
            //当我们点击某个小li，要把num改为索引号
            num=index;
            circle=index;
            animate(ul,index*focusWidth);
        })
    }
    //把ol里的第一个小li设置类名为current
    ol.children[0].className='current'; 
    //6,克隆第一张图片 放到ul最后面
    var first = ul.children[0].cloneNode(true);
    ul.appendChild(first);
    //7，点击右侧按钮，图片滚动一张
    var num=0;
    var circle=0
    //flag 节流阀
    var flag = true;
    arrow_r.addEventListener('click',function(){
        if(flag){
            flag=false;//关闭节流阀
            //如果走到了最后复制的一张图片，此时 我们的ul 要快速复原 left改为0
        if(num==ul.children.length-1){
            ul.style.left=0;
            num=0;
        }
        num++;
        animate(ul,-num*focusWidth,function(){
            flag=true;//打开节流阀
        });
    //8，circle 控制小圆圈的播放
    circle++;
    //如果circle=4 说明走到最后
    if(circle==4){
        circle=0;
    }
    circleChange();
}
        });


    //9.左侧按钮
    arrow_l.addEventListener('click',function(){
        //如果走到了最后复制的一张图片，此时 我们的ul 要快速复原 left改为0
        if(num==0){
            num=ul.children.length-1;
            ul.style.left=-num*focusWidth+'px';
           
        }
        num--;
        animate(ul,-num*focusWidth);
    //circle 控制小圆圈的播放
    circle--;
    //如果circle=0 说明走到最后
    if(circle<0){
        circle=3;
    }
    circleChange();
});
    function circleChange(){
      //先清除其余小圆圈的current类名
    for(var i=0;i<ol.children.length;i++){
        ol.children[i].className = '';
    }
    //留下当前小圆圈的current类名
    ol.children[circle].className='current';
    }


    //10，自动播放轮播图
    var timer = this.setInterval(function(){
        //手动调用点击事件
        arrow_r.click();
    },2000)


 
})
