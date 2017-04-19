# Gsync
在不能使用ＧＭＳ服务的的确帮助你同步Google Calendar, Google Contacts 和 Gmail。

## 如何编译
在启用AndroidStudio或者 gradle 编译之前设置如下环境变量：
```shell
# appAuthRedirectScheme, your_client_id and reversed id_client_your.
export APP_AUTH_REDIRECT_SCHEME=id_client_your
export CLIENT_ID=\"your_client_id\"
export REDIRECT_URI=\"id_client_your:/oauth2redirect\"
```
