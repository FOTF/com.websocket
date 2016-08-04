Spring webSocket在jetty下在应用

注意事项：
1、启用jetty的websocker模块
2、spring版本要4.0+
3、jetty版本要9.1+


错误排除：
1、
错误提示：No suitable default RequestUpgradeStrategy found
排查原因：可能是服务器没有启动web_socket模块


本测试代码为gradle项目，直接导入即可运行。
测试访问页面为:127.0.0.1/index.jsp