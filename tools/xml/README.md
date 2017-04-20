# 使用 Google Contact Schema生成对应的 JavaBean

1. 安装转换与验证工具：

```shell
pip install jingtrang
```

2. 获取 Schema 文件：

```shell
wget https://developers.google.com/google-apps/contacts/v3/schema/contact_atom.rnc
```

3. 把 rnc 文件转换为 xsd 文件

```shell
pytrang schema_contacts.rnc schema_contacts.xsd
```

4. xsd 生成对应的JavaBean

```shell
find . -name "*xsd" | xargs -iT xjc T
```

