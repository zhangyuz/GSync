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

4. 使用 xsd 生成对应的 JAXB JavaBean

```shell
find . -name "*xsd" | xargs -iT xjc T
```

5. 使用 [Android JAXB](https://github.com/yeshodhan/android-jaxb) 生成 SimpleXML 的 Java Bean

```shell
# 发现对于复杂的 xsd 文件，这个工具无法工作。。。
```

