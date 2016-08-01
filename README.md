# EventBusDemo


compile 'org.greenrobot:eventbus:3.0.0'

在 接受界面
protected void onCreate(Bundle savedInstanceState) {
       // 注册
       EventBus.getDefault().register(this);
}

// TODO: 主线程操作(可任选一个)
    //@Subscribe
//    public void onEventMainThread(MessageEvent event) {
//        String msg = "onEventMainThread收到了消息：" + event.getMessage();
//        Log.d("harvic", msg);
//        main_tv.setText(msg);
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//    }
    // TODO: 子线程
    @Subscribe
    public void onEvent(MessageEvent event) {
        String msg = "收到了消息：" + event.getMessage();
        Log.d("harvic", msg);
        main_tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

@Override
protected void onDestroy() {
    super.onDestroy();
    // 取消注册
    EventBus.getDefault().unregister(this);
}

在发送界面:

// TODO 发送
EventBus.getDefault().post(new MessageEvent(etString));

MessageEvent: 是一个实体类, 
