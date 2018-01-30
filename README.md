# PullLoadRecyclerView

[同步博客地址:http://blog.csdn.net/louyulin](http://blog.csdn.net/louyulin)

封装recycleview 上拉加载下拉刷新库

## 如何引入
第一步:

    allprojects {
    		repositories {
    			...
    			maven { url 'https://jitpack.io' }
    		}
    	}

第二步:

    dependencies {
    	        compile 'com.github.louyulin:PullLoadRecyclerView:v1.1'
    	}

### 使用:

    //绑定组件
    pullrv = (PullLoadRecyclerView) findViewById(R.id.pullrv);
    //设置下拉颜色
    pullrv.setSwipeRefreshColor(android.R.color.holo_blue_bright,android.R.color.holo_blue_dark,android.R.color.holo_blue_bright);
    //设置列数和滚动方向
    pullrv.setLayoutManager(4, LinearLayoutManager.VERTICAL);
     //设置监听
            pullrv.setOnPullLoadMoreListener(new PullLoadRecyclerView.OnPullLoadMoreListener() {
                @Override
                public void reRresh() {

                }

                @Override
                public void loadMore() {

                }
            });

### 效果图:
![这是一样图片](http://img.blog.csdn.net/20180130203001581?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbG91eXVsaW4=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)