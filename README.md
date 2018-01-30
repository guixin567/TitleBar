###    封装前后对比
    封装前：
        在每个Activity或者Fragement写标题栏布局文件
        在每个Activity或者Fragement给相应控件赋值，设置点击事件
        在BaseActivity中进行赋值或者点击事件
    封装后：
        只需要在相应的Activity或者Fragment中一行代码进行相应的设置
        好处：解耦
###    效果
![Alt text](https://github.com/guixin567/TitleBar/blob/master/image/titlebar.gif)
###    使用方式
####   继承BaseTitleBar重写相应的方法
    普通的TitleBar
        1，继承BaseTitleBar
        2,重写BindLayout，绑定标题栏的布局文件
        3,重写bindView，对布局文件里面子View文本和图片赋值及事件处理
        4，重写Builder内部类继承BaseTitleBar中的Builder
            1，重写build方法
                返回BaseTitlteBar子类对象，通过构造方法将Builder传给BaseTitleBar，这样可以获取Builder中设置的参数
            2，重写构造方法Buider(Context context)
    可折叠滚动的TitleBar
        1，跟普通的TitleBar是一样的设置
        2，布局文件中设置
            根布局是AppbarLayout
                Toolbar要设置scrollFlags
####   相应参数的作用
    //如果是NormalTitleBar可以不传ViewGroup参数，默认添加到系统根布局
    //如果是可折叠TitileBar必须传ViewGroup参数，要将titlebar添加到协调者布局下面
    new NormalTitlebar.Builder(Context context,ViewGroup parent)
        //设置标题栏
        .setTitle()
        //设置左边ICon
        .setLeftIcon()
        //设置左右文本
        .setLeftText()
        //设置右边Icon
        .setRightIcon()
        //设置右边文本
        .setRightText()
        //添加点击事件OnTitleListener
                onLeftText:左边文本回调
                onLeftIcon:左边Icon回调
                onRightText:右边文本回调
                onRightIcon:右边Icon回调
        .addListener()
        .build();
####    Activity中使用
   ![Alt text](https://github.com/guixin567/TitleBar/blob/master/image/titlebar.png)
####   原理
    1，获取Activity的根布局ViewGroup
        可以从Activity的布局文件中获取
        也可以通过Context获取当前Activity，从系统默认的Activity根布局获取
           ((Activity) mBuilder.mContext).findViewById(android.R.id.content);
    2，将TitleBar的这个视图添加到根布局
    
    3，给TitleBar里面的控件设置相应的值和点击事件
####   封装的2个类解析
#####   BaseTitleBar方法解析
######  1，BaseTitleBar(Builder builder)

    1，构造方法将Builder值赋给BaseTitleBar可以获取里面参数值
        
    2，调用onCreate方法，获取Activity的根布局视图并添加当前的TitleBar视图
######  2，onCreate()

    第一步：获取Activity的根布局视图
        
            1,默认是从Builder的构造方法中获取
            2，如果Builder中没有，直接获取系统的根布局视图
                    if(mBuilder.mParent ==null){
                        //获取Activity的根视图，这个是AppCompatActivity才有的
                        mBuilder.mParent = ((Activity) mBuilder.mContext).findViewById(android.R.id.content);;
                    }
                    
                    if(mBuilder.mParent==null){
                        return;
                    }


    第二步：添加当前的TitleBar视图到根布局视图
    
            //1，获取标题栏视图
            View titleBarView = LayoutInflater.from(mBuilder.mContext).inflate(bindLayout(), mBuilder.mParent, false);
    
            //2,添加到父控件
            mBuilder.mParent.addView(titleBarView);
######  3，bindLayout()     
    封装的Titilebar的布局
######  4，bindView()  
    设置Titilebar布局中的文本，图片，点击事件
######  5，Builder内部类
    1，构造方法
        Builder(Context context, ViewGroup parent)
        将上下文和根布局视图传给BaseTitleBar
    2，设置参数方法
        获取BaseTitleBar布局控件里面和参数
    3，build方法
        abstract BaseTitleBar build()
        让子类继承，返回BaseTitleBar的子类对象并将Builder通过构造方法传递给BaseTitleBar
#####   OnTitleLisenter
    标题栏的点击事件的封装
     onLeftText：左边文字点击   
     onLeftIcon：左边图标的点击
     onRightText：右边文字点击
     onRightIcon：右边图标的点击

    
    
    
